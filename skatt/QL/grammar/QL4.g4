grammar QL4;

@header {
  package QL4;
}

/////////////// Parser
// upper level 
form : structures;
structures : structure+;

structure :  
      question #questionStruct 
      | 'if' ifexpr=expression '{' ifstruc=structures '}' ('elseif' elseifexp=expression '{' elseifstruc=structures '}')* ('else'  '{' elsestruc=structures '}')? #conditional    
      ;

question: 
      IDENTIFIER ':' LABEL ':' TYPE ';' #regQuestion 
      | IDENTIFIER ':' LABEL ':' TYPE '(' expression ')' ';' #compQuestion
      ; 

// expressions
expression: 
      '(' expression ')' #wrapExpr  
        
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

LABEL: STRING;

////////// lexer

COMMENT : '//' .*? -> skip ;

TYPE: 'boolean' | 'string' | 'integer' | 'date' | 'decimal' | 'currency' ;

BOOLEAN : 'true' | 'false';
IDENTIFIER:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING : '"' (' '..'~')* '"';
DEC : ('-')? ('0'..'9')* '.' ('0'..'9')*;
INT    : ('-')? ('1'..'9')('0'..'9')* | '0';
WS     : [ \t\n\r]+ -> skip ;
