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
            isMatch(SYMBOL) -> MissionTokenType.GLOBAL_VAR
            isMatch(LOCAL_VAR) -> MissionTokenType.LOCAL_VAR
            isMatch(FLOAT) -> MissionTokenType.FLOAT
            isMatch(INT) -> MissionTokenType.INT
            isMatch(EQUALS) -> MissionTokenType.EQUALS
            isMatch(EQUAL) -> MissionTokenType.EQUAL
            isMatch(PLUS) -> MissionTokenType.PLUS
            isMatch(MINUS) -> MissionTokenType.MINUS
            isMatch(MULTIPLY) -> MissionTokenType.MULTIPLY
            isMatch(DIVIDE) -> MissionTokenType.DIVIDE
            isMatch(KEY_DEFINE) -> MissionTokenType.KEY_DEFINE
            isMatch(KEY_MISSIONS) -> MissionTokenType.KEY_MISSIONS
            isMatch(KEY_MISSION) -> MissionTokenType.KEY_MISSION
            isMatch(KEY_OBJECTS) -> MissionTokenType.KEY_OBJECTS
            isMatch(KEY_OBJECT) -> MissionTokenType.KEY_OBJECT
            isMatch(KEY_MISSION_AT) -> MissionTokenType.KEY_AT
            isMatch(KEY_NOT) -> MissionTokenType.KEY_NOT
            isMatch(OPCODE_TEXT) -> MissionTokenType.OPCODE_TEXT
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
        private val COMMENT = Pattern.compile("//.*")
        private val LABEL = Pattern.compile(":[\\w\\d]+")
        private val JUMP_REF = Pattern.compile("@[\\w\\d]+")
        private val STRING_KEY = Pattern.compile("'.+?'")
        private val STRING = Pattern.compile("\".+?\"")
        private val SPACE = Pattern.compile("\\s+")
        private val MODEL = Pattern.compile("#\\w*")
        private val SYMBOL = Pattern.compile("\\$\\w*")
        private val LOCAL_VAR = Pattern.compile("\\d{1,2}@")
        private val FLOAT = Pattern.compile("-?\\d+\\.\\d+")
        private val INT = Pattern.compile("-?\\d+")
        private val EQUALS = Pattern.compile("={2}")
        private val EQUAL = Pattern.compile("=")
        private val PLUS = Pattern.compile("\\+")
        private val MINUS = Pattern.compile("-")
        private val DIVIDE = Pattern.compile("/")
        private val MULTIPLY = Pattern.compile("\\*")
        private val OPCODE_TEXT = Pattern.compile("[a-zA-Z_=]+")
        private val KEY_DEFINE = Pattern.compile("DEFINE")
        private val KEY_OBJECTS = Pattern.compile("OBJECTS")
        private val KEY_OBJECT = Pattern.compile("OBJECT")
        private val KEY_MISSIONS = Pattern.compile("MISSIONS")
        private val KEY_MISSION = Pattern.compile("MISSION")
        private val KEY_MISSION_AT = Pattern.compile("AT")
        private val KEY_NOT = Pattern.compile("not|NOT")
    }
}