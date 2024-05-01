package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFile
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFileType
import nl.shadowlink.mission.plugin.utils.findChildrenOfType

fun Project.findLabelDefinition(name: String) : Gta3ScriptLabelIdentifier? {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptLabelIdentifier>() }
        .firstOrNull { definition -> definition.text.substringBefore(':') == name }
}

fun Project.findVariableDefinition(name: String): Gta3ScriptVariable? {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptVariableDefinition>() }
        .flatMap { definition -> definition.findChildrenOfType<Gta3ScriptVariable>() }
        .firstOrNull { definition -> definition.text == name }
}

fun Project.findVariableReferences(name: String): List<Gta3ScriptVariable> {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptVariable>() }
        .also { println("Found references count ${it.count()} before filtering") }
//        .filter { definition -> definition.text == name }
}