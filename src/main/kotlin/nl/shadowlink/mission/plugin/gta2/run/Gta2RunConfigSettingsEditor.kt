package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import java.io.File
import javax.swing.JCheckBox
import javax.swing.JComponent

internal class Gta2RunConfigSettingsEditor : SettingsEditor<Gta2RunConfiguration>() {

    private val gamePathField = createGameInstallBrowseTextField()

    override fun resetEditorFrom(config: Gta2RunConfiguration) {
        gamePathField.text = config.gamePath
    }

    override fun createEditor(): JComponent {
        return panel {
            row {
                label("GTA-2 directory")
                gamePathField(grow)
            }
        }
    }

    override fun applyEditorTo(config: Gta2RunConfiguration) {
        config.gamePath = gamePathField.text
    }

    private fun createGameInstallBrowseTextField(): TextFieldWithBrowseButton {
        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor().apply {
            isHideIgnored = false
            title = "Select GTA-2 directory"
            isShowFileSystemRoots = true
            withFileFilter { file -> File("${file.path}/gta2.exe").exists() }
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }
}