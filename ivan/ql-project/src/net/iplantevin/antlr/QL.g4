/**
 * Antlr 4 grammar for Questionnaire Language.
 * Ivan Plantevin, February 2014
 */

//Comlicated test expression: ! (bla == true && number < 10 + 1 / -5) || switch == true && input != "female"

grammar QL;

r2: 'hello' ID ;

r: 'hello' STR+;

form: 'form' ID block;

block: '{' statement* '}';

statement: ID ':' STR type '(' expr ')'         # computation
         | ID ':' STR type                      # question
         ;

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