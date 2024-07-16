package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("GTA3Script")
data class Gta3ScriptCommands(
    @SerialName("Commands")
    val commands: Commands
)

@Serializable
data class Commands(
    val commands: List<Command>,
)

@Serializable
data class Command(
    @SerialName("ID") val id: String,
    @SerialName("Name") val name: String,
    val args: Args?
)

@Serializable
data class Args(
    val args: List<Arg>
)

@Serializable
data class Arg(
    @SerialName("Type") val type: String,
    @SerialName("Desc") val desc: String,
)
