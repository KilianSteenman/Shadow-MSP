package nl.shadowlink.mission.plugin.gta2.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta2.Gta2MissionLanguage
import javax.swing.Icon

internal class Gta2MissionColorSettingsPage : ColorSettingsPage {

    override fun getHighlighter(): SyntaxHighlighter = Gta2MissionHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> {
        return emptyMap<String, TextAttributesKey>().toMutableMap()
    }

    override fun getIcon(): Icon = MissionIcons.FILE

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return Gta2MissionColor.values()
                .map { it.attributesDescriptor }
                .toTypedArray()
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return emptyArray()
    }

    override fun getDisplayName(): String = Gta2MissionLanguage.displayName

    override fun getDemoText(): String {
        return "CHAR_DATA p1_killer\n" +
                "CHAR_DATA p2_killer\n" +
                "CHAR_DATA p3_killer\n" +
                "CHAR_DATA p4_killer\n" +
                "\n" +
                "COUNTER regenerating_characters = 1\n" +
                "\n" +
                "LEVELSTART\n" +
                "\n" +
                "// Create the killers:\n" +
                "p1_killer = CREATE_CHAR (6.5,7.5,255.0) 0 315 CRIMINAL_TYPE2 END\n" +
                "p2_killer = CREATE_CHAR (7.5,7.5,255.0) 0 045 CRIMINAL_TYPE2 END\n" +
                "p3_killer = CREATE_CHAR (6.5,6.5,255.0) 0 225 CRIMINAL_TYPE2 END\n" +
                "p4_killer = CREATE_CHAR (7.5,6.5,255.0) 0 135 CRIMINAL_TYPE2 END\n" +
                "\n" +
                "// Arm the killers:\n" +
                "GIVE_WEAPON (p1_killer, MACHINE_GUN)\n" +
                "GIVE_WEAPON (p2_killer, MACHINE_GUN)\n" +
                "GIVE_WEAPON (p3_killer, MACHINE_GUN)\n" +
                "GIVE_WEAPON (p4_killer, MACHINE_GUN)\n" +
                "\n" +
                "// Make the killers attack any nearby player:\n" +
                "SET_CHAR_THREAT_SEARCH (p1_killer, AREA_PLAYER_ONLY)\n" +
                "SET_CHAR_THREAT_SEARCH (p2_killer, AREA_PLAYER_ONLY)\n" +
                "SET_CHAR_THREAT_SEARCH (p3_killer, AREA_PLAYER_ONLY)\n" +
                "SET_CHAR_THREAT_SEARCH (p4_killer, AREA_PLAYER_ONLY)\n" +
                "SET_CHAR_THREAT_REACTION (p1_killer, REACT_AS_NORMAL)\n" +
                "SET_CHAR_THREAT_REACTION (p2_killer, REACT_AS_NORMAL)\n" +
                "SET_CHAR_THREAT_REACTION (p3_killer, REACT_AS_NORMAL)\n" +
                "SET_CHAR_THREAT_REACTION (p4_killer, REACT_AS_NORMAL)\n" +
                "SET_CHAR_OBJECTIVE (p1_killer, KILL_CHAR_ON_FOOT, p1)\n" +
                "SET_CHAR_OBJECTIVE (p2_killer, KILL_CHAR_ON_FOOT, p2)\n" +
                "SET_CHAR_OBJECTIVE (p3_killer, KILL_CHAR_ON_FOOT, p3)\n" +
                "SET_CHAR_OBJECTIVE (p4_killer, KILL_CHAR_ON_FOOT, p4)\n" +
                "\n" +
                "// Respawn each killer if they die:\n" +
                "WHILE_EXEC (regenerating_characters = 1)\n" +
                " IF (HAS_CHARACTER_DIED(p1_killer))\n" +
                "  p1_killer = CREATE_CHAR (6.5,7.5,6.0) 0 0 CRIMINAL_TYPE2 END\n" +
                "  GIVE_WEAPON (p1_killer, MACHINE_GUN)\n" +
                "  SET_CHAR_THREAT_SEARCH (p1_killer, AREA_PLAYER_ONLY)\n" +
                "  SET_CHAR_THREAT_REACTION (p1_killer, REACT_AS_NORMAL)\n" +
                "  SET_CHAR_OBJECTIVE (p1_killer, KILL_CHAR_ON_FOOT, p1)\n" +
                " ENDIF\n" +
                "\n" +
                " IF (HAS_CHARACTER_DIED(p2_killer))\n" +
                "  p2_killer = CREATE_CHAR (7.5,7.5,6.0) 0 45 CRIMINAL_TYPE2 END\n" +
                "  GIVE_WEAPON (p2_killer, MACHINE_GUN)\n" +
                "  SET_CHAR_THREAT_SEARCH (p2_killer, AREA_PLAYER_ONLY)\n" +
                "  SET_CHAR_THREAT_REACTION (p2_killer, REACT_AS_NORMAL)\n" +
                "  SET_CHAR_OBJECTIVE (p2_killer, KILL_CHAR_ON_FOOT, p2)\n" +
                " ENDIF\n" +
                "\n" +
                " IF (HAS_CHARACTER_DIED(p3_killer))\n" +
                "  p3_killer = CREATE_CHAR (6.5,6.5,6.0) 0 225 CRIMINAL_TYPE2 END\n" +
                "  GIVE_WEAPON (p3_killer, MACHINE_GUN)\n" +
                "  SET_CHAR_THREAT_SEARCH (p3_killer, AREA_PLAYER_ONLY)\n" +
                "  SET_CHAR_THREAT_REACTION (p3_killer, REACT_AS_NORMAL)\n" +
                "  SET_CHAR_OBJECTIVE (p3_killer, KILL_CHAR_ON_FOOT, p3)\n" +
                " ENDIF\n" +
                "\n" +
                " IF (HAS_CHARACTER_DIED(p4_killer))\n" +
                "  p4_killer = CREATE_CHAR (7.5,6.5,6.0) 0 135 CRIMINAL_TYPE2 END\n" +
                "  GIVE_WEAPON (p4_killer, MACHINE_GUN)\n" +
                "  SET_CHAR_THREAT_SEARCH (p4_killer, AREA_PLAYER_ONLY)\n" +
                "  SET_CHAR_THREAT_REACTION (p4_killer, REACT_AS_NORMAL)\n" +
                "  SET_CHAR_OBJECTIVE (p4_killer, KILL_CHAR_ON_FOOT, p4)\n" +
                " ENDIF\n" +
                "ENDWHILE\n" +
                "\n" +
                "LEVELEND"
    }
}