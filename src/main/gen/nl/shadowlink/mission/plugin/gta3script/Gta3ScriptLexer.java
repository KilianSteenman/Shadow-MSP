// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: gta3script.flex

package nl.shadowlink.mission.plugin.gta3script;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes.*;


public class Gta3ScriptLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\3\1\2\22\0\1\1\3\0"+
    "\1\4\5\0\1\5\1\6\1\0\1\7\1\10\1\11"+
    "\12\12\1\13\1\0\1\14\1\15\1\16\2\0\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\2\21\1\30\1\31\1\32\1\33\2\21\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\3\21\4\0\1\42\1\0"+
    "\32\43\1\0\1\44\10\0\1\3\u01a2\0\2\3\326\0"+
    "\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\20\7\1\15"+
    "\1\16\1\11\2\17\1\11\1\20\1\21\5\7\1\22"+
    "\3\7\1\23\1\24\6\7\1\11\1\17\1\25\1\7"+
    "\1\26\3\7\1\27\1\30\1\7\1\31\4\7\1\17"+
    "\1\32\7\7\1\33\2\7\1\34\1\7\1\35\1\36"+
    "\5\7\1\37\2\7\1\40\7\7\1\41\1\42\6\7"+
    "\1\43\2\7\1\44\1\45\2\7\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\45\0\112\0\157\0\224\0\45\0\271\0\336"+
    "\0\224\0\u0103\0\u0128\0\45\0\45\0\45\0\u014d\0\u0172"+
    "\0\u0197\0\u01bc\0\u01e1\0\u0206\0\u022b\0\u0250\0\u0275\0\u029a"+
    "\0\u02bf\0\u02e4\0\u0309\0\u032e\0\u0353\0\u0378\0\45\0\45"+
    "\0\u039d\0\u03c2\0\u03e7\0\u040c\0\45\0\45\0\u0431\0\u0456"+
    "\0\u047b\0\u04a0\0\u04c5\0\u0172\0\u04ea\0\u050f\0\u0534\0\u0172"+
    "\0\u0172\0\u0559\0\u057e\0\u05a3\0\u05c8\0\u05ed\0\u0612\0\u0637"+
    "\0\u065c\0\u0172\0\u0681\0\u06a6\0\u06cb\0\u06f0\0\u0715\0\u0172"+
    "\0\u0172\0\u073a\0\u0172\0\u075f\0\u0784\0\u07a9\0\u07ce\0\45"+
    "\0\u0172\0\u07f3\0\u0818\0\u083d\0\u0862\0\u0887\0\u08ac\0\u08d1"+
    "\0\u0172\0\u08f6\0\u091b\0\u0172\0\u0940\0\u0172\0\u0172\0\u0965"+
    "\0\u098a\0\u09af\0\u09d4\0\u09f9\0\u0172\0\u0a1e\0\u0a43\0\u0172"+
    "\0\u0a68\0\u0a8d\0\u0ab2\0\u0ad7\0\u0afc\0\u0b21\0\u0b46\0\u0172"+
    "\0\u0172\0\u0b6b\0\u0b90\0\u0bb5\0\u0bda\0\u0bff\0\u0c24\0\u0172"+
    "\0\u0c49\0\u0c6e\0\u0172\0\u0172\0\u0c93\0\u0cb8\0\u0172";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\2\1\14\1\15\1\16\1\17"+
    "\3\20\1\21\1\22\1\23\1\20\1\24\1\20\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\20\1\33\1\34"+
    "\1\35\1\36\1\4\46\0\1\3\45\0\1\4\41\0"+
    "\1\4\10\0\1\11\1\0\1\11\4\0\25\11\7\0"+
    "\1\37\45\0\1\40\2\0\1\41\37\0\1\42\3\0"+
    "\1\43\43\0\1\44\1\0\1\13\1\45\3\0\23\11"+
    "\2\36\11\0\1\11\1\0\1\11\1\46\3\0\13\20"+
    "\1\47\10\20\1\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\24\20\1\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\11\20\1\50\1\20\1\51\10\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\1\52\23\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\14\20\1\53"+
    "\7\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\5\20\1\54\16\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\10\20\1\55\13\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\14\20\1\56\7\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\5\20\1\57"+
    "\5\20\1\60\1\20\1\61\6\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\4\20\1\62\17\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\4\20\1\63"+
    "\13\20\1\64\3\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\15\20\1\65\6\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\1\66\23\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\7\20\1\67\14\20"+
    "\1\11\11\0\1\11\1\0\1\36\1\46\3\0\23\20"+
    "\1\35\1\36\11\0\1\11\1\0\1\36\1\45\3\0"+
    "\23\11\2\36\11\0\1\70\1\0\1\41\32\0\5\42"+
    "\1\71\37\42\2\43\2\0\41\43\10\0\1\11\1\0"+
    "\1\44\4\0\25\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\3\20\1\72\20\20\1\11\11\0\1\11\1\0"+
    "\1\11\1\46\3\0\16\20\1\73\5\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\3\20\1\74\20\20"+
    "\1\11\11\0\1\11\1\0\1\11\1\46\3\0\11\20"+
    "\1\75\12\20\1\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\16\20\1\76\5\20\1\11\11\0\1\11\1\0"+
    "\1\11\1\46\3\0\16\20\1\77\5\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\17\20\1\100\4\20"+
    "\1\11\11\0\1\11\1\0\1\11\1\46\3\0\5\20"+
    "\1\101\16\20\1\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\17\20\1\102\4\20\1\11\11\0\1\11\1\0"+
    "\1\11\1\46\3\0\17\20\1\103\4\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\1\20\1\104\22\20"+
    "\1\11\11\0\1\11\1\0\1\11\1\46\3\0\20\20"+
    "\1\105\3\20\1\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\15\20\1\106\6\20\1\11\11\0\1\11\1\0"+
    "\1\11\1\46\3\0\10\20\1\107\13\20\1\11\13\0"+
    "\1\70\32\0\5\42\1\71\3\42\1\110\33\42\10\0"+
    "\1\11\1\0\1\11\1\46\3\0\4\20\1\111\17\20"+
    "\1\11\11\0\1\11\1\0\1\11\1\46\3\0\10\20"+
    "\1\112\11\20\1\113\1\20\1\11\11\0\1\11\1\0"+
    "\1\11\1\46\3\0\16\20\1\114\5\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\20\20\1\115\3\20"+
    "\1\11\11\0\1\11\1\0\1\11\1\46\3\0\16\20"+
    "\1\116\5\20\1\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\20\20\1\117\3\20\1\11\11\0\1\11\1\0"+
    "\1\11\1\46\3\0\15\20\1\120\6\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\4\20\1\121\17\20"+
    "\1\11\11\0\1\11\1\0\1\11\1\46\3\0\23\20"+
    "\1\122\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\11\20\1\123\12\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\5\20\1\124\16\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\7\20\1\125\14\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\4\20\1\126"+
    "\17\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\1\20\1\127\22\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\10\20\1\130\13\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\15\20\1\131\6\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\14\20\1\132"+
    "\7\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\5\20\1\133\2\20\1\134\13\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\4\20\1\135\17\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\10\20\1\136"+
    "\13\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\14\20\1\137\7\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\13\20\1\140\10\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\20\20\1\141\3\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\11\20\1\142"+
    "\12\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\13\20\1\143\10\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\11\20\1\144\12\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\13\20\1\145\10\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\17\20\1\146"+
    "\4\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\14\20\1\147\7\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\17\20\1\150\4\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\4\20\1\151\17\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\23\20\1\152"+
    "\1\11\11\0\1\11\1\0\1\11\1\46\3\0\10\20"+
    "\1\153\13\20\1\11\11\0\1\11\1\0\1\11\1\46"+
    "\3\0\1\154\23\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\4\20\1\155\11\20\1\156\5\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\13\20\1\157"+
    "\10\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\17\20\1\160\4\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\13\20\1\161\10\20\1\11\11\0\1\11"+
    "\1\0\1\11\1\46\3\0\17\20\1\162\4\20\1\11"+
    "\11\0\1\11\1\0\1\11\1\46\3\0\4\20\1\163"+
    "\17\20\1\11\11\0\1\11\1\0\1\11\1\46\3\0"+
    "\3\20\1\164\20\20\1\11\11\0\1\11\1\0\1\11"+
    "\1\46\3\0\1\165\23\20\1\11\11\0\1\11\1\0"+
    "\1\11\1\46\3\0\15\20\1\166\6\20\1\11\11\0"+
    "\1\11\1\0\1\11\1\46\3\0\17\20\1\167\4\20"+
    "\1\11\1\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[3293];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\5\1\3\11\20\1\2\11"+
    "\4\1\2\11\41\1\1\11\57\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  public Gta3ScriptLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Gta3ScriptLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return BAD_CHARACTER;
            }
          // fall through
          case 39: break;
          case 2:
            { return WHITE_SPACE;
            }
          // fall through
          case 40: break;
          case 3:
            { return NEW_LINE;
            }
          // fall through
          case 41: break;
          case 4:
            { return OP_TIMES;
            }
          // fall through
          case 42: break;
          case 5:
            { return OP_PLUS;
            }
          // fall through
          case 43: break;
          case 6:
            { return OP_MINUS;
            }
          // fall through
          case 44: break;
          case 7:
            { return IDENTIFIER;
            }
          // fall through
          case 45: break;
          case 8:
            { return OP_DIVISION;
            }
          // fall through
          case 46: break;
          case 9:
            { return NUMBER;
            }
          // fall through
          case 47: break;
          case 10:
            { return OP_LESS_THAN;
            }
          // fall through
          case 48: break;
          case 11:
            { return EQUALS;
            }
          // fall through
          case 49: break;
          case 12:
            { return OP_GREATER_THAN;
            }
          // fall through
          case 50: break;
          case 13:
            { return OP_PLUS_PLUS;
            }
          // fall through
          case 51: break;
          case 14:
            { return OP_MINUS_MINUS;
            }
          // fall through
          case 52: break;
          case 15:
            { return COMMENT;
            }
          // fall through
          case 53: break;
          case 16:
            { return GOSUB_IDENTIFIER;
            }
          // fall through
          case 54: break;
          case 17:
            { return OPCODE;
            }
          // fall through
          case 55: break;
          case 18:
            { return IF;
            }
          // fall through
          case 56: break;
          case 19:
            { return ON;
            }
          // fall through
          case 57: break;
          case 20:
            { return OR;
            }
          // fall through
          case 58: break;
          case 21:
            { return AND;
            }
          // fall through
          case 59: break;
          case 22:
            { return END;
            }
          // fall through
          case 60: break;
          case 23:
            { return NOT;
            }
          // fall through
          case 61: break;
          case 24:
            { return OFF;
            }
          // fall through
          case 62: break;
          case 25:
            { return SET;
            }
          // fall through
          case 63: break;
          case 26:
            { return ELSE;
            }
          // fall through
          case 64: break;
          case 27:
            { return TRUE;
            }
          // fall through
          case 65: break;
          case 28:
            { return END_IF;
            }
          // fall through
          case 66: break;
          case 29:
            { return FALSE;
            }
          // fall through
          case 67: break;
          case 30:
            { return GOSUB;
            }
          // fall through
          case 68: break;
          case 31:
            { return WHILE;
            }
          // fall through
          case 69: break;
          case 32:
            { return RETURN;
            }
          // fall through
          case 70: break;
          case 33:
            { return VAR_INT;
            }
          // fall through
          case 71: break;
          case 34:
            { return END_WHILE;
            }
          // fall through
          case 72: break;
          case 35:
            { return VAR_FLOAT;
            }
          // fall through
          case 73: break;
          case 36:
            { return SUBROUTINE;
            }
          // fall through
          case 74: break;
          case 37:
            { return MISSION_END;
            }
          // fall through
          case 75: break;
          case 38:
            { return MISSION_START;
            }
          // fall through
          case 76: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}