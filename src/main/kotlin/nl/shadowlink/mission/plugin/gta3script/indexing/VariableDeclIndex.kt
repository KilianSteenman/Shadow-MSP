package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariableDecl

class VariableDeclIndex : StringStubIndexExtension<Gta3ScriptVariableDecl>() {

    companion object {
        val INSTANCE = VariableDeclIndex()
    }

    override fun getKey(): StubIndexKey<String, Gta3ScriptVariableDecl> = Indices.VARIABLE_DECL

    override fun getVersion(): Int = Indices.VERSION
}
