package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner

interface Gta3ScriptNamedElement : PsiNameIdentifierOwner

abstract class Gta3ScriptNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), Gta3ScriptNamedElement