package nl.shadowlink.mission.plugin.gta2.configuration

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.gta2.Gta2MissionLanguage
import javax.swing.JComponent

internal class Gta2Configuration : Configurable {

    private val settings = Gta2Settings()

    private val compilerBrowser = createCompilerBrowser()

    override fun isModified(): Boolean {
        return compilerBrowser.text != settings.compilerPath
    }

    override fun getDisplayName(): String = Gta2MissionLanguage.displayName

    override fun apply() {
        settings.compilerPath = compilerBrowser.text
    }

    override fun reset() {
        super.reset()
        compilerBrowser.text = settings.compilerPath ?: ""
    }

    override fun createComponent(): JComponent {
        compilerBrowser.text = settings.compilerPath ?: ""

        return panel {
            row {
                label("GTA-2 Compiler path (miss.exe)")
                compilerBrowser(grow)
            }
        }
    }

    private fun createCompilerBrowser(): TextFieldWithBrowseButton {
        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFileDescriptor("exe").apply {
            isHideIgnored = false
            title = "Select GTA-2 Compiler"
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }
}