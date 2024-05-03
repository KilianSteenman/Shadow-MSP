package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult

internal class Gta2SubroutineReference(
    element: MissionSubroutineReference,
    textRange: TextRange
) : PsiReferenceBase<MissionSubroutineReference>(element, textRange), PsiPolyVariantReference {

    private var name: String = element.text.substring(textRange.startOffset, textRange.endOffset - 1)

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        return myElement.project.findSubroutineDefinition(name)?.let {
            arrayOf(PsiElementResolveResult(it))
        } ?: emptyArray()
    }

    override fun resolve(): PsiElement? {
        return multiResolve(false).firstOrNull()?.element
    }
}