package nl.shadowlink.mission.plugin.gta3d.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import nl.shadowlink.mission.plugin.gta3d.MissionFile
import nl.shadowlink.mission.plugin.gta3d.MissionFileType

/**
 * Generate PSIElement objects by creating a dummy file, parsing a string, and extracting the PSIElement
 *
 * This seems like an overly complicated way to do this, but it is how all the IntelliJ plugins work
 */
class PsiElementFactory(private val project: Project) {

    fun createLabelDefinition(name: String): PsiElement {
        val text = ":$name"
        val dummyFile = createMissionFile(text)
        return dummyFile.firstChild
    }

    fun createLabelReference(name: String): PsiElement {
        val text = "@$name"
        val dummyFile = createMissionFile(text)
        return dummyFile.firstChild
    }

    fun createLocalVar(name: String): PsiElement {
        val text = "$name@"
        val dummyFile = createMissionFile(text)
        return dummyFile.firstChild
    }

    fun createGlobalVar(name: String): PsiElement {
        val text = "\$$name"
        val dummyFile = createMissionFile(text)
        return dummyFile.firstChild
    }

    fun createObjectName(name: String): PsiElement {
        val dummyFile = createMissionFile(name)
        return dummyFile.firstChild
    }

    private fun createMissionFile(text: String): MissionFile {
        val file = PsiFileFactory.getInstance(project).createFileFromText("dummy.dsc", MissionFileType, text)
        return file as MissionFile
    }
}
