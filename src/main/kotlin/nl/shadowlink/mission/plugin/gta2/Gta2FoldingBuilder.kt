package nl.shadowlink.mission.plugin.gta2

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.childrenOfType
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionElementType
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes
import nl.shadowlink.mission.plugin.gta2.psi.MissionWhileExpression
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionConditionalStatementImpl
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionDefinitionBlockImpl
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionIfExpressionImpl
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionLevelBlockImpl
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionWhileExpressionImpl

public class Gta2FoldingBuilder : FoldingBuilderEx(), DumbAware {
    private val LOG: Logger = Logger.getInstance(this::class.java)

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        printPsi(root)

        // Initialize the group of folding regions that will expand/collapse together.
        val group = FoldingGroup.newGroup("debug name")

        return codeBlockElementTypes
            .flatMap { type -> PsiTreeUtil.findChildrenOfType(root, type) }
            .map { literalExpression -> literalExpression.toFoldingDescriptor() }
            .toTypedArray()
    }

    private fun PsiElement.toFoldingDescriptor(): FoldingDescriptor {
        return when (this) {
            is MissionWhileExpressionImpl -> this.toConditionalFoldingDescriptor()
            is MissionIfExpressionImpl -> this.toConditionalFoldingDescriptor()
            else -> {
                FoldingDescriptor(
                    this.node,
                    TextRange(
                        this.firstChild.endOffset,
                        this.lastChild.startOffset,
                    ),
                    FoldingGroup.newGroup("debug name")
                )
            }
        }
    }

    private fun PsiElement.toConditionalFoldingDescriptor(): FoldingDescriptor {
        val startOffset = childrenOfType<MissionConditionalStatementImpl>().firstOrNull()?.endOffset?.plus(1)
            ?: this.firstChild.endOffset

        return FoldingDescriptor(
            this.node,
            TextRange(
                startOffset,
                this.lastChild.startOffset,
            ),
            FoldingGroup.newGroup("debug name")
        )
    }

    private fun printPsi(element: PsiElement) {
        element.children.forEach {
            LOG.warn("Element $it")
            printPsi(it)
        }
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return when (node.psi) {
            is MissionLevelBlockImpl -> "..."
            is MissionWhileExpressionImpl -> "..."
            is MissionIfExpressionImpl -> "..."
            else -> error("Placeholder not defined for node $node")
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false

    companion object {

        private val codeBlockElementTypes = listOf(
            MissionLevelBlockImpl::class.java,
            MissionWhileExpressionImpl::class.java,
            MissionIfExpressionImpl::class.java
        )
    }
}