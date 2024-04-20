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

public class Gta3ScriptConditionalStatementImpl extends ASTWrapperPsiElement implements Gta3ScriptConditionalStatement {

  public Gta3ScriptConditionalStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitConditionalStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Gta3ScriptAndStatement> getAndStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Gta3ScriptAndStatement.class);
  }

  @Override
  @Nullable
  public Gta3ScriptConditionalStatement getConditionalStatement() {
    return findChildByClass(Gta3ScriptConditionalStatement.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMethodCall getMethodCall() {
    return findChildByClass(Gta3ScriptMethodCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptParam getParam() {
    return findChildByClass(Gta3ScriptParam.class);
  }

  @Override
  @Nullable
  public Gta3ScriptVariableReference getVariableReference() {
    return findChildByClass(Gta3ScriptVariableReference.class);
  }

}
