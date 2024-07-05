package nl.shadowlink.mission.plugin.gta3script.indexing

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptLabelDecl
import nl.shadowlink.mission.plugin.gta3script.psi.impl.Gta3ScriptLabelDeclImpl

object LabelDeclStubElementType :
    IStubElementType<LabelDeclStub, Gta3ScriptLabelDecl>("LABEL_DECLARATION", Gta3ScriptLanguage) {

    @JvmStatic
    fun getInstance(@Suppress("UNUSED_PARAMETER") debugName: String): LabelDeclStubElementType {
        return LabelDeclStubElementType;
    }

    override fun getExternalId(): String {
        return "Gta3Script.Label.Decl"
    }

    override fun serialize(stub: LabelDeclStub, dataStream: StubOutputStream) {
        dataStream.writeUTF(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): LabelDeclStub {
        val name = dataStream.readUTF()
        return LabelDeclStubImpl(parentStub, name)
    }

    override fun indexStub(stub: LabelDeclStub, sink: IndexSink) {
        sink.occurrence(Indices.LABEL_DECL, stub.name)
    }

    override fun createPsi(stub: LabelDeclStub): Gta3ScriptLabelDecl {
        return Gta3ScriptLabelDeclImpl(stub, stub.stubType)
    }

    override fun createStub(psi: Gta3ScriptLabelDecl, parentStub: StubElement<*>): LabelDeclStub {
        return LabelDeclStubImpl(parentStub, psi.name)
    }
}