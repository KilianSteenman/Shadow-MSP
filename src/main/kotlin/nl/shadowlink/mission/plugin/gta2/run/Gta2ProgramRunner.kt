package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfile
import com.intellij.execution.configurations.RunnerSettings
import com.intellij.execution.filters.TextConsoleBuilderFactory
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.openapi.wm.ToolWindowAnchor
import com.intellij.openapi.wm.ToolWindowManager
import nl.shadowlink.mission.plugin.extensions.println

class Gta2ProgramRunner : ProgramRunner<RunnerSettings> {

    override fun execute(environment: ExecutionEnvironment) {
        val runConfiguration = environment.runProfile
        if (runConfiguration !is Gta2RunConfiguration) {
            throw ExecutionException("Not a valid Gta2RunConfiguration")
        }
        verifyRunConfiguration(runConfiguration)

        val console = TextConsoleBuilderFactory.getInstance().createBuilder(environment.project).console
        val manager = ToolWindowManager.getInstance(environment.project)

        var toolWindow = manager.getToolWindow(TOOL_WINDOW_ID)
        if (toolWindow == null) {
            toolWindow = manager.registerToolWindow(TOOL_WINDOW_ID, true, ToolWindowAnchor.BOTTOM)
        }
        val contentManager = toolWindow.contentManager
        val content = contentManager.getContent(0) ?: contentManager
            .factory
            .createContent(console.component, "Mission", false)
        contentManager.addContent(content)
        toolWindow.show { }

        console.println("Compiling...")
    }

    private fun verifyRunConfiguration(runConfig: RunConfiguration) {
        try {
            runConfig.checkConfiguration()
        } catch (exception: Exception) {
            throw ExecutionException(exception.message)
        }
    }

    override fun canRun(executorId: String, profile: RunProfile): Boolean {
        return executorId == "Run"
    }

    override fun getRunnerId(): String {
        return "Gta2Runner"
    }

    companion object {
        private const val TOOL_WINDOW_ID = "Run GTA 2 Mission Script"
    }
}