package nl.shadowlink.mission.plugin.utils

import org.jdom.Element

internal fun Element.writeString(name: String, value: String) {
    addContent(Element("option").apply {
        setAttribute("name", name)
        setAttribute("value", value)
    })
}

internal fun Element.writeBoolean(name: String, value: Boolean) {
    addContent(Element("option").apply {
        setAttribute("name", name)
        setAttribute("value", value.toString())
    })
}

internal fun Element.readBoolean(name: String, defaultValue: Boolean): Boolean {
    val boolValue = children.find { it.name == "option" && it.getAttributeValue("name") == name }
            ?.getAttributeValue("value")

    return when(boolValue) {
        "true" -> true
        "false" -> false
        else -> defaultValue
    }
}

internal fun Element.readString(name: String): String? =
        children.find { it.name == "option" && it.getAttributeValue("name") == name }
                ?.getAttributeValue("value")

internal fun Element.readString(name: String, defaultValue: String): String =
        readString(name) ?: defaultValue