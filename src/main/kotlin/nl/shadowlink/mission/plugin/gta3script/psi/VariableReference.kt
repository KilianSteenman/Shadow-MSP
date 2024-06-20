package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class VariableReference(
    element: PsiElement
) : PsiReferenceBase<PsiElement>(element, TextRange.from(0, element.textLength)) {

    private val variableName = element.text

    override fun resolve(): PsiElement? {
        return element.project.findVariableDefinition(variableName)
    }

    override fun getAbsoluteRange(): TextRange {
        return element.textRange
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        Gta3ScriptUtils.setName(element as Gta3ScriptVariable, newElementName)
        return element
    }

    override fun getVariants(): Array<Any> {
        return element.project.getVariables().toTypedArray()
    }
}