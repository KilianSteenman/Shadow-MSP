package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import nl.shadowlink.mission.plugin.gta3d.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeParam
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.ParamType

class CommandMapper {

    fun toOpcode(command: Command): Opcode {
        return Opcode(
            opcode = command.id,
            format = command.name,
            params = command.args?.args?.map { arg ->
                OpcodeParam(
                    type = arg.type.toParamType(),
                    description = arg.desc,
                )
            } ?: emptyList(),
            paramCount = 0,
            description = ""
        )
    }

    private fun ArgType.toParamType(): ParamType {
        return when (this) {
            ArgType.INT -> ParamType.INT
            ArgType.LABEL -> ParamType.LABEL_REF
            else -> ParamType.ANY
        }
    }
}