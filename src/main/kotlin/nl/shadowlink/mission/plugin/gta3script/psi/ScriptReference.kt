package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class ScriptReference(
    element: Gta3ScriptScriptReference
) : PsiReferenceBase<Gta3ScriptScriptReference>(element, TextRange.from(0, element.textLength)) {

    private val scriptFileName = element.text

    override fun resolve(): PsiElement? {
        return element.project.findScript(scriptFileName)
    }

    override fun getAbsoluteRange(): TextRange {
        return element.textRange
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        Gta3ScriptUtils.setName(element, newElementName)
        return element
    }

    override fun getVariants(): Array<Any> {
        return element.project.getScriptFiles().map { it.name }.toTypedArray()
    }
}