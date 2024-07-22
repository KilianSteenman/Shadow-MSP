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
import nl.shadowlink.mission.plugin.utils.findChildrenOfType

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
    val scope = GlobalSearchScope.projectScope(this)
    val stubIndex = StubIndex.getInstance()
    return stubIndex.getAllKeys(Indices.LABEL_DECL, this)
        .flatMap { key ->
            StubIndex.getElements(
                Indices.LABEL_DECL,
                key,
                this,
                scope,
                Gta3ScriptLabelDecl::class.java
            )
        }
}

fun Project.getVariables(): List<Gta3ScriptVariableDecl> {
    val scope = GlobalSearchScope.projectScope(this)
    val stubIndex = StubIndex.getInstance()
    return stubIndex.getAllKeys(Indices.VARIABLE_DECL, this)
        .flatMap { key ->
            StubIndex.getElements(
                Indices.VARIABLE_DECL,
                key,
                this,
                scope,
                Gta3ScriptVariableDecl::class.java
            )
        }
}
