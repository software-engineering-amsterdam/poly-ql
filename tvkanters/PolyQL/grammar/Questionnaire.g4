grammar Questionnaire;

@header {
    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.model.*;
    import nl.uva.polyql.model.expressions.*;
}


form returns [Form f]
	@init { $f = new Form(); } :
	'form' ID '{' (r = formrule { $f.addRule($r.r); })+ '}';

formrule returns [Rule r] : 
	(q = question { $r = $q.q; }) | (is = ifstatement { $r = $is.is; });

question returns [Question q]
	@init { $q = new Question(); } : 
	ID { $q.setId($ID.text); } ':' STRING { $q.setContent($STRING.text); } TYPE { $q.setType($TYPE.text); };

ifstatement returns [IfStatement is]
	@init { $is = new IfStatement(); } :
	'if' '(' e=expr_comp_bool { $is.setExpression($e.e); } ')' '{' (r = formrule { $is.addRule($r.r); })+ '}';

expr_comp_bool returns [Expression e] :
	(left=expr_comp_num{$e = $left.e;}) (op=OP_COMP_BOOL right=expr_comp_num{$e = new BooleanOperation($e, $op.text, $right.e);} )* ;

expr_comp_num returns [Expression e] :
	(left=expr_sum{$e = $left.e;}) (op=OP_COMP_NUM right=expr_sum{$e = new BooleanOperation($e, $op.text, $right.e);} )* ;

expr_sum returns [Expression e] :
	(left=expr_prod{$e = $left.e;}) (op=OP_SUM right=expr_prod{$e = new NumberOperation($e, $op.text, $right.e);} )* ;

expr_prod returns [Expression e] :
	(left=expr_atom{$e = $left.e;}) (op=OP_PROD right=expr_atom{$e = new NumberOperation($e, $op.text, $right.e);} )* ;

expr_atom returns [Expression e] :
	ID { $e = new IdAtom($ID.text); }
	| NUMBER { $e = new NumberAtom($NUMBER.text); }
	| '(' expr=expr_comp_bool { $e = $expr.e; } ')' ;



OP_COMP_BOOL : ('=='|'!='|'&&'|'||');
OP_COMP_NUM : ('<'|'>'|'>='|'<=');
OP_SUM : ('+'|'-');
OP_PROD : ('*'|'/');


TYPE : ('boolean'|'number');
ID : LETTER (LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | PUNCTUATION)+ '?' '"';
LETTER : ('a'..'z'|'A'..'Z');
NUMBER : DIGIT+('.'DIGIT+)?;
DIGIT : ('0'..'9');
WS : (' '|'\n'|'\r'|'\t')+ {skip();} ;
PUNCTUATION : ('\''|','|'.'|'?'|'!'|' ');
