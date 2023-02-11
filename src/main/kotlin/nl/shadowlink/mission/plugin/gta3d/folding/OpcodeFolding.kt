package nl.shadowlink.mission.plugin.gta3d.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.openapi.editor.FoldingGroup
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.gta3d.psi.defines.DefineMissionElement
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeElement
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeExpression

class OpcodeFolding : FoldingBuilderEx() {

    override fun getPlaceholderText(node: ASTNode): String? {
        return ""
    }

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val group = FoldingGroup.newGroup("Opcode")

        val descriptors = ArrayList<FoldingDescriptor>()
        val opcodeElements = PsiTreeUtil.findChildrenOfType(root, OpcodeExpression::class.java)
                .flatMap { opcodeExpression -> PsiTreeUtil.findChildrenOfType(opcodeExpression, PsiElement::class.java) }
                .filter { element -> element.node.elementType == MissionTokenType.OPCODE }

        opcodeElements.forEach { opcodeElement ->
            descriptors.add(object : FoldingDescriptor(opcodeElement.node,
                    TextRange(opcodeElement.textRange.startOffset,
                            opcodeElement.textRange.endOffset),
                    group) {
                override fun getPlaceholderText(): String? {
                    return opcodeElement.text
                }

                override fun isNonExpandable(): Boolean {
                    return true
                }

                override fun canBeRemovedWhenCollapsed(): Boolean {
                    return false
                }
            })
        }
        return descriptors.toTypedArray()
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = true
}