package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.openapi.components.StoredProperty

class Gta3ScriptRunConfigurationOptions : RunConfigurationOptions() {

    private val gamePathProperty: StoredProperty<String?> = string("")
        .provideDelegate(this, CONFIG_OPTION_GAME_PATH)

    private val mainScriptProperty: StoredProperty<String?> =
        string("").provideDelegate(this, CONFIG_OPTION_MAIN_SCRIPT)

    var gamePath: String
        get() = gamePathProperty.getValue(this) ?: ""
        set(value) = gamePathProperty.setValue(this, value)

    var mainScript: String
        get() = mainScriptProperty.getValue(this) ?: ""
        set(value) = mainScriptProperty.setValue(this, value)

    companion object {
        private const val CONFIG_OPTION_GAME_PATH = "gamePath"
        private const val CONFIG_OPTION_MAIN_SCRIPT = "mainScript"
    }
}
