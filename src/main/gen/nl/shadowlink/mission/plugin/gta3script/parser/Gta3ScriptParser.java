// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes.*;
import static nl.shadowlink.mission.plugin.gta3script.parser.Gta3ScriptParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class Gta3ScriptParser implements PsiParser, LightPsiParser {

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
    return ScriptFile(b, l + 1);
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
  // ON | OFF
  public static boolean Boolean(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Boolean")) return false;
    if (!nextTokenIs(b, "<boolean>", OFF, ON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean>");
    r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, OFF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMENTBLOCK
  public static boolean CommentBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommentBlock")) return false;
    if (!nextTokenIs(b, COMMENTBLOCK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENTBLOCK);
    exit_section_(b, m, COMMENT_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // VariableReference (EQUALS | OP_GREATER_THAN | OP_LESS_THAN) Param | MethodCall | NOT? '(' ConditionalStatement ')' AndStatement*
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

  // VariableReference (EQUALS | OP_GREATER_THAN | OP_LESS_THAN) Param
  private static boolean ConditionalStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableReference(b, l + 1);
    r = r && ConditionalStatement_0_1(b, l + 1);
    r = r && Param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUALS | OP_GREATER_THAN | OP_LESS_THAN
  private static boolean ConditionalStatement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_0_1")) return false;
    boolean r;
    r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, OP_GREATER_THAN);
    if (!r) r = consumeToken(b, OP_LESS_THAN);
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
  // VariableDefinition | SubroutineDefinition | COMMENT | (Type IDENTIFIER)
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

  // Type IDENTIFIER
  private static boolean Definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression*
  public static boolean DefinitionBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefinitionBlock")) return false;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION_BLOCK, "<definition block>");
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DefinitionBlock", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // EXEC Expression* END_EXEC
  public static boolean ExecExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExecExpression")) return false;
    if (!nextTokenIs(b, EXEC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXEC);
    r = r && ExecExpression_1(b, l + 1);
    r = r && consumeToken(b, END_EXEC);
    exit_section_(b, m, EXEC_EXPRESSION, r);
    return r;
  }

  // Expression*
  private static boolean ExecExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExecExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExecExpression_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COMMENT | VariableAssignment | MethodCall | WhileExpression | IfExpression | SubroutineDefinition | SetExpression | MathAssignment | CommentBlock | GosubCall | Definition | ExecExpression
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
    if (!r) r = CommentBlock(b, l + 1);
    if (!r) r = GosubCall(b, l + 1);
    if (!r) r = Definition(b, l + 1);
    if (!r) r = ExecExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // GOSUB SubroutineReference
  public static boolean GosubCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GosubCall")) return false;
    if (!nextTokenIs(b, GOSUB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOSUB);
    r = r && SubroutineReference(b, l + 1);
    exit_section_(b, m, GOSUB_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // IF ConditionalStatement Expression* (ELSE Expression*)? END_IF
  public static boolean IfExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && ConditionalStatement(b, l + 1);
    r = r && IfExpression_2(b, l + 1);
    r = r && IfExpression_3(b, l + 1);
    r = r && consumeToken(b, END_IF);
    exit_section_(b, m, IF_EXPRESSION, r);
    return r;
  }

  // Expression*
  private static boolean IfExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfExpression_2", c)) break;
    }
    return true;
  }

  // (ELSE Expression*)?
  private static boolean IfExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression_3")) return false;
    IfExpression_3_0(b, l + 1);
    return true;
  }

  // ELSE Expression*
  private static boolean IfExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && IfExpression_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression*
  private static boolean IfExpression_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfExpression_3_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OP_PLUS_PLUS VariableReference | VariableReference OP_PLUS_PLUS
  public static boolean MathAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAssignment")) return false;
    if (!nextTokenIs(b, "<math assignment>", IDENTIFIER, OP_PLUS_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_ASSIGNMENT, "<math assignment>");
    r = MathAssignment_0(b, l + 1);
    if (!r) r = MathAssignment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_PLUS_PLUS VariableReference
  private static boolean MathAssignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAssignment_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PLUS_PLUS);
    r = r && VariableReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VariableReference OP_PLUS_PLUS
  private static boolean MathAssignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAssignment_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableReference(b, l + 1);
    r = r && consumeToken(b, OP_PLUS_PLUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' (NUMBER | IDENTIFIER) MathOperator (NUMBER | IDENTIFIER) ')'
  public static boolean MathOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOperation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_OPERATION, "<math operation>");
    r = consumeToken(b, "(");
    r = r && MathOperation_1(b, l + 1);
    r = r && MathOperator(b, l + 1);
    r = r && MathOperation_3(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NUMBER | IDENTIFIER
  private static boolean MathOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOperation_1")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  // NUMBER | IDENTIFIER
  private static boolean MathOperation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOperation_3")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // OP_PLUS | OP_MINUS | OP_TIMES | OP_DIVISION
  public static boolean MathOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_OPERATOR, "<math operator>");
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    if (!r) r = consumeToken(b, OP_TIMES);
    if (!r) r = consumeToken(b, OP_DIVISION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // METHOD Params END?
  public static boolean MethodCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall")) return false;
    if (!nextTokenIs(b, METHOD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METHOD);
    r = r && Params(b, l + 1);
    r = r && MethodCall_2(b, l + 1);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  // END?
  private static boolean MethodCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall_2")) return false;
    consumeToken(b, END);
    return true;
  }

  /* ********************************************************** */
  // 'MISSION_START' MissionBody? 'MISSION_END'
  public static boolean MissionBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MissionBlock")) return false;
    if (!nextTokenIs(b, MISSION_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MISSION_START);
    r = r && MissionBlock_1(b, l + 1);
    r = r && consumeToken(b, MISSION_END);
    exit_section_(b, m, MISSION_BLOCK, r);
    return r;
  }

  // MissionBody?
  private static boolean MissionBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MissionBlock_1")) return false;
    MissionBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression*
  public static boolean MissionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MissionBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, MISSION_BODY, "<mission body>");
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MissionBody", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // NUMBER | VariableReference | SUBROUTINE | Boolean
  public static boolean Param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM, "<param>");
    r = consumeToken(b, NUMBER);
    if (!r) r = VariableReference(b, l + 1);
    if (!r) r = consumeToken(b, SUBROUTINE);
    if (!r) r = Boolean(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (Param ','?)* ','?
  public static boolean Params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMS, "<params>");
    r = Params_0(b, l + 1);
    r = r && Params_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Param ','?)*
  private static boolean Params_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Params_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Params_0", c)) break;
    }
    return true;
  }

  // Param ','?
  private static boolean Params_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Param(b, l + 1);
    r = r && Params_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean Params_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_0_0_1")) return false;
    consumeToken(b, ",");
    return true;
  }

  // ','?
  private static boolean Params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Params_1")) return false;
    consumeToken(b, ",");
    return true;
  }

  /* ********************************************************** */
  // MissionBlock? DefinitionBlock?
  static boolean ScriptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ScriptFile_0(b, l + 1);
    r = r && ScriptFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MissionBlock?
  private static boolean ScriptFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile_0")) return false;
    MissionBlock(b, l + 1);
    return true;
  }

  // DefinitionBlock?
  private static boolean ScriptFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile_1")) return false;
    DefinitionBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SET VariableReference EQUALS (Param | MathOperation)
  public static boolean SetExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetExpression")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET);
    r = r && VariableReference(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && SetExpression_3(b, l + 1);
    exit_section_(b, m, SET_EXPRESSION, r);
    return r;
  }

  // Param | MathOperation
  private static boolean SetExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetExpression_3")) return false;
    boolean r;
    r = Param(b, l + 1);
    if (!r) r = MathOperation(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ':' Expression* RETURN
  public static boolean SubroutineDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ":");
    r = r && SubroutineDefinition_2(b, l + 1);
    r = r && consumeToken(b, RETURN);
    exit_section_(b, m, SUBROUTINE_DEFINITION, r);
    return r;
  }

  // Expression*
  private static boolean SubroutineDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineDefinition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SubroutineDefinition_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean SubroutineReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, SUBROUTINE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // VAR_INT | VAR_FLOAT
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    if (!nextTokenIs(b, "<type>", VAR_FLOAT, VAR_INT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, VAR_INT);
    if (!r) r = consumeToken(b, VAR_FLOAT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VariableReference EQUALS Param
  public static boolean VariableAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableReference(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && Param(b, l + 1);
    exit_section_(b, m, VARIABLE_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Type VariableIdentifierList
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    if (!nextTokenIs(b, "<variable definition>", VAR_FLOAT, VAR_INT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = Type(b, l + 1);
    r = r && VariableIdentifierList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER ','?)*
  public static boolean VariableIdentifierList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableIdentifierList")) return false;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_IDENTIFIER_LIST, "<variable identifier list>");
    while (true) {
      int c = current_position_(b);
      if (!VariableIdentifierList_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VariableIdentifierList", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // IDENTIFIER ','?
  private static boolean VariableIdentifierList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableIdentifierList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && VariableIdentifierList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean VariableIdentifierList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableIdentifierList_0_1")) return false;
    consumeToken(b, ",");
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean VariableReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE ConditionalStatement Expression* END_WHILE
  public static boolean WhileExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpression")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && ConditionalStatement(b, l + 1);
    r = r && WhileExpression_2(b, l + 1);
    r = r && consumeToken(b, END_WHILE);
    exit_section_(b, m, WHILE_EXPRESSION, r);
    return r;
  }

  // Expression*
  private static boolean WhileExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "WhileExpression_2", c)) break;
    }
    return true;
  }

}
