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
     
qitwrapper: qit;     
     
qit: identifier ': "'question'"'type              #QitStat
   | identifier ': "'question'"'type '(' expr ')' #QitExprStat
   ;
   
type: 'boolean' 
    | 'money' 
    | 'text'
    ;

ifcon : 'if(' expr ') {' block+ '}' 'else' '{' block+ '}' #IfElseStat
      | 'if(' expr ') {' block+ '}'                     #IfStat
      ;

expr: '!' expr       # NegOp
    | '(' expr ')'   # ParOp
    | expr '*' expr  # MulOp
    | expr '/' expr  # DivOp
    | expr '+' expr  # AddOp
    | expr '-' expr  # SubOp
    | expr '%' expr  # ModOp
    | expr '>' expr  # GtOp
    | expr '<' expr  # LtOp
    | expr '>=' expr # GtEqOp
    | expr '<=' expr # LtEqOp
    | expr '==' expr # EqOp
    | expr '!=' expr # NeqOp
    | expr '&&' expr # AndOp
    | expr '||' expr # OrOp         
    | identifier     # QID
    | INT            # Int;

// QL Tokens
FORMNAME: [A-Z][a-zA-Z0-9]*;
IDENTIFIER: [a-z][a-zA-Z0-9]*;
QUESTION: [A-Z][a-zA-Z0-9\\?: ]*;

// Misc
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip ;