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

public class MissionVariableDefinitionImpl extends Gta2MissionNamedElementImpl implements MissionVariableDefinition {

  public MissionVariableDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MissionVisitor visitor) {
    visitor.visitVariableDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MissionVisitor) accept((MissionVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MissionParam> getParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MissionParam.class);
  }

  @Override
  @NotNull
  public MissionType getType() {
    return findNotNullChildByClass(MissionType.class);
  }

  @Override
  @NotNull
  public List<MissionVector> getVectorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MissionVector.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
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
