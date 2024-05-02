package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class ScriptReference(
    element: PsiElement
) : PsiReferenceBase<PsiElement>(element, TextRange.from(0, element.textLength)) {

    private val scriptFileName = element.text

    override fun resolve(): PsiElement? {
        return element.project.findScript(scriptFileName).also {
            println("Search file '$scriptFileName' Found file")
        }
    }

    override fun getAbsoluteRange(): TextRange {
        return element.textRange
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Implement")
//        Gta3ScriptUtils.setName(element as Gta3ScriptVariable, newElementName)
        return element
    }
}