package nl.shadowlink.mission.plugin.game.opcodes

interface OpcodeSource {

    fun loadOpcodes(): Map<String, Opcode>
}