package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.ide.util.TreeFileChooser
import com.intellij.ide.util.TreeFileChooserFactory
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.layout.panel
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFileType
import java.io.File
import javax.swing.JComponent

internal class Gta3ScriptRunConfigSettingsEditor : SettingsEditor<Gta3ScriptRunConfiguration>() {

    private val gamePathField = createGameInstallBrowseTextField()

    private var project: Project? = null

    override fun resetEditorFrom(config: Gta3ScriptRunConfiguration) {
        gamePathField.text = config.gamePath
        project = config.project
    }

    override fun createEditor(): JComponent {
//        val inputArray: Array<String> = arrayOf("test1", "test2")
//        val model = DefaultComboBoxModel(inputArray)
//        comboTest.setModel(model)

        return panel {
            row {
                label("GTA III/VC/SA directory")
                gamePathField(grow)
            }
            row {
                label("Script")
//                textFieldWithBrowseButton {  }
//                comboBox(model)//getFilesInProject()))
//                showDialog()
//                TreeFileChooserFactory.getInstance(project).createFileChooser(
//                    "Title",
//                    Gta3ScriptFileType,
//                    Gta3ScriptFileType
//                )
//                gamePathField(grow)
            }
        }
    }

    private fun getFilesInProject(): List<String> {
        // Logic to get list of files in current project
        // For example:
        return listOf("file1.txt", "file2.txt", "file3.txt")
    }

    private fun showDialog() {

        // Create a file chooser descriptor
//        val descriptor = FileChooserDescriptor(true, false, false, false, false, false)


        // Get an instance of TreeFileChooser
        val factory = TreeFileChooserFactory.getInstance(project)
        val chooser = factory.createFileChooser("Choose a directory", null, Gta3ScriptFileType, TreeFileChooser.PsiFileFilter { true })
        chooser.showDialog()

        // Show the dialog
//        val chosenFiles: Array<VirtualFile> = chooser.selectFile()//.choose(null, null)
//        if (chosenFiles.size > 0) {
//            // Display the chosen file(s)
//            val message = StringBuilder("Chosen file(s):\n")
//            for (file in chosenFiles) {
//                message.append(file.path).append("\n")
//            }
//            Messages.showMessageDialog(project, message.toString(), "Files Chosen", Messages.getInformationIcon())
//        } else {
//            Messages.showMessageDialog(project, "No files chosen", "No Files", Messages.getWarningIcon())
//        }
    }

    override fun applyEditorTo(config: Gta3ScriptRunConfiguration) {
        config.gamePath = gamePathField.text
    }

    private fun createGameInstallBrowseTextField(): TextFieldWithBrowseButton {
        val chooseDirectoryDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor().apply {
            isHideIgnored = false
            title = "Select GTA directory"
            isShowFileSystemRoots = true
            withFileFilter { file -> File("${file.path}/gta3.exe").exists() || File("${file.path}/gta-vc.exe").exists() }
        }

        return TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(TextBrowseFolderListener(chooseDirectoryDescriptor))
        }
    }
}