// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.shadowlink.mission.plugin.gta3script.psi.impl.*;

public interface Gta3ScriptTypes {

  IElementType AND_STATEMENT = new Gta3ScriptElementType("AND_STATEMENT");
  IElementType BOOLEAN = new Gta3ScriptElementType("BOOLEAN");
  IElementType COMMENT_BLOCK = new Gta3ScriptElementType("COMMENT_BLOCK");
  IElementType CONDITIONAL_STATEMENT = new Gta3ScriptElementType("CONDITIONAL_STATEMENT");
  IElementType DEFINITION = new Gta3ScriptElementType("DEFINITION");
  IElementType DEFINITION_BLOCK = new Gta3ScriptElementType("DEFINITION_BLOCK");
  IElementType ENUM = new Gta3ScriptElementType("ENUM");
  IElementType EXEC_EXPRESSION = new Gta3ScriptElementType("EXEC_EXPRESSION");
  IElementType EXPRESSION = new Gta3ScriptElementType("EXPRESSION");
  IElementType GOSUB_CALL = new Gta3ScriptElementType("GOSUB_CALL");
  IElementType IF_EXPRESSION = new Gta3ScriptElementType("IF_EXPRESSION");
  IElementType MATH_ASSIGNMENT = new Gta3ScriptElementType("MATH_ASSIGNMENT");
  IElementType MATH_OPERATION = new Gta3ScriptElementType("MATH_OPERATION");
  IElementType MATH_OPERATOR = new Gta3ScriptElementType("MATH_OPERATOR");
  IElementType METHOD_CALL = new Gta3ScriptElementType("METHOD_CALL");
  IElementType MISSION_BLOCK = new Gta3ScriptElementType("MISSION_BLOCK");
  IElementType MISSION_BODY = new Gta3ScriptElementType("MISSION_BODY");
  IElementType PARAM = new Gta3ScriptElementType("PARAM");
  IElementType PARAMS = new Gta3ScriptElementType("PARAMS");
  IElementType PREPROCESS_BLOCK = new Gta3ScriptElementType("PREPROCESS_BLOCK");
  IElementType PREPROCESS_TYPE = new Gta3ScriptElementType("PREPROCESS_TYPE");
  IElementType SET_EXPRESSION = new Gta3ScriptElementType("SET_EXPRESSION");
  IElementType SUBROUTINE_DEFINITION = new Gta3ScriptElementType("SUBROUTINE_DEFINITION");
  IElementType SUBROUTINE_REFERENCE = new Gta3ScriptElementType("SUBROUTINE_REFERENCE");
  IElementType TYPE = new Gta3ScriptElementType("TYPE");
  IElementType VARIABLE_ASSIGNMENT = new Gta3ScriptElementType("VARIABLE_ASSIGNMENT");
  IElementType VARIABLE_DEFINITION = new Gta3ScriptElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_IDENTIFIER_LIST = new Gta3ScriptElementType("VARIABLE_IDENTIFIER_LIST");
  IElementType VARIABLE_REFERENCE = new Gta3ScriptElementType("VARIABLE_REFERENCE");
  IElementType VECTOR = new Gta3ScriptElementType("VECTOR");
  IElementType VECTOR_3 = new Gta3ScriptElementType("VECTOR_3");
  IElementType WHILE_EXPRESSION = new Gta3ScriptElementType("WHILE_EXPRESSION");

