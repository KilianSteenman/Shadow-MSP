package nl.shadowlink.mission.plugin.utils

import com.intellij.openapi.diagnostic.Logger

fun Any.log(): Logger {
    return Logger.getInstance(this::class.java)
}

fun Any.logInfo(message: String) {
    Logger.getInstance(this::class.java).info(message)
}

fun Any.logWarn(message: String) {
    Logger.getInstance(this::class.java).warn(message)
}

fun Any.logError(message: String) {
    Logger.getInstance(this::class.java).error(message)
}