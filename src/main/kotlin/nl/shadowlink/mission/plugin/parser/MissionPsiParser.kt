package nl.shadowlink.mission.plugin.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.extensions.logWarn
import nl.shadowlink.mission.plugin.lexer.MissionExpressionType
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.lexer.MissionTokenType.Companion.OPCODE_EXPRESSION_TYPES

class MissionPsiParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        builder.setDebugMode(true)

        val rootMarker = builder.mark()
        while (builder.tokenType != null) {
            val marker = builder.mark()
            when (builder.tokenType as MissionTokenType) {
                MissionTokenType.KEY_DEFINE -> handleDefine(marker, builder)
                MissionTokenType.OPCODE -> handleOpcode(marker, builder)
                MissionTokenType.LABEL -> handleDefault(marker, builder, MissionTokenType.LABEL)
                MissionTokenType.LABEL_REF -> handleDefault(marker, builder, MissionTokenType.LABEL_REF)
                MissionTokenType.SPACE -> handleDefault(marker, builder, MissionTokenType.SPACE)
                MissionTokenType.STRING -> handleDefault(marker, builder, MissionTokenType.STRING)
                MissionTokenType.STRING_KEY -> handleDefault(marker, builder, MissionTokenType.STRING_KEY)
                MissionTokenType.MODEL -> handleDefault(marker, builder, MissionTokenType.MODEL)
                MissionTokenType.GLOBAL_VAR -> handleDefault(marker, builder, MissionTokenType.GLOBAL_VAR)
                MissionTokenType.LOCAL_VAR -> handleDefault(marker, builder, MissionTokenType.LOCAL_VAR)
                MissionTokenType.FLOAT -> handleDefault(marker, builder, MissionTokenType.FLOAT)
                MissionTokenType.INT -> handleDefault(marker, builder, MissionTokenType.INT)
                else -> {
                    builder.advanceLexer()
                    marker.done(MissionTokenType.SPACE)
                }
            }
        }
        rootMarker.done(MissionTokenType.OPCODE)

        return builder.treeBuilt
    }

    private fun handleDefine(defineMarker: PsiBuilder.Marker, builder: PsiBuilder) {
        builder.advanceLexer()
        val defineType = builder.mark()

        when (builder.tokenType as MissionTokenType) {
            MissionTokenType.KEY_MISSIONS -> {
                builder.advanceLexer()
                defineType.done(MissionTokenType.KEY_MISSIONS)
                val objectCount = builder.mark()
                if (builder.tokenType == MissionTokenType.INT) {
                    builder.advanceLexer()
                    objectCount.done(MissionTokenType.INT)
                } else {
                    objectCount.error("Expected number indicating object count")
                }
                defineMarker.done(MissionExpressionType.DEFINE_MISSION_COUNT)
            }
            MissionTokenType.KEY_MISSION -> parseDefineMission(defineType, defineMarker, builder)
            MissionTokenType.KEY_OBJECTS -> {
                builder.advanceLexer()
                defineType.done(MissionTokenType.KEY_OBJECTS)
                val objectCount = builder.mark()
                if (builder.tokenType == MissionTokenType.INT) {
                    builder.advanceLexer()
                    objectCount.done(MissionTokenType.INT)
                } else {
                    objectCount.error("Expected number indicating object count")
                }
                defineMarker.done(MissionExpressionType.DEFINE_OBJECT_COUNT)
            }
            MissionTokenType.KEY_OBJECT -> parseDefineObject(defineType, defineMarker, builder)
            else -> {
                builder.advanceLexer()
                defineType.done(MissionTokenType.KEY_MISSIONS)
                defineMarker.done(MissionExpressionType.DEFINE_MISSION_COUNT)
            }
        }
    }

    private fun parseDefineObject(defineType: PsiBuilder.Marker, defineMarker: PsiBuilder.Marker, builder: PsiBuilder) {
        builder.advanceLexer()
        defineType.done(MissionTokenType.KEY_OBJECT)

        val objectName = builder.mark()
        if (builder.tokenType == MissionTokenType.OPCODE_TEXT) {
            builder.advanceLexer()
            objectName.done(MissionTokenType.OBJECT_NAME)
        } else {
            objectName.error("Expected object name")
        }

        defineMarker.done(MissionExpressionType.DEFINE_OBJECT)
    }

    private fun parseDefineMission(defineType: PsiBuilder.Marker, defineMarker: PsiBuilder.Marker, builder: PsiBuilder) {
        builder.advanceLexer()
        defineType.done(MissionTokenType.KEY_MISSION)

        val missionIndex = builder.mark()
        if (builder.tokenType == MissionTokenType.INT) {
            builder.advanceLexer()
            missionIndex.done(MissionTokenType.INT)
        } else {
            missionIndex.error("Expected mission index")
        }

        val missionAtKeyword = builder.mark()
        if (builder.tokenType == MissionTokenType.KEY_AT) {
            builder.advanceLexer()
            missionAtKeyword.done(MissionTokenType.KEY_AT)
        } else {
            missionAtKeyword.error("Expected AT keyword")
        }

        val missionLabel = builder.mark()
        if (builder.tokenType == MissionTokenType.LABEL_REF) {
            builder.advanceLexer()
            missionLabel.done(MissionTokenType.LABEL_REF)
        } else {
            missionLabel.error("Expected label reference")
        }

        // TODO: Somehow include comments
//        if (MissionTokenType.COMMENT_TYPES.contains(builder.tokenType)) {
//            val commentMark = builder.mark()
//            builder.advanceLexer()
//            commentMark.done(MissionTokenType.COMMENT)
//        }

        defineMarker.done(MissionExpressionType.DEFINE_MISSION)
    }

    private fun handleOpcode(marker: PsiBuilder.Marker, builder: PsiBuilder) {
        builder.advanceLexer()

        var paramType = builder.lookAhead(0)
        while (paramType != null && isValidOpcodeExpressionType(paramType)) {

            val tokenType = when (paramType) {
                MissionTokenType.LOCAL_VAR -> {
                    when (builder.lookAhead(1)) {
                        MissionTokenType.EQUAL -> MissionTokenType.LOCAL_VAR_DEF
                        else -> MissionTokenType.LOCAL_VAR_REF
                    }
                }
                MissionTokenType.GLOBAL_VAR -> {
                    when (builder.lookAhead(1)) {
                        MissionTokenType.EQUAL -> MissionTokenType.GLOBAL_VAR_DEF
                        else -> MissionTokenType.GLOBAL_VAR_REF
                    }
                }
                else -> paramType
            }

            val paramMarker = builder.mark()
            builder.advanceLexer()
            paramMarker.done(tokenType)
            paramType = builder.lookAhead(0)
        }

        marker.done(MissionExpressionType.OPCODE_EXPRESSION)
    }

    private fun isValidOpcodeExpressionType(elementType: IElementType?): Boolean {
        return OPCODE_EXPRESSION_TYPES.contains(elementType)
    }

    private fun handleDefault(marker: PsiBuilder.Marker, builder: PsiBuilder, missionTokenType: MissionTokenType) {
        builder.advanceLexer()
        marker.done(missionTokenType)
    }
}