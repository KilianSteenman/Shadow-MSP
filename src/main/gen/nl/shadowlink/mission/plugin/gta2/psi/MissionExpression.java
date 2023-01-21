// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionExpression extends PsiElement {

  @NotNull
  List<MissionExpression> getExpressionList();

  @Nullable
  MissionStatement getStatement();

  @NotNull
  List<MissionVector3> getVector3List();

  @Nullable
  PsiElement getComment();

  @Nullable
  PsiElement getMethod();

}
