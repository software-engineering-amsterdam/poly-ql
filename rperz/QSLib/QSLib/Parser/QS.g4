 grammar QS;

@parser::members
{
	protected const int EOF = Eof;
}

@lexer::members
{
	protected const int HIDDEN = Hidden;
	protected const int EOF = Eof;
}

@header
{
	using QSLib.AST;
	using QSLib.AST.Expressions.Nullary;
	using QSLib.AST.Expressions;
	using QSLib.AST.Expressions.Unary;
	using QSLib.AST.Expressions.Binary;
	using QSLib.AST.Expressions.Literals;
	using QSLib.AST.Statements;
	using QSLib.AST.Types;

	using System;
	using System.Linq;
	using System.Text;
}

form returns [Form f]
	:
	  b=FORM a=code_block EOF { $f = new Form($a.c, $b.line); }
	;

code_block returns [CodeBlock c]
	:
	  L_BRACKET a=statement_list R_BRACKET  { $c = new CodeBlock($a.al); } 
	;

statement_list returns [List<IStatement> al]
@init
{
	$al = new List<IStatement>();
}
	:
		(st=statement { $al.Add($st.s); })+ 
	;


statement returns [IStatement s]
	:
	  a=question_statement { $s = $a.q; }
	| b=if_statement { $s = $b.i; } 
	;

question_statement returns [IStatement q]
@init
{
	QSType type;
}
	:
	  a=STRING_LITERAL id=WORD ASSIGN v=expression COLON (TYPE_BOOL {type = new BoolType(); } |
														  TYPE_INTEGER {type = new IntegerType(); } |
														  TYPE_STRING {type = new StringType(); })	
														{ 
															$q = new ComputedQuestion($a.text.Substring(1, $a.text.Length - 2), $id.text, $v.e, type, $a.line); 
														}
	|  a=STRING_LITERAL id=WORD COLON (TYPE_BOOL {type = new BoolType(); } |
									  TYPE_INTEGER {type = new IntegerType(); } |
									  TYPE_STRING {type = new StringType(); })	
														{ 
															$q = new Question(type, $a.text.Substring(1, $a.text.Length - 2), $id.text, $a.line); 
														}

	;

num_val returns [QSExpression e]
	:
	  v=NUMBER { $e = new QSInteger(Int32.Parse($v.text), $v.line); }
	;

bool_val returns [QSExpression e]
	:
	  v=BOOL_VAL { $e = new QSBoolean(Boolean.Parse($v.text), $v.line); }
	;

expression returns [QSExpression e]
	:  
	  l=expression o=MULTIPLY r=expression { $e = new Multiply($l.e, $r.e, $o.line); } 
	| l=expression o=DIVIDE r=expression { $e = new Divide($l.e, $r.e, $o.line); } 
	| l=expression o=PLUS r=expression { $e = new Add($l.e, $r.e, $o.line); }
	| l=expression o=MINUS r=expression { $e = new Subtract($l.e, $r.e, $o.line); } 
	| o=NOT a=expression					 { $e = new Not($a.e, $o.line); } 
	| c=expression o=AND b=expression  { $e = new And($c.e, $b.e, $o.line); } 
	| c=expression o=OR b=expression   { $e = new Or($c.e, $b.e, $o.line); } 
	| l=expression o=SMALLER r=expression { $e = new LessThan($l.e, $r.e, $o.line); }
	| l=expression o=SMALLEREQUALS r=expression { $e = new LessThan_Equals($l.e, $r.e, $o.line); }
	| l=expression o=EQUALS r=expression { $e = new Equals($l.e, $r.e, $o.line); }
	| l=expression o=NOTEQUALS r=expression { $e = new NotEquals($l.e, $r.e, $o.line); }
	| l=expression o=LARGEREQUALS r=expression { $e = new GreaterThan_Equals($l.e, $r.e, $o.line); }
	| l=expression o=LARGER r=expression { $e = new GreaterThan($l.e, $r.e, $o.line); }	
	| d=num_val { $e = $d.e ; } 
	| g=bool_val { $e = $g.e ; } 
	| f=WORD { $e = new Identifier($f.text, $f.line) ; } 
	| L_HOOK l=expression R_HOOK { $e = $l.e; }
	;

if_statement returns [IfStatement i]
	:
	  o=IF L_HOOK a=expression R_HOOK b=code_block { $i = new IfStatement($a.e, $b.c, $o.line); }
	| o=IF L_HOOK a=expression R_HOOK b=code_block c=else_statement { $i = new IfStatement($a.e, $b.c, $c.c, $o.line); }
	;

else_statement returns [CodeBlock c]
@init
{
	List<IStatement> code = new List<IStatement>();
}
	:
	  o=ELSE a=code_block { $c = $a.c; }
	| o=ELSE b=if_statement {	code.Add($b.i);
								$c = new CodeBlock(code); }
	;



// lexer


IF :
	  'if' 
	;

ELSE : 
	  'else' 
	;

FORM :
	  'form'
	;

TYPE_STRING :
	  'String'
	;
TYPE_INTEGER :
	 'Integer'
	;
TYPE_BOOL :
	  'Boolean' 
	;

BOOL_VAL : 
	  'true'
	| 'false' 
	;

LARGEREQUALS :
	  '>='
	;
SMALLEREQUALS :
	  '<='
	;

NOTEQUALS :
	  '!='
	;

EQUALS :
	  '=='
	;

SMALLER :
	  '<'
	;
LARGER :
	  '>'
	;

ASSIGN :
	  '='
	;

WORD :
	  [a-zA-Z]+ 
	;

NUMBER :
	  '-'?[0-9]+ 
	;

INTERPUNCT :
	  ','
	| '.'
	| '?'
	| '!'
	| '\''
	;

PLUS :
	  '+'
	;

MINUS :
	  '-'
	;

MULTIPLY : 
	  '*'
	;

DIVIDE :
	  '/'
	;

OR :
	  '||'
	;

AND :
	  '&&'
	;

NOT :
	  '!'
	;

COLON :
	  ':'
	;

SQ :
	  '\"'
	;

L_HOOK :
	  '('
	;

R_HOOK :
	  ')'
	;

L_BRACKET :
	  '{'
	;

R_BRACKET :
	  '}'
	;

COMMENT
    :   '//' ~('\r' | '\n')* NEWLINE? -> skip
    ;

STRING_LITERAL :
	    SQ (L_HOOK (WORD+ INTERPUNCT?) R_HOOK|(WORD+ INTERPUNCT?)|[ \t\r\n])+ SQ
	  ;

NEWLINE
    :  '\r'? '\n'
    ;

WS
    :   (' ' | '\r' | '\n' | '\t' | '\f')+ -> skip
    ;

