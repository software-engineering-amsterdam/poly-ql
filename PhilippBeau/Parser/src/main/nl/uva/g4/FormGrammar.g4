// CSV.g  
grammar FormGrammar; 

@header{import main.nl.uva.parser.elements.*;}

forms returns [List<ParserForm> data] 
@init {$data = new ArrayList<ParserForm>();}
	:(f=form {$data.add($f.f);})+ EOF  
	;

form returns [ParserForm f]
	: 'form' id=ID b=block {$f = new ParserForm($id.text, $b.ifs);}
	;

block returns [List<Statement> ifs]
@init {$ifs = new ArrayList<Statement>();}
	: (LINEEND)*? '{' LINEEND (parserIF=stat {$ifs.add($parserIF.parserIF);})* '}' (LINEEND)*?;

stat returns [Statement parserIF]
	: ID ':' STRING statType LINEEND				{$parserIF = new SimpleStatement($ID.text);}
    | ID ':' STRING statType '(' expr ')' LINEEND 	{$parserIF = new ExpressionStatement($ID.text);}
    | 'if' '(' ex=expr ')' b=block					{$parserIF = new IFStatement($ex.text, $b.ifs);}
    | 'if' '(' ex=expr ')' block 'else' block		{$parserIF = new IfElseStatement($ex.text);}
    ;

// The precedence is given by the order
expr: unaryOp expr                                
    | expr multiplicativeOp expr                  
    | expr additiveOp expr                        
    | expr relationalOp expr                      
    | expr equalityOp expr                        
    | expr AND expr                               
    | expr OR expr                                
    | boolLiteral                                 
    | ID                                          
    | numLiteral                                  
    | STRING                                      
    | '(' expr ')'                                
    ;

// Statement types
statType: BOOLEAN 
        | MONEY   
        | TEXT    
        ;

// Unary Operators
unaryOp: ADD 
       | SUB 
       | NOT 
       ;

// Multiplicative Operators
multiplicativeOp: MUL 
                | DIV 
                | MOD 
                ;

// Additive Operators
additiveOp: ADD
          | SUB
          ;

// Relational Operators
relationalOp: LOWER_THAN
            | GRATER_THAN
            | LOWER_EQUAL_THAN
            | GRATER_EQUAL_THAN
            ;

// Equality Operators
equalityOp: EQUAL
          | NOT_EQUAL
          ;

// Boolean Values
boolLiteral: TRUE  
           | FALSE 
           ;

// Number Types
numLiteral: INTEGER
          | DOUBLE
          ;
          
/** Primitives */

INTEGER: [0-9]+;
DOUBLE :  INTEGER '.' INTEGER;
STRING: '"' ('\\"' | '\\\\'|.)*? '"';
LINEEND: '\r'? '\n'; //

/** Boolean */
BOOLEAN: 'boolean';
TRUE: 'true';
FALSE: 'false';

/** Boolean utils*/
AND: '&&';
OR: '||';
NOT: '!';
LOWER_THAN: '<';
GRATER_THAN: '>';
LOWER_EQUAL_THAN: '<=';
GRATER_EQUAL_THAN: '>=';
EQUAL: '==';
NOT_EQUAL: '!=';

/** Mathematical */
MUL: '*';
DIV: '/';
MOD: '%';
ADD: '+';
SUB: '-';

/** Custom data types */
MONEY:   'money';
TEXT:    'text';

/** ID datatype  */
ID: [a-zA-Z_]+ [a-zA-Z_0-9]*; 

/** All skip rules */
WS: [ \t]+ -> skip;                     
LINE_COMMENT: '//' .*? LINEEND -> skip; 
COMMENT: '/*' .*? '*/' -> skip;
