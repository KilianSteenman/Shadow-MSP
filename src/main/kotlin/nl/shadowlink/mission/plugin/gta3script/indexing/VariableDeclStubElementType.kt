package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariableDecl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptVariableDeclImpl

object VariableDeclStubElementType :
    IStubElementType<VariableDeclStub, Gta3ScriptVariableDecl>("VARIABLE_DECLARATION", Gta3ScriptLanguage) {

    @JvmStatic
    fun getInstance(@Suppress("UNUSED_PARAMETER") debugName: String): VariableDeclStubElementType {
        return VariableDeclStubElementType;
    }

    override fun getExternalId(): String {
        return "Gta3Script.Variable.Decl"
    }

    override fun serialize(stub: VariableDeclStub, dataStream: StubOutputStream) {
        dataStream.writeUTF(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): VariableDeclStub {
        val name = dataStream.readUTF()
        return VariableDeclStubImpl(parentStub, name)
    }

    override fun indexStub(stub: VariableDeclStub, sink: IndexSink) {
        sink.occurrence(Indices.VARIABLE_DECL, stub.name)
    }

    override fun createPsi(stub: VariableDeclStub): Gta3ScriptVariableDecl {
        return Gta3ScriptVariableDeclImpl(stub, stub.stubType)
    }

    override fun createStub(psi: Gta3ScriptVariableDecl, parentStub: StubElement<*>): VariableDeclStub {
        return VariableDeclStubImpl(parentStub, psi.name)
    }
}