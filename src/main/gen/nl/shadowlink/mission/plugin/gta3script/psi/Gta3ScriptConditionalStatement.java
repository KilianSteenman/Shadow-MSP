// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptConditionalStatement extends PsiElement {

  @NotNull
  List<Gta3ScriptAndStatement> getAndStatementList();

  @Nullable
  Gta3ScriptConditionalStatement getConditionalStatement();

  @Nullable
  Gta3ScriptMethodCall getMethodCall();

  @Nullable
  Gta3ScriptParam getParam();

  @Nullable
  Gta3ScriptVariableReference getVariableReference();

}
