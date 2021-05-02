package nl.shadowlink.mission.plugin.projectwizard.modulecreator

import com.intellij.openapi.roots.ModifiableRootModel

internal interface ModuleCreator {

    fun createModule(modifiableRootModel: ModifiableRootModel)
}