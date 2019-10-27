package nl.shadowlink.mission.plugin.game

object ModelNameProviderFactory {

    private val modelNameProvider = ModelNameProvider()

    fun getProvider(): ModelNameProvider = modelNameProvider
}