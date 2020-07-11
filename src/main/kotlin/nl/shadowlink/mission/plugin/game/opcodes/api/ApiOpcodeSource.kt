package nl.shadowlink.mission.plugin.game.opcodes.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nl.shadowlink.mission.plugin.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeParam
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeSource

class ApiOpcodeSource : OpcodeSource {

    override fun loadOpcodes(): Map<String, Opcode> {
        val itemType = object : TypeToken<List<OpcodeEntry>>() {}.type
        val entries = Gson().fromJson<List<OpcodeEntry>>(javaClass.getResource("/opcodes/opcodes.json").readText(), itemType)
        return entries.associate { entry ->
            entry.opcode to Opcode(
                    opcode = entry.opcode,
                    format = entry.command,
                    paramCount = entry.parameters.size,
                    params = entry.parameters.map { it.type.toParamType() },
                    description = entry.description
            )
        }
    }

    private fun EntryParamType.toParamType(): OpcodeParam {
        return when (this) {
            EntryParamType.MODEL -> OpcodeParam.MODEL
            EntryParamType.INT -> OpcodeParam.INT
            EntryParamType.LOCAL_INT -> OpcodeParam.INT
            EntryParamType.GLOBAL_INT -> OpcodeParam.INT
            EntryParamType.ANY_INT -> OpcodeParam.INT
            EntryParamType.FLOAT -> OpcodeParam.FLOAT
            EntryParamType.LOCAL_FLOAT -> OpcodeParam.FLOAT
            EntryParamType.GLOBAL_FLOAT -> OpcodeParam.FLOAT
            EntryParamType.ANY_FLOAT -> OpcodeParam.FLOAT
            EntryParamType.LABEL -> OpcodeParam.LABEL_REF
            EntryParamType.STRING -> OpcodeParam.STRING
            EntryParamType.TEXT_LABEL -> OpcodeParam.GXT_REF
            EntryParamType.ANY -> OpcodeParam.ANY
            EntryParamType.VAR_ARG -> OpcodeParam.ANY
            EntryParamType.VAR -> OpcodeParam.ANY
            EntryParamType.LOCAL_VAR -> OpcodeParam.ANY
        }
    }
}
