package nl.shadowlink.mission.plugin.usages

import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import nl.shadowlink.mission.plugin.lexer.MissionLexer
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.psi.label.LabelDefinitionElement
import nl.shadowlink.mission.plugin.psi.local.LocalVarDefinitionElement

class MissionUsagesProvider : FindUsagesProvider {

    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(MissionLexer(),
                MissionTokenType.FIND_USAGES,
                MissionTokenType.COMMENT_TYPES,
                TokenSet.EMPTY
        )
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return element.text
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return element.text
    }

    override fun getType(element: PsiElement): String {
        return when (element) {
            is LabelDefinitionElement -> "Label declaration"
            is LocalVarDefinitionElement -> "Local variable declaration"
            else -> "Unknown declaration"
        }
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return psiElement.text
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is PsiNamedElement
    }
}