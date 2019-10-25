package nl.shadowlink.mission.plugin.run.ui

import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.util.Factory
import nl.shadowlink.mission.plugin.run.MissionRunConfiguration
import javax.swing.JComponent

class MissionRunConfigSettingsEditor(settingsFactory: Factory<MissionRunConfiguration>?) : SettingsEditor<MissionRunConfiguration>(settingsFactory) {

    lateinit var settingsPanel: JComponent

    override fun resetEditorFrom(missionRunConfiguration: MissionRunConfiguration) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createEditor(): JComponent {
        return settingsPanel
    }

    override fun applyEditorTo(missionRunConfiguration: MissionRunConfiguration) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}