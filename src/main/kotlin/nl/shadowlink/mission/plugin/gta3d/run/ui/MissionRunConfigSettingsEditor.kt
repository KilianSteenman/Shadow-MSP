package nl.shadowlink.mission.plugin.gta3d.run.ui

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.gta3d.game.Game
import nl.shadowlink.mission.plugin.gta3d.run.MissionRunConfiguration
import javax.swing.DefaultComboBoxModel
import javax.swing.JCheckBox
import javax.swing.JComponent

internal class MissionRunConfigSettingsEditor : SettingsEditor<MissionRunConfiguration>() {

    private val gamePathField = createGameInstallBrowseTextField()
    private val launchGameCheckbox = JCheckBox()
    private val gameComboBoxModel = DefaultComboBoxModel<String>(arrayOf(Game.III.gameName, Game.VC.gameName, Game.SA.gameName)).apply {
        selectedItem = Game.VC.gameName
    }
    private var gameComboBoxSelection: String? = null

    override fun resetEditorFrom(missionRunConfiguration: MissionRunConfiguration) {
        gamePathField.text = missionRunConfiguration.gamePath
        gameComboBoxModel.selectedItem = missionRunConfiguration.game.gameName
        launchGameCheckbox.isSelected = missionRunConfiguration.launchGame
    }

    override fun createEditor(): JComponent {
        return panel {
            row {
                label("Game")
//                comboBox(gameComboBoxModel, ::gameComboBoxSelection)
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
        missionRunConfiguration.game = gameComboBoxModel.selectedItem.toString().toGame()
    }

    private fun String.toGame(): Game {
        return when(this) {
            Game.III.gameName -> Game.III
            Game.VC.gameName -> Game.VC
            Game.SA.gameName -> Game.SA
            else -> Game.VC
        }
    }

    private fun createGameInstallBrowseTextField(): TextFieldWithBrowseButton {
        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor().apply {
            isHideIgnored = false
            title = "Select game directory"
            isShowFileSystemRoots = true
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }
}