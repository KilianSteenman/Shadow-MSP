package nl.shadowlink.mission.plugin.extensions

import java.io.File

/**
 * Moves a file by copying and deleting the original
 */
fun File.moveTo(targetFile: File, overwrite: Boolean = false, bufferSize: Int = DEFAULT_BUFFER_SIZE) {
    this.copyTo(targetFile, overwrite, bufferSize)
    this.delete()
}