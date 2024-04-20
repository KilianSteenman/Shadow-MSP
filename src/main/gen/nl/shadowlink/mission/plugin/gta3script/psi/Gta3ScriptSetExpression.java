// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptSetExpression extends PsiElement {

  @Nullable
  Gta3ScriptMathOperation getMathOperation();

  @Nullable
  Gta3ScriptParam getParam();

  @NotNull
  Gta3ScriptVariableReference getVariableReference();

}
