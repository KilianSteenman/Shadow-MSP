package nl.shadowlink.mission.plugin.gta3script

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import nl.shadowlink.mission.plugin.gta3script.parser.Gta3ScriptParser
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTokenSets
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes

class Gta3ScriptParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer = Gta3ScriptLexerAdapter()

    override fun createParser(project: Project?) = Gta3ScriptParser()

    override fun getFileNodeType() = FILE

    override fun getCommentTokens() = Gta3ScriptTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode): PsiElement = Gta3ScriptTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = Gta3ScriptFile(viewProvider)

    private companion object {
        val FILE = IFileElementType(Gta3ScriptLanguage)
    }
}