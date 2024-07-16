package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import kotlinx.serialization.Serializable
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeSource
import nl.shadowlink.mission.plugin.settings.ShadowMspSettings

class Gta3ScSource : OpcodeSource {

    override fun loadOpcodes(): Map<String, Opcode> {
        ShadowMspSettings().gta3scPath
        return emptyMap()
    }
}
