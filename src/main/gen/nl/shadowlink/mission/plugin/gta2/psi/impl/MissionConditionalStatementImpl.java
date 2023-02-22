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

public class MissionConditionalStatementImpl extends ASTWrapperPsiElement implements MissionConditionalStatement {

  public MissionConditionalStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MissionVisitor visitor) {
    visitor.visitConditionalStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MissionVisitor) accept((MissionVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MissionAndStatement> getAndStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MissionAndStatement.class);
  }

  @Override
  @Nullable
  public MissionConditionalStatement getConditionalStatement() {
    return findChildByClass(MissionConditionalStatement.class);
  }

  @Override
  @Nullable
  public MissionMethodCall getMethodCall() {
    return findChildByClass(MissionMethodCall.class);
  }

  @Override
  @Nullable
  public MissionParam getParam() {
    return findChildByClass(MissionParam.class);
  }

  @Override
  @Nullable
  public MissionVariableReference getVariableReference() {
    return findChildByClass(MissionVariableReference.class);
  }

}
