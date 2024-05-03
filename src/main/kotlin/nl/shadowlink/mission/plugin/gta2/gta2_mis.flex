package nl.shadowlink.mission.plugin.gta2;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes.*;

%%

%{
  public Gta2MissionLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class Gta2MissionLexer
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

  "PLAYER_PED"           { return PLAYER_PED; }
  "BONUS"                { return BONUS; }
  "CHAR_DATA"            { return CHAR_DATA; }
  "CAR_DATA"             { return CAR_DATA; }
  "COUNTER"              { return COUNTER; }
  "ONSCREEN_COUNTER"     { return ONSCREEN_COUNTER; }
  "FORWARD"              { return FORWARD; }
  "TIMER_DATA"           { return TIMER_DATA; }
  "ARROW_DATA"           { return ARROW_DATA; }
  "MAP_ZONE"             { return MAP_ZONE; }
  "THREAD_TRIGGER"       { return THREAD_TRIGGER; }
  "OBJ_DATA"             { return OBJ_DATA; }
  "SAVED_COUNTER"        { return SAVED_COUNTER; }
  "CONVEYOR"             { return CONVEYOR; }
  "GENERATOR"            { return GENERATOR; }
  "DESTRUCTOR"           { return DESTRUCTOR; }
  "CRANE_DATA"           { return CRANE_DATA; }
  "CRUSHER"              { return CRUSHER; }
  "SOUND"                { return SOUND; }
  "LIGHT"                { return LIGHT; }

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
