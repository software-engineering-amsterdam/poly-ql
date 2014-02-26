/**
 * Antlr 4 grammar for Questionnaire Language.
 * Ivan Plantevin, February 2014
 */

grammar QL;

forms: form*;

form: 'form' ID block;

block: '{' stat* '}';

stat: 'if' '(' expr ')' stat 'else' stat        # ifElse
    | 'if' '(' expr ')' stat                    # if
    | block                                     # blockStat
    | ID ':' STR type '(' expr ')'              # computation
    | ID ':' STR type                           # question
    ;

// Antlr handles precedence. Highest precedence first.
expr: op=(ADD|SUB|NOT) expr                     # unary
    | expr op=(MUL|DIV) expr                    # multiplication
    | expr op=(ADD|SUB) expr                    # addition
    | expr op=(LT|GT|LEQ|GEQ) expr              # relational
    | expr op=(EQ|NEQ) expr                     # equality
    | expr AND expr                             # logicalAnd
    | expr OR expr                              # logicalOr
    | bool                                      # boolean
    | ID                                        # identifier
    | INT                                       # integer
    | STR                                       # string
    | '(' expr ')'                              # parantheses
    ;

type: BOOLEAN   # boolType
    | INTEGER   # intType
    | STRING    # strType
    ;

bool: TRUE      # true
    | FALSE     # false
    ;


// Operator tokens
NOT: '!';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
LT:  '<';
GT:  '>';
LEQ: '<=';
GEQ: '>=';
EQ:  '==';
NEQ: '!=';
AND: '&&';
OR:  '||';

// Terminal keyword tokens
BOOLEAN: 'boolean';
INTEGER: 'integer';
STRING: 'string';
TRUE: 'true';
FALSE: 'false';

// Other tokens
ID: [a-zA-Z][a-zA-Z0-9_]*;
INT: [0-9]+;
COMMENT:  '/*' .*? '*/' -> skip; // Skip comments
COMMENT2: '//' .*? '\r'? '\n' -> skip; // Skip comments
WS: [ \t\r\n]+ -> skip ; // Skip spaces and tabs
STR: '"' (ESC|.)*? '"' ;

fragment
ESC : '\\"' | '\\\\' ; // Allow escaped 2-char sequences \" and \\
