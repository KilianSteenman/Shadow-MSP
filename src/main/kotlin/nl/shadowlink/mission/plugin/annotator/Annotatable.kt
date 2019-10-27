package nl.shadowlink.mission.plugin.annotator

import com.intellij.lang.annotation.AnnotationHolder

interface Annotatable {

    fun annotate(holder: AnnotationHolder)
}