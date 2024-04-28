// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.shadowlink.mission.plugin.gta3script.psi.impl.*;

public interface Gta3ScriptTypes {

  IElementType AND_CONDITION = new Gta3ScriptElementType("AND_CONDITION");
  IElementType BOOLEAN = new Gta3ScriptElementType("BOOLEAN");
  IElementType COMPARISON = new Gta3ScriptElementType("COMPARISON");
  IElementType COMPARISON_OPERATOR = new Gta3ScriptElementType("COMPARISON_OPERATOR");
  IElementType CONDITION = new Gta3ScriptElementType("CONDITION");
  IElementType CONDITIONAL_STATEMENT = new Gta3ScriptElementType("CONDITIONAL_STATEMENT");
  IElementType CONDITION_BODY = new Gta3ScriptElementType("CONDITION_BODY");
  IElementType CONDITION_LIST = new Gta3ScriptElementType("CONDITION_LIST");
  IElementType EXPRESSION = new Gta3ScriptElementType("EXPRESSION");
  IElementType GXT_REFERENCE = new Gta3ScriptElementType("GXT_REFERENCE");
  IElementType IF_EXPRESSION = new Gta3ScriptElementType("IF_EXPRESSION");
  IElementType LINE_BREAK = new Gta3ScriptElementType("LINE_BREAK");
  IElementType LOCAL_SCOPE = new Gta3ScriptElementType("LOCAL_SCOPE");
  IElementType MATH_OPERATION = new Gta3ScriptElementType("MATH_OPERATION");
  IElementType MATH_OPERATOR = new Gta3ScriptElementType("MATH_OPERATOR");
  IElementType METHOD_CALL = new Gta3ScriptElementType("METHOD_CALL");
  IElementType METHOD_NAME = new Gta3ScriptElementType("METHOD_NAME");
  IElementType METHOD_PARAM = new Gta3ScriptElementType("METHOD_PARAM");
  IElementType METHOD_PARAM_LIST = new Gta3ScriptElementType("METHOD_PARAM_LIST");
  IElementType MISSION_BLOCK = new Gta3ScriptElementType("MISSION_BLOCK");
  IElementType PARAM = new Gta3ScriptElementType("PARAM");
  IElementType SCRIPT_FILE = new Gta3ScriptElementType("SCRIPT_FILE");
  IElementType SUBROUTINE_BODY = new Gta3ScriptElementType("SUBROUTINE_BODY");
  IElementType SUBROUTINE_CALL = new Gta3ScriptElementType("SUBROUTINE_CALL");
  IElementType SUBROUTINE_DEFINITION = new Gta3ScriptElementType("SUBROUTINE_DEFINITION");
  IElementType SUBROUTINE_LABEL = new Gta3ScriptElementType("SUBROUTINE_LABEL");
  IElementType SUBROUTINE_REFERENCE = new Gta3ScriptElementType("SUBROUTINE_REFERENCE");
  IElementType SUBROUTINE_RETURN = new Gta3ScriptElementType("SUBROUTINE_RETURN");
  IElementType TYPE = new Gta3ScriptElementType("TYPE");
  IElementType VARIABLE = new Gta3ScriptElementType("VARIABLE");
  IElementType VARIABLE_ASSIGNMENT = new Gta3ScriptElementType("VARIABLE_ASSIGNMENT");
  IElementType VARIABLE_DEFINITION = new Gta3ScriptElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_IDENTIFIER = new Gta3ScriptElementType("VARIABLE_IDENTIFIER");
  IElementType VARIABLE_IDENTIFIER_LIST = new Gta3ScriptElementType("VARIABLE_IDENTIFIER_LIST");
  IElementType VARIABLE_LIST = new Gta3ScriptElementType("VARIABLE_LIST");
  IElementType VARIABLE_REFERENCE = new Gta3ScriptElementType("VARIABLE_REFERENCE");
  IElementType WHILE_EXPRESSION = new Gta3ScriptElementType("WHILE_EXPRESSION");

