package nl.shadowlink.mission.plugin.game.opcodes

object OpcodeDatabaseFactory {

    private val opcodeDatabase = OpcodeDatabase(IniOpcodeSource())

    fun getDatabase(): OpcodeDatabase = opcodeDatabase
}