package nl.shadowlink.mission.plugin.gta3d.projectwizard

import com.intellij.execution.RunManager
import com.intellij.ide.util.projectWizard.ModuleBuilderListener
import com.intellij.openapi.module.Module
import nl.shadowlink.mission.plugin.utils.focusInEditor
import nl.shadowlink.mission.plugin.gta3d.run.MissionConfigurationFactory
import nl.shadowlink.mission.plugin.gta3d.run.MissionRunConfiguration
import org.jetbrains.jps.model.serialization.PathMacroUtil
import java.io.File

internal class MissionModuleBuilderListener : ModuleBuilderListener {

    override fun moduleCreated(module: Module) {
        createDefaultRunConfig(module)
        focusOnMainScript(module)
    }

    private fun createDefaultRunConfig(module: Module) {
        val config = MissionRunConfiguration(module.project, MissionConfigurationFactory(), "Compile & Run")
        with(RunManager.getInstance(module.project)) {
            val configSettings = createConfiguration(config, MissionConfigurationFactory())
            addConfiguration(configSettings)
            selectedConfiguration = configSettings
        }
    }

    private fun focusOnMainScript(module: Module) {
        val mainFile = File(PathMacroUtil.getModuleDir(module.moduleFilePath), "main.dsc")
        mainFile.focusInEditor(module.project)
    }
}