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
    return findChildByClass(Gta3ScriptCastAssignment.class);
  }

  @Override
  @Nullable
  public Gta3ScriptGotoCall getGotoCall() {
    return findChildByClass(Gta3ScriptGotoCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptIfExpression getIfExpression() {
    return findChildByClass(Gta3ScriptIfExpression.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLabelDefinition getLabelDefinition() {
    return findChildByClass(Gta3ScriptLabelDefinition.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLabelReturn getLabelReturn() {
    return findChildByClass(Gta3ScriptLabelReturn.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLaunchMissionCall getLaunchMissionCall() {
    return findChildByClass(Gta3ScriptLaunchMissionCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptLineBreak getLineBreak() {
    return findChildByClass(Gta3ScriptLineBreak.class);
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
  public Gta3ScriptMissionBlock getMissionBlock() {
    return findChildByClass(Gta3ScriptMissionBlock.class);
  }

  @Override
  @Nullable
  public Gta3ScriptStartNewScriptCall getStartNewScriptCall() {
    return findChildByClass(Gta3ScriptStartNewScriptCall.class);
  }

  @Override
  @Nullable
  public Gta3ScriptSubroutineCall getSubroutineCall() {
    return findChildByClass(Gta3ScriptSubroutineCall.class);
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
