package nl.shadowlink.mission.plugin.gta3d.annotator

import com.intellij.lang.annotation.AnnotationHolder

interface Annotatable {

    fun annotate(holder: AnnotationHolder)
}