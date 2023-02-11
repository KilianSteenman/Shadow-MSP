package nl.shadowlink.mission.plugin.utils

import com.intellij.openapi.vfs.VirtualFile
import java.util.zip.CRC32

fun VirtualFile.getCRC32Checksum(): Long {
    val bytes = inputStream.readAllBytes()

    return CRC32().apply {
        update(bytes, 0, bytes.size)
    }.value
}