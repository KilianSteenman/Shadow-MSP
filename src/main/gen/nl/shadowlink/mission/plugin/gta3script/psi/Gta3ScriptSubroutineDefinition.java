// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptSubroutineDefinition extends Gta3ScriptNamedElement {

  @NotNull
  List<Gta3ScriptExpression> getExpressionList();

  @NotNull
  PsiElement getSubroutine();

  @Nullable
  PsiElement getNameIdentifier();

  @Nullable
  PsiElement setName(@NotNull String name);

  @NotNull
  String getName();

}
