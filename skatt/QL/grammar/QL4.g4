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
      | 'if' ifexpr=expression '{' ifstruc=structures '}' ('elseif' expression '{' structures '}')* ('else'  '{' elsestruc=structures '}')? #conditional    
      ;

question: 
      IDENTIFIER ':' LABEL ':' TYPE ';' #regQuestion 
      | IDENTIFIER ':' LABEL ':' TYPE '(' expression ')' ';' #compQuestion
      ; 

// expressions
expression: 
      '(' expression ')' #wrapExpr  
        
        // math expressions
      | lhs=expression '*' rhs=expression #multExpr
      | lhs=expression '/' rhs=expression #divExpr
      | lhs=expression '+' rhs=expression #plusExpr
      | lhs=expression '-' rhs=expression #minExpr
      
      // logical expressions
      | '!' expression #negExpr
      | lhs=expression '&&' rhs=expression #andExpr
      | lhs=expression '||' rhs=expression #orExpr 
      | lhs=expression '==' rhs=expression #eqExpr
      | lhs=expression '>=' rhs=expression #geqExpr
      | lhs=expression '<=' rhs=expression #leqExpr
      | lhs=expression '>' rhs=expression #greExpr
      | lhs=expression '<' rhs=expression #lesExpr
      | lhs=expression '!=' rhs=expression #neqExpr
      
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
