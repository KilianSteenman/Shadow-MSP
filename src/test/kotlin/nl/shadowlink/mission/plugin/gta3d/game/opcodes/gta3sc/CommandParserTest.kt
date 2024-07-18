package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class CommandParserTest {

    private val parser = CommandParser()

    @Test
    fun `valid command xml is parsed into Gta3ScriptCommands`() {
        val input = this::class.java.getResource("/commands.xml")!!.readText()
//        val input = "<GTA3Script>\n" +
//                "  <Commands>\n" +
//                "    <Command ID=\"0x0\" Name=\"NOP\"/>\n" +
//                "    <Command ID=\"0x1\" Name=\"WAIT\">\n" +
//                "       <Args>\n" +
//                "           <Arg Type=\"INT\" Desc=\"Time\"/>\n" +
//                "       </Args>\n" +
//                "    </Command>\n" +
//                "  </Commands>\n" +
//                "</GTA3Script>"

        assertNotNull(parser.parseCommands(input))
    }

    @Test
    fun `when input is invalid, then Gta3ScriptCommands is null`() {
        val input = "invalid"

        assertNull(parser.parseCommands(input))
    }
}