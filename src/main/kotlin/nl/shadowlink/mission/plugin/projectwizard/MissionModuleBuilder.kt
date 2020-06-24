package nl.shadowlink.mission.plugin.projectwizard

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.ModuleType

class MissionModuleBuilder : ModuleBuilder() {

    override fun getModuleType(): ModuleType<*> = MissionModuleType
}