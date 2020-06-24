package nl.shadowlink.mission.plugin.projectwizard

enum class ModuleType(
        val description: String
) {
    SCM("Main script with missions"),
    CLEO("CLEO Script");
}