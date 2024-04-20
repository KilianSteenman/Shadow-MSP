//package nl.shadowlink.mission.plugin.gta3script.psi
//
//import com.intellij.lang.findUsages.FindUsagesProvider
//import com.intellij.psi.PsiElement
//
//internal class Gta3ScriptUsagesProvider : FindUsagesProvider {
//
//    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
//        return psiElement is MissionSubroutineDefinition ||
//                psiElement is MissionVariableDefinition
//    }
//
//    override fun getHelpId(psiElement: PsiElement): String? {
//        return "help ID? for element $psiElement"
//    }
//
//    override fun getType(element: PsiElement): String {
//        return when (element) {
//            is MissionSubroutineDefinition -> "Subroutine"
//            is MissionVariableDefinition -> "Variable"
//            else -> throw IllegalStateException("Unknown element type $element")
//        }
//    }
//
//    override fun getDescriptiveName(element: PsiElement): String {
//        return "Descriptive name for element $element"
//    }
//
//    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
//        return when (element) {
//            is MissionSubroutineDefinition -> element.subroutine.text
//            is MissionVariableDefinition -> element.identifier.text
//            else -> throw IllegalStateException("Unable to get text for node $element")
//        }
//    }
//}