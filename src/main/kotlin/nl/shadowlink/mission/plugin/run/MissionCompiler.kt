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

    fun compileFile(runConfig: MissionRunConfiguration, main: VirtualFile, missions: List<VirtualFile>, console: ConsoleView): Boolean {
        val outputFilePath = "${runConfig.gamePath}/data/main.scm"

        console.println("Compiling ${main.path} to $outputFilePath", ConsoleViewContentType.NORMAL_OUTPUT)
        if (missions.isNotEmpty()) {
            console.println("With missions:")
            missions.forEachIndexed { index, mission -> console.println("$index - ${mission.path}") }
        }

        val mainSource = main.readText(console)
        if (mainSource == null) {
            console.println("Compilation failed, no main source provided", ConsoleViewContentType.ERROR_OUTPUT)
            return false
        }

        val missionSources = missions.mapNotNull { mission -> mission.readText(console) }

        return try {
            val script = Compiler().compile(mainSource, missionSources)

            // Make sure we write this to a clean file TODO: Make this part of the compiler!
            with(File(outputFilePath)) {
                if (exists()) {
                    delete()
                }
            }

            ScmExporter().export(FileBinaryWriter(outputFilePath), script)
            true
        } catch (e: Exception) {
            console.println("Compilation failed", ConsoleViewContentType.ERROR_OUTPUT)
            console.println(e.toString(), ConsoleViewContentType.ERROR_OUTPUT)

            false
        }
    }

    private fun VirtualFile.readText(console: ConsoleView): String? {
        return try {
            File(this.path).readText()
        } catch (e: Exception) {
            console.println("Unable to read ${this.path}", ConsoleViewContentType.ERROR_OUTPUT)
            console.println(e.toString(), ConsoleViewContentType.ERROR_OUTPUT)
            null
        }
    }
}