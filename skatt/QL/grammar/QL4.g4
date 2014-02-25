grammar QL4;

/////////////// Parser
// upper level 
form : structures;
structures : structure+;

structure : ( 
			question 
			| ifcondition '{' structures '}' (elseifcondition '{' structures '}')* (elsecondition '{' structures '}')?    
			);


question: IDENTIFIER ':' label ':' TYPE ';' #regQuestion 
		  | IDENTIFIER ':' label ':' TYPE '('expression')' ';' #compQuestion
		  ; 

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
ifcondition : IF expression;
elseifcondition : ELSEIF expression;
elsecondition : ELSE;

label: STRING;

////////// lexer

TYPE: 'boolean' | 'string' | 'integer' | 'date' | 'decimal' | 'currency';

IF: 'if';
ELSEIF: 'elseif';
ELSE: 'else'; 

BOOLEAN : 'true' | 'false';
IDENTIFIER:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING : '"' (' '..'~')* '"';
DEC : ('0'..'9')* '.' ('0'..'9')*;
INT    : ('1'..'9')('0'..'9')* | '0';
WS     : [ \t\n\r]+ -> skip ;