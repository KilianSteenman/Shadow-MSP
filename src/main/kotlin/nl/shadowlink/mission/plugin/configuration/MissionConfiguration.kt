package nl.shadowlink.mission.plugin.configuration

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.MissionLanguage
import javax.swing.JComponent

class MissionConfiguration : Configurable {

    private val settings = MissionSettings()

    val sannyBrowser = createSannyBuilderBrowser()

    override fun isModified(): Boolean {
        return sannyBrowser.text != settings.sannyPath
    }

    override fun getDisplayName(): String = MissionLanguage.displayName

    override fun apply() {
        settings.sannyPath = sannyBrowser.text
    }

    override fun reset() {
        super.reset()
        sannyBrowser.text = settings.sannyPath ?: ""
    }

    override fun createComponent(): JComponent {
        sannyBrowser.text = settings.sannyPath ?: ""

        return panel {
            row {
                label("Sanny Builder path")
                sannyBrowser(grow)
            }
        }
    }

    private fun createSannyBuilderBrowser(): TextFieldWithBrowseButton {
        val field = TextFieldWithBrowseButton()

        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleLocalFileDescriptor().apply {
            isHideIgnored = false
            title = "Select sanny.exe"
            isShowFileSystemRoots = false
        }

        field.addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        return field
    }
}