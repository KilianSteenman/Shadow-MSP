// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionDefinition extends PsiElement {

  @NotNull
  List<MissionExpression> getExpressionList();

  @Nullable
  MissionType getType();

  @NotNull
  List<MissionVector3> getVector3List();

  @Nullable
  PsiElement getComment();

}
