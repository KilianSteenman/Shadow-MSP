package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XML
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Gta3ScSourceTest {

    private val testInput = "<GTA3Script>\n" +
            "  <Commands>\n" +
            "    <Command ID=\"0x0\" Name=\"NOP\"/>\n" +
            "    <Command ID=\"0x1\" Name=\"WAIT\">\n" +
            "      <Args>\n" +
            "        <Arg Type=\"INT\" Desc=\"Time\"/>\n" +
            "      </Args>\n" +
            "    </Command>\n" +
            "  </Commands>\n" +
            "</GTA3Script>"

    @Test
    fun `test`() {
        val commands = XML.decodeFromString(Gta3ScriptCommands.serializer(), testInput)

//        println(XML.encodeToString(Gta3ScriptCommands(Commands(listOf(Command(id = "some_id", name = "some_name"))))))
        assertTrue(false)
    }
}