package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.stubs.StubIndexKey
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFile
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFileType
import nl.shadowlink.mission.plugin.gta3script.indexing.Indices

fun Project.findLabelDeclaration(name: String): Gta3ScriptLabelDecl? {
    return StubIndex.getElements(
        Indices.LABEL_DECL, name, this, GlobalSearchScope.projectScope(this), Gta3ScriptLabelDecl::class.java
    ).firstOrNull()
}

fun Project.findVariableDeclaration(name: String): Gta3ScriptVariableDecl? {
    return StubIndex.getElements(
        Indices.VARIABLE_DECL, name, this, GlobalSearchScope.projectScope(this), Gta3ScriptVariableDecl::class.java
    ).firstOrNull()
}

fun Project.findScript(name: String): PsiFileBase? {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.projectScope(this))
        .find { it.name == name }
        ?.let { PsiManager.getInstance(this).findFile(it) as? Gta3ScriptFile }
}

fun Project.getScriptFiles(): Collection<VirtualFile> {
    return FileTypeIndex.getFiles(Gta3ScriptFileType, GlobalSearchScope.projectScope(this))
}

fun Project.getLabels(): List<Gta3ScriptLabelDecl> {
    return getAllElementsForIndex(Indices.LABEL_DECL, this)
}

fun Project.getVariables(): List<Gta3ScriptVariableDecl> {
    return getAllElementsForIndex(Indices.VARIABLE_DECL, this)
}

private inline fun <reified Key : Any, reified Psi : PsiElement?> getAllElementsForIndex(
    indexKey: StubIndexKey<Key, Psi>,
    project: Project
): List<Psi> {
    val scope = GlobalSearchScope.projectScope(project)
    val stubIndex = StubIndex.getInstance()
    return stubIndex.getAllKeys(indexKey, project)
        .flatMap { key ->
            StubIndex.getElements(
                indexKey,
                key,
                project,
                scope,
                Psi::class.java,
            )
        }
}
