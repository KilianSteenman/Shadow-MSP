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
  @NotNull
  public List<MissionExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MissionExpression.class);
  }

  @Override
  @Nullable
  public MissionType getType() {
    return findChildByClass(MissionType.class);
  }

  @Override
  @NotNull
  public List<MissionVector3> getVector3List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MissionVector3.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

}
