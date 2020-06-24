package nl.shadowlink.mission.plugin.projectwizard

import com.intellij.ide.util.projectWizard.ModuleBuilderListener
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ModuleRootModel
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.jps.model.serialization.PathMacroUtil
import java.io.File


class MissionModuleBuilderListener : ModuleBuilderListener {

    override fun moduleCreated(module: Module) {
        // TODO: Do we need to do something here?
    }
}