// CSV.g  
grammar FormGrammar; 

@header{
	import main.nl.uva.parser.elements.expressions.*;
	import main.nl.uva.parser.elements.operations.*;
	import main.nl.uva.parser.elements.statements.*;
	import main.nl.uva.parser.elements.expressions.*;
	import main.nl.uva.parser.elements.type.*;
}

forms returns [List<ParserForm> data] 
@init {$data = new ArrayList<ParserForm>();}
	:(f=form {$data.add($f.f);})+ EOF  
	;

form returns [ParserForm f]
	: 'form' id=ID children=block {$f = new ParserForm($id.text, $children.data);}  
	;

//Adds all subelements inside the block to the parent statement
block returns [List<Statement> data]
@init {$data = new ArrayList<Statement>();}
	: (LINEEND)*? '{' LINEEND (child=statement { $data.add($child.current);})* '}' (LINEEND)*?;

statement returns [Statement current]
	: ID ':' STRING sType=simpleType LINEEND					
	{
		$current = new DeclarationStatement($ID.text, $sType.type, $STRING.text);
	}
	
    | ID ':' STRING sType=simpleType '(' ex=expression')'  	
    {
    	$current = new ExpressionStatement($ID.text, $sType.type, $STRING.text, $ex.cEx);
    } LINEEND
    
    | 'if' '(' ex=expression ')' ifBlock=block 
    {$current = new IFStatement($ex.cEx, $ifBlock.data);} 				
    
    | 'if' '(' ex=expression ')' ifBlock=block 'else' elseBlock=block
    { $current = new IfElseStatement($ex.cEx, $ifBlock.data, $elseBlock.data);} 
    ;

expression returns [Expression cEx]
	: left=boolExp {$cEx = $left.cEx;} 
	;

boolExp returns [Expression cEx]
	: left=addExp {$cEx = $left.cEx;} 
  (AND right=addExp {$cEx = new AndExpression($left.cEx, $right.cEx);} | OR right=addExp {$cEx = new OrExpression($left.cEx, $right.cEx);})*
	;

addExp returns [Expression cEx]
  : left=multExp {$cEx = $left.cEx;} 
  (ADD right=multExp {$cEx = new AdditionExpression($left.cEx, $right.cEx);} | SUB right=multExp {$cEx = new SubstractionExpression($left.cEx, $right.cEx);})*
  ;

multExp returns [Expression cEx]
  : left=atom {$cEx = $left.cEx;} 
  (MUL right=atom {$cEx = new MultiplicationExpression($left.cEx, $right.cEx);} | DIV right=atom {$cEx = new MultiplicationExpression($left.cEx, $right.cEx);})*
  ;

atom returns [Expression cEx]
	: ID {$cEx = new Variable($ID.text);}
	| nL=numLiteral {$cEx = new Money($nL.text);}
	| bL=boolLiteral {$cEx = new Bool($bL.text);}
	| '(' bE=boolExp ')' {$cEx = $bE.cEx;}
	;

simpleType returns [Variable.Types type]
	: BOOLEAN {$type = Variable.Types.BOOL;}
    | MONEY {$type = Variable.Types.MONEY;}
    | TEXT {$type = Variable.Types.TEXT;}
    ;

boolLiteral
	: TRUE  
    | FALSE 
    ;

numLiteral
	: INTEGER
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
