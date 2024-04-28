// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptMathOperation extends PsiElement {

  @Nullable
  Gta3ScriptIncrementPostOperation getIncrementPostOperation();

  @Nullable
  Gta3ScriptIncrementPreOperation getIncrementPreOperation();

  @Nullable
  Gta3ScriptMathOperationAssignment getMathOperationAssignment();

  @Nullable
  Gta3ScriptMathOperationSelfAssignment getMathOperationSelfAssignment();

}
