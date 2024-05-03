package nl.shadowlink.mission.plugin.gta3d.game.models

class ModelNameProvider {

    val models: List<String> =
            listOf("NULL", "FAGGIO")

    fun isValidModel(model: String): Boolean {
        return models.contains(model)
    }
}