package nl.shadowlink.mission.plugin.gta3script

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
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptConditionBody
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptConditionBodyImpl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptConditionalStatementImpl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptIfExpressionImpl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptMissionBlockImpl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptSubroutineBodyImpl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptSubroutineDefinitionImpl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptWhileExpressionImpl

internal class Gta3ScriptFoldingBuilder : FoldingBuilderEx(), DumbAware {
    private val LOG: Logger = Logger.getInstance(this::class.java)

    private val foldableElementTypes = listOf(
        Gta3ScriptMissionBlockImpl::class.java,
        Gta3ScriptWhileExpressionImpl::class.java,
        Gta3ScriptIfExpressionImpl::class.java,
        Gta3ScriptSubroutineDefinitionImpl::class.java,
    )

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        return foldableElementTypes
            .flatMap { type -> PsiTreeUtil.findChildrenOfType(root, type) }
            .map { literalExpression -> literalExpression.toFoldingDescriptor() }
            .toTypedArray()
    }

    private fun PsiElement.toFoldingDescriptor(): FoldingDescriptor {
        return when (this) {
            is Gta3ScriptWhileExpressionImpl -> this.toConditionalFoldingDescriptor()
            is Gta3ScriptIfExpressionImpl -> this.toConditionalFoldingDescriptor()
            is Gta3ScriptSubroutineDefinitionImpl -> this.toFoldingDescriptor()
            else -> this.toDefaultFoldingDescriptor()
        }
    }

    private fun Gta3ScriptSubroutineDefinitionImpl.toFoldingDescriptor(): FoldingDescriptor {
        return FoldingDescriptor(
            this.node,
            TextRange(
                this.firstChild.endOffset - 1, // TODO: This feels dirty, but gets rid of the linebreak
                this.lastChild.startOffset,
            ),
            FoldingGroup.newGroup("Subroutine")
        )
    }

    private fun PsiElement.toDefaultFoldingDescriptor(): FoldingDescriptor {
        return FoldingDescriptor(
            this.node,
            TextRange(
                this.firstChild.endOffset,
                this.lastChild.startOffset,
            ),
            FoldingGroup.newGroup("debug name")
        )
    }

    private fun PsiElement.toConditionalFoldingDescriptor(): FoldingDescriptor {
        val conditionBody = childrenOfType<Gta3ScriptConditionBodyImpl>().first()
        val startOffset = conditionBody.startOffset - 2
        val endOffset = conditionBody.endOffset - 1

        return FoldingDescriptor(
            this.node,
            TextRange(
                startOffset,
                endOffset,
            ),
            FoldingGroup.newGroup("Conditional")
        )
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return when (node.psi) {
            is Gta3ScriptMissionBlockImpl -> "..."
            is Gta3ScriptWhileExpressionImpl -> "..."
            is Gta3ScriptIfExpressionImpl -> "..."
            is Gta3ScriptSubroutineDefinitionImpl -> "..."
            is Gta3ScriptConditionBodyImpl -> "..."
            else -> error("Placeholder not defined for node $node")
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false
}
