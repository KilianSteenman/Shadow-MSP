package nl.shadowlink.mission.plugin.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement

class MissionFolding : FoldingBuilderEx() {

    override fun getPlaceholderText(node: ASTNode): String? {
        return "Missions..."
    }

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        return emptyArray()
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = true
}