package nl.shadowlink.mission.plugin.gta2.highlighter

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighter

class Gta2MissionHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter(): SyntaxHighlighter = Gta2MissionHighlighter()
}