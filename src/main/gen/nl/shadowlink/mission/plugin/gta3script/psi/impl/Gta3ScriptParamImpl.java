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

public class Gta3ScriptParamImpl extends ASTWrapperPsiElement implements Gta3ScriptParam {

  public Gta3ScriptParamImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitParam(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Gta3ScriptBoolean getBoolean() {
    return findChildByClass(Gta3ScriptBoolean.class);
  }

  @Override
  @Nullable
  public Gta3ScriptEnum getEnum() {
    return findChildByClass(Gta3ScriptEnum.class);
  }

  @Override
  @Nullable
  public Gta3ScriptVariableReference getVariableReference() {
    return findChildByClass(Gta3ScriptVariableReference.class);
  }

  @Override
  @Nullable
  public Gta3ScriptVector3 getVector3() {
    return findChildByClass(Gta3ScriptVector3.class);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

}
