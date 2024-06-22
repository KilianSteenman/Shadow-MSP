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
import com.intellij.psi.PsiReference;

public class Gta3ScriptScriptReferenceImpl extends Gta3ScriptNamedElementImpl implements Gta3ScriptScriptReference {

  public Gta3ScriptScriptReferenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Gta3ScriptVisitor visitor) {
    visitor.visitScriptReference(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Gta3ScriptVisitor) accept((Gta3ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return notNullChild(findChildByType(IDENTIFIER));
  }

  @Override
  @NotNull
  public String getName() {
    return Gta3ScriptUtils.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String newName) {
    return Gta3ScriptUtils.setName(this, newName);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return Gta3ScriptUtils.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public PsiReference getReference() {
    return Gta3ScriptUtils.getReference(this);
  }

}
