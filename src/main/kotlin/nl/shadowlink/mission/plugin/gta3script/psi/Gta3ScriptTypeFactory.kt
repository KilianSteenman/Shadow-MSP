package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import nl.shadowlink.mission.plugin.gta3d.MissionFile
import nl.shadowlink.mission.plugin.gta3d.MissionFileType

object Gta3ScriptTypeFactory {

    fun createVariable(project: Project, name: String): PsiElement {
        val text = "VAR_INT $name"
        val dummyFile = createGta3ScriptFile(project, text)
        return dummyFile.lastChild//.lastChild (Gta3ScriptTypes.IDENTIFIER::class.java)
    }

    private fun createGta3ScriptFile(project: Project, text: String): MissionFile {
        val file = PsiFileFactory.getInstance(project).createFileFromText("dummy.sc", MissionFileType, text)
        return file as MissionFile
    }
}