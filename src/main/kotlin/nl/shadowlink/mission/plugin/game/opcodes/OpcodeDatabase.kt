package nl.shadowlink.mission.plugin.game.opcodes

import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.logError
import nl.shadowlink.mission.plugin.extensions.logWarn
import org.ini4j.Config
import org.ini4j.Ini
import java.io.File

class OpcodeDatabase {

    private val opcodeMap = mutableMapOf<String, Opcode>()

    val opcodes: List<Opcode> get() = opcodeMap.values.toList()

    init {
        loadOpcodes()
        logWarn("Opcode count ${opcodeMap.size}")
    }

    private fun loadOpcodes() {
        val iniPath = "${MissionSettings().sannyPath}/data/vc/VCSCM.INI"
        if (!File(iniPath).exists()) {
            logWarn("Unable to load opcode data, make sure path to Sanny Builder is configured in Mission Script settings")
            return
        }

        logWarn("Opcodes file $iniPath")

        val ini = Ini().apply {
            config = Config().apply { isGlobalSection = true }
            load(File(iniPath))
        }
        ini["OPCODES"]?.forEach { opcode, opcodeInfo ->
            val opcodeData = opcodeInfo.split(',')
            val paramCount = opcodeData[0].toInt()
            val opcodeFormat = opcodeData[1]
            val paramRegex = Regex("%\\d+([dpogsh])%")
            val params = paramRegex.findAll(opcodeFormat)
                    .map { placeHolderToParam(it.groupValues[1]) }
                    .toList()
            opcodeMap[opcode.toUpperCase()] = Opcode(opcode.toUpperCase(), opcodeFormat, paramCount, params)
        }
    }

    private fun placeHolderToParam(paramType: String): OpcodeParam {
        return when (paramType) {
            "s" -> OpcodeParam.STRING
            "g" -> OpcodeParam.GXT_REF
            "o" -> OpcodeParam.MODEL
            "d" -> OpcodeParam.ANY
            "h" -> OpcodeParam.ANY
            "p" -> OpcodeParam.LABEL_REF
            else -> throw IllegalArgumentException("Param type not supported ($paramType)")
        }
    }

    fun isOpcodeValid(opcode: String): Boolean {
        return opcodeMap.containsKey(opcode)
    }

    fun opcode(opcode: String?): Opcode? {
        return opcodeMap["0${opcode?.substring(1)}"]
    }
}