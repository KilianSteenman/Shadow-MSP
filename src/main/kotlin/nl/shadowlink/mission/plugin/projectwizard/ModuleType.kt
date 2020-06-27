package nl.shadowlink.mission.plugin.projectwizard

import nl.shadowlink.mission.plugin.game.Game

enum class ModuleType(
        val game: Game,
        val type: String,
        val description: String
) {
    VC_SCM(Game.VC, "SCM", "Main script");

    override fun toString(): String {
        return "${game.gameName} - $description"
    }
}