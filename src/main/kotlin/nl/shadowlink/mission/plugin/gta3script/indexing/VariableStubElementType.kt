package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptVariableImpl

object VariableStubElementType : IStubElementType<VariableStub, Gta3ScriptVariable>("Variable", Gta3ScriptLanguage) {

    @JvmStatic
    fun getInstance(@Suppress("UNUSED_PARAMETER") debugName: String): VariableStubElementType {
        return VariableStubElementType;
    }

    override fun getExternalId(): String {
        return "Gta3Script.Variable"
    }

    override fun serialize(stub: VariableStub, dataStream: StubOutputStream) {
        dataStream.writeUTF(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): VariableStub {
        val name = dataStream.readUTF()
        return VariableStubImpl(parentStub, name)
    }

    override fun indexStub(stub: VariableStub, sink: IndexSink) {
        sink.occurrence(Indices.VARIABLE, stub.name)
    }

    override fun createPsi(stub: VariableStub): Gta3ScriptVariable {
        return Gta3ScriptVariableImpl(stub, stub.stubType)
    }

    override fun createStub(psi: Gta3ScriptVariable, parentStub: StubElement<*>): VariableStub {
        return VariableStubImpl(parentStub, psi.name)
    }
}