  IElementType AND = new Gta3ScriptTokenType("AND");
  IElementType AREA_PLAYER_ONLY = new Gta3ScriptTokenType("AREA_PLAYER_ONLY");
  IElementType COMMENT = new Gta3ScriptTokenType("COMMENT");
  IElementType COMMENTBLOCK = new Gta3ScriptTokenType("COMMENTBLOCK");
  IElementType CRIMINAL_TYPE2 = new Gta3ScriptTokenType("CRIMINAL_TYPE2");
  IElementType DEF_PC = new Gta3ScriptTokenType("PC");
  IElementType DEF_PSX = new Gta3ScriptTokenType("PSX");
  IElementType DO_NOWT = new Gta3ScriptTokenType("DO_NOWT");
  IElementType ELSE = new Gta3ScriptTokenType("ELSE");
  IElementType END = new Gta3ScriptTokenType("END");
  IElementType END_EXEC = new Gta3ScriptTokenType("ENDEXEC");
  IElementType END_IF = new Gta3ScriptTokenType("ENDIF");
  IElementType END_WHILE = new Gta3ScriptTokenType("ENDWHILE");
  IElementType END_WHILE_EXEC = new Gta3ScriptTokenType("END_WHILE_EXEC");
  IElementType EQUALS = new Gta3ScriptTokenType("=");
  IElementType EXEC = new Gta3ScriptTokenType("EXEC");
  IElementType GOSUB = new Gta3ScriptTokenType("GOSUB");
  IElementType IDENTIFIER = new Gta3ScriptTokenType("IDENTIFIER");
  IElementType IF = new Gta3ScriptTokenType("IF");
  IElementType KILL_CHAR_ON_FOOT = new Gta3ScriptTokenType("KILL_CHAR_ON_FOOT");
  IElementType LEVEL_END = new Gta3ScriptTokenType("LEVELEND");
  IElementType LEVEL_START = new Gta3ScriptTokenType("LEVELSTART");
  IElementType MACHINE_GUN = new Gta3ScriptTokenType("MACHINE_GUN");
  IElementType METHOD = new Gta3ScriptTokenType("METHOD");
  IElementType MISSION_END = new Gta3ScriptTokenType("MISSIONEND");
  IElementType MISSION_START = new Gta3ScriptTokenType("MISSIONSTART");
  IElementType NOT = new Gta3ScriptTokenType("NOT");
  IElementType NUMBER = new Gta3ScriptTokenType("number");
  IElementType OFF = new Gta3ScriptTokenType("OFF");
  IElementType ON = new Gta3ScriptTokenType("ON");
  IElementType OP_DIVISION = new Gta3ScriptTokenType("/");
  IElementType OP_GREATER_THAN = new Gta3ScriptTokenType(">");
  IElementType OP_LESS_THAN = new Gta3ScriptTokenType("<");
  IElementType OP_MINUS = new Gta3ScriptTokenType("-");
  IElementType OP_MINUS_MINUS = new Gta3ScriptTokenType("--");
  IElementType OP_PLUS = new Gta3ScriptTokenType("+");
  IElementType OP_PLUS_PLUS = new Gta3ScriptTokenType("++");
  IElementType OP_TIMES = new Gta3ScriptTokenType("*");
  IElementType PREPROCESS_ENDIF = new Gta3ScriptTokenType("#endif");
  IElementType PREPROCESS_IFDEF = new Gta3ScriptTokenType("#ifdef");
  IElementType REACT_AS_NORMAL = new Gta3ScriptTokenType("REACT_AS_NORMAL");
  IElementType RETURN = new Gta3ScriptTokenType("RETURN");
  IElementType SET = new Gta3ScriptTokenType("SET");
  IElementType SUBROUTINE = new Gta3ScriptTokenType("SUBROUTINE");
  IElementType VAR_FLOAT = new Gta3ScriptTokenType("VAR_FLOAT");
  IElementType VAR_INT = new Gta3ScriptTokenType("VAR_INT");
  IElementType WHILE = new Gta3ScriptTokenType("WHILE");
  IElementType WHILE_EXEC = new Gta3ScriptTokenType("WHILE_EXEC");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_STATEMENT) {
        return new Gta3ScriptAndStatementImpl(node);
      }
      else if (type == BOOLEAN) {
        return new Gta3ScriptBooleanImpl(node);
      }
      else if (type == COMMENT_BLOCK) {
        return new Gta3ScriptCommentBlockImpl(node);
      }
      else if (type == CONDITIONAL_STATEMENT) {
        return new Gta3ScriptConditionalStatementImpl(node);
      }
      else if (type == DEFINITION) {
        return new Gta3ScriptDefinitionImpl(node);
      }
      else if (type == DEFINITION_BLOCK) {
        return new Gta3ScriptDefinitionBlockImpl(node);
      }
      else if (type == ENUM) {
        return new Gta3ScriptEnumImpl(node);
      }
      else if (type == EXEC_EXPRESSION) {
        return new Gta3ScriptExecExpressionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new Gta3ScriptExpressionImpl(node);
      }
      else if (type == GOSUB_CALL) {
        return new Gta3ScriptGosubCallImpl(node);
      }
      else if (type == IF_EXPRESSION) {
        return new Gta3ScriptIfExpressionImpl(node);
      }
      else if (type == MATH_ASSIGNMENT) {
        return new Gta3ScriptMathAssignmentImpl(node);
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
      else if (type == MISSION_BLOCK) {
        return new Gta3ScriptMissionBlockImpl(node);
      }
      else if (type == MISSION_BODY) {
        return new Gta3ScriptMissionBodyImpl(node);
      }
      else if (type == PARAM) {
        return new Gta3ScriptParamImpl(node);
      }
      else if (type == PARAMS) {
        return new Gta3ScriptParamsImpl(node);
      }
      else if (type == PREPROCESS_BLOCK) {
        return new Gta3ScriptPreprocessBlockImpl(node);
      }
      else if (type == PREPROCESS_TYPE) {
        return new Gta3ScriptPreprocessTypeImpl(node);
      }
      else if (type == SET_EXPRESSION) {
        return new Gta3ScriptSetExpressionImpl(node);
      }
      else if (type == SUBROUTINE_DEFINITION) {
        return new Gta3ScriptSubroutineDefinitionImpl(node);
      }
      else if (type == SUBROUTINE_REFERENCE) {
        return new Gta3ScriptSubroutineReferenceImpl(node);
      }
      else if (type == TYPE) {
        return new Gta3ScriptTypeImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT) {
        return new Gta3ScriptVariableAssignmentImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new Gta3ScriptVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_IDENTIFIER_LIST) {
        return new Gta3ScriptVariableIdentifierListImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new Gta3ScriptVariableReferenceImpl(node);
      }
      else if (type == VECTOR) {
        return new Gta3ScriptVectorImpl(node);
      }
      else if (type == VECTOR_3) {
        return new Gta3ScriptVector3Impl(node);
      }
      else if (type == WHILE_EXPRESSION) {
        return new Gta3ScriptWhileExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
