package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import nl.adaptivity.xmlutil.serialization.XML

class CommandParser {

    fun parseCommands(xmlInput: String): Gta3ScriptCommands? {
        return XML.defaultInstance.decodeFromString(Gta3ScriptCommands.serializer(), xmlInput)
//        return runCatching { XML.decodeFromString(Gta3ScriptCommands.serializer(), xmlInput) }.getOrNull()
    }
}