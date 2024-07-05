package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class LabelReference(
    element: PsiElement
) : PsiReferenceBase<PsiElement>(element, TextRange.from(0, element.textLength)) {

    private val labelName = element.text

    override fun resolve(): PsiElement? {
        return element.project.findLabelDeclaration(labelName)
    }

    override fun getAbsoluteRange(): TextRange {
        return element.textRange
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        when (val el = element) {
            is Gta3ScriptLabel -> Gta3ScriptUtils.setName(el, newElementName)
            is Gta3ScriptLabelDecl -> Gta3ScriptUtils.setName(el, newElementName)
        }
        return element
    }

    override fun getVariants(): Array<Any> {
        return element.project.getLabels().map { it.name }.toTypedArray()
    }
}