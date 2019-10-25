package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.ExecutionResult
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.openapi.options.SettingsEditor
import nl.shadowlink.mission.plugin.extensions.log
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.filters.TextConsoleBuilderFactory
import com.intellij.execution.process.*
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.openapi.wm.ToolWindowAnchor
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.execution.ui.ConsoleView
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import nl.shadowlink.mission.plugin.MissionFileType
import nl.shadowlink.mission.plugin.extensions.println


class MissionProgramRunner : ProgramRunner<MissionRunnerSettings> {

    override fun execute(environment: ExecutionEnvironment) {
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

        compileFiles(console, environment) { launchGame(console) }
    }

    private fun launchGame(console: ConsoleView) {
        console.println("Launching game...")

        GeneralCommandLine()
                .withExePath("wine")
                .withParameters("/Users/kilian/.wine/drive_c/Program Files/Steam/steamapps/common/Grand Theft Auto Vice City/gta-vc.exe")
                .createProcess()
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
            compileFile(console, "Z:$projectPath\\${file.name}") { compileFile(files, projectPath, fileIndex + 1, console, compilationFinished) }
        } else {
            console.println("All files compiled")
            compilationFinished?.invoke()
        }
    }

    private fun compileFile(console: ConsoleView, file: String, fileCompiled: (() -> Unit)?) {
        console.println("Compiling $file", ConsoleViewContentType.NORMAL_OUTPUT)
        try {
            val handler = OSProcessHandler(GeneralCommandLine()
                    .withExePath("wine")
                    .withParameters("/Users/kilian/.wine/drive_c/Program Files/Sanny Builder 3/sanny.exe")
                    .withParameters("\\vc")
                    .withParameters("\\nosplash")
                    .withParameters("\\compile")
                    .withParameters(file)
            )
            handler.startNotify()
            handler.addProcessListener(object : ProcessAdapter() {

                override fun processTerminated(event: ProcessEvent) {
                    console.println("Compilation done")
                    fileCompiled?.invoke()
                }

                override fun startNotified(event: ProcessEvent) {
                    console.println("Compilation starting")
                }
            })
            console.attachToProcess(handler)
        } catch (ex: ExecutionException) {
            ex.printStackTrace()
            return
        }
    }

    override fun execute(environment: ExecutionEnvironment, callback: ProgramRunner.Callback?) {
        log().warn("Execute")
    }

    override fun onProcessStarted(settings: RunnerSettings?, executionResult: ExecutionResult?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSettingsEditor(executor: Executor?, configuration: RunConfiguration?): SettingsEditor<MissionRunnerSettings>? {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return null
    }

    override fun createConfigurationData(settingsProvider: ConfigurationInfoProvider?): MissionRunnerSettings? {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return null
    }

    override fun checkConfiguration(settings: RunnerSettings?, configurationPerRunnerSettings: ConfigurationPerRunnerSettings?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun canRun(executorId: String, profile: RunProfile): Boolean {
        return executorId == "Run"
    }

    override fun getRunnerId(): String {
        return "SomeID"
    }
}