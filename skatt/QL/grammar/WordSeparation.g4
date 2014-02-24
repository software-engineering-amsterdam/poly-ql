grammar WordSeparation;

@header
{
package WordSeparation;
}
 
// PARSER
program : (part)+ end;
 
part: WORD ':';
end: WORD;

// LEXER
WORD     : ('a'..'z'|'A'..'Z')+;
WS: [ \t\n\r]+ -> skip ;