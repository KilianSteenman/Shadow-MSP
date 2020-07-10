package nl.shadowlink.mission.plugin.game.opcodes.api

data class OpcodeEntry(
        val opcode: String,
        val command: String,
        val sannyFormat: String,
        val parameters: List<OpcodeParameter>
)

data class OpcodeParameter(
        val name: String?,
        val type: EntryParamType
)

enum class EntryParamType {
    MODEL,
    INT,
    LOCAL_INT,
    GLOBAL_INT,
    ANY_INT,
    FLOAT,
    LOCAL_FLOAT,
    GLOBAL_FLOAT,
    ANY_FLOAT,
    LABEL,
    STRING,
    TEXT_LABEL,
    ANY,
    VAR_ARG,
    VAR,
    LOCAL_VAR
}