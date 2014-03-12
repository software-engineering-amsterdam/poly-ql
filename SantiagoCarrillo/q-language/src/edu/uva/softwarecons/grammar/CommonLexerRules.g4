lexer grammar CommonLexerRules; // note "lexer grammar"

//Types
BOOL_TYPE : 'boolean' ;
STRING_TYPE : 'string' ;
INT_TYPE : 'integer' ;
DATE_TYPE    : 'date' ;
DECIMAL_TYPE : 'decimal' ;
MONEY_TYPE   : 'money' ;


//Basic arithmetic 
MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;

//Booleans
NOT :   '!' ;
AND :   '&&' ;
OR :   	'||' ;

//Comparisons
LT  :   '<'  ; 
LEq	:	'<=' ;
GT	:	'>' ;
GEq	:	'>=' ;
Eq  :	'==' ;
NEq :	'!=' ;

//Booleans
BOOLEAN  :  'true'|'false';

//Conditionals
IF   :   'if' ;
ELSE :   'else';

// Identifiers
ID  :   [a-zA-Z][a-zA-Z0-9]*;

//Numbers
INT :   [0-9]+ ;



STRING :  '"' (ESC | ~["\\])* '"' ;

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;


COMMENT: '//' .*? '\r'? '\n' -> skip;
MULTYLINE_COMMENT:  '/*' .*? '*/' -> skip;


WS  :  [ \n\t\r]+ -> skip ;


