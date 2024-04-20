package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage

internal class Gta3ScriptTokenType(debugName: String) : IElementType(debugName, Gta3ScriptLanguage) {

    override fun toString(): String = "Gta3ScriptTokenType ${super.toString()}"
}