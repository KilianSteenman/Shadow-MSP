package nl.shadowlink.mission.plugin.lexer

import com.intellij.lexer.LexerBase
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.tree.IElementType
import java.util.regex.Pattern

class MissionLexer : LexerBase() {

    private var tokenType: MissionTokenType? = null
    private var buffer: CharSequence? = null
    private var bufferEnd: Int = 0
    private var firstTokenStart: Int = 0
    private var firstTokenEnd: Int = 0

    private val log = Logger.getInstance("test")

    override fun getState(): Int {
        // TODO: Figure out if we need to do something with the state?
        return 0
    }

    override fun getTokenStart(): Int {
        // TODO: Figure out what to do
        return firstTokenStart
    }

    override fun getTokenEnd(): Int {
        // TODO: Figure out what to do
        return firstTokenEnd
    }

    override fun getBufferEnd(): Int {
        // TODO: Figure out what to do
        return bufferEnd
    }

    override fun getBufferSequence(): CharSequence {
        return buffer ?: ""
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.firstTokenStart = startOffset
        this.firstTokenEnd = startOffset
        this.bufferEnd = endOffset

        advance()
    }

    override fun getTokenType(): IElementType? {
        return tokenType
    }

    override fun advance() {
        tokenType = when {
            firstTokenEnd >= bufferEnd -> null
            isMatch(OPCODE) -> MissionTokenType.OPCODE
            isMatch(COMMENT) -> MissionTokenType.COMMENT
            isMatch(LABEL) -> MissionTokenType.LABEL
            isMatch(STRING) -> MissionTokenType.STRING
            isMatch(STRING_KEY) -> MissionTokenType.STRING_KEY
            isMatch(JUMP_REF) -> MissionTokenType.LABEL_REF
            isMatch(SPACE) -> MissionTokenType.SPACE
            isMatch(MODEL) -> MissionTokenType.MODEL
            isMatch(SYMBOL) -> MissionTokenType.SYMBOL
            isMatch(FLOAT) -> MissionTokenType.FLOAT
            isMatch(INT) -> MissionTokenType.INT
            isMatch(DEFINE) -> MissionTokenType.DEFINE
            else -> {
                firstTokenStart = firstTokenEnd
                firstTokenEnd += 1
                MissionTokenType.ERROR
            }
        }
    }

    private fun isMatch(pattern: Pattern): Boolean {
        val matcher = pattern.matcher(buffer).region(firstTokenEnd, bufferEnd)
        if (matcher.lookingAt()) {
            val result = matcher.toMatchResult()
            firstTokenStart = result.start()
            firstTokenEnd = result.end()
            return true
        }
        return false
    }

    companion object {
        private val OPCODE = Pattern.compile(".{4}:")
        private val COMMENT = Pattern.compile("//.+")
        private val LABEL = Pattern.compile(":.+")
        private val JUMP_REF = Pattern.compile("@.+")
        private val STRING_KEY = Pattern.compile("'.+?'")
        private val STRING = Pattern.compile("\".+?\"")
        private val SPACE = Pattern.compile("\\s+")
        private val MODEL = Pattern.compile("#\\w*")
        private val SYMBOL = Pattern.compile("\\$\\w*")
        private val FLOAT = Pattern.compile("-?\\d+\\.\\d+")
        private val INT = Pattern.compile("-?\\d+")
        private val DEFINE = Pattern.compile("DEFINE")
    }
}