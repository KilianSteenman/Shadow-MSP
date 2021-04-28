package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.msc.CompilerArgs
import nl.shadowlink.mission.msc.compiler.CompilationState
import nl.shadowlink.mission.msc.compiler.Compiler
import nl.shadowlink.mission.plugin.extensions.println

internal class MissionCompiler {

    private class SimpleCompilerArgs(
        override val main: String? = null,
        override val destination: String? = null,
        override val missions: List<String> = emptyList(),
        override val cleoInputSource: String? = null,
        override val cleoOutputPath: String? = null,
    ) : CompilerArgs

    fun compileFile(
        runConfig: MissionRunConfiguration,
        main: VirtualFile,
        missions: List<VirtualFile>,
        console: ConsoleView
    ): Boolean {
        val outputFilePath = "${runConfig.gamePath}/data/main.scm"

        val args = SimpleCompilerArgs(
            main = main.path,
            missions = missions.map { mission -> mission.path },
            destination = outputFilePath,
        )

        return try {
            val compilationState = Compiler().compile(args)
            compilationState.print(console)
            true
        } catch (e: Exception) {
            console.println("Compilation failed", ConsoleViewContentType.ERROR_OUTPUT)
            console.println(e.toString(), ConsoleViewContentType.ERROR_OUTPUT)

            false
        }
    }

    private fun CompilationState.print(console: ConsoleView) {
        when (this) {
            is CompilationState.CompilationFailed -> console.println("Compilation failed\n$error")
            is CompilationState.ScmCompilationSuccess -> console.println(
                "Compilation completed\n" +
                        "Global count: $globalCount\n" +
                        "Mission count: $missionCount\n" +
                        "Main size: $mainSize\n" +
                        "Largest mission size: $largestMissionSize\n" +
                        "Total script size: $totalScriptSize"
            )
            is CompilationState.CleoCompilationSuccess -> console.println(
                "Cleo compilation completed"
            )
        }
    }
}