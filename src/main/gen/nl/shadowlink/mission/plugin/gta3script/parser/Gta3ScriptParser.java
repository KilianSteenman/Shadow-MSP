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
  // '<' | '>' | '>=' | '<=' | '='
  public static boolean ComparisonOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_OPERATOR, "<comparison operator>");
    r = consumeToken(b, OP_LESS_THAN);
    if (!r) r = consumeToken(b, OP_GREATER_THAN);
    if (!r) r = consumeToken(b, ">=");
    if (!r) r = consumeToken(b, "<=");
    if (!r) r = consumeToken(b, EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT? (MethodCall | Comparison)
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

  // MethodCall | Comparison
  private static boolean ConditionalStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement_1")) return false;
    boolean r;
    r = MethodCall(b, l + 1);
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
    if (!r) r = MethodCall(b, l + 1);
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
    r = r && MathOperator(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && Param(b, l + 1);
    exit_section_(b, m, MATH_OPERATION, r);
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
  // IDENTIFIER MethodParamList | IDENTIFIER
  public static boolean MethodCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MethodCall_0(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  // IDENTIFIER MethodParamList
  private static boolean MethodCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && MethodParamList(b, l + 1);
    exit_section_(b, m, null, r);
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
  // MethodParam MethodParamList | MethodParam
  public static boolean MethodParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_PARAM_LIST, "<method param list>");
    r = MethodParamList_0(b, l + 1);
    if (!r) r = MethodParam(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MethodParam MethodParamList
  private static boolean MethodParamList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodParamList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MethodParam(b, l + 1);
    r = r && MethodParamList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  static boolean ScriptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ScriptFile_0(b, l + 1);
    r = r && ScriptFile_1(b, l + 1);
    r = r && ScriptFile_2(b, l + 1);
    exit_section_(b, m, null, r);
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

}
