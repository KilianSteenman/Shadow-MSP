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
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionElementType
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTokenSets
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionLevelBlockImpl
import nl.shadowlink.mission.plugin.psi.DefaultElement

class Gta2MissionParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer = Gta2LexerAdapter()

    override fun createParser(project: Project?) = Gta2MissionParser()

    override fun getFileNodeType() = FILE

    override fun getCommentTokens() = Gta2MissionTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode): PsiElement = Gta2MissionTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = Gta2MissionFile(viewProvider)

    private companion object {
        val FILE = IFileElementType(Gta2MissionLanguage)
    }
}