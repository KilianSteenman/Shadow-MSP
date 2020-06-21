package nl.shadowlink.mission.plugin.run.ui

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.ui.layout.panel
import com.intellij.util.EnvironmentUtil
import com.intellij.util.indexing.FileBasedIndex
import nl.shadowlink.mission.plugin.MissionFileType
import nl.shadowlink.mission.plugin.extensions.println
import nl.shadowlink.mission.plugin.game.Game
import nl.shadowlink.mission.plugin.run.MissionRunConfiguration
import java.awt.event.ActionEvent
import javax.swing.DefaultComboBoxModel
import javax.swing.JCheckBox
import javax.swing.JComponent

internal class MissionRunConfigSettingsEditor : SettingsEditor<MissionRunConfiguration>() {

    private val gamePathField = createGameInstallBrowseTextField(Game.VC)
    private val launchGameCheckbox = JCheckBox()
    private val gameComboBoxModel = DefaultComboBoxModel<String>(arrayOf(Game.III.gameName, Game.VC.gameName, Game.SA.gameName))
    private var comboBoxTest: String? = null

    override fun resetEditorFrom(missionRunConfiguration: MissionRunConfiguration) {
        gamePathField.text = missionRunConfiguration.gamePath
        gameComboBoxModel.selectedItem = missionRunConfiguration.game
        launchGameCheckbox.isSelected = missionRunConfiguration.launchGame
    }

    override fun createEditor(): JComponent {
        return panel {
            row {
                label("Game")
                comboBox(gameComboBoxModel, ::comboBoxTest)
            }
            row {
                label("Game directory")
                gamePathField(grow)
            }
            row {
                label("Launch game")
                launchGameCheckbox(grow)
            }
        }
    }

    override fun applyEditorTo(missionRunConfiguration: MissionRunConfiguration) {
        missionRunConfiguration.gamePath = gamePathField.text
        missionRunConfiguration.launchGame = launchGameCheckbox.isSelected
    }

    private fun createGameInstallBrowseTextField(game: Game): TextFieldWithBrowseButton {
        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor().apply {
            isHideIgnored = false
            title = "Select ${game.gameName} directory"
            isShowFileSystemRoots = true
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }
}