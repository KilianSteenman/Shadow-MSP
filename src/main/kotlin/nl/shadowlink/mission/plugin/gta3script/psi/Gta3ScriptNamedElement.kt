package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement

interface Gta3ScriptMethodCallElement : PsiNamedElement
abstract class Gta3ScriptMethodCallElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), Gta3ScriptNamedElement

interface Gta3ScriptNamedElement : PsiNameIdentifierOwner

abstract class Gta3ScriptNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), Gta3ScriptNamedElement