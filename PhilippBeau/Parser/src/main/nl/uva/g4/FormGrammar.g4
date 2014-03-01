// CSV.g  
grammar FormGrammar; 

@header{
	import main.nl.uva.parser.elements.expressions.*;
	import main.nl.uva.parser.elements.operations.*;
	import main.nl.uva.parser.elements.statements.*;
}

forms returns [List<ParserForm> data] 
@init {$data = new ArrayList<ParserForm>();}
	:(f=form {$data.add($f.f);})+ EOF  
	;

form returns [ParserForm f]
	: 'form' id=ID {$f = new ParserForm($id.text, null);} block[$f] 
	;

block[Statement parentStatement]
	: (LINEEND)*? '{' LINEEND (child=statement[$parentStatement] 
		{
			$parentStatement.addChild($child.current);
		}
	)* '}' (LINEEND)*?;

statement[Statement parentStatement] returns [Statement current]
	: ID ':' STRING sType=simpleType LINEEND					
	{
		$current = new SimpleStatement($ID.text, $parentStatement, $sType.text, $STRING.text);
	}
	
    | ID ':' STRING sType=simpleType '(' ex=expression ')' LINEEND 	
    {
    	$current = new ExpressionStatement($ID.text, $parentStatement);
    }
    
    | 'if' '(' ex=expression ')' 
    {
    	$current = new IFStatement($ex.currEx, $parentStatement);
    } block[$current]							
    
    | 'if' '(' ex=expression ')' 
    {
    	$current = new IfElseStatement($ex.currEx, $parentStatement);
    } block[$current] 'else' block[$current]
    ;

expression returns [Expression currEx]
  :  add=addExp {$currEx = new UnaryExpression(null, $add.text);}
  ;

addExp
  :  multExp (('+' | '-') multExp)*
  ;

multExp
  :  atom (('*' | '/') atom)*
  ;

atom
  :  ID
  |  '(' addExp ')'
  ;

//ID    : 'a'..'z' | 'A'..'Z';


mathExpression returns [Expression currEx]
	: n1=numLiteral aop=arithmeticOp n2=numLiteral  {$currEx = new BinaryExpression($aop.op, $n1.text, $n2.text);}
	| n1=numLiteral cop=comparisonOp n2=numLiteral  {$currEx = new BinaryExpression($cop.op, $n1.text, $n2.text);}
	| n1=numLiteral cop=comparisonOp mEx=mathExpression  {$currEx = new BinaryExpression($cop.op, $n1.text, $mEx.text);}
	;

simpleType
	: BOOLEAN
    | MONEY
    | TEXT
    ;

prefix returns [Operation op]
	: ADD {$op = new Add();}
	| SUB {$op = new Sub();}
	;

booleanOp returns [Operation op]
	: AND {$op = new And();}
	| OR {$op = new Or();}
	;

arithmeticOp returns [Operation op]
	: MUL {$op = new Mul();}
	| ADD {$op = new Add();}
    | SUB {$op = new Sub();}
	| DIV {$op = new Div();}
    | MOD {$op = new Mod();}
    ;

comparisonOp returns [Operation op]
	: LOWER_THAN {$op = new LowerThan();}
    | GRATER_THAN {$op = new GraterThan();}
    | LOWER_EQUAL_THAN {$op = new LowerEqualThan();}
    | GRATER_EQUAL_THAN {$op = new GraterEqualThan();}
    | EQUAL {$op = new Equal();}
    | NOT_EQUAL {$op = new NotEqual();}
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
