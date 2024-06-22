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

public class Gta3ScriptComparisonImpl extends ASTWrapperPsiElement implements Gta3ScriptComparison {

  public Gta3ScriptComparisonImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitComparison(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public Gta3ScriptComparisonOperator getComparisonOperator() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, Gta3ScriptComparisonOperator.class));
  }

  @Override
  @NotNull
  public List<Gta3ScriptParam> getParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Gta3ScriptParam.class);
  }

  @Override
  @NotNull
  public Gta3ScriptLineBreak getLineBreak() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, Gta3ScriptLineBreak.class));
  }

}
