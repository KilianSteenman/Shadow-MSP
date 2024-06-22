package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLexerAdapter

internal class Gta3ScriptFindUsagesProvider : FindUsagesProvider {

    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            Gta3ScriptLexerAdapter(),
            Gta3ScriptTokenSets.IDENTIFIERS,
            Gta3ScriptTokenSets.COMMENTS,
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is PsiNamedElement
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return "HelpID"
    }

    override fun getType(element: PsiElement): String {
        if (element is Gta3ScriptVariable) {
            return "Variable"
        }
        return ""
    }

    override fun getDescriptiveName(element: PsiElement): String {
        if (element is Gta3ScriptVariable) {
            return "${element.name}_DESC"
        }
        return ""
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        if (element is Gta3ScriptVariable) {
            return element.name ?: error("No name")
        }
        return ""
    }
}