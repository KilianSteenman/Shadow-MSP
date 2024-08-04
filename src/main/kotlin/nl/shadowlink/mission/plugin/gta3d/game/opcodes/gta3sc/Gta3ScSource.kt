package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import kotlinx.serialization.Serializable
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeSource
import nl.shadowlink.mission.plugin.settings.ShadowMspSettings
import java.io.File

class Gta3ScSource(
    private val gta3scPath: String
) : OpcodeSource {

    private val parser = CommandParser()
    private val commandMapper = CommandMapper()

    override fun loadOpcodes(): Map<String, Opcode> {
        val file = File("${File(gta3scPath).parentFile}/config/gta3/commands.xml")
        println("Commands file $file")
        if (file.exists()) {
            val commands = parser.parseCommands(file.readText())
            return commands?.commands?.commands
                ?.map { commandMapper.toOpcode(it) }
                ?.associate { opcode -> opcode.opcode to opcode } ?: emptyMap()
        }
        return emptyMap()
    }
}
