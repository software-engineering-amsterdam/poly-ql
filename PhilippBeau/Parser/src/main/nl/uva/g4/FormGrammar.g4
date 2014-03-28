grammar FormGrammar; 

@header {
	import main.nl.uva.parser.expression.*;
	import main.nl.uva.parser.statement.*;
	import main.nl.uva.parser.expression.*;
	import main.nl.uva.parser.expression.unary.*;
	import main.nl.uva.validation.type.*;
	import main.nl.uva.parser.*;
}

form returns [Form parsedForm]
	: 'form' id=ID children=block {$parsedForm= new Form($id.text, $children.data, new Line($id));} EOF
	;

block returns [List<Statement> data]
@init {$data = new ArrayList<Statement>();}
	: (LINEEND)*? '{' LINEEND (child=statement { $data.add($child.current);})* '}' (LINEEND)*?;

statement returns [Statement current]
	: ID ':' sLit=STRING sType=simpleType 
	{$current = new Declaration(new Variable($sType.type, $ID.text, new Line($ID)), $sLit.text);}
	LINEEND 
	
    | ID ':' sLit=STRING sType=simpleType '(' ex=expression')'  	
    { $current = new FixedDeclaration(new Variable($sType.type, $ID.text, $ex.cEx, new Line($ID)), $sLit.text);} 
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
  	| DIV right=prefix {$cEx = new Division($cEx, $right.cEx, new Line($DIV));}
  )*
  ;

prefix returns [Expression cEx]
	: bE=atom {$cEx = $bE.cEx;}
	| token='!' bEN=prefix {$cEx = new Not($bEN.cEx, new Line($token));}
	| token='-' bEM=prefix {$cEx = new Minus($bEM.cEx, new Line($token));}
	;

atom returns [Expression cEx]
	: ID {$cEx = new VariableAtom($ID.text, new Line($ID)); }
	| nL=moneyLiteral {$cEx = new UnaryExpression($nL.money, new Line($nL.start));}
	| bL=boolLiteral {$cEx = new UnaryExpression($bL.bool, new Line($bL.start));}
	| tL=textLiteral {$cEx = new UnaryExpression($tL.string, new Line($tL.start));}
	| '(' bE=expression ')' {$cEx = $bE.cEx;}
	;

simpleType returns [Value.Type type]
	: BOOLEAN {$type = Value.Type.BOOLEAN;}
    | MONEY {$type = Value.Type.MONEY;}
    | TEXT {$type = Value.Type.TEXT;}
    ;

boolLiteral returns [Bool bool]
	: TRUE {$bool = new Bool(true);}
    | FALSE {$bool = new Bool(false);} 
    ;
      
textLiteral returns [Text string]
	: STRING {$string = new Text($STRING.text.substring(1, $STRING.text.length()-1));}
	;
	
moneyLiteral returns [Money money]
	: INTEGER {$money = new Money(Double.parseDouble($INTEGER.text));}
	| DOUBLE {$money = new Money(Double.parseDouble($DOUBLE.text));}
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
