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

public class MissionWhileExpressionImpl extends ASTWrapperPsiElement implements MissionWhileExpression {

  public MissionWhileExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MissionVisitor visitor) {
    visitor.visitWhileExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MissionVisitor) accept((MissionVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MissionConditionalStatement getConditionalStatement() {
    return findNotNullChildByClass(MissionConditionalStatement.class);
  }

  @Override
  @NotNull
  public List<MissionExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MissionExpression.class);
  }

}
