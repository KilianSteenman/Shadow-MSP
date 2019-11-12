package nl.shadowlink.mission.plugin.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.openapi.editor.FoldingGroup
import nl.shadowlink.mission.plugin.psi.defines.DefineMissionElement


class MissionFolding : FoldingBuilderEx() {

    override fun getPlaceholderText(node: ASTNode): String? {
        return "Missions ..."
    }

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val group = FoldingGroup.newGroup("simple")

        val descriptors = ArrayList<FoldingDescriptor>()
        val defineMissionExpressions = PsiTreeUtil.findChildrenOfType(root, DefineMissionElement::class.java)

        if (defineMissionExpressions.size > 2) {
            val firstMission = defineMissionExpressions.firstOrNull()
            val lastMission = defineMissionExpressions.lastOrNull()
            if (firstMission != null && lastMission != null) {
                descriptors.add(object : FoldingDescriptor(firstMission.node,
                        TextRange(firstMission.textRange.startOffset,
                                lastMission.textRange.endOffset),
                        group) {
                    override fun getPlaceholderText(): String? {
                        return "Missions ..."
                    }
                })
            }
        }
        return descriptors.toTypedArray()
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = true
}