package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StubElement
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable

interface VariableStub: StubElement<Gta3ScriptVariable> {
    val name: String
}