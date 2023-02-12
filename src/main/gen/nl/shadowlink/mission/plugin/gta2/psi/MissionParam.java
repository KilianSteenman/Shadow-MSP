// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MissionParam extends PsiElement {

  @Nullable
  MissionBoolean getBoolean();

  @Nullable
  MissionEnum getEnum();

  @Nullable
  MissionVector3 getVector3();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getSubroutine();

}
