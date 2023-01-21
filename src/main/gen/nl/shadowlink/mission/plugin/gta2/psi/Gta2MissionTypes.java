// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.shadowlink.mission.plugin.gta2.psi.impl.*;

public interface Gta2MissionTypes {

  IElementType DATA_BLOCK = new Gta2MissionElementType("DATA_BLOCK");
  IElementType DEFINITION = new Gta2MissionElementType("DEFINITION");
  IElementType EXPRESSION = new Gta2MissionElementType("EXPRESSION");
  IElementType LEVEL_BLOCK = new Gta2MissionElementType("LEVEL_BLOCK");
  IElementType STATEMENT = new Gta2MissionElementType("STATEMENT");
  IElementType TYPE = new Gta2MissionElementType("TYPE");
  IElementType VECTOR_3 = new Gta2MissionElementType("VECTOR_3");

  IElementType CHAR_DATA_DEF = new Gta2MissionTokenType("CHAR_DATA");
  IElementType COMMA = new Gta2MissionTokenType(",");
  IElementType COMMENT = new Gta2MissionTokenType("comment");
  IElementType COUNTER_DEF = new Gta2MissionTokenType("COUNTER");
  IElementType END = new Gta2MissionTokenType("END");
  IElementType END_IF = new Gta2MissionTokenType("ENDIF");
  IElementType END_WHILE = new Gta2MissionTokenType("ENDWHILE");
  IElementType ENUM = new Gta2MissionTokenType("ENUM");
  IElementType EQ = new Gta2MissionTokenType("=");
  IElementType FORWARD_DEF = new Gta2MissionTokenType("FORWARD");
  IElementType ID = new Gta2MissionTokenType("id");
  IElementType IF = new Gta2MissionTokenType("IF");
  IElementType LEVEL_END = new Gta2MissionTokenType("LEVELEND");
  IElementType LEVEL_START = new Gta2MissionTokenType("LEVELSTART");
  IElementType LP = new Gta2MissionTokenType("(");
  IElementType METHOD = new Gta2MissionTokenType("method");
  IElementType NUMBER = new Gta2MissionTokenType("number");
  IElementType OP_1 = new Gta2MissionTokenType("+");
  IElementType OP_2 = new Gta2MissionTokenType("-");
  IElementType OP_3 = new Gta2MissionTokenType("*");
  IElementType OP_4 = new Gta2MissionTokenType("/");
  IElementType OP_PLUS_PLUS = new Gta2MissionTokenType("++");
  IElementType PLAYER_PED_DEF = new Gta2MissionTokenType("PLAYER_PED");
  IElementType RETURN = new Gta2MissionTokenType("RETURN");
  IElementType RP = new Gta2MissionTokenType(")");
  IElementType SET = new Gta2MissionTokenType("SET");
  IElementType THREAD_TRIGGER_DEF = new Gta2MissionTokenType("THREAD_TRIGGER");
  IElementType TIMER_DATA_DEF = new Gta2MissionTokenType("TIMER_DATA");
  IElementType WHILE = new Gta2MissionTokenType("WHILE");
  IElementType WHILE_EXEC = new Gta2MissionTokenType("WHILE_EXEC");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DATA_BLOCK) {
        return new MissionDataBlockImpl(node);
      }
      else if (type == DEFINITION) {
        return new MissionDefinitionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new MissionExpressionImpl(node);
      }
      else if (type == LEVEL_BLOCK) {
        return new MissionLevelBlockImpl(node);
      }
      else if (type == STATEMENT) {
        return new MissionStatementImpl(node);
      }
      else if (type == TYPE) {
        return new MissionTypeImpl(node);
      }
      else if (type == VECTOR_3) {
        return new MissionVector3Impl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
