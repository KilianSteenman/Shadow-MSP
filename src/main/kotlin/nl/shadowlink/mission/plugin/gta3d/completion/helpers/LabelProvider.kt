package nl.shadowlink.mission.plugin.gta3d.completion.helpers

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiFile
import nl.shadowlink.mission.plugin.gta3d.psi.findLabelDefinitions

object LabelProvider {

    fun getLabelCompletions(file: PsiFile): List<LookupElement> {
        return findLabelDefinitions(file)
                .map { def ->
                    LookupElementBuilder.create("@${def.name}").withTypeText("Label")
                }
    }
}