package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StubIndexKey
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable

object Indices {
    val VERSION = 1

    val VARIABLE = StubIndexKey.createIndexKey<String, Gta3ScriptVariable>("gta3script.variable")
}