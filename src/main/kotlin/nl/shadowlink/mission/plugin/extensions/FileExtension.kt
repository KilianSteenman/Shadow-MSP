package nl.shadowlink.mission.plugin.extensions

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import java.io.File

/**
 * Moves a file by copying and deleting the original
 */
fun File.moveTo(targetFile: File, overwrite: Boolean = false, bufferSize: Int = DEFAULT_BUFFER_SIZE) {
    this.copyTo(targetFile, overwrite, bufferSize)
    this.delete()
}

fun File.focusInEditor(project: Project) {
    val virtualMainFile = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(this)
    virtualMainFile?.let { FileEditorManager.getInstance(project).openFile(it, true) }
}