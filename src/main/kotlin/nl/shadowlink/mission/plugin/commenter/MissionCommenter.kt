package nl.shadowlink.mission.plugin.commenter

import com.intellij.lang.Commenter

class MissionCommenter : Commenter {

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

    override fun getBlockCommentPrefix(): String? = null

    override fun getBlockCommentSuffix(): String? = null

    override fun getLineCommentPrefix(): String = "//"
}