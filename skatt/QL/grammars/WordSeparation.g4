grammar WordSeparation;

@header
{
package WordSeparation;
}
 
// PARSER
program : (part)+;
 
part: WORD | WORD ':';

// LEXER

WORD     : ('a'..'z'|'A'..'Z')+;
WS: [ \t\n\r]+ -> skip ;