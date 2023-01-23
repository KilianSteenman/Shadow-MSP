package nl.shadowlink.mission.plugin.gta2

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import nl.shadowlink.mission.plugin.MissionIcons.FILE
import nl.shadowlink.mission.plugin.gta2.parser.Gta2MissionParser
import nl.shadowlink.mission.plugin.psi.DefaultElement

class Gta2MissionParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer = Gta2LexerAdapter()

    override fun createParser(project: Project?): PsiParser = Gta2MissionParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet {
        // TODO: Implement comment token
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode): PsiElement {
        // TODO: Implement this
        return DefaultElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile = Gta2MissionFile(viewProvider)

    private companion object {
        val FILE = IFileElementType(Gta2MissionLanguage)
    }
}