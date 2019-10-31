package nl.shadowlink.mission.plugin.game.opcodes

import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.logWarn
import java.io.File

class OpcodeDatabase {

    val opcodes = mutableListOf<Opcode>()

    init {
        val opcodesFilePath = MissionSettings().sannyPath.replace("sanny.exe", "data/vc/opcodes.txt")
        logWarn("Opcodes file $opcodesFilePath")
        File(opcodesFilePath).readLines().forEach { line ->
            if (line.isNotBlank()) {
                logWarn("Opcode $line")
                opcodes.add(Opcode(line.substring(0, 4), line.substring(6)))
            }
        }
        logWarn("Opcode count ${opcodes.size}")
    }

    fun isOpcodeValid(opcode: String): Boolean {
        return opcodes.find { it.opcode == opcode } != null
    }
}