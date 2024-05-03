package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

object Gta2Utils {

    /**
     * Subroutines
     */

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

    /**
     * Variables
     */

    @JvmStatic
    fun getNameIdentifier(element: MissionVariableDefinition): PsiElement? {
        return element.node.findChildByType(Gta2MissionTypes.IDENTIFIER)?.psi
    }

    @JvmStatic
    fun setName(element: MissionVariableDefinition, name: String): PsiElement? {
        return element
    }

    @JvmStatic
    fun getName(element: MissionVariableDefinition): String {
        return element.identifier.text
    }

    @JvmStatic
    fun getReference(element: MissionVariableReference): PsiReference? {
        return element.project.findVariableDefinition(element.identifier.text)
            ?.let { def -> Gta2VariableReference(element, TextRange(0, element.textLength)) }
    }
}