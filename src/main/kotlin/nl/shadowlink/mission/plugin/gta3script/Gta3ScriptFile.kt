package nl.shadowlink.mission.plugin.gta3script

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class Gta3ScriptFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, Gta3ScriptLanguage) {

    override fun getFileType(): FileType = Gta3ScriptFileType()
}