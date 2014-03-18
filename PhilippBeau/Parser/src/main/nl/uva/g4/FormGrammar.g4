grammar FormGrammar; 

@header{
	import main.nl.uva.parser.elements.expressions.*;
	import main.nl.uva.parser.elements.statements.*;
	import main.nl.uva.parser.elements.expressions.*;
	import main.nl.uva.parser.elements.expressions.atoms.*;
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
	: ID ':' STRING sType=simpleType 
	{$current = new DeclarationStatement(new Variable($sType.type, $ID.text), $STRING.text);}
	LINEEND 
	
    | ID ':' STRING sType=simpleType '(' ex=expression')'  	
    { $current = new ExpressionStatement(new Variable($sType.type, $ID.text, $ex.cEx), $STRING.text);} 
    LINEEND
    
    | 'if' '(' ex=expression ')' ifBlock=block 
    {$current = new IFStatement($ex.cEx, $ifBlock.data);} 				
    
    | 'if' '(' ex=expression ')' ifBlock=block 'else' elseBlock=block
    { $current = new IfElseStatement(new IFStatement($ex.cEx, $ifBlock.data), new IFStatement(new Not($ex.cEx), $elseBlock.data));} 
    ;

expression returns [Expression cEx]
	: left=boolExp {$cEx = $left.cEx;} 
	;

boolExp returns [Expression cEx]
	: left=addExp {$cEx = $left.cEx;} 
  (
  	AND right=addExp {$cEx = new And($cEx, $right.cEx);} 
  	| OR right=addExp {$cEx = new Or($cEx, $right.cEx);}
  	| EQUAL right=addExp {$cEx = new Comparrison($cEx, $right.cEx);}
  )*
	;

addExp returns [Expression cEx]
  : left=multExp {$cEx = $left.cEx;} 
  (
  	ADD right=multExp {$cEx = new Addition($cEx, $right.cEx);} 
  	| SUB right=multExp {$cEx = new Substraction($cEx, $right.cEx);}
  )*
  ;

multExp returns [Expression cEx]
  : left=prefix {$cEx = $left.cEx;} 
  (MUL right=prefix {$cEx = new Multiplication($cEx, $right.cEx);} 
  	| DIV right=prefix {$cEx = new Multiplication($cEx, $right.cEx);}
  )*
  ;

prefix returns [Expression cEx]
	: '!' bE=atom {$cEx = new Not($bE.cEx);}
	| '-' bE=atom {$cEx = new Minus($bE.cEx);}
	| at=atom {$cEx = $at.cEx;}
	;

atom returns [Expression cEx]
	: ID {$cEx = new VariableAtom($ID.text);}
	| nL=numLiteral {$cEx = new MoneyAtom($nL.text);}
	| bL=boolLiteral {$cEx = new BoolAtom($bL.text);}
	| '(' bE=boolExp ')' {$cEx = $bE.cEx;}
	;

simpleType returns [Value type]
	: BOOLEAN {$type = new Bool();}
    | MONEY {$type = new Money();}
    | TEXT {$type = new Text();}
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
