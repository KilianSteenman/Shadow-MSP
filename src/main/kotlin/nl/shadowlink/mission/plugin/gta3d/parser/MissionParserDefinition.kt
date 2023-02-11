package nl.shadowlink.mission.plugin.gta3d.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import nl.shadowlink.mission.plugin.gta3d.MissionFile
import nl.shadowlink.mission.plugin.gta3d.MissionLanguage
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionExpressionType
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionLexer
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.gta3d.psi.DefaultElement
import nl.shadowlink.mission.plugin.gta3d.psi.defines.*
import nl.shadowlink.mission.plugin.gta3d.psi.global.GlobalVarElement
import nl.shadowlink.mission.plugin.gta3d.psi.label.LabelDefinitionElement
import nl.shadowlink.mission.plugin.gta3d.psi.label.LabelReferenceElement
import nl.shadowlink.mission.plugin.gta3d.psi.local.LocalVarDefinitionElement
import nl.shadowlink.mission.plugin.gta3d.psi.local.LocalVarReferenceElement
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeElement
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeExpression
import nl.shadowlink.mission.plugin.gta3d.psi.params.*

class MissionParserDefinition : ParserDefinition {

    override fun createParser(project: Project): PsiParser = MissionPsiParser()

    override fun createFile(viewProvider: FileViewProvider): PsiFile = MissionFile(viewProvider)

    override fun getFileNodeType(): IFileElementType =
        IFileElementType(Language.findInstance(MissionLanguage::class.java))

    override fun createLexer(project: Project): Lexer = MissionLexer()

    override fun createElement(node: ASTNode): PsiElement {
        return when (node.elementType) {
            MissionExpressionType.DEFINE_MISSION_COUNT -> DefineMissionCountElement(node)
            MissionExpressionType.DEFINE_MISSION -> DefineMissionElement(node)
            MissionExpressionType.DEFINE_OBJECT_COUNT -> DefineObjectCountElement(node)
            MissionExpressionType.OPCODE_EXPRESSION -> OpcodeExpression(node)
            MissionTokenType.KEY_DEFINE -> DefinitionElement(node)
            MissionTokenType.LABEL -> LabelDefinitionElement(node)
            MissionTokenType.LABEL_REF -> LabelReferenceElement(node)
            MissionTokenType.STRING_KEY -> StringKeyElement(node)
            MissionTokenType.LOCAL_VAR_DEF -> LocalVarDefinitionElement(node)
            MissionTokenType.LOCAL_VAR_REF -> LocalVarReferenceElement(node)
            MissionTokenType.GLOBAL_VAR -> GlobalVarElement(node)
            MissionTokenType.MODEL -> ModelElement(node)
            MissionTokenType.OPCODE -> OpcodeElement(node)
            MissionTokenType.STRING -> StringElement(node)
            MissionTokenType.INT -> IntElement(node)
            MissionTokenType.FLOAT -> FloatElement(node)
            MissionTokenType.OBJECT_NAME -> ObjectNameElement(node)
            else -> DefaultElement(node)
        }
    }

    override fun getWhitespaceTokens(): TokenSet = MissionTokenType.WHITE_SPACE_TYPES

    override fun getStringLiteralElements(): TokenSet = MissionTokenType.STRING_TYPES

    override fun getCommentTokens(): TokenSet = MissionTokenType.COMMENT_TYPES
}