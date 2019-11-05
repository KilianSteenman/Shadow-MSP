package nl.shadowlink.mission.plugin.game.opcodes

data class Opcode(
        val opcode: String,
        val format: String,
        val params: List<OpcodeParam>
)