// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionVariableAssignment extends PsiElement {

  @Nullable
  MissionMethodCall getMethodCall();

  @NotNull
  MissionParams getParams();

  @NotNull
  MissionVariableReference getVariableReference();

}
