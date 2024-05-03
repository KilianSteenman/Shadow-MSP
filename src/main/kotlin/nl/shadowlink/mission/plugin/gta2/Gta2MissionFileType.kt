package nl.shadowlink.mission.plugin.gta2

import com.intellij.openapi.fileTypes.LanguageFileType
import nl.shadowlink.mission.plugin.MissionIcons
import javax.swing.Icon

object Gta2MissionFileType : LanguageFileType(Gta2MissionLanguage) {

    override fun getIcon(): Icon = MissionIcons.FILE

    override fun getName(): String = "GTA 2 - Mission Script"

    override fun getDefaultExtension(): String = "mis"

    override fun getDescription(): String = "GTA 2 - Mission Script"
}