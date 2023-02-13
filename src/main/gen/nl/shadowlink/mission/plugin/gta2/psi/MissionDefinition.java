// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionDefinition extends PsiElement {

  @Nullable
  MissionPreprocessBlock getPreprocessBlock();

  @Nullable
  MissionSubroutineDefinition getSubroutineDefinition();

  @Nullable
  MissionType getType();

  @Nullable
  MissionVariableDefinition getVariableDefinition();

  @Nullable
  PsiElement getComment();

  @Nullable
  PsiElement getSubroutine();

}
