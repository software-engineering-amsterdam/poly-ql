lexer grammar QSLexer;

@members
{
	protected const int EOF = Eof;
	protected const int HIDDEN = Hidden;
}



IF :
	| 'if' 
	;

ELSE : 
	| 'else' 
	;

TYPE :
	| 'String'
	| 'Integer'
	| 'Boolean' 
	;

BOOL_VAL : 
	| 'true'
	| 'false' 
	;

WORD :
	| [a-zA-Z]+ 
	;

INTEGER_VAL :
	| [0-9]+ 
	;

INTERPUNCT :
	| ','
	| '.'
	| '?'
	| '!'
	;

COLON :
	| ':'
	;

SQ :
	| '\''
	;

WS	: 
	[ \t\r\n]+ ->skip ;


