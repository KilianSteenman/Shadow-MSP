package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

object Gta2Utils {

    @JvmStatic
    fun getNameIdentifier(element: MissionSubroutineDefinition): PsiElement? {
        return element.node.findChildByType(Gta2MissionTypes.SUBROUTINE)?.psi
    }

    @JvmStatic
    fun setName(element: MissionSubroutineDefinition, name: String): PsiElement? {
        return element
    }

    @JvmStatic
    fun getName(element: MissionSubroutineDefinition): String {
        val text = element.subroutine.text
        return text.substring(0, text.length - 1)
    }

    @JvmStatic
    fun getReference(element: MissionSubroutineReference): PsiReference? {
        return element.project.findSubroutineDefinition("test")
            ?.let { def -> Gta2SubroutineReference(element, TextRange(0, element.textLength)) }
    }
}