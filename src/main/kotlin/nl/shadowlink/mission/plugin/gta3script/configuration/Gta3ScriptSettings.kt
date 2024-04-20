package nl.shadowlink.mission.plugin.gta3script.configuration

import com.intellij.ide.util.PropertiesComponent

internal class Gta3ScriptSettings {

    private val component: PropertiesComponent by lazy { PropertiesComponent.getInstance() }

    var compilerPath
        get() = component.getValue(COMPILER_PATH) ?: ""
        set(value) = component.setValue(COMPILER_PATH, value)

    companion object {
        private const val COMPILER_PATH = "COMPILER_PATH"
    }
}