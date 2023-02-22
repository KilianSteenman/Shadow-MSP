package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import nl.shadowlink.mission.plugin.gta2.Gta2MissionFile
import nl.shadowlink.mission.plugin.gta2.Gta2MissionFileType
import nl.shadowlink.mission.plugin.gta2.psi.impl.MissionSubroutineDefinitionImpl
import nl.shadowlink.mission.plugin.utils.findChildrenOfType

fun Project.findSubroutineDefinition(name: String): MissionSubroutineDefinition? {
    return FileTypeIndex.getFiles(Gta2MissionFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta2MissionFile }
        .flatMap { file -> file.findChildrenOfType<MissionSubroutineDefinitionImpl>() }
        .firstOrNull { definition -> definition.name == name }
}

fun Project.findVariableDefinition(name: String): MissionVariableDefinition? {
    return FileTypeIndex.getFiles(Gta2MissionFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta2MissionFile }
        .flatMap { file -> file.findChildrenOfType<MissionVariableDefinition>() }
        .firstOrNull { definition -> definition.identifier.text == name }
}