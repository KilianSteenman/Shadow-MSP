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

public class Gta3ScriptMathOperationImpl extends ASTWrapperPsiElement implements Gta3ScriptMathOperation {

  public Gta3ScriptMathOperationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitMathOperation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public Gta3ScriptMathOperator getMathOperator() {
    return findNotNullChildByClass(Gta3ScriptMathOperator.class);
  }

  @Override
  @NotNull
  public Gta3ScriptParam getParam() {
    return findNotNullChildByClass(Gta3ScriptParam.class);
  }

  @Override
  @NotNull
  public Gta3ScriptVariableReference getVariableReference() {
    return findNotNullChildByClass(Gta3ScriptVariableReference.class);
  }

}
