grammar Questionnaire;

@header {
    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.ast.*;
    import nl.uva.polyql.ast.expressions.*;
    import nl.uva.polyql.ast.expressions.operations.*;
}


form returns [Form f] :
	'form' ID { $f = new Form($ID.text); } '{' (r = formrule[$f])* '}';

formrule[RuleContainer rc] :
	calcquestion[$rc] | question[$rc] | ifstatement[$rc] | COMMENT;
	
calcquestion[RuleContainer rc] returns [CalculatedQuestion cq] : 
	id=ID ':' label=STRING type=TYPE '(' e=expr_main[$rc] ')' { $cq = $rc.addCalculatedQuestion($id.text, $label.text, $type.text, $e.e); };

question[RuleContainer rc] returns [Question q] : 
	id=ID ':' label=STRING type=TYPE { $q = $rc.addQuestion($id.text, $label.text, $type.text); };

ifstatement[RuleContainer rc] returns [IfStatement is, ElseStatement es] :
	'if' '(' e=expr_main[$rc] { $is = $rc.addIfStatement($e.e); } ')' '{' formrule[$is]* '}'
	('else' { $es = $rc.addElseStatement($e.e); } '{' formrule[$es]* '}')?;

expr_main[RuleContainer rc] returns [Expression e] :
	expr=expr_or[$rc] { $e = $expr.e; };

expr_or[RuleContainer rc] returns [Expression e] :
	left=expr_and[$rc] { $e = $left.e; } (op=op_or right=expr_and[$rc] { $e = new BinaryOperation($e, $op.text, $right.e); })*;

expr_and[RuleContainer rc] returns [Expression e] :
	left=expr_eq[$rc] { $e = $left.e; } (op=op_and right=expr_eq[$rc] { $e = new BinaryOperation($e, $op.text, $right.e); })*;

expr_eq[RuleContainer rc] returns [Expression e] :
	left=expr_num[$rc] { $e = $left.e; } (op=op_eq right=expr_num[$rc] { $e = new BinaryOperation($e, $op.text, $right.e); })*;

expr_num[RuleContainer rc] returns [Expression e] :
	left=expr_sum[$rc] { $e = $left.e; } (op=op_num right=expr_sum[$rc] { $e = new BinaryOperation($e, $op.text, $right.e); })*;

expr_sum[RuleContainer rc] returns [Expression e] :
	left=expr_prod[$rc] { $e = $left.e; } (op=op_sum right=expr_prod[$rc] { $e = new BinaryOperation($e, $op.text, $right.e); })*;

expr_prod[RuleContainer rc] returns [Expression e] :
	left=expr_unary[$rc] { $e = $left.e; } (op=op_prod right=expr_unary[$rc] { $e = new BinaryOperation($e, $op.text, $right.e); })*;

expr_unary[RuleContainer rc] returns [Expression e] :
	op=op_unary unary=expr_unary[$rc] { $e = new UnaryOperation($op.text, $unary.e); }
	| expr=expr_atom[$rc] { $e = $expr.e; };

expr_atom[RuleContainer rc] returns [Expression e] :
	ID { $e = new QuestionAtom($rc, $ID.text); }
	| NUMBER { $e = new NumberAtom($NUMBER.text); }
	| STRING { $e = new StringAtom($STRING.text); }
	| BOOLEAN { $e = new BooleanAtom($BOOLEAN.text); }
	| '(' expr=expr_main[$rc] { $e = $expr.e; } ')' ;


op_or : '||' | '|';
op_and : '&&';
op_eq : '==' | '!=';
op_num : '<' | '>' | '>=' | '<=';
op_sum : '+' | '-';
op_prod : '*' | '/';
op_unary : '!' | '-';

COMMENT : '//' ~('\n' | '\r')*;
TYPE : 'boolean' | 'number' | 'string';
BOOLEAN : 'true' | 'false';
ID : LETTER (LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | PUNCTUATION)* '"';
LETTER : 'a'..'z' | 'A'..'Z';
NUMBER : '-'?DIGIT+('.'DIGIT+)?;
DIGIT : '0'..'9';
WS : (' ' | '\n' | '\r' | '\t')+ { skip(); };
PUNCTUATION : '\'' | ',' | '.' | '?' | '!' | ' ' | '(' | ')' | ':' | ';';
