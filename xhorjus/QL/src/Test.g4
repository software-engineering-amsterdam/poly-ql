/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar Test;

questionnare    : 'form' title '{' block+ '}';

title           : TITLE;
block           : ifblock | question; 

question		: qid ASSIGNMENT '"' qcontent '"' qtype;
qid             : QUESTIONTITLE;
qcontent        : .+?;
qtype           : 'boolean' | 'int' | 'string';

ifblock         : 'if' LP expr RP '{' question+ '}' 'else' '{' question+ '}'
                | 'if' LP expr RP '{' question+ '}';

expr            : expr '*' expr  # Mul
                | expr '/' expr  # Div
                | expr '+' expr  # Add
                | expr '-' expr  # Sub
                | expr '>' expr  # Gt
                | expr '<' expr  # Lt
                | expr '>=' expr # GtEq
                | expr '<=' expr # LtEq
                | expr '==' expr # Eq
                | expr '!=' expr # Neq
                | '!' expr       # Neg
                | '(' expr ')'   # parens                
                | qid            # QuestionID
                | INT            # Int;

INT             : [0-9]+;
TITLE           : [A-Z][a-zA-Z0-9]*;
QUESTIONTITLE   : [a-z][a-zA-Z0-9]*;
ASSIGNMENT      : ':';
LP              : '(';
RP              : ')'; 
WS              : [ \t\r\n]+ -> skip ;