// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptMathOperationSelfAssignment extends PsiElement {

  @NotNull
  Gta3ScriptMathOperator getMathOperator();

  @NotNull
  List<Gta3ScriptVariable> getVariableList();

  @Nullable
  PsiElement getNumber();

}
