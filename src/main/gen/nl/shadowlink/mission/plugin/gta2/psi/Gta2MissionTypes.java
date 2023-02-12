// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.shadowlink.mission.plugin.gta2.psi.impl.*;

public interface Gta2MissionTypes {

  IElementType AND_STATEMENT = new Gta2MissionElementType("AND_STATEMENT");
  IElementType CONDITIONAL_STATEMENT = new Gta2MissionElementType("CONDITIONAL_STATEMENT");
  IElementType DEFINITION = new Gta2MissionElementType("DEFINITION");
  IElementType DEFINITION_BLOCK = new Gta2MissionElementType("DEFINITION_BLOCK");
  IElementType ENUM = new Gta2MissionElementType("ENUM");
  IElementType EXPRESSION = new Gta2MissionElementType("EXPRESSION");
  IElementType IF_EXPRESSION = new Gta2MissionElementType("IF_EXPRESSION");
  IElementType LEVEL_BLOCK = new Gta2MissionElementType("LEVEL_BLOCK");
  IElementType LEVEL_BODY = new Gta2MissionElementType("LEVEL_BODY");
  IElementType MATH_ASSIGNMENT = new Gta2MissionElementType("MATH_ASSIGNMENT");
  IElementType METHOD_CALL = new Gta2MissionElementType("METHOD_CALL");
  IElementType PARAM = new Gta2MissionElementType("PARAM");
  IElementType PARAMS = new Gta2MissionElementType("PARAMS");
  IElementType SET_EXPRESSION = new Gta2MissionElementType("SET_EXPRESSION");
  IElementType SUBROUTINE_DEFINITION = new Gta2MissionElementType("SUBROUTINE_DEFINITION");
  IElementType TYPE = new Gta2MissionElementType("TYPE");
  IElementType VARIABLE_ASSIGNMENT = new Gta2MissionElementType("VARIABLE_ASSIGNMENT");
  IElementType VARIABLE_DEFINITION = new Gta2MissionElementType("VARIABLE_DEFINITION");
  IElementType VECTOR_3 = new Gta2MissionElementType("VECTOR_3");
  IElementType WHILE_EXPRESSION = new Gta2MissionElementType("WHILE_EXPRESSION");

  IElementType AND = new Gta2MissionTokenType("AND");
  IElementType AREA_PLAYER_ONLY = new Gta2MissionTokenType("AREA_PLAYER_ONLY");
  IElementType CAR_DATA = new Gta2MissionTokenType("CAR_DATA");
  IElementType CHAR_DATA = new Gta2MissionTokenType("CHAR_DATA");
  IElementType COMMENT = new Gta2MissionTokenType("COMMENT");
  IElementType COUNTER = new Gta2MissionTokenType("COUNTER");
  IElementType CRIMINAL_TYPE2 = new Gta2MissionTokenType("CRIMINAL_TYPE2");
  IElementType END = new Gta2MissionTokenType("END");
  IElementType END_IF = new Gta2MissionTokenType("ENDIF");
  IElementType END_WHILE = new Gta2MissionTokenType("ENDWHILE");
  IElementType FORWARD = new Gta2MissionTokenType("FORWARD");
  IElementType IDENTIFIER = new Gta2MissionTokenType("IDENTIFIER");
  IElementType IF = new Gta2MissionTokenType("IF");
  IElementType KILL_CHAR_ON_FOOT = new Gta2MissionTokenType("KILL_CHAR_ON_FOOT");
  IElementType LEVEL_END = new Gta2MissionTokenType("LEVELEND");
  IElementType LEVEL_START = new Gta2MissionTokenType("LEVELSTART");
  IElementType MACHINE_GUN = new Gta2MissionTokenType("MACHINE_GUN");
  IElementType METHOD = new Gta2MissionTokenType("METHOD");
  IElementType NOT = new Gta2MissionTokenType("NOT");
  IElementType NUMBER = new Gta2MissionTokenType("number");
  IElementType OP_PLUS_PLUS = new Gta2MissionTokenType("++");
  IElementType PLAYER_PED = new Gta2MissionTokenType("PLAYER_PED");
  IElementType REACT_AS_NORMAL = new Gta2MissionTokenType("REACT_AS_NORMAL");
  IElementType RETURN = new Gta2MissionTokenType("RETURN");
  IElementType SET = new Gta2MissionTokenType("SET");
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
      else if (type == EXPRESSION) {
        return new MissionExpressionImpl(node);
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
      else if (type == METHOD_CALL) {
        return new MissionMethodCallImpl(node);
      }
      else if (type == PARAM) {
        return new MissionParamImpl(node);
      }
      else if (type == PARAMS) {
        return new MissionParamsImpl(node);
      }
      else if (type == SET_EXPRESSION) {
        return new MissionSetExpressionImpl(node);
      }
      else if (type == SUBROUTINE_DEFINITION) {
        return new MissionSubroutineDefinitionImpl(node);
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
      else if (type == VECTOR_3) {
        return new MissionVector3Impl(node);
      }
      else if (type == WHILE_EXPRESSION) {
        return new MissionWhileExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
