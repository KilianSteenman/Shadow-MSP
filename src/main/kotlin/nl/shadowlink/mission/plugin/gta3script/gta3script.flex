package nl.shadowlink.mission.plugin.gta3script;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes.*;

%%

%{
  public Gta3ScriptLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class Gta3ScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
NUMBER=-?[0-9]+(\.[0-9]*)?
IDENTIFIER=[a-zA-Z0-9_]+
COMMENT="//".*
SUBROUTINE=([a-z0-9_]+):
COMMENT_BLOCK="/*" !([^]* "*/" [^]*) ("*/")?
METHOD=[A-Z_]+

%%
<YYINITIAL> {
  {WHITE_SPACE}          { return WHITE_SPACE; }

  "LEVELSTART"           { return LEVEL_START; }
  "LEVELEND"             { return LEVEL_END; }
  "MISSIONSTART"         { return MISSION_START; }
  "MISSIONEND"           { return MISSION_END; }
  "WHILE_EXEC"           { return WHILE_EXEC; }
  "END_WHILE_EXEC"       { return END_WHILE_EXEC; }
  "WHILE"                { return WHILE; }
  "ENDWHILE"             { return END_WHILE; }
  "EXEC"                 { return EXEC; }
  "ENDEXEC"              { return END_EXEC; }
  "IF"                   { return IF; }
  "ENDIF"                { return END_IF; }
  "ELSE"                 { return ELSE; }
  "END"                  { return END; }
  "RETURN"               { return RETURN; }
  "SET"                  { return SET; }
  "NOT"                  { return NOT; }
  "AND"                  { return AND; }
  "ON"                   { return ON; }
  "OFF"                  { return OFF; }
  "GOSUB"                { return GOSUB; }
  "DO_NOWT"              { return DO_NOWT; }

  "++"                   { return OP_PLUS_PLUS; }
  "+"                    { return OP_PLUS; }
  "--"                   { return OP_MINUS_MINUS; }
  "-"                    { return OP_MINUS; }
  "*"                    { return OP_TIMES; }
  "/"                    { return OP_DIVISION; }
  "="                    { return EQUALS; }
  "<"                    { return OP_LESS_THAN; }
  ">"                    { return OP_GREATER_THAN; }

  "VAR_INT"              { return VAR_INT; }
  "VAR_FLOAT"            { return VAR_FLOAT; }

  "MACHINE_GUN"          { return MACHINE_GUN; }
  "CRIMINAL_TYPE2"       { return CRIMINAL_TYPE2; }
  "AREA_PLAYER_ONLY"     { return AREA_PLAYER_ONLY; }
  "REACT_AS_NORMAL"      { return REACT_AS_NORMAL; }
  "KILL_CHAR_ON_FOOT"    { return KILL_CHAR_ON_FOOT; }
  "#ifdef"               { return PREPROCESS_IFDEF; }
  "#endif"               { return PREPROCESS_ENDIF; }
  "PC"                   { return DEF_PC; }
  "PSX"                  { return DEF_PSX; }

  {SPACE}                { return SPACE; }
  {NUMBER}               { return NUMBER; }
  {COMMENT}              { return COMMENT; }
  {SUBROUTINE}           { return SUBROUTINE; }
  {COMMENT_BLOCK}        { return COMMENT_BLOCK; }
  {METHOD}               { return METHOD; }
  {IDENTIFIER}           { return IDENTIFIER; }
}

[^] { return BAD_CHARACTER; }
