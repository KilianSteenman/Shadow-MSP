package nl.shadowlink.mission.plugin

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MissionFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, MissionLanguage) {

    override fun getFileType(): FileType = MissionFileType
}