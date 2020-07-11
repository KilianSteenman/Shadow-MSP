package nl.shadowlink.mission.plugin.game.opcodes

data class Opcode(
        val opcode: String,
        val format: String,
        val paramCount: Int,
        val params: List<OpcodeParam>,
        val description: String?
)