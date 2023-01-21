// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta2.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class MissionVisitor extends PsiElementVisitor {

  public void visitDataBlock(@NotNull MissionDataBlock o) {
    visitPsiElement(o);
  }

  public void visitDefinition(@NotNull MissionDefinition o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull MissionExpression o) {
    visitPsiElement(o);
  }

  public void visitLevelBlock(@NotNull MissionLevelBlock o) {
    visitPsiElement(o);
  }

  public void visitStatement(@NotNull MissionStatement o) {
    visitPsiElement(o);
  }

  public void visitType(@NotNull MissionType o) {
    visitPsiElement(o);
  }

  public void visitVector3(@NotNull MissionVector3 o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
