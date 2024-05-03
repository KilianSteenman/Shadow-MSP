package nl.shadowlink.mission.plugin.gta3script

import com.intellij.openapi.fileTypes.LanguageFileType
import nl.shadowlink.mission.plugin.MissionIcons
import javax.swing.Icon

object Gta3ScriptFileType : LanguageFileType(Gta3ScriptLanguage) {

    override fun getIcon(): Icon = MissionIcons.FILE

    override fun getName(): String = "GTA 3 - Script"

    override fun getDefaultExtension(): String = "sc"

    override fun getDescription(): String = "Scripting language for GTA 3 / VS / SA"
}