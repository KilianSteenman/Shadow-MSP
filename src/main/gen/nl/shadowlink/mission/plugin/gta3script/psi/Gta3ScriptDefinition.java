// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Gta3ScriptDefinition extends PsiElement {

  @Nullable
  Gta3ScriptPreprocessBlock getPreprocessBlock();

  @Nullable
  Gta3ScriptSubroutineDefinition getSubroutineDefinition();

  @Nullable
  Gta3ScriptType getType();

  @Nullable
  Gta3ScriptVariableDefinition getVariableDefinition();

  @Nullable
  PsiElement getComment();

  @Nullable
  PsiElement getSubroutine();

}
