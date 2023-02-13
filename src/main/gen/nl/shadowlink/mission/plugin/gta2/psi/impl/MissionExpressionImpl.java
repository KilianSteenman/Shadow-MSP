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

public class MissionExpressionImpl extends ASTWrapperPsiElement implements MissionExpression {

  public MissionExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MissionVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MissionVisitor) accept((MissionVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MissionCommentBlock getCommentBlock() {
    return findChildByClass(MissionCommentBlock.class);
  }

  @Override
  @Nullable
  public MissionIfExpression getIfExpression() {
    return findChildByClass(MissionIfExpression.class);
  }

  @Override
  @Nullable
  public MissionMathAssignment getMathAssignment() {
    return findChildByClass(MissionMathAssignment.class);
  }

  @Override
  @Nullable
  public MissionMethodCall getMethodCall() {
    return findChildByClass(MissionMethodCall.class);
  }

  @Override
  @Nullable
  public MissionSetExpression getSetExpression() {
    return findChildByClass(MissionSetExpression.class);
  }

  @Override
  @Nullable
  public MissionSubroutineCall getSubroutineCall() {
    return findChildByClass(MissionSubroutineCall.class);
  }

  @Override
  @Nullable
  public MissionSubroutineDefinition getSubroutineDefinition() {
    return findChildByClass(MissionSubroutineDefinition.class);
  }

  @Override
  @Nullable
  public MissionVariableAssignment getVariableAssignment() {
    return findChildByClass(MissionVariableAssignment.class);
  }

  @Override
  @Nullable
  public MissionWhileExecExpression getWhileExecExpression() {
    return findChildByClass(MissionWhileExecExpression.class);
  }

  @Override
  @Nullable
  public MissionWhileExpression getWhileExpression() {
    return findChildByClass(MissionWhileExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

}
