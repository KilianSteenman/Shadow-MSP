package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.msc.binarywriter.FileBinaryWriter
import nl.shadowlink.mission.msc.compiler.Compiler
import nl.shadowlink.mission.msc.compiler.ScmExporter
import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.println
import java.io.File

internal class MissionCompiler {

    fun compileFile(missionSettings: MissionSettings, runConfig: MissionRunConfiguration, file: VirtualFile, projectPath: String, console: ConsoleView, fileCompiled: (() -> Unit)?) {
        val outputFilePath = "${projectPath.replace("\\", "/")}/output/${file.name.replace(".dsc", ".scm")}"
        console.println("Compiling ${file.path}\nOutput: $outputFilePath", ConsoleViewContentType.NORMAL_OUTPUT)

        try {
            val script = Compiler().compile(File(file.path).readText())
            ScmExporter().export(FileBinaryWriter(outputFilePath), script)
        } catch (e: Exception) {
            console.println("Compilation failed", ConsoleViewContentType.ERROR_OUTPUT)
            console.println(e.toString(), ConsoleViewContentType.ERROR_OUTPUT)
        }

        fileCompiled?.invoke()
    }
}