// This is a generated file. Not intended for manual editing.
package nl.shadowlink.mission.plugin.gta3script.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes.*;
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptNamedElementImpl;
import nl.shadowlink.mission.plugin.gta3script.psi.*;

public class Gta3ScriptVariableDefinitionImpl extends Gta3ScriptNamedElementImpl implements Gta3ScriptVariableDefinition {

  public Gta3ScriptVariableDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitVariableDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public Gta3ScriptType getType() {
    return findNotNullChildByClass(Gta3ScriptType.class);
  }

  @Override
  @NotNull
  public Gta3ScriptVariableIdentifierList getVariableIdentifierList() {
    return findNotNullChildByClass(Gta3ScriptVariableIdentifierList.class);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return Gta3ScriptUtils.getNameIdentifier(this);
  }

  @Override
  @Nullable
  public PsiElement setName(@NotNull String name) {
    return Gta3ScriptUtils.setName(this, name);
  }

  @Override
  @NotNull
  public String getName() {
    return Gta3ScriptUtils.getName(this);
  }

}
