grammar Form2;

@header {
	package Form2;
}

/////////////// Parser
// upper level 
form : (structure)+;

structure : ( 
			question 
			| ifcondition '{' (structure)+ '}' (elseifcondition '{' (structure)+ '}')+ elsecondition '{' (structure)+ '}'    
			| ifcondition '{' (structure)+ '}' (elseifcondition '{' (structure)+ '}')+
			| ifcondition '{' (structure)+ '}' (elsecondition '{' (structure)+ '}')+    
			| ifcondition '{' (structure)+ '}'
			);

ifcondition : IF expression;
elseifcondition : ELSEIF expression;
elsecondition : ELSE;

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
ELSEIF: 'elseif';
ELSE: 'else'; 
IDENTIFIER:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING : '"' (' '..'~')* '"';
INT    : '0'..'9'+;
WS     : [ \t\n\r]+ -> skip ;