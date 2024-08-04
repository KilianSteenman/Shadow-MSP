package nl.shadowlink.mission.plugin.gta3d.game.opcodes

data class Opcode(
    val opcode: String,
    val format: String,
    val params: List<OpcodeParam>,
    val description: String?
) {

    val paramCount: Int
        get() = params.size

    fun paramInfo(): String {
        return if (params.isNotEmpty()) {
            params.joinToString(", ") { param -> "${param.description} (${param.type})" }
        } else {
            "No parameters"
        }
    }
}