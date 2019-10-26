package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import nl.shadowlink.mission.plugin.extensions.log
import com.intellij.execution.filters.TextConsoleBuilderFactory
import com.intellij.execution.runners.DefaultProgramRunner
import com.intellij.openapi.wm.ToolWindowAnchor
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.execution.ui.ConsoleView
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import nl.shadowlink.mission.plugin.MissionFileType
import nl.shadowlink.mission.plugin.extensions.println
import nl.shadowlink.mission.plugin.game.Game

class MissionProgramRunner : DefaultProgramRunner() {

    private val launcher = GameLauncher()

    private val compiler = MissionCompiler()

    override fun execute(environment: ExecutionEnvironment) {
        val runConfiguration = environment.runProfile
        var gamePath = ""
        if (runConfiguration is MissionRunConfiguration) {
            gamePath = runConfiguration.gamePath
        }

        if (gamePath.isEmpty()) {
            throw ExecutionException("GamePath not set")
        }

        val console = TextConsoleBuilderFactory.getInstance().createBuilder(environment.project).console
        val manager = ToolWindowManager.getInstance(environment.project)

        var toolWindow = manager.getToolWindow("Run Mission Script")
        if (toolWindow == null) {
            toolWindow = manager.registerToolWindow("Run Mission Script", true, ToolWindowAnchor.BOTTOM)
        }
        val contentManager = toolWindow.contentManager
        val content = contentManager
                .factory
                .createContent(console.component, "Mission", false)
        contentManager.addContent(content)
        toolWindow.show { }

        console.println("Compiling...")

        compileFiles(console, environment) { /*launcher.launchGame(console, gamePath)*/ }
    }

    private fun compileFiles(console: ConsoleView, environment: ExecutionEnvironment, compilationFinished: () -> Unit) {
        val projectPath = environment.project.basePath!!.replace("/", "\\")

        val files = FileBasedIndex.getInstance()
                .getContainingFiles(
                        FileTypeIndex.NAME,
                        MissionFileType,
                        GlobalSearchScope.allScope(environment.project)
                ).also {
                    it.forEach { file -> console.println("File ${file.name}") }
                }

        compileFile(files.toList(), projectPath, 0, console, compilationFinished)
    }

    private fun compileFile(files: List<VirtualFile>, projectPath: String, fileIndex: Int, console: ConsoleView, compilationFinished: (() -> Unit)? = null) {
        val file = files.toList().getOrNull(fileIndex)
        if (file != null) {
            compiler.compileFile(file, projectPath, Game.VC, console) { compileFile(files, projectPath, fileIndex + 1, console, compilationFinished) }
        } else {
            console.println("All files compiled")
            compilationFinished?.invoke()
        }
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