package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.psi.tree.TokenSet

object Gta3ScriptTokenSets {

    val IDENTIFIERS: TokenSet = TokenSet.create(Gta3ScriptTypes.IDENTIFIER)
    val COMMENTS: TokenSet = TokenSet.create(Gta3ScriptTypes.COMMENT)

    val KEYWORDS: TokenSet = TokenSet.create(
        Gta3ScriptTypes.IF,
        Gta3ScriptTypes.AND,
        Gta3ScriptTypes.ELSE,
        Gta3ScriptTypes.END_IF,
        Gta3ScriptTypes.WHILE,
        Gta3ScriptTypes.WHILE_EXEC,
        Gta3ScriptTypes.END_WHILE,
        Gta3ScriptTypes.END_WHILE_EXEC,
        Gta3ScriptTypes.EXEC,
        Gta3ScriptTypes.END_EXEC,
        Gta3ScriptTypes.LEVEL_START,
        Gta3ScriptTypes.LEVEL_END,
        Gta3ScriptTypes.MISSION_START,
        Gta3ScriptTypes.MISSION_END,
        Gta3ScriptTypes.RETURN
    )
}