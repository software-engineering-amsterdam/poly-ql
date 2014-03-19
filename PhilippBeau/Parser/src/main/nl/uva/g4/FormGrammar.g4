grammar FormGrammar; 

@header{
	import main.nl.uva.parser.element.expression.*;
	import main.nl.uva.parser.element.statement.*;
	import main.nl.uva.parser.element.expression.*;
	import main.nl.uva.parser.element.expression.atom.*;
	import main.nl.uva.parser.element.type.*;
	import main.nl.uva.parser.element.*;
}

form returns [Form parsedForm]
	: 'form' id=ID children=block {$parsedForm= new Form($id.text, $children.data, new Line($id));} EOF
	;

block returns [List<Statement> data]
@init {$data = new ArrayList<Statement>();}
	: (LINEEND)*? '{' LINEEND (child=statement { $data.add($child.current);})* '}' (LINEEND)*?;

statement returns [Statement current]
	: ID ':' sLit=stringLiteral sType=simpleType 
	{$current = new Declaration(new Variable($sType.type, $ID.text, new Line($ID)), $sLit.string);}
	LINEEND 
	
    | ID ':' sLit=stringLiteral sType=simpleType '(' ex=expression')'  	
    { $current = new FixedDeclaration(new Variable($sType.type, $ID.text, $ex.cEx, new Line($ID)), $sLit.string);} 
    LINEEND
    
    | ifToken='if' '(' ex=expression ')' ifBlock=block 
    {$current = new IfThen($ex.cEx, $ifBlock.data, new Line($ifToken));} 				
    
    | ifToken='if' '(' ex=expression ')' ifBlock=block elseToken='else' elseBlock=block
    { $current = new IfThenElse($ex.cEx, $ifBlock.data, $elseBlock.data, new Line($ifToken));} 
    ;

expression returns [Expression cEx]
	: left=orExp {$cEx = $left.cEx;} 
	;

orExp returns [Expression cEx]
	: left=andExp {$cEx = $left.cEx;} 
  (
  	 OR right=andExp {$cEx = new Or($cEx, $right.cEx, new Line($OR));}
  )*
	;
	
andExp returns [Expression cEx]
	: left=equalExp {$cEx = $left.cEx;} 
  (
  	 AND right=equalExp {$cEx = new And($cEx, $right.cEx, new Line($AND));}
  )*
	;
	
equalExp returns [Expression cEx]
	: left=differenceExp {$cEx = $left.cEx;} 
  (
	EQUAL right=differenceExp {$cEx = new Equal($cEx, $right.cEx, new Line($EQUAL));}
  	| NOT_EQUAL right=differenceExp {$cEx = new UnEqual($cEx, $right.cEx, new Line($EQUAL));}
  )*
	;

differenceExp returns [Expression cEx]
	: left=addExp {$cEx = $left.cEx;} 
  (
	LOWER_THAN right=addExp {$cEx = new LowerThan($cEx, $right.cEx, new Line($LOWER_THAN));}
  	| GRATER_THAN right=addExp {$cEx = new GraterThan($cEx, $right.cEx, new Line($GRATER_THAN));}
  	| LOWER_EQUAL_THAN right=addExp {$cEx = new LowerEqualThan($cEx, $right.cEx, new Line($LOWER_EQUAL_THAN));}
  	| GRATER_EQUAL_THAN right=addExp {$cEx = new GraterEqualThan($cEx, $right.cEx, new Line($GRATER_EQUAL_THAN));}
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
  ( 
	MUL right=prefix {$cEx = new Multiplication($cEx, $right.cEx, new Line($MUL));} 
  	| DIV right=prefix {$cEx = new Multiplication($cEx, $right.cEx, new Line($DIV));}
  )*
  ;

prefix returns [Expression cEx]
	: bE=atom {$cEx = $bE.cEx;}
	| token='!' bEN=notPrefix {$cEx = new Not($bEN.cEx, new Line($token));}
	| token='-' bEM=minusPrefix {$cEx = new Minus($bEM.cEx, new Line($token));}
	;
	
notPrefix returns [Expression cEx]
	: bE=atom {$cEx = $bE.cEx;}
	| token='!' bEA=notPrefix {$cEx = new Not($bEA.cEx, new Line($token));}
	;

minusPrefix returns [Expression cEx]
	: bE=atom {$cEx = $bE.cEx;}
	| token='-' bEM=minusPrefix {$cEx = new Minus($bEM.cEx, new Line($token));}
	;

atom returns [Expression cEx]
	: ID {$cEx = new VariableAtom($ID.text, new Line($ID)); }
	| nL=numLiteral {$cEx = new MoneyAtom($nL.text, new Line($nL.start));}
	| bL=boolLiteral {$cEx = new BoolAtom($bL.text, new Line($bL.start));}
	| tL=stringLiteral {$cEx = new TextAtom($tL.string, new Line($tL.start));}
	| '(' bE=expression ')' {$cEx = $bE.cEx;}
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
      
stringLiteral returns [String string]
	: STRING {$string = new String($STRING.text.substring(1, $STRING.text.length()-1));}
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
