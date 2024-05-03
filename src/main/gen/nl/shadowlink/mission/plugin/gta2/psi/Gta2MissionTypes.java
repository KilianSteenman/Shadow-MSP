// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.shadowlink.mission.plugin.gta2.psi.impl.*;

public interface Gta2MissionTypes {

  IElementType AND_STATEMENT = new Gta2MissionElementType("AND_STATEMENT");
  IElementType BOOLEAN = new Gta2MissionElementType("BOOLEAN");
  IElementType COMMENT_BLOCK = new Gta2MissionElementType("COMMENT_BLOCK");
  IElementType CONDITIONAL_STATEMENT = new Gta2MissionElementType("CONDITIONAL_STATEMENT");
  IElementType DEFINITION = new Gta2MissionElementType("DEFINITION");
  IElementType DEFINITION_BLOCK = new Gta2MissionElementType("DEFINITION_BLOCK");
  IElementType ENUM = new Gta2MissionElementType("ENUM");
  IElementType EXEC_EXPRESSION = new Gta2MissionElementType("EXEC_EXPRESSION");
  IElementType EXPRESSION = new Gta2MissionElementType("EXPRESSION");
  IElementType GOSUB_CALL = new Gta2MissionElementType("GOSUB_CALL");
  IElementType IF_EXPRESSION = new Gta2MissionElementType("IF_EXPRESSION");
  IElementType LEVEL_BLOCK = new Gta2MissionElementType("LEVEL_BLOCK");
  IElementType LEVEL_BODY = new Gta2MissionElementType("LEVEL_BODY");
  IElementType MATH_ASSIGNMENT = new Gta2MissionElementType("MATH_ASSIGNMENT");
  IElementType MATH_OPERATION = new Gta2MissionElementType("MATH_OPERATION");
  IElementType MATH_OPERATOR = new Gta2MissionElementType("MATH_OPERATOR");
  IElementType METHOD_CALL = new Gta2MissionElementType("METHOD_CALL");
  IElementType MISSION_BLOCK = new Gta2MissionElementType("MISSION_BLOCK");
  IElementType PARAM = new Gta2MissionElementType("PARAM");
  IElementType PARAMS = new Gta2MissionElementType("PARAMS");
  IElementType PREPROCESS_BLOCK = new Gta2MissionElementType("PREPROCESS_BLOCK");
  IElementType PREPROCESS_TYPE = new Gta2MissionElementType("PREPROCESS_TYPE");
  IElementType SET_EXPRESSION = new Gta2MissionElementType("SET_EXPRESSION");
  IElementType SUBROUTINE_DEFINITION = new Gta2MissionElementType("SUBROUTINE_DEFINITION");
  IElementType SUBROUTINE_REFERENCE = new Gta2MissionElementType("SUBROUTINE_REFERENCE");
  IElementType TYPE = new Gta2MissionElementType("TYPE");
  IElementType VARIABLE_ASSIGNMENT = new Gta2MissionElementType("VARIABLE_ASSIGNMENT");
  IElementType VARIABLE_DEFINITION = new Gta2MissionElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_REFERENCE = new Gta2MissionElementType("VARIABLE_REFERENCE");
  IElementType VECTOR = new Gta2MissionElementType("VECTOR");
  IElementType VECTOR_3 = new Gta2MissionElementType("VECTOR_3");
  IElementType WHILE_EXEC_EXPRESSION = new Gta2MissionElementType("WHILE_EXEC_EXPRESSION");
  IElementType WHILE_EXPRESSION = new Gta2MissionElementType("WHILE_EXPRESSION");

