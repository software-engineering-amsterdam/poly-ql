/**
 * Antlr 4 grammar for Questionnaire Language.
 * Ivan Plantevin, February 2014
 */

grammar QL;

form: 'form' ID block;

block: '{' stat* '}';

stat: 'if' '(' expr ')' stat 'else' stat        # ifElse
    | 'if' '(' expr ')' stat                    # if
    | block                                     # blockStat
    | ID ':' STR type '(' expr ')'              # computation
    | ID ':' STR type                           # question
    ;

// Antlr handles precedence. Highest precedence first.
expr: op=('+'|'-'|'!') expr                     # unary
    | expr op=('*'|'/') expr                    # multiplication
    | expr op=('+'|'-') expr                    # addition
    | expr op=('<'|'>'|'<='|'>='|'=='|'!=') expr# comparison
    | expr op=('&&'|'||') expr                  # logical
    | bool                                      # boolean
    | ID                                        # identifier
    | INT                                       # integer
    | STR                                       # string
    | '(' expr ')'                              # parantheses
    ;

type: 'boolean'
    | 'integer'
    | 'string';

bool: 'true'
    | 'false';

// Tokens
ID: [a-zA-Z][a-zA-Z0-9_]*;

INT: [0-9]+;

STR: '"' .*? '"';

COMMENT:  '/*' .*? '*/' -> skip; // Skip comments

COMMENT2: '//' .*? '\r'? '\n' -> skip; // Skip comments

WS: [ \t\r\n]+ -> skip ; // Skip spaces and tabs