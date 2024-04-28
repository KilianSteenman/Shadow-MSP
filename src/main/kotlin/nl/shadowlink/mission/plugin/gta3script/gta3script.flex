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

WHITE_SPACE=[ \t]+

NEW_LINE=[\n\r|\n|\r]+
NUMBER=-?[0-9]+(\.[0-9]*)?
COMMENT="//".*
OPCODE=[A-Z_]+:
GOSUB_IDENTIFIER=[a-z0-9_]+:
IDENTIFIER=\$?[a-zA-Z0-9_.]+
COMMENT_BLOCK="/*" !([^]* "*/" [^]*) ("*/")?

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
  "OR"                     { return OR; }
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
  "VAR_FLOAT"              { return VAR_FLOAT; }
  "SUBROUTINE"             { return SUBROUTINE; }

  {NEW_LINE}               { return NEW_LINE; }
  {NUMBER}                 { return NUMBER; }
  {COMMENT}                { return COMMENT; }
  {COMMENT_BLOCK}          { return COMMENT; }
  {OPCODE}                 { return OPCODE; }
  {GOSUB_IDENTIFIER}       { return GOSUB_IDENTIFIER; }
  {IDENTIFIER}             { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
