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
	field[$rc] | question[$rc] | ifstatement[$rc];
	
field[RuleContainer rc] : 
	id=ID ':' content=STRING '(' e=expr_main[$rc] ')' { $rc.addField($id.text, $content.text, $e.e); };

question[RuleContainer rc] : 
	id=ID ':' content=STRING type=TYPE { $rc.addQuestion($id.text, $content.text, $type.text); };

ifstatement[RuleContainer rc] : 
	'if' '(' e=expr_main[$rc] { $rc.addIfStatement($e.e); } ')' '{' (r = formrule[$rc])+ '}';

expr_main[RuleContainer rc] returns [Expression e] :
	expr=expr_or[$rc]{ $e = $expr.e; } ;

expr_or[RuleContainer rc] returns [Expression e] :
	(left=expr_and[$rc]{$e = $left.e;}) (op=OP_OR right=expr_and[$rc]{$e = new BooleanOperation($e, $op.text, $right.e);})* ;

expr_and[RuleContainer rc] returns [Expression e] :
	(left=expr_eq[$rc]{$e = $left.e;}) (op=OP_AND right=expr_eq[$rc]{$e = new BooleanOperation($e, $op.text, $right.e);})* ;

expr_eq[RuleContainer rc] returns [Expression e] :
	(left=expr_num[$rc]{$e = $left.e;}) (op=OP_EQ right=expr_num[$rc]{$e = new BooleanOperation($e, $op.text, $right.e);})* ;

expr_num[RuleContainer rc] returns [Expression e] :
	(left=expr_sum[$rc]{$e = $left.e;}) (op=OP_NUM right=expr_sum[$rc]{$e = new BooleanOperation($e, $op.text, $right.e);})* ;

expr_sum[RuleContainer rc] returns [Expression e] :
	(left=expr_prod[$rc]{$e = $left.e;}) (op=OP_SUM right=expr_prod[$rc]{$e = OperationHelper.getSameTypeOperation($e, $op.text, $right.e);})* ;

expr_prod[RuleContainer rc] returns [Expression e] :
	(left=expr_atom[$rc]{$e = $left.e;}) (op=OP_PROD right=expr_atom[$rc]{$e = OperationHelper.getSameTypeOperation($e, $op.text, $right.e);})* ;

expr_atom[RuleContainer rc] returns [Expression e] :
	mod=MODIFIER?ID { $e = new QuestionAtom($rc, $ID.text, $mod.text); }
	| NUMBER { $e = new NumberAtom($NUMBER.text); }
	| STRING { $e = new StringAtom($STRING.text); }
	| '(' expr=expr_main[$rc]{ $e = $expr.e; } ')' ;


OP_OR : '||';
OP_AND : '&&';
OP_EQ : ('=='|'!=');
OP_NUM : ('<'|'>'|'>='|'<=');
OP_SUM : ('+'|'-');
OP_PROD : ('*'|'/');
MODIFIER : ('!'|'-');

TYPE : ('boolean'|'number'|'string');
ID : LETTER (LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | PUNCTUATION)+ '"';
LETTER : ('a'..'z'|'A'..'Z');
NUMBER : '-'?DIGIT+('.'DIGIT+)?;
DIGIT : ('0'..'9');
WS : (' '|'\n'|'\r'|'\t')+ {skip();} ;
PUNCTUATION : ('\''|','|'.'|'?'|'!'|' '|'('|')'|':'|';');
