package nl.shadowlink.mission.plugin.gta3script.configuration

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import javax.swing.JComponent

internal class Gta3ScriptSettingsEditor : Configurable {

    private val settings = Gta3ScriptSettings()

    private val compilerBrowser = createCompilerBrowser()

    override fun isModified(): Boolean {
        return compilerBrowser.text != settings.compilerPath
    }

    override fun getDisplayName(): String = Gta3ScriptLanguage.displayName

    override fun apply() {
        settings.compilerPath = compilerBrowser.text
    }

    override fun reset() {
        super.reset()
        compilerBrowser.text = settings.compilerPath
    }

    override fun createComponent(): JComponent {
        compilerBrowser.text = settings.compilerPath

        return panel {
            row {
                label("Delfi's GTA-2 Compiler")
                compilerBrowser(grow)
            }
        }
    }

    private fun createCompilerBrowser(): TextFieldWithBrowseButton {
        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFileDescriptor("exe").apply {
            isHideIgnored = false
            title = "Select Delfi's GTA-2 Compiler"

            withFileFilter { file ->
                file.name == DELFI_COMPILER_NAME/* TODO: && file.getCRC32Checksum() == DELFI_COMPILER_CHECKSUM */
            }
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }

    companion object {
        private const val DELFI_COMPILER_NAME = "miscomp.exe"//"compiler.exe"
        private const val DELFI_COMPILER_CHECKSUM = 1182121558L
    }
}