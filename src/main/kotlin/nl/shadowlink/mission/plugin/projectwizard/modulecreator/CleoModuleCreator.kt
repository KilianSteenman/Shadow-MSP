package nl.shadowlink.mission.plugin.projectwizard.modulecreator

import com.intellij.openapi.roots.ModifiableRootModel
import org.jetbrains.jps.model.serialization.PathMacroUtil
import java.io.File

internal class CleoModuleCreator : ModuleCreator {

    override fun createModule(modifiableRootModel: ModifiableRootModel) {
        val cleoSource = File(PathMacroUtil.getModuleDir(modifiableRootModel.module.moduleFilePath), "cleo.dsc")
        cleoSource.writeText("// Cleo source file")
    }
}