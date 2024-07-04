package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable

class VariableStubImpl(
    parent: StubElement<*>?,
    override val name: String,
) : StubBase<Gta3ScriptVariable>(parent, VariableStubElementType), VariableStub