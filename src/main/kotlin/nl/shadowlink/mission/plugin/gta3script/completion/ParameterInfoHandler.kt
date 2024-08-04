package nl.shadowlink.mission.plugin.gta3script.completion

import com.intellij.lang.parameterInfo.CreateParameterInfoContext
import com.intellij.lang.parameterInfo.ParameterInfoHandler
import com.intellij.lang.parameterInfo.ParameterInfoUIContext
import com.intellij.lang.parameterInfo.UpdateParameterInfoContext
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parentOfType
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptMethodCall

class Gta3ScParameterInfoHandler : ParameterInfoHandler<PsiElement, Gta3ScriptMethodCall> {

    override fun findElementForParameterInfo(context: CreateParameterInfoContext): PsiElement? {
        val element = context.file.findElementAt(context.editor.caretModel.offset)
        val methodCall = element?.parentOfType<Gta3ScriptMethodCall>()
        if (methodCall != null) {
            return methodCall
        } else {
            println("Sad days :(")
            return null
        }
    }

    override fun findElementForUpdatingParameterInfo(context: UpdateParameterInfoContext) =
        context.file.findElementAt(context.editor.caretModel.offset)

    override fun updateUI(p: Gta3ScriptMethodCall?, context: ParameterInfoUIContext) {
        if (p == null) return

        context.setupUIComponentPresentation(
            "test",
            p.startOffset,
            p.endOffset,
            !context.isUIComponentEnabled,
            false,
            false,
            context.defaultParameterColor
        )
    }

    override fun updateParameterInfo(parameterOwner: PsiElement, context: UpdateParameterInfoContext) {
//        TODO("Not yet implemented")
    }

    override fun showParameterInfo(element: PsiElement, context: CreateParameterInfoContext) {
//        if (element !is Gta3ScriptMethodCall) return

        context.itemsToShow = arrayOf(element)
        context.showHint(element, element.textRange.startOffset, this)
    }
}