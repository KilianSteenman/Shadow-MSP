package nl.shadowlink.mission.plugin.projectwizard

import androidx.compose.desktop.ComposePanel
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.openapi.options.ConfigurationException
import nl.shadowlink.mission.plugin.projectwizard.ui.ProjectSetupScreen
import java.awt.Dimension
import javax.swing.JComponent

internal class ScriptTypeWizardStep(
    private val missionModuleBuilder: MissionModuleBuilder
) : ModuleWizardStep() {

    override fun updateDataModel() {
        println("When is this called?")
    }

    override fun validate(): Boolean {
        if (missionModuleBuilder.type == null) {
            throw ConfigurationException("No module type selected")
        }
        return true
    }

    override fun getComponent(): JComponent {
        return ComposePanel().apply {
            preferredSize = Dimension(800, 600)
            setContent {
//                    WidgetTheme(darkTheme = true) {
                ProjectSetupScreen { missionModuleBuilder.type = it }
//            }
            }
        }
    }
}
