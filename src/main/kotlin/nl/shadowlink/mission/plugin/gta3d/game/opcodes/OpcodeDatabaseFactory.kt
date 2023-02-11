package nl.shadowlink.mission.plugin.gta3d.game.opcodes

import nl.shadowlink.mission.plugin.gta3d.game.opcodes.api.ApiOpcodeSource

object OpcodeDatabaseFactory {

    private val opcodeDatabase = OpcodeDatabase(ApiOpcodeSource())

    fun getDatabase(): OpcodeDatabase = opcodeDatabase
}