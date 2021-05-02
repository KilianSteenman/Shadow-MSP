package nl.shadowlink.mission.plugin.projectwizard.modulecreator

import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.jps.model.serialization.PathMacroUtil
import java.io.File

internal class MissionScriptModuleCreator(
    private val mainScriptName: String
) : ModuleCreator {

    override fun createModule(modifiableRootModel: ModifiableRootModel) {
        //  create directory for the sources if not already there
        val directory = File(PathMacroUtil.getModuleDir(modifiableRootModel.module.moduleFilePath), "missions")
        if (!directory.exists()) {
            directory.mkdirs()
        }

        // kick  virtual file system in the privates, so it refreshes and we can mark directory as sources
        LocalFileSystem.getInstance().refreshAndFindFileByIoFile(directory)?.let { virtualFile ->
            modifiableRootModel.getContentRootFor(virtualFile)?.addSourceFolder(virtualFile.url, false)
        }

        val mainSource = File(PathMacroUtil.getModuleDir(modifiableRootModel.module.moduleFilePath), "main.dsc")
        mainSource.writeText(javaClass.getResource("/scripts/$mainScriptName.dsc").readText())
    }

    private fun ModifiableRootModel.getContentRootFor(url: VirtualFile): ContentEntry? {
        for (e in contentEntries) {
            if (VfsUtilCore.isEqualOrAncestor(e.url, url.url)) return e
        }
        return null
    }
}