package nl.shadowlink.mission.plugin.game

internal enum class Game(
        val gameName: String,
        val exeName: String,
        val sannyGameTypeParam: String
) {
    III("GTA: III", "gta3.exe", "iii"),
    VC("GTA: VC", "gta-vc.exe", "vc"),
    SA("GTA: SA", "gta-sa.exe", "sa")
}