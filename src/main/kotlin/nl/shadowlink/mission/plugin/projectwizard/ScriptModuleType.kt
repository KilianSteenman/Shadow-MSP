package nl.shadowlink.mission.plugin.projectwizard

import nl.shadowlink.mission.plugin.game.Game
import nl.shadowlink.mission.plugin.projectwizard.modulecreator.CleoModuleCreator
import nl.shadowlink.mission.plugin.projectwizard.modulecreator.MissionScriptModuleCreator
import nl.shadowlink.mission.plugin.projectwizard.modulecreator.ModuleCreator
import nl.shadowlink.mission.plugin.projectwizard.modulecreator.NoopModuleCreator

internal enum class ScriptModuleType(
    val game: Game,
    val type: ScriptType,
    val title: String,
    val moduleCreator: ModuleCreator,
    val isAvailable: Boolean = false
) {
    III_SCM(Game.III, ScriptType.SCM, "Mission script - III", MissionScriptModuleCreator("iii_main")),
    VC_SCM(Game.VC, ScriptType.SCM, "Mission script - VC", MissionScriptModuleCreator("vc_main"), true),
    SA_SCM(Game.SA, ScriptType.SCM, "Mission script - SA", NoopModuleCreator()),
    III_CLEO(Game.III, ScriptType.CLEO, "Cleo script - III", NoopModuleCreator()),
    VC_CLEO(Game.VC, ScriptType.CLEO, "Cleo script - VC", CleoModuleCreator(), true),
    SA_CLEO(Game.SA, ScriptType.CLEO, "Cleo script - SA", NoopModuleCreator());

    override fun toString(): String {
        return "${game.gameName} - $title"
    }
}

internal enum class ScriptType(
    val title: String
) {
    SCM("Mission script"),
    CLEO("Cleo script")
}