// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import nl.shadowlink.mission.plugin.gta2.psi.*;

public class MissionDefinitionImpl extends ASTWrapperPsiElement implements MissionDefinition {

  public MissionDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MissionVisitor visitor) {
    visitor.visitDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MissionVisitor) accept((MissionVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MissionPreprocessBlock getPreprocessBlock() {
    return findChildByClass(MissionPreprocessBlock.class);
  }

  @Override
  @Nullable
  public MissionSubroutineDefinition getSubroutineDefinition() {
    return findChildByClass(MissionSubroutineDefinition.class);
  }

  @Override
  @Nullable
  public MissionType getType() {
    return findChildByClass(MissionType.class);
  }

  @Override
  @Nullable
  public MissionVariableDefinition getVariableDefinition() {
    return findChildByClass(MissionVariableDefinition.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

  @Override
  @Nullable
  public PsiElement getSubroutine() {
    return findChildByType(SUBROUTINE);
  }

}
