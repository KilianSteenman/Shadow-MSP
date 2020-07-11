package nl.shadowlink.mission.plugin.completion.helpers

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiFile
import nl.shadowlink.mission.plugin.psi.findGlobalDefinitions

object VariableProvider {

    fun provideGlobals(file: PsiFile): List<LookupElement> {
        return findGlobalDefinitions(file.project).map {
            LookupElementBuilder.create("$${it.name}").withTypeText("Global variable")
        }
    }

    fun provideLocals(file: PsiFile): List<LookupElement> {
        return listOf("0@", "1@", "2@", "3@", "4@", "5@", "6@", "7@", "8@", "9@", "10@")
                .map {
                    LookupElementBuilder.create(it).withTypeText("Local variable")
                }
    }

    fun provideAll(file: PsiFile): List<LookupElement> {
        return provideGlobals(file) + provideLocals(file)
    }
}