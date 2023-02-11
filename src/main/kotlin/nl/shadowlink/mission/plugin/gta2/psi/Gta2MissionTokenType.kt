package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta3d.MissionLanguage

internal class Gta2MissionTokenType(debugName: String) : IElementType(debugName, MissionLanguage) {

    override fun toString(): String = "Gta2MissionTokenType ${super.toString()}"
}