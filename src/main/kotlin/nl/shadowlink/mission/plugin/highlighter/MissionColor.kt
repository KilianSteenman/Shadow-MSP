package nl.shadowlink.mission.plugin.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

enum class MissionColor(humanName: String, val attributesKey: TextAttributesKey) {
    LINE_COMMENT("Comments//Line comment", Default.LINE_COMMENT),

    NUMBER("Literals//Number", Default.NUMBER),
    STRING("Literals//String", Default.STRING);

    private val textAttributesKey = TextAttributesKey.createTextAttributesKey("missionscript.$name", attributesKey)
    val attributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
}