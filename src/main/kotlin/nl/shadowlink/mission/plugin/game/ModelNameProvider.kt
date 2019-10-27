package nl.shadowlink.mission.plugin.game

class ModelNameProvider {

    fun models(): List<String> =
            listOf("NULL", "FAGGIO")

    fun isValidModel(model: String): Boolean {
        return models().contains(model)
    }
}