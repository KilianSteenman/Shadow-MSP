// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptExpression extends PsiElement {

  @Nullable
  Gta3ScriptCastAssignment getCastAssignment();

  @Nullable
  Gta3ScriptGotoCall getGotoCall();

  @Nullable
  Gta3ScriptIfExpression getIfExpression();

  @Nullable
  Gta3ScriptLabelDefinition getLabelDefinition();

  @Nullable
  Gta3ScriptLabelReturn getLabelReturn();

  @Nullable
  Gta3ScriptLaunchMissionCall getLaunchMissionCall();

  @Nullable
  Gta3ScriptLineBreak getLineBreak();

  @Nullable
  Gta3ScriptLocalScope getLocalScope();

  @Nullable
  Gta3ScriptMathOperation getMathOperation();

  @Nullable
  Gta3ScriptMethodCall getMethodCall();

  @Nullable
  Gta3ScriptMissionBlock getMissionBlock();

  @Nullable
  Gta3ScriptStartNewScriptCall getStartNewScriptCall();

  @Nullable
  Gta3ScriptSubroutineCall getSubroutineCall();

  @Nullable
  Gta3ScriptVariableAssignment getVariableAssignment();

  @Nullable
  Gta3ScriptVariableDefinition getVariableDefinition();

  @Nullable
  Gta3ScriptWhileExpression getWhileExpression();

}
