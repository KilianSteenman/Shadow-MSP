package nl.shadowlink.mission.plugin.configuration

import com.intellij.ide.util.PropertiesComponent

class MissionSettings {

    private val component: PropertiesComponent by lazy { PropertiesComponent.getInstance() }

    var sannyPath
        get() = component.getValue(SANNY_PATH)
        set(value) = component.setValue(SANNY_PATH, value)

    companion object {
        private const val SANNY_PATH = "SANNY_PATH"
    }
}