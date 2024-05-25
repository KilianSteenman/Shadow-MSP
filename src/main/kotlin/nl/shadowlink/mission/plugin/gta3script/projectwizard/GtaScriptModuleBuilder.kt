package nl.shadowlink.mission.plugin.gta3script.projectwizard

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import com.intellij.openapi.module.ModuleType

class GtaScriptModuleBuilder : ModuleBuilder() {

    override fun getModuleType(): ModuleType<*> = GtaScriptModuleType()

    override fun getCustomOptionsStep(context: WizardContext?, parentDisposable: Disposable?): ModuleWizardStep? {
        return GtaScriptTypeWizardStep()
    }

//    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
//        doAddContentEntry(modifiableRootModel)
//
//        val contentEntryPath = contentEntryPath ?: return
//        LocalFileSystem.getInstance().findFileByPath(contentEntryPath) ?: return
//
//        type?.moduleCreator?.createModule(modifiableRootModel)
//    }
}