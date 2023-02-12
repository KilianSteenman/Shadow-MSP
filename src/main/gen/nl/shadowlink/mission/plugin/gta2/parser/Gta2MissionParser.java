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
    return MissionFile(b, l + 1);
  }

  /* ********************************************************** */
  // AND '(' ConditionalStatement ')'
  public static boolean AndStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AndStatement")) return false;
    if (!nextTokenIs(b, AND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && consumeToken(b, "(");
    r = r && ConditionalStatement(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, AND_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // '=' Param
  static boolean Assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Assignment")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && Param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' Param | MethodCall | NOT? '(' ConditionalStatement ')' AndStatement*
  public static boolean ConditionalStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_STATEMENT, "<conditional statement>");
    r = ConditionalStatement_0(b, l + 1);
    if (!r) r = MethodCall(b, l + 1);
    if (!r) r = ConditionalStatement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER '=' Param
  private static boolean ConditionalStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && Param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT? '(' ConditionalStatement ')' AndStatement*
  private static boolean ConditionalStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConditionalStatement_2_0(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && ConditionalStatement(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && ConditionalStatement_2_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT?
  private static boolean ConditionalStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_2_0")) return false;
    consumeToken(b, NOT);
    return true;
  }

  // AndStatement*
  private static boolean ConditionalStatement_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_2_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AndStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConditionalStatement_2_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VariableDefinition | SubroutineDefinition | COMMENT | (Type SUBROUTINE)
  public static boolean Definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = VariableDefinition(b, l + 1);
    if (!r) r = SubroutineDefinition(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = Definition_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Type SUBROUTINE
  private static boolean Definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1);
    r = r && consumeToken(b, SUBROUTINE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Definition*
  public static boolean DefinitionBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefinitionBlock")) return false;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION_BLOCK, "<definition block>");
    while (true) {
      int c = current_position_(b);
      if (!Definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DefinitionBlock", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // MACHINE_GUN | CRIMINAL_TYPE2 | AREA_PLAYER_ONLY | REACT_AS_NORMAL | KILL_CHAR_ON_FOOT
  public static boolean Enum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Enum")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM, "<enum>");
    r = consumeToken(b, MACHINE_GUN);
    if (!r) r = consumeToken(b, CRIMINAL_TYPE2);
    if (!r) r = consumeToken(b, AREA_PLAYER_ONLY);
    if (!r) r = consumeToken(b, REACT_AS_NORMAL);
    if (!r) r = consumeToken(b, KILL_CHAR_ON_FOOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMENT | VariableAssignment | MethodCall | WhileExpression | IfExpression | SubroutineDefinition | SetExpression | MathAssignment
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = consumeToken(b, COMMENT);
    if (!r) r = VariableAssignment(b, l + 1);
    if (!r) r = MethodCall(b, l + 1);
    if (!r) r = WhileExpression(b, l + 1);
    if (!r) r = IfExpression(b, l + 1);
    if (!r) r = SubroutineDefinition(b, l + 1);
    if (!r) r = SetExpression(b, l + 1);
    if (!r) r = MathAssignment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF '(' ConditionalStatement ')' Expression* END_IF
  public static boolean IfExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && consumeToken(b, "(");
    r = r && ConditionalStatement(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && IfExpression_4(b, l + 1);
    r = r && consumeToken(b, END_IF);
    exit_section_(b, m, IF_EXPRESSION, r);
    return r;
  }

  // Expression*
  private static boolean IfExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfExpression_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LEVEL_START LevelBody? LEVEL_END
  public static boolean LevelBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LevelBlock")) return false;
    if (!nextTokenIs(b, LEVEL_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEVEL_START);
    r = r && LevelBlock_1(b, l + 1);
    r = r && consumeToken(b, LEVEL_END);
    exit_section_(b, m, LEVEL_BLOCK, r);
    return r;
  }

  // LevelBody?
  private static boolean LevelBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LevelBlock_1")) return false;
    LevelBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression*
  public static boolean LevelBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LevelBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, LEVEL_BODY, "<level body>");
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LevelBody", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // OP_PLUS_PLUS IDENTIFIER | IDENTIFIER OP_PLUS_PLUS
  public static boolean MathAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAssignment")) return false;
    if (!nextTokenIs(b, "<math assignment>", IDENTIFIER, OP_PLUS_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_ASSIGNMENT, "<math assignment>");
    r = parseTokens(b, 0, OP_PLUS_PLUS, IDENTIFIER);
    if (!r) r = parseTokens(b, 0, IDENTIFIER, OP_PLUS_PLUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // METHOD Params? END?
  public static boolean MethodCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall")) return false;
    if (!nextTokenIs(b, METHOD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METHOD);
    r = r && MethodCall_1(b, l + 1);
    r = r && MethodCall_2(b, l + 1);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  // Params?
  private static boolean MethodCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall_1")) return false;
    Params(b, l + 1);
    return true;
  }

  // END?
  private static boolean MethodCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall_2")) return false;
    consumeToken(b, END);
    return true;
  }

  /* ********************************************************** */
  // DefinitionBlock? LevelBlock?
  static boolean MissionFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MissionFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MissionFile_0(b, l + 1);
    r = r && MissionFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DefinitionBlock?
  private static boolean MissionFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MissionFile_0")) return false;
    DefinitionBlock(b, l + 1);
    return true;
  }

  // LevelBlock?
  private static boolean MissionFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MissionFile_1")) return false;
    LevelBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NUMBER | Enum | IDENTIFIER | SUBROUTINE | Vector3
  public static boolean Param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM, "<param>");
    r = consumeToken(b, NUMBER);
    if (!r) r = Enum(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SUBROUTINE);
    if (!r) r = Vector3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Param+ | ('(' (Param ','?)+ ')')
  public static boolean Params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMS, "<params>");
    r = Params_0(b, l + 1);
    if (!r) r = Params_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Param+
  private static boolean Params_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Param(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!Param(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Params_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' (Param ','?)+ ')'
  private static boolean Params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && Params_1_1(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (Param ','?)+
  private static boolean Params_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Params_1_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!Params_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Params_1_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // Param ','?
  private static boolean Params_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Param(b, l + 1);
    r = r && Params_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean Params_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_1_1_0_1")) return false;
    consumeToken(b, ",");
    return true;
  }

  /* ********************************************************** */
  // SET IDENTIFIER Assignment
  public static boolean SetExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetExpression")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SET, IDENTIFIER);
    r = r && Assignment(b, l + 1);
    exit_section_(b, m, SET_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // SUBROUTINE Expression* RETURN
  public static boolean SubroutineDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineDefinition")) return false;
    if (!nextTokenIs(b, SUBROUTINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUBROUTINE);
    r = r && SubroutineDefinition_1(b, l + 1);
    r = r && consumeToken(b, RETURN);
    exit_section_(b, m, SUBROUTINE_DEFINITION, r);
    return r;
  }

  // Expression*
  private static boolean SubroutineDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineDefinition_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SubroutineDefinition_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PLAYER_PED | CHAR_DATA | COUNTER | FORWARD | TIMER_DATA | THREAD_TRIGGER | CAR_DATA
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, PLAYER_PED);
    if (!r) r = consumeToken(b, CHAR_DATA);
    if (!r) r = consumeToken(b, COUNTER);
    if (!r) r = consumeToken(b, FORWARD);
    if (!r) r = consumeToken(b, TIMER_DATA);
    if (!r) r = consumeToken(b, THREAD_TRIGGER);
    if (!r) r = consumeToken(b, CAR_DATA);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' (Param | MethodCall)
  public static boolean VariableAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && VariableAssignment_2(b, l + 1);
    exit_section_(b, m, VARIABLE_ASSIGNMENT, r);
    return r;
  }

  // Param | MethodCall
  private static boolean VariableAssignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignment_2")) return false;
    boolean r;
    r = Param(b, l + 1);
    if (!r) r = MethodCall(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // Type IDENTIFIER Assignment?
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = Type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && VariableDefinition_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Assignment?
  private static boolean VariableDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2")) return false;
    Assignment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' number ',' number ',' number ')'
  public static boolean Vector3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector3")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VECTOR_3, "<vector 3>");
    r = consumeToken(b, "(");
    r = r && consumeToken(b, NUMBER);
    r = r && consumeToken(b, ",");
    r = r && consumeToken(b, NUMBER);
    r = r && consumeToken(b, ",");
    r = r && consumeToken(b, NUMBER);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WHILE_EXEC '(' ConditionalStatement ')' Expression* END_WHILE
  public static boolean WhileExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpression")) return false;
    if (!nextTokenIs(b, WHILE_EXEC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE_EXEC);
    r = r && consumeToken(b, "(");
    r = r && ConditionalStatement(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && WhileExpression_4(b, l + 1);
    r = r && consumeToken(b, END_WHILE);
    exit_section_(b, m, WHILE_EXPRESSION, r);
    return r;
  }

  // Expression*
  private static boolean WhileExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpression_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "WhileExpression_4", c)) break;
    }
    return true;
  }

}