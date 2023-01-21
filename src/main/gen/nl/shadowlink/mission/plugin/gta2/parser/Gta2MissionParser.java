// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class Gta2MissionParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return missionFile(b, l + 1);
  }

  /* ********************************************************** */
  // EQ params*
  static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, EQ)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && assignment_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // params*
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!params(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assignment_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // definition*
  public static boolean dataBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataBlock")) return false;
    Marker m = enter_section_(b, l, _NONE_, DATA_BLOCK, "<data block>");
    while (true) {
      int c = current_position_(b);
      if (!definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dataBlock", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // (type id assignment?) | comment | (type method) | method_def
  public static boolean definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = definition_0(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = definition_2(b, l + 1);
    if (!r) r = method_def(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type id assignment?
  private static boolean definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && definition_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assignment?
  private static boolean definition_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition_0_2")) return false;
    assignment(b, l + 1);
    return true;
  }

  // type method
  private static boolean definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, METHOD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // while | if | method_def | statement | comment | set
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = while_$(b, l + 1);
    if (!r) r = if_$(b, l + 1);
    if (!r) r = method_def(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = set(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF LP statement RP expression* END_IF
  static boolean if_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_$")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, LP);
    r = r && statement(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && if_4(b, l + 1);
    r = r && consumeToken(b, END_IF);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression*
  private static boolean if_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LEVEL_START expression* LEVEL_END
  public static boolean levelBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "levelBlock")) return false;
    if (!nextTokenIs(b, LEVEL_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEVEL_START);
    r = r && levelBlock_1(b, l + 1);
    r = r && consumeToken(b, LEVEL_END);
    exit_section_(b, m, LEVEL_BLOCK, r);
    return r;
  }

  // expression*
  private static boolean levelBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "levelBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "levelBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // method expression* RETURN
  static boolean method_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_def")) return false;
    if (!nextTokenIs(b, METHOD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METHOD);
    r = r && method_def_1(b, l + 1);
    r = r && consumeToken(b, RETURN);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression*
  private static boolean method_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_def_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_def_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // dataBlock? levelBlock?
  static boolean missionFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "missionFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = missionFile_0(b, l + 1);
    r = r && missionFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // dataBlock?
  private static boolean missionFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "missionFile_0")) return false;
    dataBlock(b, l + 1);
    return true;
  }

  // levelBlock?
  private static boolean missionFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "missionFile_1")) return false;
    levelBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // number | ENUM | id | method
  static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, METHOD);
    return r;
  }

  /* ********************************************************** */
  // vector3 | number | ENUM | id | (LP (param ','?)* RP)
  static boolean params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vector3(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = params_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LP (param ','?)* RP
  private static boolean params_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && params_4_1(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, null, r);
    return r;
  }

  // (param ','?)*
  private static boolean params_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_4_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!params_4_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "params_4_1", c)) break;
    }
    return true;
  }

  // param ','?
  private static boolean params_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param(b, l + 1);
    r = r && params_4_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean params_4_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_4_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // SET id assignment
  static boolean set(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SET, ID);
    r = r && assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((id EQ)? ENUM params* END?) | (id EQ param) | (op_plus_plus id)
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = statement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (id EQ)? ENUM params* END?
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_0_0(b, l + 1);
    r = r && consumeToken(b, ENUM);
    r = r && statement_0_2(b, l + 1);
    r = r && statement_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (id EQ)?
  private static boolean statement_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_0")) return false;
    statement_0_0_0(b, l + 1);
    return true;
  }

  // id EQ
  private static boolean statement_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, EQ);
    exit_section_(b, m, null, r);
    return r;
  }

  // params*
  private static boolean statement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!params(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_0_2", c)) break;
    }
    return true;
  }

  // END?
  private static boolean statement_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_3")) return false;
    consumeToken(b, END);
    return true;
  }

  // id EQ param
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, EQ);
    r = r && param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // op_plus_plus id
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OP_PLUS_PLUS, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLAYER_PED_DEF | CHAR_DATA_DEF | COUNTER_DEF | FORWARD_DEF | TIMER_DATA_DEF | THREAD_TRIGGER_DEF
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, PLAYER_PED_DEF);
    if (!r) r = consumeToken(b, CHAR_DATA_DEF);
    if (!r) r = consumeToken(b, COUNTER_DEF);
    if (!r) r = consumeToken(b, FORWARD_DEF);
    if (!r) r = consumeToken(b, TIMER_DATA_DEF);
    if (!r) r = consumeToken(b, THREAD_TRIGGER_DEF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LP number COMMA number COMMA number RP
  public static boolean vector3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector3")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LP, NUMBER, COMMA, NUMBER, COMMA, NUMBER, RP);
    exit_section_(b, m, VECTOR_3, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE_EXEC LP statement RP expression* END_WHILE
  static boolean while_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_$")) return false;
    if (!nextTokenIs(b, WHILE_EXEC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHILE_EXEC, LP);
    r = r && statement(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && while_4(b, l + 1);
    r = r && consumeToken(b, END_WHILE);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression*
  private static boolean while_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "while_4", c)) break;
    }
    return true;
  }

}
