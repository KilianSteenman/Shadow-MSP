package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptLabelDecl
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariableDecl

class LabelDeclIndex : StringStubIndexExtension<Gta3ScriptLabelDecl>() {

    companion object {
        val INSTANCE = LabelDeclIndex()
    }

    override fun getKey(): StubIndexKey<String, Gta3ScriptLabelDecl> = Indices.LABEL_DECL

    override fun getVersion(): Int = Indices.VERSION
}
