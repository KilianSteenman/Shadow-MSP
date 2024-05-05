package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.openapi.components.StoredProperty

class Gta3ScriptRunConfigurationOptions : RunConfigurationOptions() {

    private val gamePathProperty: StoredProperty<String?> = string("").provideDelegate(this, CONFIG_OPTION_GAME_PATH)

    var gamePath: String
        get() = gamePathProperty.getValue(this) ?: ""
        set(value) = gamePathProperty.setValue(this, value)

    companion object {
        private const val CONFIG_OPTION_GAME_PATH = "gamePath"
    }
}
