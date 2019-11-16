package nl.shadowlink.mission.plugin.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

enum class MissionColor(humanName: String, val attributesKey: TextAttributesKey) {
    LINE_COMMENT("Comments//Line comment", Default.LINE_COMMENT),

    NUMBER("Literals//Number", Default.NUMBER),
    STRING("Literals//String", Default.STRING),

    CONSTANT("Constants", Default.CONSTANT),
    KEYWORD("Keywords//Define", Default.KEYWORD),

    LABEL("Labels//Declaration", Default.FUNCTION_DECLARATION),
    LABEL_REF("Labels//Reference", Default.FUNCTION_DECLARATION),

    GLOBAL_VAR("Variables//Global", Default.INSTANCE_FIELD),
    LOCAL_VAR("Variables//Local", Default.LOCAL_VARIABLE);

    private val textAttributesKey = TextAttributesKey.createTextAttributesKey("missionscript.$name", attributesKey)
    val attributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
}