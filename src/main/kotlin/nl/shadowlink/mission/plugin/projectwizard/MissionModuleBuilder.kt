package nl.shadowlink.mission.plugin.projectwizard

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtilCore.isEqualOrAncestor
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.jps.model.serialization.PathMacroUtil
import java.io.File

class MissionModuleBuilder : ModuleBuilder() {

    init {
        addListener(MissionModuleBuilderListener())
    }

    override fun getModuleType(): ModuleType<*> = MissionModuleType

    override fun getCustomOptionsStep(context: WizardContext?, parentDisposable: Disposable?): ModuleWizardStep? {
        return ScriptTypeWizardStep()
    }

    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
        doAddContentEntry(modifiableRootModel)

        val contentEntryPath = contentEntryPath ?: return
        LocalFileSystem.getInstance().findFileByPath(contentEntryPath) ?: return

        //  create directory for the sources if not already there
        val directory = File(PathMacroUtil.getModuleDir(modifiableRootModel.module.moduleFilePath), "missions")
        if (!directory.exists()) {
            directory.mkdirs()
        }

        // kick  virtual file system in the privates,  so it refreshes
        // and we can mark directory as sources
        LocalFileSystem.getInstance().refreshAndFindFileByIoFile(directory)?.let { virtualFile ->
            getContentRootFor(virtualFile, modifiableRootModel)?.addSourceFolder(virtualFile.url, false)
        }

        val mainSource = File(PathMacroUtil.getModuleDir(modifiableRootModel.module.moduleFilePath), "main.dsc")
        mainSource.writeText("0000: NOP")
    }

    private fun getContentRootFor(url: VirtualFile, rootModel: ModifiableRootModel): ContentEntry? {
        for (e in rootModel.contentEntries) {
            if (isEqualOrAncestor(e.url, url.url)) return e
        }
        return null
    }
}
