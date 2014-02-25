grammar QL4;

/////////////// Parser
// upper level 
form : structures;
structures : (structure)+;
structure : ( 
			question 
			| ifcondition '{' structures '}' (elseifcondition '{' structures '}')+ elsecondition '{' structures '}'    
			| ifcondition '{' structures '}' (elseifcondition '{' structures '}')+
			| ifcondition '{' structures '}' elsecondition '{' structures '}'   
			| ifcondition '{' structures '}'
			);

ifcondition : IF expression;
elseifcondition : ELSEIF expression;
elsecondition : ELSE;

question: IDENTIFIER ':' label ':' TYPE ';' 
		  | IDENTIFIER ':' label ':' TYPE '('expression')' ';'; 

// expressions
expression: '(' expression ')' #wrapExpr  
		  | expression ('*'|'/') expression #multExpr
		  | expression ('+'|'-') expression #plusExpr
		  | '!' expression #negExpr
		  | expression ('&&' | '||') expression #logExpr 
		  | expression ('==' | '>=' | '<=' | '<' | '>' | '!=' ) expression #compExpr
		  | BOOLEAN #boolExpr
		  | DEC #decExpr
		  | INT #intExpr 
		  | IDENTIFIER #identExpr
		  ;

// lower level components
label: STRING;
TYPE: 'boolean' | 'string' | 'integer' | 'date' | 'decimal' | 'currency';

////////// lexer

IF: 'if';
ELSEIF: 'elseif';
ELSE: 'else'; 
BOOLEAN : 'true' | 'false';
IDENTIFIER:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING : '"' (' '..'~')* '"';
DEC : ('0'..'9')* '.' ('0'..'9')*;
INT    : ('1'..'9')('0'..'9')* | '0';
WS     : [ \t\n\r]+ -> skip ;