  IElementType AND = new Gta2MissionTokenType("AND");
  IElementType AREA_PLAYER_ONLY = new Gta2MissionTokenType("AREA_PLAYER_ONLY");
  IElementType ARROW_DATA = new Gta2MissionTokenType("ARROW_DATA");
  IElementType BONUS = new Gta2MissionTokenType("BONUS");
  IElementType CAR_DATA = new Gta2MissionTokenType("CAR_DATA");
  IElementType CHAR_DATA = new Gta2MissionTokenType("CHAR_DATA");
  IElementType COMMENT = new Gta2MissionTokenType("COMMENT");
  IElementType COMMENTBLOCK = new Gta2MissionTokenType("COMMENTBLOCK");
  IElementType CONVEYOR = new Gta2MissionTokenType("CONVEYOR");
  IElementType COUNTER = new Gta2MissionTokenType("COUNTER");
  IElementType CRANE_DATA = new Gta2MissionTokenType("CRANE_DATA");
  IElementType CRIMINAL_TYPE2 = new Gta2MissionTokenType("CRIMINAL_TYPE2");
  IElementType CRUSHER = new Gta2MissionTokenType("CRUSHER");
  IElementType DEF_PC = new Gta2MissionTokenType("PC");
  IElementType DEF_PSX = new Gta2MissionTokenType("PSX");
  IElementType DESTRUCTOR = new Gta2MissionTokenType("DESTRUCTOR");
  IElementType DO_NOWT = new Gta2MissionTokenType("DO_NOWT");
  IElementType ELSE = new Gta2MissionTokenType("ELSE");
  IElementType END = new Gta2MissionTokenType("END");
  IElementType END_EXEC = new Gta2MissionTokenType("ENDEXEC");
  IElementType END_IF = new Gta2MissionTokenType("ENDIF");
  IElementType END_WHILE = new Gta2MissionTokenType("ENDWHILE");
  IElementType END_WHILE_EXEC = new Gta2MissionTokenType("END_WHILE_EXEC");
  IElementType EQUALS = new Gta2MissionTokenType("=");
  IElementType EXEC = new Gta2MissionTokenType("EXEC");
  IElementType FORWARD = new Gta2MissionTokenType("FORWARD");
  IElementType GENERATOR = new Gta2MissionTokenType("GENERATOR");
  IElementType GOSUB = new Gta2MissionTokenType("GOSUB");
  IElementType IDENTIFIER = new Gta2MissionTokenType("IDENTIFIER");
  IElementType IF = new Gta2MissionTokenType("IF");
  IElementType KILL_CHAR_ON_FOOT = new Gta2MissionTokenType("KILL_CHAR_ON_FOOT");
  IElementType LEVEL_END = new Gta2MissionTokenType("LEVELEND");
  IElementType LEVEL_START = new Gta2MissionTokenType("LEVELSTART");
  IElementType LIGHT = new Gta2MissionTokenType("LIGHT");
  IElementType MACHINE_GUN = new Gta2MissionTokenType("MACHINE_GUN");
  IElementType MAP_ZONE = new Gta2MissionTokenType("MAP_ZONE");
  IElementType METHOD = new Gta2MissionTokenType("METHOD");
  IElementType MISSION_END = new Gta2MissionTokenType("MISSIONEND");
  IElementType MISSION_START = new Gta2MissionTokenType("MISSIONSTART");
  IElementType NOT = new Gta2MissionTokenType("NOT");
  IElementType NUMBER = new Gta2MissionTokenType("number");
  IElementType OBJ_DATA = new Gta2MissionTokenType("OBJ_DATA");
  IElementType OFF = new Gta2MissionTokenType("OFF");
  IElementType ON = new Gta2MissionTokenType("ON");
  IElementType ONSCREEN_COUNTER = new Gta2MissionTokenType("ONSCREEN_COUNTER");
  IElementType OP_DIVISION = new Gta2MissionTokenType("/");
  IElementType OP_GREATER_THAN = new Gta2MissionTokenType(">");
  IElementType OP_LESS_THAN = new Gta2MissionTokenType("<");
  IElementType OP_MINUS = new Gta2MissionTokenType("-");
  IElementType OP_MINUS_MINUS = new Gta2MissionTokenType("--");
  IElementType OP_PLUS = new Gta2MissionTokenType("+");
  IElementType OP_PLUS_PLUS = new Gta2MissionTokenType("++");
  IElementType OP_TIMES = new Gta2MissionTokenType("*");
  IElementType PLAYER_PED = new Gta2MissionTokenType("PLAYER_PED");
  IElementType PREPROCESS_ENDIF = new Gta2MissionTokenType("#endif");
  IElementType PREPROCESS_IFDEF = new Gta2MissionTokenType("#ifdef");
  IElementType REACT_AS_NORMAL = new Gta2MissionTokenType("REACT_AS_NORMAL");
  IElementType RETURN = new Gta2MissionTokenType("RETURN");
  IElementType SAVED_COUNTER = new Gta2MissionTokenType("SAVED_COUNTER");
  IElementType SET = new Gta2MissionTokenType("SET");
  IElementType SOUND = new Gta2MissionTokenType("SOUND");
  IElementType SUBROUTINE = new Gta2MissionTokenType("SUBROUTINE");
  IElementType THREAD_TRIGGER = new Gta2MissionTokenType("THREAD_TRIGGER");
  IElementType TIMER_DATA = new Gta2MissionTokenType("TIMER_DATA");
  IElementType WHILE = new Gta2MissionTokenType("WHILE");
  IElementType WHILE_EXEC = new Gta2MissionTokenType("WHILE_EXEC");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_STATEMENT) {
        return new MissionAndStatementImpl(node);
      }
      else if (type == BOOLEAN) {
        return new MissionBooleanImpl(node);
      }
      else if (type == COMMENT_BLOCK) {
        return new MissionCommentBlockImpl(node);
      }
      else if (type == CONDITIONAL_STATEMENT) {
        return new MissionConditionalStatementImpl(node);
      }
      else if (type == DEFINITION) {
        return new MissionDefinitionImpl(node);
      }
      else if (type == DEFINITION_BLOCK) {
        return new MissionDefinitionBlockImpl(node);
      }
      else if (type == ENUM) {
        return new MissionEnumImpl(node);
      }
      else if (type == EXEC_EXPRESSION) {
        return new MissionExecExpressionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new MissionExpressionImpl(node);
      }
      else if (type == GOSUB_CALL) {
        return new MissionGosubCallImpl(node);
      }
      else if (type == IF_EXPRESSION) {
        return new MissionIfExpressionImpl(node);
      }
      else if (type == LEVEL_BLOCK) {
        return new MissionLevelBlockImpl(node);
      }
      else if (type == LEVEL_BODY) {
        return new MissionLevelBodyImpl(node);
      }
      else if (type == MATH_ASSIGNMENT) {
        return new MissionMathAssignmentImpl(node);
      }
      else if (type == MATH_OPERATION) {
        return new MissionMathOperationImpl(node);
      }
      else if (type == MATH_OPERATOR) {
        return new MissionMathOperatorImpl(node);
      }
      else if (type == METHOD_CALL) {
        return new MissionMethodCallImpl(node);
      }
      else if (type == MISSION_BLOCK) {
        return new MissionMissionBlockImpl(node);
      }
      else if (type == PARAM) {
        return new MissionParamImpl(node);
      }
      else if (type == PARAMS) {
        return new MissionParamsImpl(node);
      }
      else if (type == PREPROCESS_BLOCK) {
        return new MissionPreprocessBlockImpl(node);
      }
      else if (type == PREPROCESS_TYPE) {
        return new MissionPreprocessTypeImpl(node);
      }
      else if (type == SET_EXPRESSION) {
        return new MissionSetExpressionImpl(node);
      }
      else if (type == SUBROUTINE_DEFINITION) {
        return new MissionSubroutineDefinitionImpl(node);
      }
      else if (type == SUBROUTINE_REFERENCE) {
        return new MissionSubroutineReferenceImpl(node);
      }
      else if (type == TYPE) {
        return new MissionTypeImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT) {
        return new MissionVariableAssignmentImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new MissionVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new MissionVariableReferenceImpl(node);
      }
      else if (type == VECTOR) {
        return new MissionVectorImpl(node);
      }
      else if (type == VECTOR_3) {
        return new MissionVector3Impl(node);
      }
      else if (type == WHILE_EXEC_EXPRESSION) {
        return new MissionWhileExecExpressionImpl(node);
      }
      else if (type == WHILE_EXPRESSION) {
        return new MissionWhileExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
