package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class LabelReference(
    element: PsiElement
) : PsiReferenceBase<PsiElement>(element, TextRange.from(0, element.textLength)) {

    private val labelName = element.text.substringBefore(":")

    override fun resolve(): PsiElement? {
        return element.project.findLabelDefinition(labelName).also {
            println("Search '$labelName' Found definition '${it?.text}' at ${it?.textRange}")
        }
    }

    override fun getAbsoluteRange(): TextRange {
        return element.textRange
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        Gta3ScriptUtils.setName(element as Gta3ScriptVariable, newElementName)
        return element
    }
}