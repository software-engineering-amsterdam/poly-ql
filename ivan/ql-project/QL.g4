/**
 * Antlr 4 grammar for Questionnaire Language.
 * Ivan Plantevin, February 2014
 */

grammar QL;

r2 : 'hello' ID ;

// Tokens
ID : [a-zA-Z][a-zA-Z0-9_]*;

INT : [0-9]+;

STR : '"' .* '"';

COMMENT : '/*' .* '*/' -> skip; // Skip comments

WS : [ \t\n]+ -> skip ; // Skip spaces, tabs, newlines