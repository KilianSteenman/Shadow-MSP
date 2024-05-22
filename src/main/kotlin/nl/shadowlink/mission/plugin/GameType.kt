package nl.shadowlink.mission.plugin

enum class GameType(
    val visualName: String,
    val exeName: String,
    val gta3scConfig: String
) {
    III("III", "gta3.exe", "gta3"),
    VC("VC", "gta-vc.exe", "gtavc"),
    SA("SA", "gta-sa.exe", "gtasa");

    companion object {

        fun valueOfOrNull(name: String?): GameType? {
            if (name == null) return null

            return try {
                valueOf(name)
            } catch (e: IllegalArgumentException) {
                null
            }
        }

        fun valueOfOrDefault(name: String?, default: GameType): GameType {
            if (name == null) return default

            return try {
                valueOf(name)
            } catch (e: IllegalArgumentException) {
                default
            }
        }

        fun getGameType(visualName: String?): GameType? {
            return GameType.values().firstOrNull { it.visualName == visualName }
        }
    }
}