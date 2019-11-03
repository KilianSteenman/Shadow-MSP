package nl.shadowlink.mission.plugin.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.tree.IFileElementType
import nl.shadowlink.mission.plugin.MissionFile
import nl.shadowlink.mission.plugin.lexer.MissionLexer
import nl.shadowlink.mission.plugin.MissionLanguage
import nl.shadowlink.mission.plugin.lexer.MissionExpressionType
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.psi.*
import nl.shadowlink.mission.plugin.psi.label.LabelDefinitionElement
import nl.shadowlink.mission.plugin.psi.label.LabelReferenceElement
import nl.shadowlink.mission.plugin.psi.local.LocalVarDefinitionElement
import nl.shadowlink.mission.plugin.psi.local.LocalVarReferenceElement

class MissionParserDefinition : ParserDefinition {

    override fun createParser(project: Project): PsiParser = MissionPsiParser()

    override fun createFile(viewProvider: FileViewProvider): PsiFile = MissionFile(viewProvider)

    override fun getFileNodeType(): IFileElementType =
            IFileElementType(Language.findInstance(MissionLanguage::class.java))

    override fun createLexer(project: Project): Lexer = MissionLexer()

    override fun createElement(node: ASTNode): PsiElement {
        return when(node.elementType) {
            MissionExpressionType.DEFINE_MISSION_COUNT -> DefineMissionCountElement(node)
            MissionExpressionType.DEFINE_OBJECT_COUNT -> DefineObjectCountElement(node)
            MissionExpressionType.OPCODE_EXPRESSION -> OpcodeExpression(node)
            MissionTokenType.KEY_DEFINE -> DefinitionElement(node)
            MissionTokenType.KEY_OBJECTS -> ObjectCountElement(node)
            MissionTokenType.LABEL -> LabelDefinitionElement(node)
            MissionTokenType.LABEL_REF -> LabelReferenceElement(node)
            MissionTokenType.STRING_KEY -> StringKeyElement(node)
            MissionTokenType.GLOBAL_VAR -> GlobalVarReferenceElement(node)
            MissionTokenType.LOCAL_VAR_DEF -> LocalVarDefinitionElement(node)
            MissionTokenType.LOCAL_VAR_REF -> LocalVarReferenceElement(node)
            MissionTokenType.MODEL -> ModelElement(node)
            MissionTokenType.OPCODE -> OpcodeElement(node)
            MissionTokenType.STRING -> StringElement(node)
            else -> DefaultElement(node)
        }
    }

    override fun getWhitespaceTokens(): TokenSet = MissionTokenType.WHITE_SPACE_TYPES

    override fun getStringLiteralElements(): TokenSet = MissionTokenType.STRING_TYPES

    override fun getCommentTokens(): TokenSet = MissionTokenType.COMMENT_TYPES
}