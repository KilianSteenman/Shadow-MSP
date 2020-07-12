package nl.shadowlink.mission.plugin.game.opcodes.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nl.shadowlink.mission.plugin.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeParam
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeSource
import nl.shadowlink.mission.plugin.game.opcodes.ParamType

class ApiOpcodeSource : OpcodeSource {

    override fun loadOpcodes(): Map<String, Opcode> {
        val itemType = object : TypeToken<List<OpcodeEntry>>() {}.type
        val entries = Gson().fromJson<List<OpcodeEntry>>(javaClass.getResource("/opcodes/opcodes.json").readText(), itemType)
        return entries.associate { entry ->
            entry.opcode to Opcode(
                    opcode = entry.opcode,
                    format = entry.command,
                    paramCount = entry.parameters.size,
                    params = entry.parameters.map { it.toOpcodeParam() },
                    description = entry.description
            )
        }
    }

    private fun OpcodeParameter.toOpcodeParam(): OpcodeParam {
        return OpcodeParam(
                type = this.type.toParamType(),
                description = this.name
        )
    }

    private fun EntryParamType.toParamType(): ParamType {
        return when (this) {
            EntryParamType.MODEL -> ParamType.MODEL
            EntryParamType.INT -> ParamType.INT
            EntryParamType.LOCAL_INT -> ParamType.INT
            EntryParamType.GLOBAL_INT -> ParamType.INT
            EntryParamType.ANY_INT -> ParamType.INT
            EntryParamType.FLOAT -> ParamType.FLOAT
            EntryParamType.LOCAL_FLOAT -> ParamType.FLOAT
            EntryParamType.GLOBAL_FLOAT -> ParamType.FLOAT
            EntryParamType.ANY_FLOAT -> ParamType.FLOAT
            EntryParamType.LABEL -> ParamType.LABEL_REF
            EntryParamType.STRING -> ParamType.STRING
            EntryParamType.TEXT_LABEL -> ParamType.GXT_REF
            EntryParamType.ANY -> ParamType.ANY
            EntryParamType.VAR_ARG -> ParamType.ANY
            EntryParamType.VAR -> ParamType.ANY
            EntryParamType.LOCAL_VAR -> ParamType.ANY
        }
    }
}
