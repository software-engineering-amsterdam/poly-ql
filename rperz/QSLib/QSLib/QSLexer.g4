lexer grammar QSLexer;

@members
{
	protected const int EOF = Eof;
	protected const int HIDDEN = Hidden;
}


IF :
	  'if' 
	;

ELSE : 
	  'else' 
	;

FORM :
	  'form'
	;

TYPE_STRING :
	  'String'
	;
TYPE_INTEGER :
	 'Integer'
	;
TYPE_BOOL :
	  'Boolean' 
	;

BOOL_VAL : 
	  'true'
	| 'false' 
	;

LARGEREQUALS :
	  '>='
	;
SMALLEREQUALS :
	  '<='
	;

NOTEQUALS :
	  '!='
	;

EQUALS :
	  '=='
	;

SMALLER :
	  '<'
	;
LARGER :
	  '>'
	;

ASSIGN :
	  '='
	;

WORD :
	  [a-zA-Z]+ 
	;

INTEGER_VAL :
	  [0-9]+ 
	;

INTERPUNCT :
	  ','
	| '.'
	| '?'
	| '!'
	;

COMMENT :
	  '\\\\'
	;

PLUS :
	  '+'
	;

MINUS :
	  '-'
	;

MULTIPLY : 
	  '*'
	;

DIVIDE :
	  '/'
	;


COLON :
	  ':'
	;

SQ :
	  '\''
	;

L_HOOK :
	'('
	;

R_HOOK :
	')'
	;

L_BRACKET :
	'{'
	;

R_BRACKET :
	'}'
	;

	
WS	: 
	[ \t\r\n]+ ->skip ;


