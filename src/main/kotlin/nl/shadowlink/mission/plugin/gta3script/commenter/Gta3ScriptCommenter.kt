package nl.shadowlink.mission.plugin.gta3script.commenter

import com.intellij.lang.Commenter

class Gta3ScriptCommenter : Commenter {

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

    override fun getBlockCommentPrefix(): String? = "/*"

    override fun getBlockCommentSuffix(): String? = "*/"

    override fun getLineCommentPrefix(): String = "//"
}