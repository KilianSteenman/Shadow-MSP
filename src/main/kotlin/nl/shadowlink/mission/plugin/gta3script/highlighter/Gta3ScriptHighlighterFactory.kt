package nl.shadowlink.mission.plugin.gta3script.highlighter

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighter

class Gta3ScriptHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter(): SyntaxHighlighter = Gta3ScriptHighlighter()
}