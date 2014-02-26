grammar Form;

@header {
	package Form;
}

/////////////// Parser
// upper level 
form : (question | construct)+;

construct : condition '{' (question | construct)+ '}';
condition : IF expression;

question: IDENTIFIER ':' label ':' TYPE ';' 
		  | IDENTIFIER ':' label ':' TYPE '('expression')' ';'; 

// expressions
expression: '(' expression ')'  
		  | expression ('*'|'/') expression
		  | expression ('+'|'-') expression
		  | '!' expression
		  | expression ('&&' | '||') expression 
		  | expression ('==' | '>=' | '<=' | '<' | '>' | '!=' ) expression
		  | INT | IDENTIFIER;

// lower level components
label: STRING;

////////// lexer
TYPE: 'boolean' | 'string' | 'integer' | 'date' | 'decimal' | 'currency';
IF: 'if';
IDENTIFIER:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING : '"' (' '..'~')* '"';
INT    : ('0'..'9') | (('1'...'9')('0'...'9')+);
WS     : [ \t\n\r]+ -> skip ;