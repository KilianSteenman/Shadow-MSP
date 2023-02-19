package nl.shadowlink.mission.plugin.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

inline fun <reified T : PsiElement> PsiElement.findChildrenOfType(): List<T> {
    return PsiTreeUtil.findChildrenOfType(this, T::class.java).toList()
}
