package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptLabelDecl
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariableDecl

interface LabelDeclStub : StubElement<Gta3ScriptLabelDecl> {
    val name: String
}

class LabelDeclStubImpl(
    parent: StubElement<*>?,
    override val name: String,
) : StubBase<Gta3ScriptLabelDecl>(parent, LabelDeclStubElementType), LabelDeclStub
