package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

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
        val text = element.text
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

    /*
    * Variable renames
    */
    @JvmStatic
    fun getName(element: Gta3ScriptVariable): String {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.text ?: "UNKNOWN"
    }

    @JvmStatic
    fun setName(element: Gta3ScriptVariable, newName: String): PsiElement {
        val identifierNode = element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)
        if (identifierNode != null) {
            val newIdentifier = Gta3ScriptTypeFactory.createVariable(element.project, newName).node
            element.node.replaceChild(identifierNode, newIdentifier)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: Gta3ScriptVariable): PsiElement? {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.psi
    }
}