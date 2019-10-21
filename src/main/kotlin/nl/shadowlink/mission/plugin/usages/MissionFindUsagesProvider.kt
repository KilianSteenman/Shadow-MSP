package nl.shadowlink.mission.plugin.usages

import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import nl.shadowlink.mission.plugin.lexer.MissionLexer
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import kotlin.reflect.jvm.jvmName

class MissionFindUsagesProvider: FindUsagesProvider {

    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(MissionLexer(),
                TokenSet.create(MissionTokenType.LABEL, MissionTokenType.LABEL_REF),
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
        return element::class.jvmName
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return psiElement.text
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is PsiNamedElement
    }
}