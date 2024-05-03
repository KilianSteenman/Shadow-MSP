// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionSubroutineDefinition extends Gta2MissionNamedElement {

  @NotNull
  List<MissionExpression> getExpressionList();

  @NotNull
  PsiElement getSubroutine();

  @Nullable
  PsiElement getNameIdentifier();

  @Nullable
  PsiElement setName(@NotNull String name);

  @NotNull
  String getName();

}
