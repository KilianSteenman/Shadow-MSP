package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

object Gta3ScriptUtils {

    /*
    * Variable
    */

    @JvmStatic
    fun getName(element: Gta3ScriptVariable): String {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.text ?: "UNKNOWN"
    }

    @JvmStatic
    fun setName(element: Gta3ScriptVariable, newName: String): PsiElement {
        val identifierNode = element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)
        if (identifierNode != null) {
            val newIdentifier = Gta3ScriptTypeFactory.createIdentifier(element.project, newName)
            element.node.replaceChild(identifierNode, newIdentifier)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: Gta3ScriptVariable): PsiElement? {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.psi
    }

    @JvmStatic
    fun getReference(element: Gta3ScriptVariable): PsiReference {
        return VariableReference(element)
    }

    /*
    * Label
    */

    @JvmStatic
    fun getName(element: Gta3ScriptLabelIdentifier): String {
        return element.node.findChildByType(Gta3ScriptTypes.GOSUB_IDENTIFIER)?.text?.substringBeforeLast(":")
            ?: "UNKNOWN"
    }

    @JvmStatic
    fun setName(element: Gta3ScriptLabelIdentifier, newName: String): PsiElement {
        TODO("Implement label set name")
//        val identifierNode = element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)
//        if (identifierNode != null) {
//            val newIdentifier = Gta3ScriptTypeFactory.createVariable(element.project, newName).node
//            element.node.replaceChild(identifierNode, newIdentifier)
//        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: Gta3ScriptLabelIdentifier): PsiElement? {
        return element.node.findChildByType(Gta3ScriptTypes.GOSUB_IDENTIFIER)?.psi
    }

    @JvmStatic
    fun getReference(element: Gta3ScriptLabelIdentifier): PsiReference {
        return LabelReference(element)
    }


    /*
    * Label reference
    */

    @JvmStatic
    fun getName(element: Gta3ScriptSubroutineReference): String {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.text ?: "UNKNOWN"
    }

    @JvmStatic
    fun setName(element: Gta3ScriptSubroutineReference, newName: String): PsiElement {
        TODO("Implement label set name")
//        val identifierNode = element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)
//        if (identifierNode != null) {
//            val newIdentifier = Gta3ScriptTypeFactory.createVariable(element.project, newName).node
//            element.node.replaceChild(identifierNode, newIdentifier)
//        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: Gta3ScriptSubroutineReference): PsiElement? {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.psi
    }

    @JvmStatic
    fun getReference(element: Gta3ScriptSubroutineReference): PsiReference {
        return LabelReference(element)
    }

    /*
    * Script reference
    */

    @JvmStatic
    fun getName(element: Gta3ScriptScriptReference): String {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.text ?: "UNKNOWN"
    }

    @JvmStatic
    fun setName(element: Gta3ScriptScriptReference, newName: String): PsiElement {
        println("Setting script reference node to $newName")
        val identifierNode = element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)
        if (identifierNode != null) {
            val newIdentifier = Gta3ScriptTypeFactory.createIdentifier(element.project, newName)
            println("New Identifier node ${newIdentifier.text}")
            element.node.replaceChild(identifierNode, newIdentifier)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: Gta3ScriptScriptReference): PsiElement? {
        return element.node.findChildByType(Gta3ScriptTypes.IDENTIFIER)?.psi
    }

    @JvmStatic
    fun getReference(element: Gta3ScriptScriptReference): PsiReference {
        return ScriptReference(element)
    }
}
