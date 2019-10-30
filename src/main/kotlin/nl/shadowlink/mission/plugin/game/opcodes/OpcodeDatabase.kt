package nl.shadowlink.mission.plugin.game.opcodes

import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.logWarn
import java.io.File

class OpcodeDatabase {

    private val opcodes = mutableListOf<String>()

    init {
        val opcodesFilePath = MissionSettings().sannyPath.replace("sanny.exe", "data/vc/opcodes.txt")
        logWarn("Opcodes file $opcodesFilePath")
        File(opcodesFilePath).readLines().forEach { line ->
            if (line.isNotBlank()) {
                logWarn("Opcode $line")
                opcodes.add(line.substring(0, 4))
            }
        }
        logWarn("Opcode count ${opcodes.size}")
    }

    fun isOpcodeValid(opcode: String): Boolean {
        return opcodes.contains(opcode)
    }
}