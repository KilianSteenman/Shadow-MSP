package nl.shadowlink.mission.plugin.projectwizard

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ui.components.JBList
import com.intellij.ui.layout.panel
import javax.swing.JComponent
import javax.swing.ListModel
import javax.swing.event.ListDataListener

class ScriptTypeWizardStep : ModuleWizardStep() {

    private val projectTypeSelectionModel = object : ListModel<ModuleType> {
        override fun getElementAt(index: Int): ModuleType = ModuleType.values()[index]

        override fun getSize(): Int = ModuleType.values().size

        override fun addListDataListener(l: ListDataListener?) {
            // TODO: Check if we need to implement this method
        }

        override fun removeListDataListener(l: ListDataListener?) {
            // TODO: Check if we need to implement this method
        }
    }

    private val projectTypeList = JBList(projectTypeSelectionModel)

    private var projectSelection: ModuleType = ModuleType.VC_SCM

    override fun updateDataModel() {
        // TODO: Update data model according to selection
    }

    override fun getComponent(): JComponent {
        return panel {
            row {
                projectTypeList(grow)
            }
            row {
                label(projectSelection.description)
            }
        }
    }
}