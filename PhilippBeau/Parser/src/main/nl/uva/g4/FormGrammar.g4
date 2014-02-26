// CSV.g  
grammar FormGrammar; 

@header{import main.nl.uva.parser.elements.*;}

forms returns [List<ParserForm> data] 
@init {$data = new ArrayList<ParserForm>();}
	:(f=form {$data.add($f.f);})+ EOF  
	;

form returns [ParserForm f]
	: 'form' id=ID {$f = new ParserForm($id.text, null);} block[$f] //{$f.addBlock($b.ifs)} 
	;

block[Statement parentStatement] //returns [List<Statement> ifs]
//@init {$ifs = new ArrayList<Statement>();}
	: (LINEEND)*? '{' LINEEND (child=statement[$parentStatement] {$parentStatement.addChild($child.current);})* '}' (LINEEND)*?;

statement[Statement parentStatement] returns [Statement current]
	: ID ':' STRING sType=statType LINEEND					{$current = new SimpleStatement($ID.text, $parentStatement, $sType.text, $STRING.text);}
    | ID ':' STRING sType=statType '(' expr ')' LINEEND 	{$current = new ExpressionStatement($ID.text, $parentStatement);}
    | 'if' '(' ex=expr ')' {$current = new IFStatement($ex.text, $parentStatement);} block[$current]							
    | 'if' '(' ex=expr ')' {$current = new IfElseStatement($ex.text, $parentStatement);} block[$current] 'else' block[$current]				
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

/** Boolean operators*/
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
