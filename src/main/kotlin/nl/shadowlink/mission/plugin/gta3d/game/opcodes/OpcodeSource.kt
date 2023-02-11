package nl.shadowlink.mission.plugin.gta3d.game.opcodes

interface OpcodeSource {

    fun loadOpcodes(): Map<String, Opcode>
}