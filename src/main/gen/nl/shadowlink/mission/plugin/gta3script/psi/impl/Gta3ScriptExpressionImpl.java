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
  public Gta3ScriptCastAssignment getCastAssignment() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptCastAssignment.class);
  }

  @Override
  @Nullable
  public Gta3ScriptGotoCall getGotoCall() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptGotoCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptIfExpression getIfExpression() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptIfExpression.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLabelDefinition getLabelDefinition() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptLabelDefinition.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLabelReturn getLabelReturn() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptLabelReturn.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLaunchMissionCall getLaunchMissionCall() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptLaunchMissionCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLineBreak getLineBreak() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptLineBreak.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLocalScope getLocalScope() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptLocalScope.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMathOperation getMathOperation() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptMathOperation.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMethodCall getMethodCall() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptMethodCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptMissionBlock getMissionBlock() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptMissionBlock.class);
  }

  @Override
  @Nullable
  public Gta3ScriptStartNewScriptCall getStartNewScriptCall() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptStartNewScriptCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptSubroutineCall getSubroutineCall() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptSubroutineCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptVariableAssignment getVariableAssignment() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptVariableAssignment.class);
  }

  @Override
  @Nullable
  public Gta3ScriptVariableDefinition getVariableDefinition() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptVariableDefinition.class);
  }

  @Override
  @Nullable
  public Gta3ScriptWhileExpression getWhileExpression() {
    return PsiTreeUtil.getChildOfType(this, Gta3ScriptWhileExpression.class);
  }

}
