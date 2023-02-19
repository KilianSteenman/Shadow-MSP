// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionExpression extends PsiElement {

  @Nullable
  MissionCommentBlock getCommentBlock();

  @Nullable
  MissionDefinition getDefinition();

  @Nullable
  MissionExecExpression getExecExpression();

  @Nullable
  MissionGosubCall getGosubCall();

  @Nullable
  MissionIfExpression getIfExpression();

  @Nullable
  MissionMathAssignment getMathAssignment();

  @Nullable
  MissionMethodCall getMethodCall();

  @Nullable
  MissionPreprocessBlock getPreprocessBlock();

  @Nullable
  MissionSetExpression getSetExpression();

  @Nullable
  MissionSubroutineDefinition getSubroutineDefinition();

  @Nullable
  MissionVariableAssignment getVariableAssignment();

  @Nullable
  MissionWhileExecExpression getWhileExecExpression();

  @Nullable
  MissionWhileExpression getWhileExpression();

  @Nullable
  PsiElement getComment();

}
