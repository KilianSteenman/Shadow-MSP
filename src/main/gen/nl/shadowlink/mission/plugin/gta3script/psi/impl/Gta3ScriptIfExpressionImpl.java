// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import nl.shadowlink.mission.plugin.gta3script.psi.*;

public class Gta3ScriptIfExpressionImpl extends ASTWrapperPsiElement implements Gta3ScriptIfExpression {

  public Gta3ScriptIfExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitIfExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Gta3ScriptAndCondition> getAndConditionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Gta3ScriptAndCondition.class);
  }

  @Override
  @NotNull
  public Gta3ScriptCondition getCondition() {
    return findNotNullChildByClass(Gta3ScriptCondition.class);
  }

  @Override
  @NotNull
  public List<Gta3ScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Gta3ScriptExpression.class);
  }

  @Override
  @NotNull
  public Gta3ScriptLineBreak getLineBreak() {
    return findNotNullChildByClass(Gta3ScriptLineBreak.class);
  }

}
