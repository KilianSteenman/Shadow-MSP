package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.tree.IElementType

object StubElementTypeFactory {
    @JvmStatic
    fun factory(name: String): IElementType {
        if (name == "VARIABLE") return VariableStubElementType
        throw RuntimeException("Unknown element type: $name")
    }
}