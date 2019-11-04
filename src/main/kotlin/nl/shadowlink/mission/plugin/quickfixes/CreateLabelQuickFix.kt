package nl.shadowlink.mission.plugin.quickfixes

import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import nl.shadowlink.mission.plugin.psi.label.LabelReferenceElement

class CreateLabelQuickFix(
        private val labelReferenceElement: LabelReferenceElement
) : BaseIntentionAction() {

    override fun getText(): String = "Create label"

    override fun getFamilyName(): String = "Label name"

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean = true

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        // TODO: Implement element creation
    }
}