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
NUMBER=[0-9]+(\.[0-9]*)?
IDENTIFIER=[a-z0-9_]+
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
  "++"                   { return OP_PLUS_PLUS; }
  "PLAYER_PED"           { return PLAYER_PED; }
  "BONUS"                { return BONUS; }
  "CHAR_DATA"            { return CHAR_DATA; }
  "CAR_DATA"             { return CAR_DATA; }
  "COUNTER"              { return COUNTER; }
  "ONSCREEN_COUNTER"     { return ONSCREEN_COUNTER; }
  "FORWARD"              { return FORWARD; }
  "TIMER_DATA"           { return TIMER_DATA; }
  "THREAD_TRIGGER"       { return THREAD_TRIGGER; }
  "MACHINE_GUN"          { return MACHINE_GUN; }
  "CRIMINAL_TYPE2"       { return CRIMINAL_TYPE2; }
  "AREA_PLAYER_ONLY"     { return AREA_PLAYER_ONLY; }
  "REACT_AS_NORMAL"      { return REACT_AS_NORMAL; }
  "KILL_CHAR_ON_FOOT"    { return KILL_CHAR_ON_FOOT; }

  {SPACE}                { return SPACE; }
  {NUMBER}               { return NUMBER; }
  {IDENTIFIER}           { return IDENTIFIER; }
  {COMMENT}              { return COMMENT; }
  {SUBROUTINE}           { return SUBROUTINE; }
  {COMMENT_BLOCK}        { return COMMENT_BLOCK; }
  {METHOD}               { return METHOD; }

}

[^] { return BAD_CHARACTER; }
