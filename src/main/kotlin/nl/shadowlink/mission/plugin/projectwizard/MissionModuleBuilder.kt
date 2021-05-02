package nl.shadowlink.mission.plugin.projectwizard

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.LocalFileSystem

internal class MissionModuleBuilder : ModuleBuilder() {

    var type: ScriptModuleType? = null

    init {
        addListener(MissionModuleBuilderListener())
    }

    override fun getModuleType(): ModuleType<*> = MissionModuleType

    override fun getCustomOptionsStep(context: WizardContext?, parentDisposable: Disposable?): ModuleWizardStep? {
        return ScriptTypeWizardStep(this)
    }

    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
        doAddContentEntry(modifiableRootModel)

        val contentEntryPath = contentEntryPath ?: return
        LocalFileSystem.getInstance().findFileByPath(contentEntryPath) ?: return

        type?.moduleCreator?.createModule(modifiableRootModel)
    }
}
