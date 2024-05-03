package nl.shadowlink.mission.plugin.gta2.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner

interface Gta2MissionNamedElement : PsiNameIdentifierOwner

abstract class Gta2MissionNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), Gta2MissionNamedElement