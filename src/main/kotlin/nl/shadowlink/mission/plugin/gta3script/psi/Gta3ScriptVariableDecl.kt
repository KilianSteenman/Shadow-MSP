package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.stubs.IStubElementType
import nl.shadowlink.mission.plugin.gta3script.indexing.VariableDeclStub

interface Gta3ScriptVariableDeclElement : PsiNameIdentifierOwner

abstract class Gta3ScriptVariableDeclElementImpl : StubBasedPsiElementBase<VariableDeclStub>, Gta3ScriptVariableDeclElement {

    constructor(node: ASTNode) : super(node)
    constructor(stub: VariableDeclStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)

    override fun toString() = "Gta3ScriptVariableDecl"
}
