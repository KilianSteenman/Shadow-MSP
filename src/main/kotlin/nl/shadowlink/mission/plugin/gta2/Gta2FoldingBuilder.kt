package nl.shadowlink.mission.plugin.gta2

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionDefinitionBlockImpl

public class Gta2FoldingBuilder : FoldingBuilderEx(), DumbAware {
    private val LOG: Logger = Logger.getInstance(this::class.java)

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        printPsi(root)

        // Initialize the group of folding regions that will expand/collapse together.
        val group = FoldingGroup.newGroup("debug name")//SimpleAnnotator.SIMPLE_PREFIX_STR)
        // Initialize the list of folding regions
        val descriptors: MutableList<FoldingDescriptor> = ArrayList()
        // Get a collection of the literal expressions in the document below root
        val literalExpressions = PsiTreeUtil.findChildrenOfType(root, MissionDefinitionBlockImpl::class.java)

        // Evaluate the collection
//        for (literalExpression in literalExpressions) {
//            val value = if (literalExpression.getValue() is String) literalExpression.getValue() else null
//            if (value != null && value.startsWith(SimpleAnnotator.SIMPLE_PREFIX_STR + SimpleAnnotator.SIMPLE_SEPARATOR_STR)) {
//                val project: Project = literalExpression.getProject()
//                val key: String = value.substring(
//                    SimpleAnnotator.SIMPLE_PREFIX_STR.length() + SimpleAnnotator.SIMPLE_SEPARATOR_STR.length()
//                )
//                // Get a list of all properties for a given key in the project
//                val properties: List<SimpleProperty> = SimpleUtil.findProperties(project, key)
//                if (properties.size == 1) {
//                    // Add a folding descriptor for the literal expression at this node.
//                    descriptors.add(
//                        FoldingDescriptor(
//                            literalExpression.getNode(),
//                            TextRange(
//                                literalExpression.getTextRange().getStartOffset() + 1,
//                                literalExpression.getTextRange().getEndOffset() - 1
//                            ),
//                            group
//                        )
//                    )
//                }
//            }
//        }
        return descriptors.toTypedArray()
    }

    private fun printPsi(element: PsiElement) {
        element.children.forEach {
            LOG.warn("Element $it")
            printPsi(it)
        }
    }

    override fun getPlaceholderText(node: ASTNode): String = "Placeholder"

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false
}