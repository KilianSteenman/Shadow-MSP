package nl.shadowlink.mission.plugin.gta3script.psi

import com.intellij.psi.PsiElement
import com.intellij.usages.impl.rules.UsageType
import com.intellij.usages.impl.rules.UsageTypeProvider

class Gta3ScriptUsageTypeProvider : UsageTypeProvider {

    override fun getUsageType(element: PsiElement): UsageType? {
        return when (element) {
            is Gta3ScriptVariable -> REFERENCE
            is Gta3ScriptVariableDecl -> DECLARATION
            else -> null
        }
    }

    companion object {
        val DECLARATION = UsageType("Declaration")
        val REFERENCE = UsageType("Reference")
    }
}