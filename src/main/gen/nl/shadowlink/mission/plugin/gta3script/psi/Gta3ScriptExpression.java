// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptExpression extends PsiElement {

  @Nullable
  Gta3ScriptIfExpression getIfExpression();

  @Nullable
  Gta3ScriptLocalScope getLocalScope();

  @Nullable
  Gta3ScriptMathOperation getMathOperation();

  @Nullable
  Gta3ScriptMethodCall getMethodCall();

  @Nullable
  Gta3ScriptSubroutineCall getSubroutineCall();

  @Nullable
  Gta3ScriptSubroutineDefinition getSubroutineDefinition();

  @Nullable
  Gta3ScriptVariableAssignment getVariableAssignment();

  @Nullable
  Gta3ScriptVariableDefinition getVariableDefinition();

  @Nullable
  Gta3ScriptWhileExpression getWhileExpression();

}
