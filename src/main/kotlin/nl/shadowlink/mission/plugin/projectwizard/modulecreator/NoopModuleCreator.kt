package nl.shadowlink.mission.plugin.projectwizard.modulecreator

import com.intellij.openapi.roots.ModifiableRootModel

internal class NoopModuleCreator : ModuleCreator {

    override fun createModule(modifiableRootModel: ModifiableRootModel) {
        // NOOP
    }
}