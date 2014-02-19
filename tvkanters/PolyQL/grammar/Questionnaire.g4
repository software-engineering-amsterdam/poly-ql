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

/*
expr_comp_bool returns [Expression e]
	@init { $e = new Expression(); } :
	(left=expr_comp_num op=OP_COMP_BOOL{$e.setOperation($left.e, $op.text)})* right=expr_comp_num{$e.setRight($right.e)}  ; */
expr_comp_bool returns [Operation e] :
	(left=expr_comp_num{$e = new Operation($left.e);}) (op=OP_COMP_BOOL right=expr_comp_num{$e.setOperation($op.text, $right.e); $e = new Operation($e);} )* ;
expr_comp_num returns [Operation e] :
	(left=expr_sum{$e = new Operation($left.e);}) (op=OP_COMP_NUM right=expr_sum{$e.setOperation($op.text, $right.e); $e = new Operation($e);} )* ;
expr_sum returns [Operation e] :
	(left=expr_prod{$e = new Operation($left.e);}) (op=OP_SUM right=expr_prod{$e.setOperation($op.text, $right.e); $e = new Operation($e);} )* ;
expr_prod returns [Operation e] :
	(left=expr_atom{$e = new Operation($left.e);}) (op=OP_PROD right=expr_atom{$e.setOperation($op.text, $right.e); $e = new Operation($e);} )* ;
//expr_atom returns [Expression e]
//	@init { $e = new Expression(); } :
//	(left=expr_atom{$e.setLeft($left.e);}) (op=OP_PROD right=expr_atom{$e.setOperation($op.text, $right.e); $e = new Expression($e);} )* ; 
	
//expr_comp_num returns [Expression e]
//	@init { $e = new Expression(); } :
//	expr_sum (OP_COMP_NUM expr_sum)* ;
//expr_sum:   expr_mult (OP_SUM expr_mult)* ;
//expr_mult:  expr_atom (OP_PROD expr_atom)* ;
expr_atom returns [Expression e] :
	ID { $e = new IdAtom($ID.text); }
	| NUMBER { $e = new NumberAtom($NUMBER.text); }
	| '(' expr=expr_comp_bool { $e = $expr.e; } ')' ;



OP_COMP_BOOL : ('=='|'!='|'&&'|'||');
OP_COMP_NUM : ('<'|'>'|'>='|'<=');
OP_SUM : ('+'|'-');
OP_PROD : ('*'|'/');


TYPE : ('boolean'|'money');
ID : (LETTER | DIGIT)+;
STRING : '"' (LETTER | DIGIT | PUNCTUATION)+ '?' '"';
LETTER : ('a'..'z'|'A'..'Z');
NUMBER : DIGIT+('.'DIGIT+)?;
DIGIT : ('0'..'9');
WS : (' '|'\n'|'\r'|'\t')+ {skip();} ;
PUNCTUATION : ('\''|','|'.'|'?'|'!'|' ');
