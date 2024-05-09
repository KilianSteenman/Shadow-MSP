package nl.shadowlink.mission.plugin.settings

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.gta2.Gta2MissionLanguage
import javax.swing.JComponent

internal class ShadowMspSettingsEditor : Configurable {

    private val settings = ShadowMspSettings()

    private val gta3scBrowser = createCompilerBrowser(GTA3SC_FILE_NAME)
    private val gta2CompilerBrowser = createCompilerBrowser(GTA2_COMPILER_NAME)

    override fun isModified(): Boolean {
        return gta3scBrowser.text != settings.gta3scPath
    }

    override fun getDisplayName(): String = Gta2MissionLanguage.displayName

    override fun apply() {
        settings.gta3scPath = gta3scBrowser.text
    }

    override fun reset() {
        super.reset()
        gta3scBrowser.text = settings.gta3scPath
    }

    override fun createComponent(): JComponent {
        gta3scBrowser.text = settings.gta3scPath

        return panel {
            row {
                label("GTA-2 Compiler path")
                gta2CompilerBrowser(grow)
            }
            row {
                label("gta3sc path")
                gta3scBrowser(grow)
            }
        }
    }

    private fun createCompilerBrowser(compilerExeName: String): TextFieldWithBrowseButton {
        val fullFileName = if (System.getProperty("os.name").equals("windows", true)) {
            "$compilerExeName.exe"
        } else {
            compilerExeName
        }

        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFileDescriptor("exe").apply {
            isHideIgnored = false
            title = "Select $compilerExeName"

            withFileFilter { file ->
                file.name == fullFileName && VfsUtilCore.virtualToIoFile(file).canExecute()
            }
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }

    companion object {
        private const val GTA3SC_FILE_NAME = "gta3sc"
        private const val GTA2_COMPILER_NAME = "miscomp"
    }
}