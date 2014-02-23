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
	using QSLib.Expressions;
	using QSLib.Expressions.Math;
	using QSLib.Expressions.Types;
	using QSLib.Expressions.Conditions.Comparison;
	using QSLib.Expressions.Conditions;
	using QSLib.Expressions.Conditions.Binary;
	using QSLib;
	using System;
	using System.Linq;
	using System.Text;
}

form returns [Form f]
	:
	  FORM a=code_block EOF { $f = new Form($a.c); }
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
	| b=conditional_statement { $s = $b.c; } 
	;

question_statement returns [Question q]
	:
	  a=STRING_LITERAL b=type_declaration { $q = new Question(new QSString($a.text,$a.line), $b.e, $a.line); }
	;

type_declaration returns [Identifier e]
	:
	  a=assignment COLON TYPE_STRING { $a.e.SetType = "".GetType(); $e = $a.e; $e.Declare();  }
	| a=assignment COLON TYPE_BOOL	 { $a.e.SetType = true.GetType(); $e = $a.e; $e.Declare();  }
	| a=assignment COLON TYPE_INTEGER  { $a.e.SetType = 1.GetType(); $e = $a.e; $e.Declare();  }
	;


assignment returns [Identifier e]
	:
	  id=WORD ASSIGN v=expression { $e = new Identifier($id.text, $v.e, $id.line); }
	| id=WORD	{ $e = new Identifier($id.text, $id.line); }
	;

num_val returns [IExpression e]
	:
	  v=NUMBER { $e = new QSNumber(Int32.Parse($v.text), $v.line); }
	;

bool_val returns [IExpression e]
	:
	  v=BOOL_VAL { $e = new QSBoolean(Boolean.Parse($v.text), $v.line); }
	;

expression returns [IExpression e]
	:
	  a=math_expression { $e = ($a.e  as IExpression); }
	| b=boolean_expression { $e = ($b.e as IExpression); }
	| c=comparative_expression { $e = ($c.e as IExpression); }
	;


math_expression returns [IExpression e]
	: 
	  l=simple_math o=MULTIPLY r=simple_math { $e = new Multiply($l.e, $r.e, $o.line); } // multiply and divide have higher precedence
	| l=simple_math o=DIVIDE r=simple_math { $e = new Divide($l.e, $r.e, $o.line); } 
	| l=simple_math o=PLUS r=simple_math { $e = new Add($l.e, $r.e, $o.line); }
	| l=simple_math o=MINUS r=simple_math { $e = new Subtract($l.e, $r.e, $o.line); } // than plus and minus 
	| a=boolean_expression  { $e = ($a.e as IExpression); }
	;

simple_math returns [IExpression e]
	: 
	  l=primary o=MULTIPLY r=simple_math { $e = new Multiply($l.e, $r.e, $o.line); } // multiply and divide have higher precedence
	| l=primary o=DIVIDE r=simple_math { $e = new Divide($l.e, $r.e, $o.line); } 
	| l=primary o=PLUS r=simple_math { $e = new Add($l.e, $r.e, $o.line); }
	| l=primary o=MINUS r=simple_math { $e = new Subtract($l.e, $r.e, $o.line); } // than plus and minus 
	| a=primary { $e = ($a.e as IExpression); }
	;


boolean_expression returns [IExpression e]
	: 
	  o=NOT a=simple_bool					 { $e = new Not($a.e, $o.line); } // not has highest precedence but
	| c=simple_bool o=AND b=simple_bool  { $e = new And($c.e, $b.e, $o.line); } // and has higher precedence
	| c=simple_bool o=OR b=simple_bool   { $e = new Or($c.e, $b.e, $o.line); } // than or
	| d=comparative_expression { $e = ($d.e as IExpression); } 
	;

simple_bool returns [IExpression e]
	: 
	  o=NOT a=primary					 { $e = new Not($a.e, $o.line); } // not has highest precedence but
	| c=primary o=AND b=simple_bool  { $e = new And($c.e, $b.e, $o.line); } // and has higher precedence
	| c=primary o=OR b=simple_bool   { $e = new Or($c.e, $b.e, $o.line); } // than or
	| a=primary { $e = ($a.e as IExpression); }
	;


comparative_expression returns [IExpression e]
    :
	  l=simple_compare o=SMALLER r=simple_compare { $e = new SmallerThan($l.e, $r.e, $o.line); }
	| l=simple_compare o=SMALLEREQUALS r=simple_compare { $e = new SmallerThan_Equals($l.e, $r.e, $o.line); }
	| l=simple_compare o=EQUALS r=simple_compare { $e = new Equals($l.e, $r.e, $o.line); }
	| l=simple_compare o=NOTEQUALS r=simple_compare { $e = new NotEquals($l.e, $r.e, $o.line); }
	| l=simple_compare o=LARGEREQUALS r=simple_compare { $e = new LargerThan_Equals($l.e, $r.e, $o.line); }
	| l=simple_compare o=LARGER r=simple_compare { $e = new LargerThan($l.e, $r.e, $o.line); }	
	| a=simple_compare  { $e = ($a.e as IExpression); }
	;

simple_compare returns [IExpression e]
    :
	  l=primary o=SMALLER r=simple_compare { $e = new SmallerThan($l.e, $r.e, $o.line); }
	| l=primary o=SMALLEREQUALS r=simple_compare { $e = new SmallerThan_Equals($l.e, $r.e, $o.line); }
	| l=primary o=EQUALS r=simple_compare { $e = new Equals($l.e, $r.e, $o.line); }
	| l=primary o=NOTEQUALS r=simple_compare { $e = new NotEquals($l.e, $r.e, $o.line); }
	| l=primary o=LARGEREQUALS r=simple_compare { $e = new LargerThan_Equals($l.e, $r.e, $o.line); }
	| l=primary o=LARGER r=simple_compare { $e = new LargerThan($l.e, $r.e, $o.line); }	
	| a=primary { $e = ($a.e as IExpression); }
	;

primary returns [IExpression e]
	:
	  d=num_val { $e = $d.e ; } 
	| g=bool_val { $e = $g.e ; } 
	| f=assignment { $e = $f.e ; } 
	;

conditional_statement returns [IfStatement c]
	:
	  a=if_statement { $c = $a.i; }
	| a=if_statement n=else_statement { $c = $a.i; $c.SetElse = $n.e; }
	;

if_statement returns [IfStatement i]
	:
	  o=IF L_HOOK a=expression R_HOOK b=code_block { $i = new IfStatement($a.e, $b.c, $o.line); }
	;

else_statement returns [ElseStatement e]
	:
	  o=ELSE a=code_block { $e = new ElseStatement($a.c, $o.line); }
	| o=ELSE b=if_statement { $e = new ElseStatement($o.line); $e.SetIf = $b.i; }
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
	  [0-9]+ 
	;

INTERPUNCT :
	  ','
	| '.'
	| '?'
	| '!'
	;

COMMENT :
	  '\\\\'
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

STRING_LITERAL :
	    SQ ((WORD+ INTERPUNCT?)|[ \t\r\n])+ SQ
	  ;

		
WS	: 
	[ \t\r\n]+ ->skip ;

