package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import javax.swing.JCheckBox
import javax.swing.JComponent

internal class Gta2RunConfigSettingsEditor : SettingsEditor<Gta2RunConfiguration>() {

    private val gamePathField = createGameInstallBrowseTextField()
    private val launchGameCheckbox = JCheckBox()

    override fun resetEditorFrom(config: Gta2RunConfiguration) {
        gamePathField.text = config.gamePath
        launchGameCheckbox.isSelected = config.launchGame
    }

    override fun createEditor(): JComponent {
        return panel {
            row {
                label("GTA-2 directory")
                gamePathField(grow)
            }
            row {
                label("Launch game")
                launchGameCheckbox(grow)
            }
        }
    }

    override fun applyEditorTo(config: Gta2RunConfiguration) {
        config.gamePath = gamePathField.text
        config.launchGame = launchGameCheckbox.isSelected
    }

    private fun createGameInstallBrowseTextField(): TextFieldWithBrowseButton {
        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor().apply {
            isHideIgnored = false
            title = "Select GTA-2 directory"
            isShowFileSystemRoots = true
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }
}