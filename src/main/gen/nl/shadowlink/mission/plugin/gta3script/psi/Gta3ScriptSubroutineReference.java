// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface Gta3ScriptSubroutineReference extends Gta3ScriptNamedElement {

  @NotNull
  PsiElement getIdentifier();

  @NotNull
  String getName();

  @NotNull
  PsiElement setName(@NotNull String newName);

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  PsiReference getReference();

}
