package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class LabelReference(
    element: Gta3ScriptLabel
) : PsiReferenceBase<Gta3ScriptLabel>(element, TextRange.from(0, element.textLength)) {

    private val labelName = element.text

    override fun resolve(): PsiElement? {
        return element.project.findLabelDefinition(labelName)
    }

    override fun getAbsoluteRange(): TextRange {
        return element.textRange
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        Gta3ScriptUtils.setName(element, newElementName)
        return element
    }
}