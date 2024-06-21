package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptVariableImpl

class VariableStubElementType : IStubElementType<VariableStub, Gta3ScriptVariable>("GLOBAL_VARIABLE", Gta3ScriptLanguage) {

    override fun createPsi(stub: VariableStub): Gta3ScriptVariable {
        println("Create psi")
        return Gta3ScriptVariableImpl(stub.psi.node)//, this)
    }

    override fun createStub(psi: Gta3ScriptVariable, parentStub: StubElement<*>): VariableStub {
        println("Create stub ${psi.text}")
        return VariableStubImpl(parentStub, Gta3ScriptStubElementTypes.VARIABLE, psi.name)
    }

    override fun serialize(stub: VariableStub, dataStream: StubOutputStream) {
        dataStream.writeUTF(stub.name)
    }

    override fun getExternalId(): String {
        return "Gta3Script.Variable"
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): VariableStub {
        val name = dataStream.readUTF()
        return VariableStubImpl(parentStub, this, name)
    }

    override fun indexStub(stub: VariableStub, sink: IndexSink) {
        println("IndexStub ${stub.name}")
        sink.occurrence(VariableIndex.KEY, stub.name)
    }
}