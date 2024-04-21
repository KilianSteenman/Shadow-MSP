// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptVariableDefinition extends Gta3ScriptNamedElement {

  @NotNull
  Gta3ScriptType getType();

  @NotNull
  Gta3ScriptVariableIdentifierList getVariableIdentifierList();

  @Nullable
  PsiElement getNameIdentifier();

  @Nullable
  PsiElement setName(@NotNull String name);

  @NotNull
  String getName();

}
