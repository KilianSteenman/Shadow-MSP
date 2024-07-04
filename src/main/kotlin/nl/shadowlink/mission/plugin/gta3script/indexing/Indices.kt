package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StubIndexKey
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariableDecl

object Indices {
    val VERSION = 3

    val VARIABLE_DECL = StubIndexKey.createIndexKey<String, Gta3ScriptVariableDecl>("gta3script.variable.decl")
}