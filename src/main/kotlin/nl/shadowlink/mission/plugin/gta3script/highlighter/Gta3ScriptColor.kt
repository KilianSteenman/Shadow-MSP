package nl.shadowlink.mission.plugin.gta3script.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

enum class Gta3ScriptColor(humanName: String, val attributesKey: TextAttributesKey) {
    LINE_COMMENT("Comments//Line comment", Default.LINE_COMMENT),
    BLOCK_COMMENT("Comments//Block comment", Default.BLOCK_COMMENT),

    NUMBER("Literals//Number", Default.NUMBER),
    STRING("Literals//String", Default.STRING),

    CONSTANT("Constants", Default.CONSTANT),
    KEYWORD("Keywords//Define", Default.KEYWORD),

    LABEL_DECLARATION("Label//Declaration", Default.FUNCTION_DECLARATION),
    LABEL_REFERENCE("Label//Reference", Default.FUNCTION_CALL),

    VARIABLE_DECLARATION("Variables//Declaration", Default.GLOBAL_VARIABLE),
    VARIABLE_REFERENCE("Variables//Reference", Default.GLOBAL_VARIABLE);

    private val textAttributesKey = TextAttributesKey.createTextAttributesKey("gta3script.$name", attributesKey)
    val attributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
}