package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.ide.util.PropertiesComponent

class Gta2RunConfigurationOptions : RunConfigurationOptions() {

    private val gamePathProperty: PropertiesComponent by lazy { PropertiesComponent.getInstance() }

    var gamePath: String
        get() = gamePathProperty.getValue(CONFIG_OPTION_GAME_PATH) ?: ""
        set(value) = gamePathProperty.setValue(CONFIG_OPTION_GAME_PATH, value)

    companion object {
        private const val CONFIG_OPTION_GAME_PATH = "gamePath"
    }
}