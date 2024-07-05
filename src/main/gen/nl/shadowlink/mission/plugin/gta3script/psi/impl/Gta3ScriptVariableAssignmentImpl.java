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

public class Gta3ScriptVariableAssignmentImpl extends ASTWrapperPsiElement implements Gta3ScriptVariableAssignment {

  public Gta3ScriptVariableAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitVariableAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Gta3ScriptBoolean getBoolean() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptBoolean.class);
  }

  @Override
  @NotNull
  public Gta3ScriptLineBreak getLineBreak() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, Gta3ScriptLineBreak.class));
  }

  @Override
  @NotNull
  public Gta3ScriptVariable getVariable() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, Gta3ScriptVariable.class));
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

}
