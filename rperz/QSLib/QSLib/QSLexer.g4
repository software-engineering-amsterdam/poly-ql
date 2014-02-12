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

TYPE :
	  'String'
	| 'Integer'
	| 'Boolean' 
	;

BOOL_VAL : 
	  'true'
	| 'false' 
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


