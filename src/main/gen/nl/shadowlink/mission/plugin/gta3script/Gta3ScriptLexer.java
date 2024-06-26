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
    "\1\4\1\0\1\5\3\0\1\6\1\7\1\0\1\10"+
    "\1\11\1\12\12\13\1\14\1\0\1\15\1\16\1\17"+
    "\1\0\1\5\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\2\5\1\31\1\32\1\33\1\34"+
    "\1\35\1\5\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\3\5\4\0\1\44\1\0\32\5\1\0\1\45\10\0"+
    "\1\3\u01a2\0\2\3\326\0\u0100\3";

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
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\16\4"+
    "\1\16\1\17\1\11\1\20\1\21\1\11\1\22\1\23"+
    "\5\4\1\24\6\4\1\25\1\26\7\4\1\11\1\20"+
    "\1\27\11\4\1\30\1\31\1\4\1\32\5\4\1\20"+
    "\1\33\4\4\1\34\7\4\1\35\2\4\1\36\1\4"+
    "\1\37\1\40\11\4\1\41\6\4\1\42\15\4\1\43"+
    "\1\44\3\4\1\45\13\4\1\46\2\4\1\47\3\4"+
    "\1\50\2\4\1\51\10\4\1\52\1\4\1\53\5\4"+
    "\1\54\6\4\1\55";

  private static int [] zzUnpackAction() {
    int [] result = new int[182];
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
    "\0\0\0\46\0\114\0\162\0\230\0\230\0\46\0\276"+
    "\0\344\0\u010a\0\u0130\0\46\0\u0156\0\46\0\u017c\0\u01a2"+
    "\0\u01c8\0\u01ee\0\u0214\0\u023a\0\u0260\0\u0286\0\u02ac\0\u02d2"+
    "\0\u02f8\0\u031e\0\u0344\0\u036a\0\u0390\0\46\0\46\0\u03b6"+
    "\0\u03dc\0\u0402\0\u0428\0\46\0\46\0\u044e\0\u0474\0\u049a"+
    "\0\u04c0\0\u04e6\0\230\0\u050c\0\u0532\0\u0558\0\u057e\0\u05a4"+
    "\0\u05ca\0\230\0\230\0\u05f0\0\u0616\0\u063c\0\u0662\0\u0688"+
    "\0\u06ae\0\u06d4\0\u06fa\0\u0720\0\230\0\u0746\0\u076c\0\u0792"+
    "\0\u07b8\0\u07de\0\u0804\0\u082a\0\u0850\0\u0876\0\230\0\230"+
    "\0\u089c\0\230\0\u08c2\0\u08e8\0\u090e\0\u0934\0\u095a\0\46"+
    "\0\230\0\u0980\0\u09a6\0\u09cc\0\u09f2\0\230\0\u0a18\0\u0a3e"+
    "\0\u0a64\0\u0a8a\0\u0ab0\0\u0ad6\0\u0afc\0\230\0\u0b22\0\u0b48"+
    "\0\230\0\u0b6e\0\230\0\230\0\u0b94\0\u0bba\0\u0be0\0\u0c06"+
    "\0\u0c2c\0\u0c52\0\u0c78\0\u0c9e\0\u0cc4\0\230\0\u0cea\0\u0d10"+
    "\0\u0d36\0\u0d5c\0\u0d82\0\u0da8\0\230\0\u0dce\0\u0df4\0\u0e1a"+
    "\0\u0e40\0\u0e66\0\u0e8c\0\u0eb2\0\u0ed8\0\u0efe\0\u0f24\0\u0f4a"+
    "\0\u0f70\0\u0f96\0\230\0\230\0\u0fbc\0\u0fe2\0\u1008\0\230"+
    "\0\u102e\0\u1054\0\u107a\0\u10a0\0\u10c6\0\u10ec\0\u1112\0\u1138"+
    "\0\u115e\0\u1184\0\u11aa\0\230\0\u11d0\0\u11f6\0\230\0\u121c"+
    "\0\u1242\0\u1268\0\230\0\u128e\0\u12b4\0\230\0\u12da\0\u1300"+
    "\0\u1326\0\u134c\0\u1372\0\u1398\0\u13be\0\u13e4\0\230\0\u140a"+
    "\0\230\0\u1430\0\u1456\0\u147c\0\u14a2\0\u14c8\0\230\0\u14ee"+
    "\0\u1514\0\u153a\0\u1560\0\u1586\0\u15ac\0\230";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[182];
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
    "\1\11\1\6\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\3\6\1\21\1\22\1\23\1\6\1\24\1\25"+
    "\1\26\1\27\1\30\1\6\1\31\1\32\1\33\1\6"+
    "\1\34\1\35\1\6\1\4\47\0\1\3\46\0\1\4"+
    "\42\0\1\4\5\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\25\6\10\0\1\36\46\0\1\37\2\0\1\40"+
    "\40\0\1\41\3\0\1\42\40\0\1\6\3\0\1\43"+
    "\1\0\1\13\4\0\25\6\17\0\1\44\45\0\1\45"+
    "\34\0\1\6\3\0\1\6\1\0\1\6\4\0\13\6"+
    "\1\46\11\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\11\6\1\47\1\6\1\50\11\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\1\51\24\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\14\6\1\52"+
    "\10\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\5\6\1\53\17\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\1\54\13\6\1\55\5\6\1\56\2\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\10\6"+
    "\1\57\14\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\14\6\1\60\10\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\5\6\1\61\5\6\1\62\2\6"+
    "\1\63\6\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\4\6\1\64\20\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\4\6\1\65\13\6\1\66\1\67"+
    "\3\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\16\6\1\70\6\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\1\71\24\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\7\6\1\72\15\6\12\0\1\73"+
    "\1\0\1\40\32\0\6\41\1\74\37\41\2\42\2\0"+
    "\42\42\5\0\1\6\3\0\1\6\1\0\1\43\4\0"+
    "\25\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\3\6\1\75\21\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\17\6\1\76\5\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\3\6\1\77\21\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\11\6\1\100"+
    "\13\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\17\6\1\101\1\102\4\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\21\6\1\103\3\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\1\104\24\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\1\105\24\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\17\6"+
    "\1\106\5\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\20\6\1\107\4\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\5\6\1\110\17\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\20\6\1\111\4\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\20\6"+
    "\1\112\4\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\1\113\24\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\1\6\1\114\23\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\21\6\1\115\3\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\16\6\1\116"+
    "\6\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\10\6\1\117\14\6\14\0\1\73\32\0\6\41\1\74"+
    "\3\41\1\120\33\41\5\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\4\6\1\121\20\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\10\6\1\122\12\6\1\123"+
    "\1\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\17\6\1\124\5\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\21\6\1\125\3\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\14\6\1\126\10\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\13\6\1\127"+
    "\11\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\3\6\1\130\21\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\16\6\1\131\6\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\17\6\1\132\5\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\21\6\1\133"+
    "\3\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\16\6\1\134\6\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\16\6\1\135\6\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\4\6\1\136\20\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\24\6\1\137"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\11\6"+
    "\1\140\13\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\5\6\1\141\17\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\7\6\1\142\15\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\4\6\1\143\20\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\1\6"+
    "\1\144\23\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\2\6\1\145\22\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\24\6\1\146\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\24\6\1\147\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\10\6\1\150\14\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\16\6"+
    "\1\151\6\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\20\6\1\152\4\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\14\6\1\153\10\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\5\6\1\154\2\6"+
    "\1\155\14\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\4\6\1\156\20\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\10\6\1\157\14\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\7\6\1\160\15\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\1\161"+
    "\24\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\5\6\1\162\2\6\1\163\14\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\14\6\1\164\10\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\13\6\1\165"+
    "\11\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\24\6\1\166\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\21\6\1\167\3\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\11\6\1\170\13\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\13\6\1\171\11\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\11\6"+
    "\1\172\13\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\24\6\1\173\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\13\6\1\174\11\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\11\6\1\175\13\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\13\6\1\176"+
    "\11\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\13\6\1\177\11\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\13\6\1\200\11\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\20\6\1\201\4\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\14\6\1\202"+
    "\10\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\20\6\1\203\4\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\4\6\1\204\20\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\12\6\1\205\12\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\3\6\1\206"+
    "\21\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\14\6\1\207\10\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\20\6\1\210\4\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\24\6\1\211\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\4\6\1\212\20\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\10\6"+
    "\1\213\14\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\1\214\24\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\10\6\1\215\14\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\24\6\1\216\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\1\217\24\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\4\6\1\220"+
    "\12\6\1\221\5\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\23\6\1\222\1\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\13\6\1\223\11\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\20\6\1\224"+
    "\4\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\17\6\1\225\5\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\11\6\1\226\13\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\20\6\1\227\4\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\13\6\1\230"+
    "\11\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\20\6\1\231\4\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\24\6\1\232\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\4\6\1\233\20\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\17\6\1\234\5\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\1\235"+
    "\24\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\3\6\1\236\21\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\1\237\24\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\17\6\1\240\5\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\10\6\1\241\14\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\21\6"+
    "\1\242\3\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\16\6\1\243\6\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\2\6\1\244\22\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\14\6\1\245\10\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\13\6"+
    "\1\246\11\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\20\6\1\247\4\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\16\6\1\250\6\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\13\6\1\251\11\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\2\6"+
    "\1\252\22\6\6\0\1\6\3\0\1\6\1\0\1\6"+
    "\4\0\10\6\1\253\14\6\6\0\1\6\3\0\1\6"+
    "\1\0\1\6\4\0\7\6\1\254\15\6\6\0\1\6"+
    "\3\0\1\6\1\0\1\6\4\0\15\6\1\255\7\6"+
    "\6\0\1\6\3\0\1\6\1\0\1\6\4\0\24\6"+
    "\1\256\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\20\6\1\257\4\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\12\6\1\260\12\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\10\6\1\261\14\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\17\6\1\262"+
    "\5\6\6\0\1\6\3\0\1\6\1\0\1\6\4\0"+
    "\17\6\1\263\5\6\6\0\1\6\3\0\1\6\1\0"+
    "\1\6\4\0\10\6\1\264\14\6\6\0\1\6\3\0"+
    "\1\6\1\0\1\6\4\0\14\6\1\265\10\6\6\0"+
    "\1\6\3\0\1\6\1\0\1\6\4\0\13\6\1\266"+
    "\11\6\1\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[5586];
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
    "\1\0\1\11\4\1\1\11\4\1\1\11\1\1\1\11"+
    "\17\1\2\11\4\1\2\11\52\1\1\11\146\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[182];
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
          case 46: break;
          case 2:
            { return WHITE_SPACE;
            }
          // fall through
          case 47: break;
          case 3:
            { return NEW_LINE;
            }
          // fall through
          case 48: break;
          case 4:
            { return IDENTIFIER;
            }
          // fall through
          case 49: break;
          case 5:
            { return OP_TIMES;
            }
          // fall through
          case 50: break;
          case 6:
            { return OP_PLUS;
            }
          // fall through
          case 51: break;
          case 7:
            { return OP_MINUS;
            }
          // fall through
          case 52: break;
          case 8:
            { return OP_DIVISION;
            }
          // fall through
          case 53: break;
          case 9:
            { return NUMBER;
            }
          // fall through
          case 54: break;
          case 10:
            { return COLON;
            }
          // fall through
          case 55: break;
          case 11:
            { return OP_LESS_THAN;
            }
          // fall through
          case 56: break;
          case 12:
            { return EQUALS;
            }
          // fall through
          case 57: break;
          case 13:
            { return OP_GREATER_THAN;
            }
          // fall through
          case 58: break;
          case 14:
            { return OP_PLUS_PLUS;
            }
          // fall through
          case 59: break;
          case 15:
            { return OP_MINUS_MINUS;
            }
          // fall through
          case 60: break;
          case 16:
            { return COMMENT_BLOCK;
            }
          // fall through
          case 61: break;
          case 17:
            { return COMMENT;
            }
          // fall through
          case 62: break;
          case 18:
            { return OP_LESS_THAN_OR_EQUAL;
            }
          // fall through
          case 63: break;
          case 19:
            { return OP_GREATER_THAN_OR_EQUAL;
            }
          // fall through
          case 64: break;
          case 20:
            { return IF;
            }
          // fall through
          case 65: break;
          case 21:
            { return ON;
            }
          // fall through
          case 66: break;
          case 22:
            { return OR;
            }
          // fall through
          case 67: break;
          case 23:
            { return AND;
            }
          // fall through
          case 68: break;
          case 24:
            { return NOT;
            }
          // fall through
          case 69: break;
          case 25:
            { return OFF;
            }
          // fall through
          case 70: break;
          case 26:
            { return SET;
            }
          // fall through
          case 71: break;
          case 27:
            { return ELSE;
            }
          // fall through
          case 72: break;
          case 28:
            { return GOTO;
            }
          // fall through
          case 73: break;
          case 29:
            { return TRUE;
            }
          // fall through
          case 74: break;
          case 30:
            { return END_IF;
            }
          // fall through
          case 75: break;
          case 31:
            { return FALSE;
            }
          // fall through
          case 76: break;
          case 32:
            { return GOSUB;
            }
          // fall through
          case 77: break;
          case 33:
            { return WHILE;
            }
          // fall through
          case 78: break;
          case 34:
            { return RETURN;
            }
          // fall through
          case 79: break;
          case 35:
            { return VAR_INT;
            }
          // fall through
          case 80: break;
          case 36:
            { return END_WHILE;
            }
          // fall through
          case 81: break;
          case 37:
            { return LVAR_INT;
            }
          // fall through
          case 82: break;
          case 38:
            { return VAR_FLOAT;
            }
          // fall through
          case 83: break;
          case 39:
            { return LVAR_FLOAT;
            }
          // fall through
          case 84: break;
          case 40:
            { return SUBROUTINE;
            }
          // fall through
          case 85: break;
          case 41:
            { return MISSION_END;
            }
          // fall through
          case 86: break;
          case 42:
            { return MISSION_START;
            }
          // fall through
          case 87: break;
          case 43:
            { return LAUNCH_MISSION;
            }
          // fall through
          case 88: break;
          case 44:
            { return START_NEW_SCRIPT;
            }
          // fall through
          case 89: break;
          case 45:
            { return LOAD_AND_LAUNCH_MISSION;
            }
          // fall through
          case 90: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
