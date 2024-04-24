package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFile
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFileType
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptSubroutineDefinitionImpl
import nl.shadowlink.mission.plugin.utils.findChildrenOfType

fun Project.findSubroutineDefinition(name: String): Gta3ScriptSubroutineDefinition? {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptSubroutineDefinitionImpl>() }
        .firstOrNull { definition -> definition.name == name }
}

fun Project.findVariableDefinition(name: String): Gta3ScriptVariableDefinition? {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptVariableDefinition>() }
        .firstOrNull { definition -> definition.text == name }
}