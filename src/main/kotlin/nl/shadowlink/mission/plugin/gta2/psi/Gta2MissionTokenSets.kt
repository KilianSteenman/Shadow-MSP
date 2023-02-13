package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.psi.tree.TokenSet

object Gta2MissionTokenSets {

    val IDENTIFIERS: TokenSet = TokenSet.create(Gta2MissionTypes.IDENTIFIER)
    val COMMENTS: TokenSet = TokenSet.create(Gta2MissionTypes.COMMENT, Gta2MissionTypes.COMMENT_BLOCK)
}