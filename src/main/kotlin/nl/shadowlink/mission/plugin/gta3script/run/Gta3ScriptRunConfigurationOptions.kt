package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.openapi.components.StoredProperty
import nl.shadowlink.mission.plugin.GameType

class Gta3ScriptRunConfigurationOptions : RunConfigurationOptions() {

    private val gamePathProperty: StoredProperty<String?> = string(null)
        .provideDelegate(this, CONFIG_OPTION_GAME_PATH)

    private val gameTypeProperty: StoredProperty<String?> = string("")
        .provideDelegate(this, CONFIG_OPTION_GAME_TYPE)

    private val mainScriptProperty: StoredProperty<String?> =
        string("").provideDelegate(this, CONFIG_OPTION_SCRIPT)

    private val launchGameProperty: StoredProperty<Boolean> =
        property(false).provideDelegate(this, CONFIG_OPTION_LAUNCH_GAME)

    private val backupProperty: StoredProperty<Boolean> =
        property(true).provideDelegate(this, CONFIG_OPTION_BACKUP)

    var gameType: GameType
        get() = GameType.getGameType(gameTypeProperty.getValue(this)) ?: GameType.III
        set(value) = gameTypeProperty.setValue(this, value.visualName)

    var gamePath: String?
        get() = gamePathProperty.getValue(this)
        set(value) = gamePathProperty.setValue(this, value)

    val dataDir: String?
        get() = gamePath?.let { "$it/data" }

    var script: String?
        get() = mainScriptProperty.getValue(this)
        set(value) = mainScriptProperty.setValue(this, value)

    var launchGame: Boolean
        get() = launchGameProperty.getValue(this)
        set(value) = launchGameProperty.setValue(this, value)

    var backup: Boolean
        get() = backupProperty.getValue(this)
        set(value) = backupProperty.setValue(this, value)

    companion object {
        private const val CONFIG_OPTION_GAME_TYPE = "gameType"
        private const val CONFIG_OPTION_GAME_PATH = "gamePath"
        private const val CONFIG_OPTION_SCRIPT = "script"
        private const val CONFIG_OPTION_LAUNCH_GAME = "launchGame"
        private const val CONFIG_OPTION_BACKUP = "backup"
    }
}
