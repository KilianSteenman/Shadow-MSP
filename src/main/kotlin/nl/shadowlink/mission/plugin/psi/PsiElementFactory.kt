package nl.shadowlink.mission.plugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import nl.shadowlink.mission.plugin.MissionFile
import nl.shadowlink.mission.plugin.MissionFileType

/**
 * Generate PSIElement objects by creating a dummy file, parsing a string, and extracting the PSIElement
 *
 * This seems like an overly complicated way to do this, but it is how all the IntelliJ plugins work
 */
class PsiElementFactory(private val project: Project) {

    fun createLabelDefinition(name: String): LabelDefinitionElement {
        val text = ":$name"
        val dummyFile = createMissionFile(text)
        return dummyFile.findChildByClass(LabelDefinitionElement::class.java)!!
    }

    fun createLabelReference(name: String): PsiElement {
        val text = "@$name"
        val dummyFile = createMissionFile(text)
        return dummyFile.findChildByClass(LabelReferenceElement::class.java)!!
    }

    private fun createMissionFile(text: String): MissionFile {
        val file = PsiFileFactory.getInstance(project).createFileFromText("dummy.dsc", MissionFileType, text)
        return file as MissionFile
    }
}