  IElementType AND = new Gta3ScriptTokenType("AND");
  IElementType COMMENT = new Gta3ScriptTokenType("COMMENT");
  IElementType COMMENTBLOCK = new Gta3ScriptTokenType("COMMENTBLOCK");
  IElementType ELSE = new Gta3ScriptTokenType("ELSE");
  IElementType END = new Gta3ScriptTokenType("END");
  IElementType END_IF = new Gta3ScriptTokenType("ENDIF");
  IElementType END_WHILE = new Gta3ScriptTokenType("ENDWHILE");
  IElementType EQUALS = new Gta3ScriptTokenType("=");
  IElementType FALSE = new Gta3ScriptTokenType("FALSE");
  IElementType GOSUB = new Gta3ScriptTokenType("GOSUB");
  IElementType GOSUB_IDENTIFIER = new Gta3ScriptTokenType("GOSUB_IDENTIFIER");
  IElementType IDENTIFIER = new Gta3ScriptTokenType("IDENTIFIER");
  IElementType IF = new Gta3ScriptTokenType("IF");
  IElementType LINEBREAK = new Gta3ScriptTokenType("linebreak");
  IElementType METHODCALL = new Gta3ScriptTokenType("MethodCall");
  IElementType MISSION_END = new Gta3ScriptTokenType("MISSION_END");
  IElementType MISSION_START = new Gta3ScriptTokenType("MISSION_START");
  IElementType NEW_LINE = new Gta3ScriptTokenType("NEW_LINE");
  IElementType NOT = new Gta3ScriptTokenType("NOT");
  IElementType NUMBER = new Gta3ScriptTokenType("NUMBER");
  IElementType OFF = new Gta3ScriptTokenType("OFF");
  IElementType ON = new Gta3ScriptTokenType("ON");
  IElementType OPCODE = new Gta3ScriptTokenType("OPCODE");
  IElementType OP_DIVISION = new Gta3ScriptTokenType("/");
  IElementType OP_GREATER_THAN = new Gta3ScriptTokenType(">");
  IElementType OP_LESS_THAN = new Gta3ScriptTokenType("<");
  IElementType OP_MINUS = new Gta3ScriptTokenType("-");
  IElementType OP_MINUS_MINUS = new Gta3ScriptTokenType("--");
  IElementType OP_PLUS = new Gta3ScriptTokenType("+");
  IElementType OP_PLUS_PLUS = new Gta3ScriptTokenType("++");
  IElementType OP_TIMES = new Gta3ScriptTokenType("*");
  IElementType RETURN = new Gta3ScriptTokenType("RETURN");
  IElementType SET = new Gta3ScriptTokenType("SET");
  IElementType SUBROUTINE = new Gta3ScriptTokenType("SUBROUTINE");
  IElementType TRUE = new Gta3ScriptTokenType("TRUE");
  IElementType VAR_FLOAT = new Gta3ScriptTokenType("VAR_FLOAT");
  IElementType VAR_INT = new Gta3ScriptTokenType("VAR_INT");
  IElementType WHILE = new Gta3ScriptTokenType("WHILE");
  IElementType WHITE_SPACE = new Gta3ScriptTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_CONDITION) {
        return new Gta3ScriptAndConditionImpl(node);
      }
      else if (type == BOOLEAN) {
        return new Gta3ScriptBooleanImpl(node);
      }
      else if (type == COMPARISON) {
        return new Gta3ScriptComparisonImpl(node);
      }
      else if (type == COMPARISON_OPERATOR) {
        return new Gta3ScriptComparisonOperatorImpl(node);
      }
      else if (type == CONDITION) {
        return new Gta3ScriptConditionImpl(node);
      }
      else if (type == CONDITIONAL_STATEMENT) {
        return new Gta3ScriptConditionalStatementImpl(node);
      }
      else if (type == CONDITION_BODY) {
        return new Gta3ScriptConditionBodyImpl(node);
      }
      else if (type == CONDITION_LIST) {
        return new Gta3ScriptConditionListImpl(node);
      }
      else if (type == EXPRESSION) {
        return new Gta3ScriptExpressionImpl(node);
      }
      else if (type == GXT_REFERENCE) {
        return new Gta3ScriptGxtReferenceImpl(node);
      }
      else if (type == IF_EXPRESSION) {
        return new Gta3ScriptIfExpressionImpl(node);
      }
      else if (type == LINE_BREAK) {
        return new Gta3ScriptLineBreakImpl(node);
      }
      else if (type == LOCAL_SCOPE) {
        return new Gta3ScriptLocalScopeImpl(node);
      }
      else if (type == MATH_OPERATION) {
        return new Gta3ScriptMathOperationImpl(node);
      }
      else if (type == MATH_OPERATOR) {
        return new Gta3ScriptMathOperatorImpl(node);
      }
      else if (type == METHOD_CALL) {
        return new Gta3ScriptMethodCallImpl(node);
      }
      else if (type == METHOD_NAME) {
        return new Gta3ScriptMethodNameImpl(node);
      }
      else if (type == METHOD_PARAM) {
        return new Gta3ScriptMethodParamImpl(node);
      }
      else if (type == METHOD_PARAM_LIST) {
        return new Gta3ScriptMethodParamListImpl(node);
      }
      else if (type == MISSION_BLOCK) {
        return new Gta3ScriptMissionBlockImpl(node);
      }
      else if (type == PARAM) {
        return new Gta3ScriptParamImpl(node);
      }
      else if (type == SCRIPT_FILE) {
        return new Gta3ScriptScriptFileImpl(node);
      }
      else if (type == SUBROUTINE_BODY) {
        return new Gta3ScriptSubroutineBodyImpl(node);
      }
      else if (type == SUBROUTINE_CALL) {
        return new Gta3ScriptSubroutineCallImpl(node);
      }
      else if (type == SUBROUTINE_DEFINITION) {
        return new Gta3ScriptSubroutineDefinitionImpl(node);
      }
      else if (type == SUBROUTINE_LABEL) {
        return new Gta3ScriptSubroutineLabelImpl(node);
      }
      else if (type == SUBROUTINE_REFERENCE) {
        return new Gta3ScriptSubroutineReferenceImpl(node);
      }
      else if (type == SUBROUTINE_RETURN) {
        return new Gta3ScriptSubroutineReturnImpl(node);
      }
      else if (type == TYPE) {
        return new Gta3ScriptTypeImpl(node);
      }
      else if (type == VARIABLE) {
        return new Gta3ScriptVariableImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT) {
        return new Gta3ScriptVariableAssignmentImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new Gta3ScriptVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_IDENTIFIER) {
        return new Gta3ScriptVariableIdentifierImpl(node);
      }
      else if (type == VARIABLE_IDENTIFIER_LIST) {
        return new Gta3ScriptVariableIdentifierListImpl(node);
      }
      else if (type == VARIABLE_LIST) {
        return new Gta3ScriptVariableListImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new Gta3ScriptVariableReferenceImpl(node);
      }
      else if (type == WHILE_EXPRESSION) {
        return new Gta3ScriptWhileExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
