package nl.shadowlink.mission.plugin.settings

import com.intellij.ide.util.PropertiesComponent
import java.io.File

internal class ShadowMspSettings {

    private val component: PropertiesComponent by lazy { PropertiesComponent.getInstance() }

    var gta3scPath
        get() = component.getValue(GTA_3_SC_PATH) ?: ""
        set(value) = component.setValue(GTA_3_SC_PATH, value)

    var gta2CompilerPath
        get() = component.getValue(GTA_2_COMPILER_PATH) ?: ""
        set(value) = component.setValue(GTA_2_COMPILER_PATH, value)

    fun verifyGtaScriptCompiler() {
        if (gta3scPath.isBlank() || !File(gta3scPath).exists()) {
            throw IllegalStateException("gta3sc is path not defined")
        }
    }

    companion object {
        private const val GTA_2_COMPILER_PATH = "GTA_2_COMPILER_PATH"
        private const val GTA_3_SC_PATH = "GTA_3_SC_PATH"
    }
}