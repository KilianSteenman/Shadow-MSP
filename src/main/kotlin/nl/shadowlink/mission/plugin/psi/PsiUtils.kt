package nl.shadowlink.mission.plugin.psi

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.MissionFile
import nl.shadowlink.mission.plugin.MissionFileType
import nl.shadowlink.mission.plugin.psi.label.LabelDefinitionElement

fun findLabelDefinitions(project: Project): List<LabelDefinitionElement> {
    return FileTypeIndex.getFiles(MissionFileType, GlobalSearchScope.allScope(project))
            .mapNotNull { virtualFile -> PsiManager.getInstance(project).findFile(virtualFile) as MissionFile? }
            .mapNotNull { missionFile -> PsiTreeUtil.getChildrenOfType(missionFile, LabelDefinitionElement::class.java) }
            .flatMap { definitions -> definitions.asList() }
}

fun findLabelDefinitions(file: PsiFile): List<LabelDefinitionElement> {
    return if (file is MissionFile) {
        return PsiTreeUtil.getChildrenOfType(file, LabelDefinitionElement::class.java)?.asList() ?: emptyList()
    } else {
        emptyList()
    }
}