package nl.shadowlink.mission.plugin.gta3script;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes.*;

%%

%{
  public _Gta3ScriptLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _Gta3ScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

NEW_LINE=\\n
SPACE=\[ \t\n\x0B\f\r]
NUMBER=-?[0-9]+(\.[0-9]*)?
COMMENT="//".*
GOSUB_IDENTIFIER=[a-z]+:
IDENTIFIER=\$?[a-zA-Z0-9_.]+

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  "MISSION_START"          { return MISSION_START; }
  "MISSION_END"            { return MISSION_END; }
  "WHILE"                  { return WHILE; }
  "ENDWHILE"               { return END_WHILE; }
  "IF"                     { return IF; }
  "ENDIF"                  { return END_IF; }
  "ELSE"                   { return ELSE; }
  "AND"                    { return AND; }
  "END"                    { return END; }
  "RETURN"                 { return RETURN; }
  "SET"                    { return SET; }
  "NOT"                    { return NOT; }
  "ON"                     { return ON; }
  "OFF"                    { return OFF; }
  "TRUE"                   { return TRUE; }
  "FALSE"                  { return FALSE; }
  "GOSUB"                  { return GOSUB; }
  "++"                     { return OP_PLUS_PLUS; }
  "+"                      { return OP_PLUS; }
  "--"                     { return OP_MINUS_MINUS; }
  "-"                      { return OP_MINUS; }
  "*"                      { return OP_TIMES; }
  "/"                      { return OP_DIVISION; }
  "<"                      { return OP_LESS_THAN; }
  ">"                      { return OP_GREATER_THAN; }
  "="                      { return EQUALS; }
  "VAR_INT"                { return VAR_INT; }
  "linebreak"              { return LINEBREAK; }
  "VAR_FLOAT"              { return VAR_FLOAT; }
  "SUBROUTINE"             { return SUBROUTINE; }

  {NEW_LINE}               { return NEW_LINE; }
  {SPACE}                  { return SPACE; }
  {NUMBER}                 { return NUMBER; }
  {COMMENT}                { return COMMENT; }
  {GOSUB_IDENTIFIER}       { return GOSUB_IDENTIFIER; }
  {IDENTIFIER}             { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
