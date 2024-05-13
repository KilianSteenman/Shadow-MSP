package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.openapi.components.StoredProperty
import java.io.File

class Gta3ScriptRunConfigurationOptions : RunConfigurationOptions() {

    private val gamePathProperty: StoredProperty<String?> = string("")
        .provideDelegate(this, CONFIG_OPTION_GAME_PATH)

    private val mainScriptProperty: StoredProperty<String?> =
        string("").provideDelegate(this, CONFIG_OPTION_MAIN_SCRIPT)

    var gamePath: String
        get() = gamePathProperty.getValue(this) ?: ""
        set(value) = gamePathProperty.setValue(this, value)

    val dataDir: String
        get() = "$gamePath/data"

    val gameConfig: String
        get() {
            return when {
                File("$gamePath/gta3.exe").exists() -> "gta3"
                File("$gamePath/gta-vc.exe").exists() -> "gtavc"
                File("$gamePath/gta-sa.exe").exists() -> "gtasa"
                else -> error("Unknown gta directory selected")
            }
        }

    var mainScript: String
        get() = mainScriptProperty.getValue(this) ?: ""
        set(value) = mainScriptProperty.setValue(this, value)

    companion object {
        private const val CONFIG_OPTION_GAME_PATH = "gamePath"
        private const val CONFIG_OPTION_MAIN_SCRIPT = "mainScript"
    }
}
