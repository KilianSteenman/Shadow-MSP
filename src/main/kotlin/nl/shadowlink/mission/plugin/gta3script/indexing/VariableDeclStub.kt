package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariableDecl

interface VariableDeclStub : StubElement<Gta3ScriptVariableDecl> {
    val name: String
}

class VariableDeclStubImpl(
    parent: StubElement<*>?,
    override val name: String,
) : StubBase<Gta3ScriptVariableDecl>(parent, VariableDeclStubElementType), VariableDeclStub
