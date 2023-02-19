// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes.*;
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionNamedElementImpl;
import nl.shadowlink.mission.plugin.gta2.psi.*;

public class MissionSubroutineDefinitionImpl extends Gta2MissionNamedElementImpl implements MissionSubroutineDefinition {

  public MissionSubroutineDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MissionVisitor visitor) {
    visitor.visitSubroutineDefinition(this);
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
  @NotNull
  public PsiElement getSubroutine() {
    return findNotNullChildByType(SUBROUTINE);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return Gta2Utils.getNameIdentifier(this);
  }

  @Override
  @Nullable
  public PsiElement setName(@NotNull String name) {
    return Gta2Utils.setName(this, name);
  }

  @Override
  @NotNull
  public String getName() {
    return Gta2Utils.getName(this);
  }

}
