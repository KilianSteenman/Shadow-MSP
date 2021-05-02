package nl.shadowlink.mission.plugin.tools.opcodedb

import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeDatabaseFactory
import javax.swing.JComponent
import javax.swing.ListModel
import javax.swing.event.ListDataListener

class OpcodeDbViewer {

    private val opcodeSelectionModel = object : ListModel<String> {
        private val opcodes = OpcodeDatabaseFactory.getDatabase().opcodes

        override fun getElementAt(index: Int): String = "${opcodes[index].opcode} - ${opcodes[index].format}"

        override fun getSize(): Int = opcodes.size

        override fun addListDataListener(l: ListDataListener?) {
            // TODO: Check if we need to implement this method
        }

        override fun removeListDataListener(l: ListDataListener?) {
            // TODO: Check if we need to implement this method
        }
    }

    private val projectTypeList = JBScrollPane(JBList(opcodeSelectionModel))

    fun createContent(): JComponent {
        return panel {
            row {
                projectTypeList(grow)
            }
        }
    }
}