package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfile
import com.intellij.execution.configurations.RunnerSettings
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.process.ScriptRunnerUtil
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import java.io.File

class Gta2ProgramRunner : ProgramRunner<RunnerSettings> {

    override fun execute(environment: ExecutionEnvironment) {
        val runConfiguration = environment.runProfile
        if (runConfiguration !is Gta2RunConfiguration) {
            throw ExecutionException("Not a valid Gta2RunConfiguration")
        }
        verifyRunConfiguration(runConfiguration)

        val generalCommandLine = GeneralCommandLine("${runConfiguration.gamePath}\\gta2.exe")
        generalCommandLine.workDirectory = File(runConfiguration.gamePath + "\\")
        ScriptRunnerUtil.getProcessOutput(generalCommandLine)
    }

    private fun verifyRunConfiguration(runConfig: RunConfiguration) {
        try {
            runConfig.checkConfiguration()
        } catch (exception: Exception) {
            throw ExecutionException(exception.message)
        }
    }

    override fun canRun(executorId: String, profile: RunProfile): Boolean {
        return profile is Gta2RunConfiguration && executorId == DefaultRunExecutor.EXECUTOR_ID
    }

    override fun getRunnerId(): String {
        return "Gta2Runner"
    }
}