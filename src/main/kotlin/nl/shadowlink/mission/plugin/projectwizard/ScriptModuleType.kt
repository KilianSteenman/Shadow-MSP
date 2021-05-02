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
    val description: String,
    val moduleCreator: ModuleCreator,
    val isAvailable: Boolean = false
) {
    III_SCM(
        game = Game.III,
        type = ScriptType.SCM,
        title = "Mission script - III",
        description = "Mission Script for GTA: III",
        moduleCreator = MissionScriptModuleCreator("iii_main")
    ),
    VC_SCM(
        game = Game.VC,
        type = ScriptType.SCM,
        title = "Mission script - VC",
        description = "Mission Script for GTA: VC",
        moduleCreator = MissionScriptModuleCreator("vc_main"),
        isAvailable = true
    ),
    SA_SCM(
        game = Game.SA,
        type = ScriptType.SCM,
        title = "Mission script - SA",
        description = "Mission Script for GTA: SA",
        moduleCreator = NoopModuleCreator()
    ),
    III_CLEO(
        game = Game.III,
        type = ScriptType.CLEO,
        title = "Cleo script - III",
        description = "Cleo Script for GTA: III",
        moduleCreator = NoopModuleCreator()
    ),
    VC_CLEO(
        game = Game.VC,
        type = ScriptType.CLEO,
        title = "Cleo script - VC",
        description = "Cleo Script for GTA: VC",
        moduleCreator = CleoModuleCreator(),
        isAvailable = true
    ),
    SA_CLEO(
        game = Game.SA,
        type = ScriptType.CLEO,
        title = "Cleo script - SA",
        description = "Cleo Script for GTA: SA",
        moduleCreator = NoopModuleCreator()
    );

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