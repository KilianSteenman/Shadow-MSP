package nl.shadowlink.mission.plugin

import com.intellij.lang.Language

object MissionLanguage : Language("MissionScript") {

    override fun getDisplayName(): String {
        return "Mission Script"
    }
}