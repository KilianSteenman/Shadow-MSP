package nl.shadowlink.mission.plugin.psi.defines

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.annotator.Annotatable
import nl.shadowlink.mission.plugin.extensions.logInfo
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.psi.IntElement

class DefineMissionCountElement(node: ASTNode) : ASTWrapperPsiElement(node), Annotatable {

    override fun annotate(holder: AnnotationHolder) {
        val missionCount = PsiTreeUtil.findChildOfType(this, IntElement::class.java)
        val missions = PsiTreeUtil.countChildrenOfType(this.parent, DefineMissionElement::class.java)

        if(missionCount != null) {
            if(missionCount.value != missions) {
                holder.createErrorAnnotation(missionCount, "Expected mission count $missions")
            }
        }
    }
}