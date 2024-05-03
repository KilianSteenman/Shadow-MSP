package nl.shadowlink.mission.plugin.gta3d.psi.defines

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.gta3d.annotator.Annotatable
import nl.shadowlink.mission.plugin.gta3d.psi.params.IntElement

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