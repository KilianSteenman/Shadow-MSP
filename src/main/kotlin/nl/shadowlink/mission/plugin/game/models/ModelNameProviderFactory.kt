package nl.shadowlink.mission.plugin.game.models

object ModelNameProviderFactory {

    private val modelNameProvider = ModelNameProvider()

    fun getProvider(): ModelNameProvider = modelNameProvider
}