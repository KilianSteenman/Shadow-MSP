package nl.shadowlink.mission.plugin.gta3script.projectwizard

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ui.dsl.builder.panel
import nl.shadowlink.mission.plugin.GameType
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent

class GtaScriptTypeWizardStep : ModuleWizardStep() {

    override fun getComponent(): JComponent {
        val gameTypeComboBoxModel = DefaultComboBoxModel(GameType.entries.toTypedArray())

        return panel {
            row("Name") {
                textField()
            }
            row("GameType") {
                comboBox(gameTypeComboBoxModel)
            }
        }
    }

    override fun updateDataModel() {
        println("Update data model")
    }
}