package nl.shadowlink.mission.plugin.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.lang.parameterInfo.*
import com.intellij.psi.util.parentOfType
import nl.shadowlink.mission.plugin.extensions.logWarn
import nl.shadowlink.mission.plugin.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.psi.opcode.OpcodeExpression

class OpcodeParameterInfoHandler : ParameterInfoHandler<OpcodeExpression, Opcode> {

    override fun showParameterInfo(element: OpcodeExpression, context: CreateParameterInfoContext) {
        context.showHint(element, element.textRange.startOffset, this)
    }

    override fun updateParameterInfo(parameterOwner: OpcodeExpression, context: UpdateParameterInfoContext) {
        logWarn("Update Parameter info")
    }

    override fun getParametersForLookup(item: LookupElement?, context: ParameterInfoContext?): Array<Any>? {
        return null
    }

    override fun couldShowInLookup(): Boolean = true

    override fun findElementForUpdatingParameterInfo(context: UpdateParameterInfoContext): OpcodeExpression? {
        return context.file.findElementAt(context.offset)?.parentOfType(OpcodeExpression::class)
    }

    override fun findElementForParameterInfo(context: CreateParameterInfoContext): OpcodeExpression? {
        return context.file.findElementAt(context.offset)?.parentOfType(OpcodeExpression::class)?.also {
            context.itemsToShow = arrayOf(it.getOpcodeInfo())
        }
    }

    override fun updateUI(opcode: Opcode, context: ParameterInfoUIContext) {
        val toReturn = opcode.paramInfo()
        val hlStart = -1
        val hlEnd = -1
        context.setupUIComponentPresentation(
                toReturn,
                hlStart,
                hlEnd,
                false,
                false,
                false,
                context.defaultParameterColor
        )
    }
}