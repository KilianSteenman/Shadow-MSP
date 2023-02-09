package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import nl.shadowlink.mission.plugin.extensions.readBoolean
import nl.shadowlink.mission.plugin.extensions.readString
import nl.shadowlink.mission.plugin.extensions.writeBoolean
import nl.shadowlink.mission.plugin.extensions.writeString
import org.jdom.Element
import java.io.File

internal class Gta2RunConfiguration(
    project: Project,
    factory: ConfigurationFactory?,
    name: String?
) : RunConfigurationBase<Gta2RunState>(project, factory, name) {

    var gamePath: String = ""

    var launchGame: Boolean = false

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> = Gta2RunConfigSettingsEditor()

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? = null

    override fun writeExternal(element: Element) {
        super.writeExternal(element)
        element.writeString("path", gamePath)
        element.writeBoolean("launch_game", launchGame)
    }

    override fun readExternal(element: Element) {
        super.readExternal(element)
        gamePath = element.readString("path", "")
        launchGame = element.readBoolean("launch_game", false)
    }

    override fun checkConfiguration() {
        when {
            gamePath.isEmpty() ->
                throw RuntimeConfigurationException("GTA-2 directory not set, make sure you select the directory that contains gta2.exe.")
            !File("$gamePath/gta2.exe").exists() ->
                throw RuntimeConfigurationException("'$gamePath' is not a valid GTA-2 directory. Select the directory that contains gta2.exe.")
            else -> super.checkConfiguration()
        }
    }
}