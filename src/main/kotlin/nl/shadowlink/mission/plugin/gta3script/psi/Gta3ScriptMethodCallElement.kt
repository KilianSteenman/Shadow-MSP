package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

interface Gta3ScriptMethodCallElement : PsiNamedElement

abstract class Gta3ScriptMethodCallElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), Gta3ScriptMethodCallElement