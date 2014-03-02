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
	: 'form' id=ID {$f = new ParserForm($id.text, null);} block[$f] 
	;

//Adds all subelements inside the block to the parent statement
block[Statement parentStatement]
	: (LINEEND)*? '{' LINEEND (child=statement[$parentStatement] 
//		{
//			$parentStatement.addChild($child.current);
//		}
	)* '}' (LINEEND)*?;

statement[Statement parentStatement] returns [Statement current]
	: ID ':' STRING sType=simpleType LINEEND					
	{
		$current = new DeclarationStatement($ID.text, $parentStatement, $sType.type, $STRING.text);
	}
	
    | ID ':' STRING sType=simpleType  	
    {
    	$current = new ExpressionStatement($ID.text, $parentStatement, $sType.type, $STRING.text);
    } '(' ex=expression[$current] ')' LINEEND
    
    | 'if' 
    {
    	$current = new IFStatement($parentStatement);
    } '(' ex=expression[$current] ')' block[$current]							
    
    | 'if' 
    {
    	$current = new IfElseStatement($parentStatement);
    } '(' ex=expression[$current] ')' block[$current] 'else' block[$current]
    ;

expression[Statement pSt] returns [Expression cEx]
	: left=boolExp[$pSt] {$cEx = $left.cEx;} 
	;

boolExp[Statement pEx] returns [Expression cEx]
	: left=addExp[$pEx] {$cEx = $left.cEx;} 
  (AND {$cEx = new AndExpression($pEx, $cEx);} right=addExp[$cEx] {$cEx.setRight($right.cEx);} | OR {$cEx = new OrExpression($pEx, $cEx);} right=addExp[$cEx] {$cEx.setRight($right.cEx);})*
	;

addExp[Statement pEx] returns [Expression cEx]
  : left=multExp[$pEx] {$cEx = $left.cEx;} 
  (ADD {$cEx = new AdditionExpression($pEx, $cEx);}  right=multExp[$cEx] {$cEx.setRight($right.cEx);} | SUB {$cEx = new SubstractionExpression($pEx, $cEx);} right=multExp[$cEx] {$cEx.setRight($right.cEx);})*
  ;

multExp[Statement pEx] returns [Expression cEx]
  : left=atom[$pEx] {$cEx = $left.cEx;} 
  (MUL {$cEx = new MultiplicationExpression($pEx, $cEx);} right=atom[$cEx] {$cEx.setRight($right.cEx);}| DIV {$cEx = new MultiplicationExpression($pEx, $cEx);} right=atom[$cEx] {$cEx.setRight($right.cEx);})*
  ;

atom[Statement pEx] returns [Expression cEx]
	: ID {$cEx = new Variable($pEx, $ID.text);}
	| nL=numLiteral {$cEx = new Money($pEx, $nL.text);}
	| bL=boolLiteral {$cEx = new Bool($pEx, $bL.text);}
	| '(' bE=boolExp[$pEx] ')' {$cEx = $bE.cEx;}
	;

simpleType returns [Variable.Types type]
	: BOOLEAN {$type = Variable.Types.BOOL;}
    | MONEY {$type = Variable.Types.MONEY;}
    | TEXT {$type = Variable.Types.TEXT;}
    ;

//addSub returns [Operation op]
//	: ADD {$op = new Add();}
//	| SUB {$op = new Sub();}
//	;
	
//divMult returns [Operation op]
//	: MUL {$op = new Mul();}
//	| DIV {$op = new Div();}
//	;

//booleanOp returns [Operation op]
//	: AND {$op = new And();}
//	| OR {$op = new Or();}
//	;

//arithmeticOp returns [Operation op]
//	: MUL {$op = new Mul();}
//	| ADD {$op = new Add();}
//    | SUB {$op = new Sub();}
//	| DIV {$op = new Div();}
//    | MOD {$op = new Mod();}
//    ;

//comparisonOp returns [Operation op]
//	: LOWER_THAN {$op = new LowerThan();}
//    | GRATER_THAN {$op = new GraterThan();}
//    | LOWER_EQUAL_THAN {$op = new LowerEqualThan();}
//    | GRATER_EQUAL_THAN {$op = new GraterEqualThan();}
//    | EQUAL {$op = new Equal();}
//    | NOT_EQUAL {$op = new NotEqual();}
//    ;

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
