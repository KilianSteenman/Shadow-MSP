package nl.shadowlink.mission.plugin.gta3d.game.models

object ModelNameProviderFactory {

    private val modelNameProvider = ModelNameProvider()

    fun getProvider(): ModelNameProvider = modelNameProvider
}