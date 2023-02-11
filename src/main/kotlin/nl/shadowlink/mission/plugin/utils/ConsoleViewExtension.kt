package nl.shadowlink.mission.plugin.utils

import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType

fun ConsoleView.println(text: String, contextType: ConsoleViewContentType = ConsoleViewContentType.NORMAL_OUTPUT) {
    this.print("$text\n", contextType)
}