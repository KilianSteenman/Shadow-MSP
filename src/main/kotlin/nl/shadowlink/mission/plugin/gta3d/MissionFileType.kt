package nl.shadowlink.mission.plugin.gta3d

import com.intellij.openapi.fileTypes.LanguageFileType
import nl.shadowlink.mission.plugin.MissionIcons
import javax.swing.Icon

object MissionFileType : LanguageFileType(MissionLanguage) {

    override fun getIcon(): Icon? {
        return MissionIcons.FILE
    }

    override fun getName(): String {
        return "Mission Script"
    }

    override fun getDefaultExtension(): String {
        return "dsc"
    }

    override fun getDescription(): String {
        return "GTA Mission Script"
    }
}