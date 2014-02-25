/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar Test;

@header {
	package antlr4;
}

questionnare    : 'form' title '{' block+ '}';

title           : TITLE;
block           : ifblock | question; 

question		: qid ASSIGNMENT '"' qcontent '"' qtype;
qid             : QUESTIONTITLE;
qcontent        : .+?;
qtype           : 'boolean' | 'money' | 'string';

ifblock         : 'if' LP expr RP '{' question+ '}' 'else' '{' question+ '}'
                | 'if' LP expr RP '{' question+ '}';

expr            : '!' expr       # Neg
                | '(' expr ')'   # Parentheses
				| expr '*' expr  # Mul
                | expr '/' expr  # Div
                | expr '+' expr  # Add
                | expr '-' expr  # Sub
                | expr '%' expr  # Mod
                | expr '>' expr  # Gt
                | expr '<' expr  # Lt
                | expr '>=' expr # GtEq
                | expr '<=' expr # LtEq
                | expr '==' expr # Eq
                | expr '!=' expr # Neq
                | expr '&&' expr # And
                | expr '||' expr # Or            
                | question       # QuestionID
                | INT            # Int;

INT             : [0-9]+;
TITLE           : [A-Z][a-zA-Z0-9]*;
QUESTIONTITLE   : [a-z][a-zA-Z0-9]*;
ASSIGNMENT      : ':';
LP              : '(';
RP              : ')'; 
WS              : [ \t\r\n]+ -> skip ;

/* From http://stackoverflow.com/questions/14778570/antlr-4-channel-hidden-and-options */
COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip;