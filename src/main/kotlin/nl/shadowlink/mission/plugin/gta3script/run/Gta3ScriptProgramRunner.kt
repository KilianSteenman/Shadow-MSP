package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.ExecutionManager
import com.intellij.execution.configurations.*
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.execution.runners.executeState
import com.intellij.execution.ui.RunContentDescriptor
import org.jetbrains.concurrency.resolvedPromise


internal class Gta3ScriptProgramRunner : ProgramRunner<RunnerSettings> {

    override fun execute(environment: ExecutionEnvironment) {
        val state = environment.state ?: return

        @Suppress("UnstableApiUsage")
        ExecutionManager.getInstance(environment.project).startRunProfile(environment) {
            resolvedPromise(doExecute(state, environment))
        }
    }

    private fun doExecute(state: RunProfileState, environment: ExecutionEnvironment): RunContentDescriptor? {
        return executeState(state, environment, this)
    }

    private fun verifyRunConfiguration(runConfig: RunConfiguration) {
        try {
            runConfig.checkConfiguration()
        } catch (exception: Exception) {
            throw ExecutionException(exception.message)
        }
    }

    override fun canRun(executorId: String, profile: RunProfile): Boolean {
        return profile is Gta3ScriptRunConfiguration && executorId == DefaultRunExecutor.EXECUTOR_ID
    }

    override fun getRunnerId(): String {
        return "Gta2Runner"
    }
}