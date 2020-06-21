package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.msc.binarywriter.FileBinaryWriter
import nl.shadowlink.mission.msc.compiler.Compiler
import nl.shadowlink.mission.msc.compiler.ScmExporter
import nl.shadowlink.mission.plugin.extensions.println
import java.io.File

internal class MissionCompiler {

    fun compileFile(runConfig: MissionRunConfiguration, file: VirtualFile, console: ConsoleView): Boolean {
        val outputFilePath = "${runConfig.gamePath}/data/main.scm"

        console.println("Compiling ${file.path} to $outputFilePath", ConsoleViewContentType.NORMAL_OUTPUT)

        return try {
            val script = Compiler().compile(File(file.path).readText())
            ScmExporter().export(FileBinaryWriter(outputFilePath), script)

            true
        } catch (e: Exception) {
            console.println("Compilation failed", ConsoleViewContentType.ERROR_OUTPUT)
            console.println(e.toString(), ConsoleViewContentType.ERROR_OUTPUT)

            false
        }
    }
}