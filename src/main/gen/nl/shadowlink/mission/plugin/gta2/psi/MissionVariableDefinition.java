// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionVariableDefinition extends PsiElement {

  @NotNull
  List<MissionParam> getParamList();

  @NotNull
  MissionType getType();

  @NotNull
  List<MissionVector> getVectorList();

  @NotNull
  PsiElement getIdentifier();

}
