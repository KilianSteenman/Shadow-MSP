package nl.shadowlink.mission.plugin.psi.global

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.psi.PsiElementFactory

class GlobalVarElement(node: ASTNode) : ASTWrapperPsiElement(node), PsiNamedElement {

    override fun getName(): String {
        return node.text.substring(1)
    }

    override fun setName(name: String): PsiElement {
        val replacement = PsiElementFactory(this.project).createGlobalVar(name)
        return this.replace(replacement)
    }

    override fun getReferences(): Array<PsiReference> {
        val file = PsiTreeUtil.getParentOfType(this, PsiFile::class.java)
        val vars = PsiTreeUtil.collectElementsOfType(file, GlobalVarElement::class.java)

        return vars.map { GlobalVarReference(it) }.toTypedArray()

//        return super.getReferences()
    }

    
}

class GlobalVarReference(
    private val element: GlobalVarElement
) : PsiReferenceBase<GlobalVarElement>(element, TextRange(0, element.textLength)) {
    override fun resolve(): PsiElement {
        return element
    }

//    override fun handleElementRename(newName: String): PsiElement {
//        val replacement = PsiElementFactory(project).createGlobalVar(newName)
//        return replace(replacement)
//    }
}