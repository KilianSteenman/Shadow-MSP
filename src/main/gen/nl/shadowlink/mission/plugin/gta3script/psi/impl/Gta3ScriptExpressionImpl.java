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

public class Gta3ScriptExpressionImpl extends ASTWrapperPsiElement implements Gta3ScriptExpression {

  public Gta3ScriptExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Gta3ScriptIfExpression getIfExpression() {
    return findChildByClass(Gta3ScriptIfExpression.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLocalScope getLocalScope() {
    return findChildByClass(Gta3ScriptLocalScope.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMathOperation getMathOperation() {
    return findChildByClass(Gta3ScriptMathOperation.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMethodCall getMethodCall() {
    return findChildByClass(Gta3ScriptMethodCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptSubroutineCall getSubroutineCall() {
    return findChildByClass(Gta3ScriptSubroutineCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptSubroutineDefinition getSubroutineDefinition() {
    return findChildByClass(Gta3ScriptSubroutineDefinition.class);
  }

  @Override
  @Nullable
  public Gta3ScriptVariableAssignment getVariableAssignment() {
    return findChildByClass(Gta3ScriptVariableAssignment.class);
  }

  @Override
  @Nullable
  public Gta3ScriptVariableDefinition getVariableDefinition() {
    return findChildByClass(Gta3ScriptVariableDefinition.class);
  }

  @Override
  @Nullable
  public Gta3ScriptWhileExpression getWhileExpression() {
    return findChildByClass(Gta3ScriptWhileExpression.class);
  }

}
