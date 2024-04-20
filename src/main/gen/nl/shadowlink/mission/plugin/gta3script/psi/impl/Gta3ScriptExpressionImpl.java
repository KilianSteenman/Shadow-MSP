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
  public Gta3ScriptCommentBlock getCommentBlock() {
    return findChildByClass(Gta3ScriptCommentBlock.class);
  }

  @Override
  @Nullable
  public Gta3ScriptDefinition getDefinition() {
    return findChildByClass(Gta3ScriptDefinition.class);
  }

  @Override
  @Nullable
  public Gta3ScriptExecExpression getExecExpression() {
    return findChildByClass(Gta3ScriptExecExpression.class);
  }

  @Override
  @Nullable
  public Gta3ScriptGosubCall getGosubCall() {
    return findChildByClass(Gta3ScriptGosubCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptIfExpression getIfExpression() {
    return findChildByClass(Gta3ScriptIfExpression.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMathAssignment getMathAssignment() {
    return findChildByClass(Gta3ScriptMathAssignment.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMethodCall getMethodCall() {
    return findChildByClass(Gta3ScriptMethodCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptPreprocessBlock getPreprocessBlock() {
    return findChildByClass(Gta3ScriptPreprocessBlock.class);
  }

  @Override
  @Nullable
  public Gta3ScriptSetExpression getSetExpression() {
    return findChildByClass(Gta3ScriptSetExpression.class);
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
  public Gta3ScriptWhileExecExpression getWhileExecExpression() {
    return findChildByClass(Gta3ScriptWhileExecExpression.class);
  }

  @Override
  @Nullable
  public Gta3ScriptWhileExpression getWhileExpression() {
    return findChildByClass(Gta3ScriptWhileExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

}
