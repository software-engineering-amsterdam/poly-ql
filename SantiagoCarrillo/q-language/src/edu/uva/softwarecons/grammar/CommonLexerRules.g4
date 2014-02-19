lexer grammar CommonLexerRules; // note "lexer grammar"

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

// Identifiers
ID  :   [a-zA-Z0-9]+ ;      

//Numbers
INT :   [0-9]+ ;         

STRING :  '"' (ESC | ~["\\])* '"' ;

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

WS  :  [ \n\t\r]+ -> skip ; // toss out whitespace

