package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.RunProfile
import com.intellij.execution.filters.TextConsoleBuilderFactory
import com.intellij.execution.runners.DefaultProgramRunner
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType.ERROR_OUTPUT
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.ToolWindowAnchor
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import nl.shadowlink.mission.plugin.MissionFileType
import nl.shadowlink.mission.plugin.extensions.log
import nl.shadowlink.mission.plugin.extensions.println

class MissionProgramRunner : DefaultProgramRunner() {

    private val launcher = GameLauncher()

    private val compiler = MissionCompiler()

    override fun execute(environment: ExecutionEnvironment) {
        val runConfiguration = environment.runProfile

        if (runConfiguration !is MissionRunConfiguration) {
            throw ExecutionException("Not a valid MissionRunConfiguration")
        }

        val console = TextConsoleBuilderFactory.getInstance().createBuilder(environment.project).console
        val manager = ToolWindowManager.getInstance(environment.project)

        var toolWindow = manager.getToolWindow("Run Mission Script")
        if (toolWindow == null) {
            toolWindow = manager.registerToolWindow("Run Mission Script", true, ToolWindowAnchor.BOTTOM)
        }
        val contentManager = toolWindow.contentManager
        val content = contentManager.getContent(0) ?: contentManager
                .factory
                .createContent(console.component, "Mission", false)
        contentManager.addContent(content)
        toolWindow.show { }

        console.println("Compiling...")

        compileProject(runConfiguration, console, environment)
    }

    private fun compileProject(runConfig: MissionRunConfiguration, console: ConsoleView, environment: ExecutionEnvironment) {
        val mainScript = findMainScript(environment)

        if (compile(mainScript, runConfig, console)) {
            if (runConfig.launchGame && runConfig.gamePath.isNotBlank()) {
                launcher.launchGame(console, runConfig.gamePath)
            }
        }
    }

    private fun compile(main: VirtualFile?, runConfig: MissionRunConfiguration, console: ConsoleView): Boolean {
        if (main?.canonicalFile?.path == null) {
            console.println("Main script not found in project", ERROR_OUTPUT)
            throw ExecutionException("Main script not found")
        }

        return compiler.compileFile(runConfig, main.canonicalFile!!, console)
    }

    private fun findMainScript(environment: ExecutionEnvironment): VirtualFile? {
        val scriptFiles = FileTypeIndex.getFiles(MissionFileType, GlobalSearchScope.allScope(environment.project))
        return scriptFiles.find { file -> file.nameWithoutExtension == "main" }
    }

    override fun execute(environment: ExecutionEnvironment, callback: ProgramRunner.Callback?) {
        log().warn("Execute")
    }

    override fun canRun(executorId: String, profile: RunProfile): Boolean {
        return executorId == "Run"
    }

    override fun getRunnerId(): String {
        return "SomeID"
    }
}