grammar QL4;

@header {
	package Form2;
}

/////////////// Parser
// upper level 
form : structures;
structures : structure+;

structure :  
			question #questionStruct 
			| ifcondition '{' structures '}' (elseifcondition '{' structures '}')* (elsecondition '{' structures '}')? #workflowStruct    
			;


question: 
			IDENTIFIER ':' label ':' TYPE ';' #regQuestion 
		  | IDENTIFIER ':' label ':' TYPE '('expression')' ';' #compQuestion
		  ; 

// expressions
expression: '(' expression ')' #wrapExpr  
	      
	      // math expressions
		  | expression '*' expression #multExpr
		  | expression '/' expression #divExpr
		  | expression '+' expression #plusExpr
		  | expression '-' expression #minExpr
		  
		  // logical expressions
		  | '!' expression #negExpr
		  | expression '&&' expression #andExpr
		  | expression '||' expression #orExpr 
		  | expression '==' expression #eqExpr
		  | expression '>=' expression #geqExpr
		  | expression '<=' expression #leqExpr
		  | expression '>' expression #greExpr
		  | expression '<' expression #lesExpr
		  | expression '!=' expression #neqExpr
		  
		  // single elements expressions
		  | BOOLEAN #bool
		  | DEC #dec
		  | INT #int 
		  | IDENTIFIER #ident
		  ;

// lower level components
ifcondition : IF expression;
elseifcondition : ELSEIF expression;
elsecondition : ELSE;

label: STRING;

////////// lexer

COMMENT : '//' .*? -> skip ;

TYPE: 'boolean' | 'string' | 'integer' | 'date' | 'decimal' | 'currency' ;

IF: 'if';
ELSEIF: 'elseif';
ELSE: 'else'; 

BOOLEAN : 'true' | 'false';
IDENTIFIER:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING : '"' (' '..'~')* '"';
DEC : ('0'..'9')* '.' ('0'..'9')*;
INT    : ('1'..'9')('0'..'9')* | '0';
WS     : [ \t\n\r]+ -> skip ;