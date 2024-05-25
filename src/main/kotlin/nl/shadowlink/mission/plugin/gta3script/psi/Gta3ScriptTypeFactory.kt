package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import nl.shadowlink.mission.plugin.gta3d.MissionFile
import nl.shadowlink.mission.plugin.gta3d.MissionFileType
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFile
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFileType
import nl.shadowlink.mission.plugin.utils.findChildrenOfType

object Gta3ScriptTypeFactory {

    fun createIdentifier(project: Project, name: String): ASTNode {
        val text = "VAR_INT $name\n"
        val dummyFile = createGta3ScriptFile(project, text)
        return dummyFile.findChildrenOfType<Gta3ScriptVariable>()
            .firstOrNull()?.node?.findChildByType(Gta3ScriptTypes.IDENTIFIER)
            ?: error("Unable to create identifier for $name")
    }

    fun createLabel(project: Project, name: String): ASTNode {
        val text = "$name:\n"
        val dummyFile = createGta3ScriptFile(project, text)
        return dummyFile.findChildrenOfType<Gta3ScriptLabel>()
            .firstOrNull()?.node?.findChildByType(Gta3ScriptTypes.IDENTIFIER)
            ?: error("Unable to create label for $name")
    }

    private fun createGta3ScriptFile(project: Project, text: String): Gta3ScriptFile {
        val file = PsiFileFactory.getInstance(project).createFileFromText("dummy.sc", Gta3ScriptFileType, text)
        return file as Gta3ScriptFile
    }
}