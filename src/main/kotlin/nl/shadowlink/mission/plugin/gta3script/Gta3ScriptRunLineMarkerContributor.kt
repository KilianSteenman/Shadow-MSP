package nl.shadowlink.mission.plugin.gta3script

import com.intellij.execution.ExecutorRegistry
import com.intellij.execution.RunManager
import com.intellij.execution.configurations.ConfigurationTypeUtil
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.impl.RunManagerImpl
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.execution.runners.ExecutionUtil
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import com.intellij.util.FunctionUtil
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptScriptStartExpression
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTokenType
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes
import nl.shadowlink.mission.plugin.gta3script.run.Gta3ScriptConfigurationType
import nl.shadowlink.mission.plugin.gta3script.run.Gta3ScriptRunConfiguration

class Gta3ScriptRunLineMarkerContributor : RunLineMarkerContributor() {

    override fun getInfo(element: PsiElement): Info? {
        if (element.elementType != Gta3ScriptTypes.SCRIPT_START) return null

        val runAction = object : AnAction() {
            override fun actionPerformed(e: AnActionEvent) {
                e.project?.let {
                    createAndRunConfiguration(it, element.containingFile)
                }
            }
        }

        return Info(
            AllIcons.RunConfigurations.TestState.Run,
            arrayOf(runAction),
            FunctionUtil.constant("Run this file"),
        )
    }

    private fun createAndRunConfiguration(project: Project, file: PsiFile) {
        val runManager = RunManager.getInstance(project) as RunManagerImpl
        val configurationType = ConfigurationTypeUtil.findConfigurationType(Gta3ScriptConfigurationType::class.java)
        val factory = configurationType.configurationFactories[0]

        val configuration = runManager.createConfiguration("Run ${file.name}", factory)
        val runConfiguration = configuration.configuration as Gta3ScriptRunConfiguration
        runConfiguration.scriptFile = file.name
        runConfiguration.isCustomScript = true

        runManager.setTemporaryConfiguration(configuration)
        runManager.selectedConfiguration = configuration

        val executor = requireNotNull(ExecutorRegistry.getInstance().getExecutorById(DefaultRunExecutor.EXECUTOR_ID))
        ExecutionUtil.runConfiguration(configuration, executor)
    }
}