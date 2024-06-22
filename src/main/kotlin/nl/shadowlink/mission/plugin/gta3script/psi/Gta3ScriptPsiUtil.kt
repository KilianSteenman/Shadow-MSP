package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFile
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFileType
import nl.shadowlink.mission.plugin.gta3script.indexing.Indices
import nl.shadowlink.mission.plugin.gta3script.indexing.VariableIndex
import nl.shadowlink.mission.plugin.utils.findChildrenOfType

fun Project.findLabelDefinition(name: String): Gta3ScriptLabel? {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptLabelDefinition>() }
        .flatMap { definition -> definition.findChildrenOfType<Gta3ScriptLabel>() }
        .firstOrNull { definition -> definition.text == name }
}

fun Project.findVariableDefinition(name: String): Gta3ScriptVariable? {
//    fun findGlobalVariables(project: Project, name: String): Collection<MyLanguageGlobalVariable> {
//        return requireNotNull(StubIndex.getElements(
//            Indices.VARIABLE, "Gta3Script.Variable.name", this, GlobalSearchScope.allScope(this), Gta3ScriptVariable::class.java
//        ).first())
//    }

    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptVariableDefinition>() }
        .flatMap { definition -> definition.findChildrenOfType<Gta3ScriptVariable>() }
        .firstOrNull { definition -> definition.text == name }
}

fun Project.findScript(name: String): PsiFileBase? {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .find { it.name == name }
        ?.let { PsiManager.getInstance(this).findFile(it) as? Gta3ScriptFile }
}

fun Project.getScriptFiles(): Collection<VirtualFile> {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
}

fun Project.getLabels(): List<Gta3ScriptLabel> {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptLabelDefinition>() }
        .flatMap { definition -> definition.findChildrenOfType<Gta3ScriptLabel>() }
}

fun Project.getVariables(): List<Gta3ScriptVariable> {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.allScope(this))
        .mapNotNull { virtualFile -> PsiManager.getInstance(this).findFile(virtualFile) as? Gta3ScriptFile }
        .flatMap { file -> file.findChildrenOfType<Gta3ScriptVariableDefinition>() }
        .flatMap { definition -> definition.findChildrenOfType<Gta3ScriptVariable>() }
}
