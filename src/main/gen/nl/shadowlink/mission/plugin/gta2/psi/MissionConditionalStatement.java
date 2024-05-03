// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionConditionalStatement extends PsiElement {

  @NotNull
  List<MissionAndStatement> getAndStatementList();

  @Nullable
  MissionConditionalStatement getConditionalStatement();

  @Nullable
  MissionMethodCall getMethodCall();

  @Nullable
  MissionParam getParam();

  @Nullable
  MissionVariableReference getVariableReference();

}
