package nl.shadowlink.mission.plugin.game.models

class ModelNameProvider {

    val models: List<String> =
            listOf("NULL", "FAGGIO")

    fun isValidModel(model: String): Boolean {
        return models.contains(model)
    }
}