package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable

class VariableIndex : StringStubIndexExtension<Gta3ScriptVariable>() {

    init {
        println("VariableIndex called")
    }

    override fun getKey(): StubIndexKey<String, Gta3ScriptVariable> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, Gta3ScriptVariable> =
            StubIndexKey.createIndexKey("Gta3Script.Variable")
    }
}
