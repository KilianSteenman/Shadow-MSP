package nl.shadowlink.mission.plugin.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import nl.shadowlink.mission.plugin.extensions.readBoolean
import nl.shadowlink.mission.plugin.extensions.readString
import nl.shadowlink.mission.plugin.extensions.writeBoolean
import nl.shadowlink.mission.plugin.extensions.writeString
import nl.shadowlink.mission.plugin.game.Game
import nl.shadowlink.mission.plugin.run.ui.MissionRunConfigSettingsEditor
import org.jdom.Element
import java.io.File

internal class MissionRunConfiguration(project: Project, factory: ConfigurationFactory?, name: String?) : RunConfigurationBase<MissionRunState>(project, factory, name) {

    var gamePath: String = ""

    var game: Game = Game.VC

    var launchGame: Boolean = false

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return MissionRunConfigSettingsEditor()
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return null
    }

    override fun writeExternal(element: Element) {
        super.writeExternal(element)
        element.writeString("path", gamePath)
        element.writeBoolean("launch_game", launchGame)
        element.writeString("game", game.name)
    }

    override fun readExternal(element: Element) {
        super.readExternal(element)
        gamePath = element.readString("path", "")
        launchGame = element.readBoolean("launch_game", false)
        game = Game.valueOf(element.readString("game", Game.VC.name))
    }

    override fun checkConfiguration() {
        if (!File("$gamePath/${game.exeName}").exists()) {
            throw RuntimeConfigurationException("'$gamePath' is not a valid ${game.gameName} directory, make sure you select the directory that contains ${game.exeName}.");
        }
        super.checkConfiguration()
    }
}