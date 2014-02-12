/**
 * Antlr 4 grammar for Questionnaire Language.
 * Ivan Plantevin, February 2014
 */

grammar QL;

r2: 'hello' ID ;

r: 'hello' STR;

form: 'form' ID block;

block: '{' statement* '}';

statement: computedQuestion
         | regularQuestion;
//         | if
//         | ifElse

computedQuestion: name ':' label type '(' expr ')';

regularQuestion: name ':' label type;

name: ID;

label: STR;

expr: expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | ID
    | INT;

type: 'boolean'
    | 'integer'
    | 'string';

bool: 'true'
    | 'false';

// Tokens
ID: [a-zA-Z][a-zA-Z0-9_]*;

INT: [0-9]+;

STR: '"' ~('"')* '"';

COMMENT: '/*' .* '*/' -> skip; // Skip comments

//NEWLINE: [\r\n];

WS: [ \t\r\n]+ -> skip ; // Skip spaces and tabs