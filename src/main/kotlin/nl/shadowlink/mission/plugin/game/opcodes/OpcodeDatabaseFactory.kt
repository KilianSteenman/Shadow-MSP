package nl.shadowlink.mission.plugin.game.opcodes

import nl.shadowlink.mission.plugin.game.opcodes.api.ApiOpcodeSource

object OpcodeDatabaseFactory {

    private val opcodeDatabase = OpcodeDatabase(ApiOpcodeSource())

    fun getDatabase(): OpcodeDatabase = opcodeDatabase
}