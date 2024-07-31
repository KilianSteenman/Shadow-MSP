package nl.shadowlink.mission.plugin.gta3d.game.opcodes

import com.intellij.openapi.util.NlsSafe
import nl.shadowlink.mission.plugin.utils.logWarn

class OpcodeDatabase(source: OpcodeSource) {

    private val opcodeMap = source.loadOpcodes()

    val opcodes: List<Opcode> get() = opcodeMap.values.toList()

    init {
        logWarn("Opcode count ${opcodeMap.size}")
    }

    fun isOpcodeValid(opcode: String): Boolean {
        return opcodeMap.containsKey(opcode)
    }

    fun opcode(opcode: String?): Opcode? {
        return opcodeMap["0${opcode?.substring(1)}"]
    }

    fun getOpcodeByName(name: String): Opcode? {
        return opcodes.find { it.format == name }
    }
}