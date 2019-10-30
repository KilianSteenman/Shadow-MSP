package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import nl.shadowlink.mission.plugin.annotator.Annotatable
import nl.shadowlink.mission.plugin.game.models.ModelNameProviderFactory

class ModelElement(node: ASTNode) : ASTWrapperPsiElement(node), Annotatable {

    private val modelName get() = node.text.substring(1)

    override fun annotate(holder: AnnotationHolder) {
        if (!ModelNameProviderFactory.getProvider().isValidModel(modelName)) {
            holder.createErrorAnnotation(this, "$modelName is not a valid model")
        }
    }
}