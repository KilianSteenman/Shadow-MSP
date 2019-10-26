package nl.shadowlink.mission.plugin.run.ui

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.game.Game
import nl.shadowlink.mission.plugin.run.MissionRunConfiguration
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent

class MissionRunConfigSettingsEditor : SettingsEditor<MissionRunConfiguration>() {

    private val gamePathField = createGameInstallBrowseTextField(Game.VC)
    private val gameComboBoxModel = DefaultComboBoxModel<String>(arrayOf(Game.III.gameName, Game.VC.gameName, Game.SA.gameName))
    private var comboBoxTest: String? = null

    override fun resetEditorFrom(missionRunConfiguration: MissionRunConfiguration) {
        gamePathField.text = missionRunConfiguration.gamePath
        gameComboBoxModel.selectedItem = missionRunConfiguration.game
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
        }
    }

    override fun applyEditorTo(missionRunConfiguration: MissionRunConfiguration) {
        missionRunConfiguration.gamePath = gamePathField.text
        missionRunConfiguration.game = gameComboBoxModel.selectedItem as String? ?: ""
    }

    private fun createGameInstallBrowseTextField(game: Game): TextFieldWithBrowseButton {
        val field = TextFieldWithBrowseButton()

        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleLocalFileDescriptor().apply {
            isHideIgnored = false
            title = "Select game (${game.exeName})"
            isShowFileSystemRoots = false
        }

        field.addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        return field
    }
}