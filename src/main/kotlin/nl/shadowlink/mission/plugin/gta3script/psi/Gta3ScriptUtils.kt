package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

object Gta3ScriptUtils {

    /**
     * Subroutines
     */

    @JvmStatic
    fun getNameIdentifier(element: Gta3ScriptSubroutineDefinition): PsiElement? {
        return element.node.findChildByType(Gta3ScriptTypes.SUBROUTINE)?.psi
    }

    @JvmStatic
    fun setName(element: Gta3ScriptSubroutineDefinition, name: String): PsiElement? {
        return element
    }

    @JvmStatic
    fun getName(element: Gta3ScriptSubroutineDefinition): String {
        val text = element.identifier.text
        return text.substring(0, text.length - 1)
    }

//    @JvmStatic
//    fun getReference(element: Gta3ScriptSubroutineReference): PsiReference? {
//        return element.project.findSubroutineDefinition("test")
//            ?.let { def -> Gta3ScriptSubroutineReference(element, TextRange(0, element.textLength)) }
//    }

    /**
     * Variables
     */

    @JvmStatic
    fun getNameIdentifier(element: Gta3ScriptVariableDefinition): PsiElement? {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.psi
    }

    @JvmStatic
    fun setName(element: Gta3ScriptVariableDefinition, name: String): PsiElement? {
        return element
    }

    @JvmStatic
    fun getName(element: Gta3ScriptVariableDefinition): String {
        return element.text
    }

//    @JvmStatic
//    fun getReference(element: Gta3ScriptVariableReference): PsiReference? {
//        return element.project.findVariableDefinition(element.identifier.text)
//            ?.let { def -> Gta3ScriptVariableReference(element, TextRange(0, element.textLength)) }
//    }
}