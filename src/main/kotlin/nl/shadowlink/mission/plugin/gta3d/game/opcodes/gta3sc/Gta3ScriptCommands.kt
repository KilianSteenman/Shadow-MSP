package nl.shadowlink.mission.plugin.gta3d.game.opcodes.gta3sc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

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
    @SerialName("Supported") val supported: Boolean = true,
    @SerialName("Internal") val isInternal: Boolean = false,
    val args: Args?
)

@Serializable
data class Args(
    val args: List<Arg>
)

@Serializable
data class Arg(
    @SerialName("Type") @XmlElement(false) val type: ArgType,
    @SerialName("Desc") val desc: String?,
    @SerialName("AllowConst") val allowConstant: Boolean?,
    @SerialName("AllowLocalVar") val allowLocalVar: Boolean?,
    @SerialName("AllowGlobalVar") val allowGlobalVar: Boolean?,
    @SerialName("Optional") val isOptional: Boolean = false,
    @SerialName("Out") val isOut: Boolean?,
    @SerialName("Entity") val entity: String?,
    @SerialName("Ref") val isRef: Boolean?,
    @SerialName("Enum") val isEnum: Boolean?,
)

@Serializable
enum class ArgType {
    INT,
    FLOAT,
    LABEL,
    PARAM,
    TEXT_LABEL,
    CONSTANT,
}
