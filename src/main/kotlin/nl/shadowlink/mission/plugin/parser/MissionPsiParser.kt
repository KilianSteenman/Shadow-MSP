package nl.shadowlink.mission.plugin.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.lexer.MissionTokenType

class MissionPsiParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        builder.setDebugMode(true)

        val rootMarker = builder.mark()
        while (builder.tokenType != null) {
            val marker = builder.mark()
            when (builder.tokenType as MissionTokenType) {
                MissionTokenType.OPCODE -> handleDefault(marker, builder, MissionTokenType.OPCODE)
                MissionTokenType.LABEL -> handleDefault(marker, builder, MissionTokenType.LABEL)
                MissionTokenType.LABEL_REF -> handleDefault(marker, builder, MissionTokenType.LABEL_REF)
                MissionTokenType.SPACE -> handleDefault(marker, builder, MissionTokenType.SPACE)
                MissionTokenType.STRING -> handleDefault(marker, builder, MissionTokenType.STRING)
                MissionTokenType.MODEL -> handleDefault(marker, builder, MissionTokenType.MODEL)
                MissionTokenType.SYMBOL -> handleDefault(marker, builder, MissionTokenType.SYMBOL)
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

    private fun handleDefault(marker: PsiBuilder.Marker, builder: PsiBuilder, missionTokenType: MissionTokenType) {
        builder.advanceLexer()
        marker.done(missionTokenType)
    }
}