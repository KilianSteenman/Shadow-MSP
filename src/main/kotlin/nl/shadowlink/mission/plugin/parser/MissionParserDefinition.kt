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
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.psi.*

class MissionParserDefinition : ParserDefinition {

    override fun createParser(project: Project): PsiParser = MissionPsiParser()

    override fun createFile(viewProvider: FileViewProvider): PsiFile = MissionFile(viewProvider)

    override fun getFileNodeType(): IFileElementType =
            IFileElementType(Language.findInstance(MissionLanguage::class.java))

    override fun createLexer(project: Project): Lexer = MissionLexer()

    override fun createElement(node: ASTNode): PsiElement {
        return when(node.elementType) {
            MissionTokenType.LABEL -> LabelDefinitionElement(node)
            MissionTokenType.LABEL_REF -> LabelReferenceElement(node)
            MissionTokenType.STRING_KEY -> StringKeyElement(node)
            MissionTokenType.SYMBOL -> GlobalVarReferenceElement(node)
            MissionTokenType.LOCAL_VAR -> LocalVarElement(node)
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