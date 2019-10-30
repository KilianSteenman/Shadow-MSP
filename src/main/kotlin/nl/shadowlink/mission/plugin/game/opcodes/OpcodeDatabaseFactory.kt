package nl.shadowlink.mission.plugin.game.opcodes

object OpcodeDatabaseFactory {

    private val opcodeDatabase = OpcodeDatabase()

    fun getDatabase(): OpcodeDatabase = opcodeDatabase
}