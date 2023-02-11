package nl.shadowlink.mission.plugin.gta3d.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

class MissionAnnotator: Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if(element is Annotatable) {
            element.annotate(holder)
        }
    }
}