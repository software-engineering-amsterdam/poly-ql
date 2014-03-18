grammar FormGrammar; 

@header{
	import main.nl.uva.parser.element.expression.*;
	import main.nl.uva.parser.element.statement.*;
	import main.nl.uva.parser.element.expression.*;
	import main.nl.uva.parser.element.expression.atom.*;
	import main.nl.uva.parser.element.type.*;
	import main.nl.uva.parser.element.*;
}

//forms returns [List<Form> data] 
//@init {$data = new ArrayList<Form>();}
//	:(f=form {$data.add($f.f);})+ EOF  
//	;

form returns [Form parsedForm]
	: 'form' id=ID children=block {$parsedForm= new Form($id.text, $children.data, new Line($id));} EOF
	;

//Adds all subelements inside the block to the parent statement
block returns [List<Statement> data]
@init {$data = new ArrayList<Statement>();}
	: (LINEEND)*? '{' LINEEND (child=statement { $data.add($child.current);})* '}' (LINEEND)*?;

statement returns [Statement current]
	: ID ':' STRING sType=simpleType 
	{$current = new Declaration(new Variable($sType.type, $ID.text, new Line($ID)), $STRING.text);}
	LINEEND 
	
    | ID ':' STRING sType=simpleType '(' ex=expression')'  	
    { $current = new FixedDeclaration(new Variable($sType.type, $ID.text, $ex.cEx, new Line($ID)), $STRING.text);} 
    LINEEND
    
    | ifToken='if' '(' ex=expression ')' ifBlock=block 
    {$current = new IF($ex.cEx, $ifBlock.data, new Line($ifToken));} 				
    
    | ifToken='if' '(' ex=expression ')' ifBlock=block elseToken='else' elseBlock=block
    { $current = new IfElse(new IF($ex.cEx, $ifBlock.data, new Line($ifToken)), new IF(new Not($ex.cEx, Line.NO_LINE_NUMBER), $elseBlock.data, new Line($elseToken)), new Line($ifToken));} 
    ;

expression returns [Expression cEx]
	: left=boolExp {$cEx = $left.cEx;} 
	;

boolExp returns [Expression cEx]
	: left=addExp {$cEx = $left.cEx;} 
  (
  	AND right=addExp {$cEx = new And($cEx, $right.cEx, new Line($AND));} 
  	| OR right=addExp {$cEx = new Or($cEx, $right.cEx, new Line($OR));}
  	| EQUAL right=addExp {$cEx = new Comparrison($cEx, $right.cEx, new Line($EQUAL));}
  )*
	;

addExp returns [Expression cEx]
  : left=multExp {$cEx = $left.cEx;} 
  (
  	ADD right=multExp {$cEx = new Addition($cEx, $right.cEx, new Line($ADD));} 
  	| SUB right=multExp {$cEx = new Substraction($cEx, $right.cEx, new Line($SUB));}
  )*
  ;

multExp returns [Expression cEx]
  : left=prefix {$cEx = $left.cEx;} 
  (MUL right=prefix {$cEx = new Multiplication($cEx, $right.cEx, new Line($MUL));} 
  	| DIV right=prefix {$cEx = new Multiplication($cEx, $right.cEx, new Line($DIV));}
  )*
  ;

prefix returns [Expression cEx]
	: token='!' bE=atom {$cEx = new Not($bE.cEx, new Line($token));}
	| token='-' bE=atom {$cEx = new Minus($bE.cEx, new Line($token));}
	| at=atom {$cEx = $at.cEx;}
	;

atom returns [Expression cEx]
	: ID {$cEx = new VariableAtom($ID.text, new Line($ID)); }
	| nL=numLiteral {$cEx = new MoneyAtom($nL.text, new Line($nL.start));}
	| bL=boolLiteral {$cEx = new BoolAtom($bL.text, new Line($bL.start));}
	| '(' bE=boolExp ')' {$cEx = $bE.cEx;}
	;

simpleType returns [Value.Type type]
	: BOOLEAN {$type = Value.Type.BOOLEAN;}
    | MONEY {$type = Value.Type.MONEY;}
    | TEXT {$type = Value.Type.TEXT;}
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
