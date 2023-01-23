// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionExpression extends PsiElement {

  @Nullable
  MissionIfExpression getIfExpression();

  @Nullable
  MissionMethodCall getMethodCall();

  @Nullable
  MissionSetExpression getSetExpression();

  @Nullable
  MissionSubroutineDefinition getSubroutineDefinition();

  @Nullable
  MissionVariableAssignment getVariableAssignment();

  @Nullable
  MissionWhileExpression getWhileExpression();

  @Nullable
  PsiElement getComment();

}
