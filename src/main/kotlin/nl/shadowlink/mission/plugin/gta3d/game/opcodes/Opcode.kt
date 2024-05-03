package nl.shadowlink.mission.plugin.gta3d.game.opcodes

data class Opcode(
        val opcode: String,
        val format: String,
        val paramCount: Int,
        val params: List<OpcodeParam>,
        val description: String?
) {

    fun paramInfo(): String {
        return if (params.isNotEmpty()) {
            params.joinToString(", ") { param -> "${param.description} (${param.type})" }
        } else {
            "No parameters"
        }
    }
}