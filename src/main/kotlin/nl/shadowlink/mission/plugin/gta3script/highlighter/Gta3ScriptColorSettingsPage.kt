package nl.shadowlink.mission.plugin.gta3script.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import javax.swing.Icon

internal class Gta3ScriptColorSettingsPage : ColorSettingsPage {

    override fun getHighlighter(): SyntaxHighlighter = Gta3ScriptHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> {
        return emptyMap<String, TextAttributesKey>().toMutableMap()
    }

    override fun getIcon(): Icon = MissionIcons.FILE

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return Gta3ScriptColor.values()
                .map { it.attributesDescriptor }
                .toTypedArray()
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return emptyArray()
    }

    override fun getDisplayName(): String = Gta3ScriptLanguage.displayName

    override fun getDemoText(): String {
        return "VAR_INT player_car\n" +
                "VAR_FLOAT player_x player_y player_z\n" +
                "\n" +
                "SETUP_ZONE_PED_INFO CHINA DAY (30) 0 650 0 (0 0 0 0) 0\n" +
                "\n" +
                "// Math operations\n" +
                "++ ped_counter\n" +
                "-- ped_counter\n" +
                "ped_counter ++\n" +
                "ped_counter --\n" +
                "time_chunk = ped_time_limit / number_of_injured_peds\n" +
                "time_chunk /= 2\n" +
                "brackets_var = number_of_injured_peds + 1\n" +
                "time_chunk *= brackets_var\n" +
                "ped_time_limit += time_chunk\n" +
                "debug_crap_on = TRUE\n" +
                "\n" +
                "GOSUB label\n" +
                "\n" +
                "{\n" +
                "// Label test\n" +
                "label:\n" +
                "IF info_time_lapsed > 3000\n" +
                "AND flag_info < 2\n" +
                "OR flag_info < 2\n" +
                "\tFLASH_HUD_OBJECT -1\n" +
                "ENDIF\n" +
                "\n" +
                "IF NOT police_guard2 = 0\n" +
                "\tIF get_away_car = 0\n" +
                "\t\tPRINT_NOW RM1_4 5000 1//\"You have run out of grenades! Get some more from ammunation\"\n" +
                "\t\tREMOVE_BLIP\tray1_blip\n" +
                "\t\tADD_SPRITE_BLIP_FOR_COORD 345.5 -713.5 26.1 RADAR_SPRITE_WEAPON ray1_blip\n" +
                "\t\tpolice_guard2 = 1\n" +
                "\tENDIF\n" +
                "ENDIF\n" +
                "\n" +
                "RETURN\n" +
                "}"
    }
}