package nl.shadowlink.mission.plugin.gta3d.projectwizard.modulecreator

import com.intellij.openapi.roots.ModifiableRootModel

internal interface ModuleCreator {

    fun createModule(modifiableRootModel: ModifiableRootModel)
}