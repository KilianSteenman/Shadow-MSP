package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.stubs.IStubElementType
import nl.shadowlink.mission.plugin.gta3script.indexing.LabelDeclStub
import nl.shadowlink.mission.plugin.gta3script.indexing.VariableDeclStub

interface Gta3ScriptLabelDeclElement : PsiNameIdentifierOwner

abstract class Gta3ScriptLabelDeclElementImpl : StubBasedPsiElementBase<LabelDeclStub>, Gta3ScriptLabelDeclElement {

    constructor(node: ASTNode) : super(node)
    constructor(stub: LabelDeclStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)

    override fun toString() = "Gta3ScriptLabelDecl"
}
