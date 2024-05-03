package nl.shadowlink.mission.plugin.gta2

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class Gta2MissionFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, Gta2MissionLanguage) {

    override fun getFileType(): FileType = Gta2MissionFileType
}