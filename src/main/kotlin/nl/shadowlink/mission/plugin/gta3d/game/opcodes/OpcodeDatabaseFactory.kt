package nl.shadowlink.mission.plugin.gta3d.game.opcodes

import nl.shadowlink.mission.plugin.gta3d.game.opcodes.api.ApiOpcodeSource
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc.Gta3ScSource

object OpcodeDatabaseFactory {

    private val opcodeDatabase = OpcodeDatabase(Gta3ScSource())//ApiOpcodeSource())

    fun getDatabase(): OpcodeDatabase = opcodeDatabase
}