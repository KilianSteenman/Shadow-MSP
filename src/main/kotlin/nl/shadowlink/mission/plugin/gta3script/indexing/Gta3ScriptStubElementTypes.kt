package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.IStubElementType
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable

interface Gta3ScriptStubElementTypes {

    companion object {
        val VARIABLE: IStubElementType<VariableStub, Gta3ScriptVariable> = VariableStubElementType()
    }
}