package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.psi.tree.TokenSet

object Gta2MissionTokenSets {

    val IDENTIFIERS: TokenSet = TokenSet.create(Gta2MissionTypes.IDENTIFIER)
    val COMMENTS: TokenSet = TokenSet.create(Gta2MissionTypes.COMMENT, Gta2MissionTypes.COMMENT_BLOCK)

    val KEYWORDS: TokenSet = TokenSet.create(
        Gta2MissionTypes.IF,
        Gta2MissionTypes.AND,
        Gta2MissionTypes.ELSE,
        Gta2MissionTypes.END_IF,
        Gta2MissionTypes.WHILE,
        Gta2MissionTypes.WHILE_EXEC,
        Gta2MissionTypes.END_WHILE,
        Gta2MissionTypes.END_WHILE_EXEC,
        Gta2MissionTypes.LEVEL_START,
        Gta2MissionTypes.LEVEL_END,
        Gta2MissionTypes.MISSION_START,
        Gta2MissionTypes.MISSION_END,
        Gta2MissionTypes.RETURN
    )
}