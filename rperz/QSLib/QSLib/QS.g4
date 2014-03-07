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
	using QSLib;
	using QSLib.Expressions;
	using QSLib.Expressions.Unary;
	using QSLib.Expressions.Binary;
	using QSLib.Expressions.Literals;
	using QSLib.Statements;
	using QSLib.Types;

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

question_statement returns [Question q]
	:
	  a=STRING_LITERAL b=type_declaration { $q = new Question(new QSString($a.text,$a.line), $b.e, $a.line); }
	;

type_declaration returns [Identifier e]
@init
{
	bool optionalExpr = false;
	bool optionalType = false;
}
	:

	  id=WORD (ASSIGN v=expression { optionalExpr = true; })? COLON TYPE_BOOL 
					{ 
						if(optionalExpr)
						{
							$e = new Identifier($id.text, new BoolType(), $v.e, $id.line);  
						}
						else 
						{
							$e = new Identifier($id.text, new BoolType(), $id.line);  
						}
					}
	| id=WORD (ASSIGN v=expression { optionalExpr = true; })? COLON TYPE_INTEGER  
					{ 
						if(optionalExpr)
						{
							$e = new Identifier($id.text, new NumberType(), $v.e, $id.line);  
						}
						else 
						{
							$e = new Identifier($id.text, new NumberType(), $id.line);  
						}
					}
	 | id=WORD (ASSIGN v=expression { optionalExpr = true; })? (COLON TYPE_STRING { optionalType = true; })? 
					{ 
						if(optionalExpr && optionalType)
						{
							$e = new Identifier($id.text, new StringType(), $v.e, $id.line);  
						}
						else if(optionalType)
						{
							$e = new Identifier($id.text, new StringType(), $id.line);
						}	  
						else if(optionalExpr)
						{
							$e = new Identifier($id.text, $v.e, $id.line); 
						}
						else
						{
							$e = new Identifier($id.text, $id.line);  
						}
					}
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
	  l=expression o=MULTIPLY r=expression { $e = new Multiply($l.e, $r.e, $o.line); } 
	| l=expression o=DIVIDE r=expression { $e = new Divide($l.e, $r.e, $o.line); } 
	| l=expression o=PLUS r=expression { $e = new Add($l.e, $r.e, $o.line); }
	| l=expression o=MINUS r=expression { $e = new Subtract($l.e, $r.e, $o.line); } 
	| o=NOT a=expression					 { $e = new Not($a.e, $o.line); } 
	| c=expression o=AND b=expression  { $e = new And($c.e, $b.e, $o.line); } 
	| c=expression o=OR b=expression   { $e = new Or($c.e, $b.e, $o.line); } 
	| l=expression o=SMALLER r=expression { $e = new SmallerThan($l.e, $r.e, $o.line); }
	| l=expression o=SMALLEREQUALS r=expression { $e = new SmallerThan_Equals($l.e, $r.e, $o.line); }
	| l=expression o=EQUALS r=expression { $e = new Equals($l.e, $r.e, $o.line); }
	| l=expression o=NOTEQUALS r=expression { $e = new NotEquals($l.e, $r.e, $o.line); }
	| l=expression o=LARGEREQUALS r=expression { $e = new LargerThan_Equals($l.e, $r.e, $o.line); }
	| l=expression o=LARGER r=expression { $e = new LargerThan($l.e, $r.e, $o.line); }	
	| d=num_val { $e = $d.e ; } 
	| g=bool_val { $e = $g.e ; } 
	| f=type_declaration { $e = $f.e ; } 
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
	  [0-9]+ 
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
	    SQ ((WORD+ INTERPUNCT?)|[ \t\r\n])+ SQ
	  ;

NEWLINE
    :  '\r'? '\n'
    ;

WS
    :   (' ' | '\r' | '\n' | '\t' | '\f')+ -> skip
    ;

