package nl.shadowlink.mission.plugin.gta3script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptLabel
import nl.shadowlink.mission.plugin.gta3script.psi.findLabelDeclaration

class Gta3ScriptAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is Gta3ScriptLabel -> annotateLabel(element, holder)
        }
    }

    private fun annotateLabel(label: Gta3ScriptLabel, holder: AnnotationHolder) {
        if (label.project.findLabelDeclaration(label.name) == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved label")
                .create()
        }
    }
}