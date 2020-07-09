package nl.shadowlink.mission.plugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.MissionFile
import nl.shadowlink.mission.plugin.MissionFileType
import nl.shadowlink.mission.plugin.psi.global.GlobalVarDefinitionElement
import nl.shadowlink.mission.plugin.psi.global.GlobalVarElement
import nl.shadowlink.mission.plugin.psi.label.LabelDefinitionElement

fun findLabelDefinitions(project: Project): List<LabelDefinitionElement> {
    return FileTypeIndex.getFiles(MissionFileType, GlobalSearchScope.allScope(project))
            .mapNotNull { virtualFile -> PsiManager.getInstance(project).findFile(virtualFile) as MissionFile }
            .flatMap { missionFile -> findLabelDefinitions(missionFile) }
}

fun findLabelDefinitions(file: PsiFile): List<LabelDefinitionElement> {
    return if (file is MissionFile) {
        return PsiTreeUtil.getChildrenOfType(file, LabelDefinitionElement::class.java)?.asList() ?: emptyList()
    } else {
        emptyList()
    }
}

fun findGlobalDefinitions(project: Project): List<GlobalVarElement> {
    return FileTypeIndex.getFiles(MissionFileType, GlobalSearchScope.allScope(project))
            .mapNotNull { virtualFile -> PsiManager.getInstance(project).findFile(virtualFile) as MissionFile }
            .flatMap { missionFile -> findGlobalDefinitions(missionFile) }
}

fun findGlobalDefinitions(file: PsiFile): List<GlobalVarElement> {
    return if (file is MissionFile) {
        return PsiTreeUtil.getChildrenOfType(file, GlobalVarDefinitionElement::class.java)?.asList() ?: emptyList()
    } else {
        emptyList()
    }
}