grammar QL;

@header {
	package antlr4;
}

questionnaire: 'form' formname '{' block+ '}';
formname: FORMNAME;
identifier: IDENTIFIER;
question: QUESTION;
block: qit 
     | ifcon; 
     
qit: identifier ASS '"'question'"'type              #QitStat
   | identifier ASS '"'question'"'type '(' expr ')' #QitExprStat
   ;
   
type: 'boolean' 
    | 'money' 
    | 'text'
    ;

ifcon : 'if(' expr ') {' qit+ '}' 'else' '{' qit+ '}' #IfStat
      | 'if(' expr ') {' qit+ '}'                     #IfElseStat
      ;

expr: '!' expr       # Neg
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
    | identifier     # QuestionID
    | INT            # Int;

// QL Tokens
FORMNAME: [A-Z][a-zA-Z0-9]*;
IDENTIFIER: [a-z][a-zA-Z0-9]*;
QUESTION: [A-Z][a-zA-Z0-9\\?: ]*;

// Misc
ASS: ':';
LP: '(';
RP: ')'; 
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip ;