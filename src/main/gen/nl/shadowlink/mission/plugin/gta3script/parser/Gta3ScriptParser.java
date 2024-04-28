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
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // TRUE | FALSE | ON | OFF
  public static boolean Boolean(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Boolean")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, OFF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Param ComparisonOperator Param
  public static boolean Comparison(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comparison")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON, "<comparison>");
    r = Param(b, l + 1);
    r = r && ComparisonOperator(b, l + 1);
    r = r && Param(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_LESS_THAN | OP_GREATER_THAN | OP_GREATER_THAN_OR_EQUAL | OP_LESS_THAN_OR_EQUAL | EQUALS
  public static boolean ComparisonOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_OPERATOR, "<comparison operator>");
    r = consumeToken(b, OP_LESS_THAN);
    if (!r) r = consumeToken(b, OP_GREATER_THAN);
    if (!r) r = consumeToken(b, OP_GREATER_THAN_OR_EQUAL);
    if (!r) r = consumeToken(b, OP_LESS_THAN_OR_EQUAL);
    if (!r) r = consumeToken(b, EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT? (method_call | Comparison)
  public static boolean ConditionalStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_STATEMENT, "<conditional statement>");
    r = ConditionalStatement_0(b, l + 1);
    r = r && ConditionalStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NOT?
  private static boolean ConditionalStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_0")) return false;
    consumeToken(b, NOT);
    return true;
  }

  // method_call | Comparison
  private static boolean ConditionalStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_1")) return false;
    boolean r;
    r = method_call(b, l + 1);
    if (!r) r = Comparison(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SubroutineDefinition | VariableDefinition | VariableAssignment | MethodCall | LocalScope | IfExpression | WhileExpression | MathOperation | SubroutineCall
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = SubroutineDefinition(b, l + 1);
    if (!r) r = VariableDefinition(b, l + 1);
    if (!r) r = VariableAssignment(b, l + 1);
    if (!r) r = consumeToken(b, METHODCALL);
    if (!r) r = LocalScope(b, l + 1);
    if (!r) r = IfExpression(b, l + 1);
    if (!r) r = WhileExpression(b, l + 1);
    if (!r) r = MathOperation(b, l + 1);
    if (!r) r = SubroutineCall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' IDENTIFIER ')'
  public static boolean GxtReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GxtReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GXT_REFERENCE, "<gxt reference>");
    r = consumeToken(b, "(");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
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
  // '{' Expression* '}'
  public static boolean LocalScope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalScope")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOCAL_SCOPE, "<local scope>");
    r = consumeToken(b, "{");
    r = r && LocalScope_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Expression*
  private static boolean LocalScope_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalScope_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LocalScope_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VariableReference MathOperator EQUALS Param
  public static boolean MathOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOperation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableReference(b, l + 1);
    r = r && consumeTokens(b, 0, MATHOPERATOR, EQUALS);
    r = r && Param(b, l + 1);
    exit_section_(b, m, MATH_OPERATION, r);
    return r;
  }

  /* ********************************************************** */
  // Param
  public static boolean MethodParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParam")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_PARAM, "<method param>");
    r = Param(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Param MethodParamDefinition? | '(' Param* ')' MethodParamDefinition?
  public static boolean MethodParamDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_PARAM_DEFINITION, "<method param definition>");
    r = MethodParamDefinition_0(b, l + 1);
    if (!r) r = MethodParamDefinition_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Param MethodParamDefinition?
  private static boolean MethodParamDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Param(b, l + 1);
    r = r && MethodParamDefinition_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MethodParamDefinition?
  private static boolean MethodParamDefinition_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamDefinition_0_1")) return false;
    MethodParamDefinition(b, l + 1);
    return true;
  }

  // '(' Param* ')' MethodParamDefinition?
  private static boolean MethodParamDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamDefinition_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && MethodParamDefinition_1_1(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && MethodParamDefinition_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Param*
  private static boolean MethodParamDefinition_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamDefinition_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Param(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MethodParamDefinition_1_1", c)) break;
    }
    return true;
  }

  // MethodParamDefinition?
  private static boolean MethodParamDefinition_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamDefinition_1_3")) return false;
    MethodParamDefinition(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MethodParamDefinition?
  public static boolean MethodParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamList")) return false;
    Marker m = enter_section_(b, l, _NONE_, METHOD_PARAM_LIST, "<method param list>");
    MethodParamDefinition(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // MISSION_START Expression* MISSION_END
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

  // Expression*
  private static boolean MissionBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MissionBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MissionBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NUMBER | VariableReference | SUBROUTINE | Boolean | GxtReference
  public static boolean Param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM, "<param>");
    r = consumeToken(b, NUMBER);
    if (!r) r = VariableReference(b, l + 1);
    if (!r) r = consumeToken(b, SUBROUTINE);
    if (!r) r = Boolean(b, l + 1);
    if (!r) r = GxtReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression* MissionBlock? Expression*
  public static boolean ScriptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_FILE, "<script file>");
    r = ScriptFile_0(b, l + 1);
    r = r && ScriptFile_1(b, l + 1);
    r = r && ScriptFile_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Expression*
  private static boolean ScriptFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ScriptFile_0", c)) break;
    }
    return true;
  }

  // MissionBlock?
  private static boolean ScriptFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile_1")) return false;
    MissionBlock(b, l + 1);
    return true;
  }

  // Expression*
  private static boolean ScriptFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ScriptFile_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // GOSUB SubroutineReference
  public static boolean SubroutineCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineCall")) return false;
    if (!nextTokenIs(b, GOSUB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOSUB);
    r = r && SubroutineReference(b, l + 1);
    exit_section_(b, m, SUBROUTINE_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // SubroutineLabel ':' Expression* RETURN
  public static boolean SubroutineDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SubroutineLabel(b, l + 1);
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
  public static boolean SubroutineLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubroutineLabel")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, SUBROUTINE_LABEL, r);
    return r;
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
  // IDENTIFIER
  public static boolean VariableIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // VariableIdentifier VariableIdentifierList | VariableIdentifier ',' VariableIdentifierList | VariableIdentifier
  public static boolean VariableIdentifierList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableIdentifierList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableIdentifierList_0(b, l + 1);
    if (!r) r = VariableIdentifierList_1(b, l + 1);
    if (!r) r = VariableIdentifier(b, l + 1);
    exit_section_(b, m, VARIABLE_IDENTIFIER_LIST, r);
    return r;
  }

  // VariableIdentifier VariableIdentifierList
  private static boolean VariableIdentifierList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableIdentifierList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableIdentifier(b, l + 1);
    r = r && VariableIdentifierList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VariableIdentifier ',' VariableIdentifierList
  private static boolean VariableIdentifierList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableIdentifierList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableIdentifier(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && VariableIdentifierList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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

  /* ********************************************************** */
  // AND condition
  public static boolean and_condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_condition")) return false;
    if (!nextTokenIs(b, AND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && condition(b, l + 1);
    exit_section_(b, m, AND_CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUALS '#' IDENTIFIER line_break
  public static boolean cast_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cast_assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && consumeToken(b, "#");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, CAST_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Param ComparisonOperator Param line_break
  public static boolean comparison(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON, "<comparison>");
    r = Param(b, l + 1);
    r = r && ComparisonOperator(b, l + 1);
    r = r && Param(b, l + 1);
    r = r && line_break(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT? (method_call | comparison)
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = condition_0(b, l + 1);
    r = r && condition_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NOT?
  private static boolean condition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_0")) return false;
    consumeToken(b, NOT);
    return true;
  }

  // method_call | comparison
  private static boolean condition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_1")) return false;
    boolean r;
    r = method_call(b, l + 1);
    if (!r) r = comparison(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // expression*
  public static boolean condition_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, CONDITION_BODY, "<condition body>");
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "condition_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // condition (and_condition | or_condition)*
  public static boolean condition_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION_LIST, "<condition list>");
    r = condition(b, l + 1);
    r = r && condition_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (and_condition | or_condition)*
  private static boolean condition_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!condition_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "condition_list_1", c)) break;
    }
    return true;
  }

  // and_condition | or_condition
  private static boolean condition_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_list_1_0")) return false;
    boolean r;
    r = and_condition(b, l + 1);
    if (!r) r = or_condition(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // line_break | variable_definition | variable_assignment | label_identifier | subroutine_call | method_call | mission_block | if_expression | while_expression | math_operation | label_return | cast_assignment | local_scope | MISSION_END
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = line_break(b, l + 1);
    if (!r) r = variable_definition(b, l + 1);
    if (!r) r = variable_assignment(b, l + 1);
    if (!r) r = label_identifier(b, l + 1);
    if (!r) r = subroutine_call(b, l + 1);
    if (!r) r = method_call(b, l + 1);
    if (!r) r = mission_block(b, l + 1);
    if (!r) r = if_expression(b, l + 1);
    if (!r) r = while_expression(b, l + 1);
    if (!r) r = math_operation(b, l + 1);
    if (!r) r = label_return(b, l + 1);
    if (!r) r = cast_assignment(b, l + 1);
    if (!r) r = local_scope(b, l + 1);
    if (!r) r = consumeToken(b, MISSION_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF condition_list condition_body (ELSE condition_body)? END_IF line_break
  public static boolean if_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expression")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && condition_list(b, l + 1);
    r = r && condition_body(b, l + 1);
    r = r && if_expression_3(b, l + 1);
    r = r && consumeToken(b, END_IF);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, IF_EXPRESSION, r);
    return r;
  }

  // (ELSE condition_body)?
  private static boolean if_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expression_3")) return false;
    if_expression_3_0(b, l + 1);
    return true;
  }

  // ELSE condition_body
  private static boolean if_expression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && condition_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (OP_PLUS_PLUS | OP_MINUS_MINUS) line_break
  public static boolean increment_post_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "increment_post_operation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && increment_post_operation_1(b, l + 1);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, INCREMENT_POST_OPERATION, r);
    return r;
  }

  // OP_PLUS_PLUS | OP_MINUS_MINUS
  private static boolean increment_post_operation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "increment_post_operation_1")) return false;
    boolean r;
    r = consumeToken(b, OP_PLUS_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS_MINUS);
    return r;
  }

  /* ********************************************************** */
  // (OP_PLUS_PLUS | OP_MINUS_MINUS) IDENTIFIER line_break
  public static boolean increment_pre_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "increment_pre_operation")) return false;
    if (!nextTokenIs(b, "<increment pre operation>", OP_MINUS_MINUS, OP_PLUS_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCREMENT_PRE_OPERATION, "<increment pre operation>");
    r = increment_pre_operation_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && line_break(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_PLUS_PLUS | OP_MINUS_MINUS
  private static boolean increment_pre_operation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "increment_pre_operation_0")) return false;
    boolean r;
    r = consumeToken(b, OP_PLUS_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS_MINUS);
    return r;
  }

  /* ********************************************************** */
  // GOSUB_IDENTIFIER line_break
  public static boolean label_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label_identifier")) return false;
    if (!nextTokenIs(b, GOSUB_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOSUB_IDENTIFIER);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, LABEL_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN
  public static boolean label_return(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label_return")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    exit_section_(b, m, LABEL_RETURN, r);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE
  public static boolean line_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_break")) return false;
    if (!nextTokenIs(b, NEW_LINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW_LINE);
    exit_section_(b, m, LINE_BREAK, r);
    return r;
  }

  /* ********************************************************** */
  // '{' expression* '}'
  public static boolean local_scope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_scope")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOCAL_SCOPE, "<local scope>");
    r = consumeToken(b, "{");
    r = r && local_scope_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression*
  private static boolean local_scope_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_scope_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "local_scope_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // increment_pre_operation | increment_post_operation | math_operation_assignment | math_operation_self_assignment
  public static boolean math_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_operation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_OPERATION, "<math operation>");
    r = increment_pre_operation(b, l + 1);
    if (!r) r = increment_post_operation(b, l + 1);
    if (!r) r = math_operation_assignment(b, l + 1);
    if (!r) r = math_operation_self_assignment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUALS (IDENTIFIER | NUMBER) math_operator (IDENTIFIER | NUMBER)
  public static boolean math_operation_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_operation_assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && math_operation_assignment_2(b, l + 1);
    r = r && math_operator(b, l + 1);
    r = r && math_operation_assignment_4(b, l + 1);
    exit_section_(b, m, MATH_OPERATION_ASSIGNMENT, r);
    return r;
  }

  // IDENTIFIER | NUMBER
  private static boolean math_operation_assignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_operation_assignment_2")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  // IDENTIFIER | NUMBER
  private static boolean math_operation_assignment_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_operation_assignment_4")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER math_operator EQUALS (IDENTIFIER | NUMBER)
  public static boolean math_operation_self_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_operation_self_assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && math_operator(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && math_operation_self_assignment_3(b, l + 1);
    exit_section_(b, m, MATH_OPERATION_SELF_ASSIGNMENT, r);
    return r;
  }

  // IDENTIFIER | NUMBER
  private static boolean math_operation_self_assignment_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_operation_self_assignment_3")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // OP_PLUS | OP_MINUS | OP_TIMES | OP_DIVISION
  public static boolean math_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_operator")) return false;
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
  // method_name MethodParamList line_break
  public static boolean method_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_name(b, l + 1);
    r = r && MethodParamList(b, l + 1);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean method_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, METHOD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // MISSION_START expression*
  public static boolean mission_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mission_block")) return false;
    if (!nextTokenIs(b, MISSION_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MISSION_START);
    r = r && mission_block_1(b, l + 1);
    exit_section_(b, m, MISSION_BLOCK, r);
    return r;
  }

  // expression*
  private static boolean mission_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mission_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mission_block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OR condition
  public static boolean or_condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_condition")) return false;
    if (!nextTokenIs(b, OR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && condition(b, l + 1);
    exit_section_(b, m, OR_CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // expression*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // GOSUB subroutine_reference line_break
  public static boolean subroutine_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subroutine_call")) return false;
    if (!nextTokenIs(b, GOSUB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOSUB);
    r = r && subroutine_reference(b, l + 1);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, SUBROUTINE_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean subroutine_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subroutine_reference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, SUBROUTINE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // variable '=' (IDENTIFIER | NUMBER | Boolean) line_break
  public static boolean variable_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && variable_assignment_2(b, l + 1);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, VARIABLE_ASSIGNMENT, r);
    return r;
  }

  // IDENTIFIER | NUMBER | Boolean
  private static boolean variable_assignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment_2")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = Boolean(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // Type variable (','? variable)* line_break
  public static boolean variable_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition")) return false;
    if (!nextTokenIs(b, "<variable definition>", VAR_FLOAT, VAR_INT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = Type(b, l + 1);
    r = r && variable(b, l + 1);
    r = r && variable_definition_2(b, l + 1);
    r = r && line_break(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (','? variable)*
  private static boolean variable_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variable_definition_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_definition_2", c)) break;
    }
    return true;
  }

  // ','? variable
  private static boolean variable_definition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_definition_2_0_0(b, l + 1);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean variable_definition_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_2_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  /* ********************************************************** */
  // WHILE condition_list condition_body END_WHILE line_break
  public static boolean while_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_expression")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && condition_list(b, l + 1);
    r = r && condition_body(b, l + 1);
    r = r && consumeToken(b, END_WHILE);
    r = r && line_break(b, l + 1);
    exit_section_(b, m, WHILE_EXPRESSION, r);
    return r;
  }

}
