package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.stubs.IStubElementType
import nl.shadowlink.mission.plugin.gta3script.indexing.VariableStub

interface Gta3ScriptVariableElement : PsiNameIdentifierOwner

abstract class Gta3ScriptVariableElementImpl : StubBasedPsiElementBase<VariableStub>, Gta3ScriptVariableElement {
    constructor(node: ASTNode) : super(node)
    constructor(stub: VariableStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)

    override fun toString() = "Gta3ScriptVariable"
}
