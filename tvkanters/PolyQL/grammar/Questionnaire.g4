grammar Questionnaire;

@header {
    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.model.*;
    import nl.uva.polyql.model.expressions.*;
}


form returns [Form f]
	@init { $f = new Form(); } :
	'form' ID '{' (r = formrule[$f])+ '}';

formrule[RuleContainer rc] : 
	question[$rc] | ifstatement[$rc];

question[RuleContainer rc] : 
	id=ID ':' content=STRING type=TYPE { $rc.addQuestion($id.text, $content.text, $type.text); };

ifstatement[RuleContainer rc] returns [IfStatement is]
	@init { $is = $rc.addIfStatement(); } : 
	'if' '(' e=expr_comp_bool[$is] { $is.setExpression($e.e); } ')' '{' (r = formrule[$rc])+ '}';

expr_comp_bool[Rule r] returns [Expression e] :
	(left=expr_comp_num[$r]{$e = $left.e;}) (op=OP_COMP_BOOL right=expr_comp_num[$r]{$e = new BooleanOperation($r, $e, $op.text, $right.e);} )* ;

expr_comp_num[Rule r] returns [Expression e] :
	(left=expr_sum[$r]{$e = $left.e;}) (op=OP_COMP_NUM right=expr_sum[$r]{$e = new BooleanOperation($r, $e, $op.text, $right.e);} )* ;

expr_sum[Rule r] returns [Expression e] :
	(left=expr_prod[$r]{$e = $left.e;}) (op=OP_SUM right=expr_prod[$r]{$e = new NumberOperation($r, $e, $op.text, $right.e);} )* ;

expr_prod[Rule r] returns [Expression e] :
	(left=expr_atom[$r]{$e = $left.e;}) (op=OP_PROD right=expr_atom[$r]{$e = new NumberOperation($r, $e, $op.text, $right.e);} )* ;

expr_atom[Rule r] returns [Expression e] :
	mod=MODIFIER?ID { $e = new IdAtom($r, $ID.text, $mod.text); }
	| NUMBER { $e = new NumberAtom($r, $NUMBER.text); }
	| '(' expr=expr_comp_bool[$r]{ $e = $expr.e; } ')' ;



OP_COMP_BOOL : ('=='|'!='|'&&'|'||');
OP_COMP_NUM : ('<'|'>'|'>='|'<=');
OP_SUM : ('+'|'-');
OP_PROD : ('*'|'/');
MODIFIER : ('!'|'-');

TYPE : ('boolean'|'number');
ID : LETTER (LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | PUNCTUATION)+ '?' '"';
LETTER : ('a'..'z'|'A'..'Z');
NUMBER : '-'?DIGIT+('.'DIGIT+)?;
DIGIT : ('0'..'9');
WS : (' '|'\n'|'\r'|'\t')+ {skip();} ;
PUNCTUATION : ('\''|','|'.'|'?'|'!'|' ');
