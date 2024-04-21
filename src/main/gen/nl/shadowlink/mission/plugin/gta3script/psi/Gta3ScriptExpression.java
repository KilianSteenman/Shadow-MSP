// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptExpression extends PsiElement {

  @Nullable
  Gta3ScriptCommentBlock getCommentBlock();

  @Nullable
  Gta3ScriptDefinition getDefinition();

  @Nullable
  Gta3ScriptExecExpression getExecExpression();

  @Nullable
  Gta3ScriptGosubCall getGosubCall();

  @Nullable
  Gta3ScriptIfExpression getIfExpression();

  @Nullable
  Gta3ScriptMathAssignment getMathAssignment();

  @Nullable
  Gta3ScriptMethodCall getMethodCall();

  @Nullable
  Gta3ScriptPreprocessBlock getPreprocessBlock();

  @Nullable
  Gta3ScriptSetExpression getSetExpression();

  @Nullable
  Gta3ScriptSubroutineDefinition getSubroutineDefinition();

  @Nullable
  Gta3ScriptVariableAssignment getVariableAssignment();

  @Nullable
  Gta3ScriptWhileExpression getWhileExpression();

  @Nullable
  PsiElement getComment();

}
