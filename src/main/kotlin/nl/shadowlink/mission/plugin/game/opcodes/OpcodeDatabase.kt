package nl.shadowlink.mission.plugin.game.opcodes

import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.logWarn
import org.ini4j.Config
import org.ini4j.Ini
import java.io.File
import java.io.FileReader

class OpcodeDatabase {

    val opcodes = mutableListOf<Opcode>()

    init {
        loadOpcodes()
        logWarn("Opcode count ${opcodes.size}")
    }

    private fun loadOpcodes() {
        val opcodesFilePath = MissionSettings().sannyPath.replace("sanny.exe", "data/vc/VCSCM.INI")
        logWarn("Opcodes file $opcodesFilePath")

        val ini = Ini().apply {
            config = Config().apply { isGlobalSection = true }
            load(File(opcodesFilePath))
        }
        ini["OPCODES"]?.forEach { opcode, opcodeInfo ->
            val opcodeData = opcodeInfo.split(',')
            val paramCount = opcodeData[0]
            val opcodeFormat = opcodeData[1]
            opcodes.add(Opcode(opcode, opcodeFormat, emptyList()))
        }
    }

    fun isOpcodeValid(opcode: String): Boolean {
        return opcodes.find { it.opcode == opcode } != null
    }
}