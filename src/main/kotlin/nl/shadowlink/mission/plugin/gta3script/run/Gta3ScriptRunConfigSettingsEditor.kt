package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.dsl.builder.bindItem
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import nl.shadowlink.mission.plugin.GameType
import nl.shadowlink.mission.plugin.gta3script.psi.findScript
import nl.shadowlink.mission.plugin.gta3script.psi.getScriptFiles
import java.io.File
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent

internal class Gta3ScriptRunConfigSettingsEditor : SettingsEditor<Gta3ScriptRunConfiguration>() {

    private var gameType: GameType = GameType.III
    private var gamePath: String? = null
    private var scriptFile: String? = null

    private lateinit var panel: DialogPanel
    private val scriptFileComboBoxModel = DefaultComboBoxModel<String>()

    override fun resetEditorFrom(config: Gta3ScriptRunConfiguration) {
        gamePath = config.gamePath
        gameType = config.gameType
        scriptFile = config.scriptFile

        scriptFileComboBoxModel.removeAllElements()
        config.project.getScriptFiles().forEach { scriptFileComboBoxModel.addElement(it.name) }

        panel.reset()
    }

    override fun createEditor(): JComponent {
        val gameTypeComboBoxModel = DefaultComboBoxModel(GameType.values())

        return panel {
            row("Game type") {
                comboBox(
                    model = gameTypeComboBoxModel,
                ).bindItem(
                    getter = { gameType },
                    setter = { newType -> gameType = (newType ?: GameType.III) }
                )
            }
            row("Game directory") {
                textFieldWithBrowseButton(
                    browseDialogTitle = "Select Game Directory",
                    fileChooserDescriptor = createFileChooserDescriptor(),
                    fileChosen = { file ->
                        file.path.also {
                            gamePath = it
                        }
                    }
                ).bindText(
                    getter = { gamePath ?: "" },
                    setter = { gamePath = it }
                ).horizontalAlign(HorizontalAlign.FILL)
            }
            row("Script") {
                comboBox(
                    model = scriptFileComboBoxModel,
                ).bindItem(
                    getter = { scriptFile },
                    setter = { newScriptFile -> scriptFile = newScriptFile }
                )
            }
            group("Run Game") {
                row {
                    checkBox("Launch game").comment("Launch the game after compilation")
                }
                row {
                    checkBox("Backup current script").comment("Create a backup of the current main.scm and restores it when the game is closed")
                }
            }
        }.also { panel = it }
    }

    override fun applyEditorTo(config: Gta3ScriptRunConfiguration) {
        panel.apply()
        config.gamePath = gamePath
        config.gameType = gameType
        config.scriptFile = scriptFile
    }

    private fun createFileChooserDescriptor() = FileChooserDescriptorFactory.createSingleFolderDescriptor().apply {
        isHideIgnored = false
        title = "Select Game Directory"
        isShowFileSystemRoots = true
        withFileFilter { file -> File("${file.path}/${gameType.exeName}").exists() }
    }
}