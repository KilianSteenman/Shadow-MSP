package nl.shadowlink.mission.plugin.gta3script.projectwizard

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.SettingsStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.ui.dsl.builder.panel
import nl.shadowlink.mission.plugin.GameType
import javax.swing.DefaultComboBoxModel
import javax.swing.JComboBox
import javax.swing.JComponent

class GtaScriptModuleBuilder : ModuleBuilder() {

    override fun getModuleType(): ModuleType<*> = GtaScriptModuleType()

    override fun getCustomOptionsStep(context: WizardContext?, parentDisposable: Disposable?): ModuleWizardStep {
        return object : ModuleWizardStep() {
            val gameTypeComboBoxModel = DefaultComboBoxModel(GameType.entries.toTypedArray())

            override fun getComponent(): JComponent {
                return panel {
                    row("GameType") {
                        comboBox(gameTypeComboBoxModel)
                    }
                }
            }

            override fun updateDataModel() {
                TODO("Not yet implemented")
            }
        }
    }
}
