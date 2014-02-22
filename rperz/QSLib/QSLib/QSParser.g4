parser grammar QSParser;

@members
{
	protected const int EOF = Eof;
	public Form root;
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
	using System.Collections.Generic;
	using System.Linq;
	using System.Text;
}

form returns [Form f]
@after
{
   root = f;
}
	:
	  FORM a=code_block { $f = new Form($a.c); }
	;

code_block returns [CodeBlock c]
@init
{
	List<IStatement> al = new List<IStatement>();
}
	:
	  L_BRACKET (st=statement)+ { al.Add($st.s); } R_BRACKET  { $c = new CodeBlock(al); }
	;

string_literal :
	    SQ (WORD+ INTERPUNCT?)+ SQ
	  ;

statement returns [IStatement s]
	:
	  a=question_statement { $s = $a.q; }
	//| conditional_statement 
	;

question_statement returns [Question q]
	:
	  a=question b=type_declaration { $q = new Question($a.s, $b.e); }
	;

question returns [QSString s]
	:
	  a=string_literal { $s = new QSString($a.text); }
	;


type_declaration returns [Identifier e]
	:
	  a=assignment COLON TYPE_STRING { $a.e.SetType = "".GetType(); }
	| a=assignment COLON TYPE_BOOL	 { $a.e.SetType = true.GetType(); }
	| a=assignment COLON TYPE_INTEGER  { $a.e.SetType = 1.GetType(); }
	;


assignment returns [Identifier e]
	:
	  id=WORD ASSIGN v=expression { $e = new Identifier($id.text, $v.e); }
	| id=WORD	{ $e = new Identifier($id.text); }
	;

expression returns [IExpression e]
	:
	  a=math_expression { $e = $a.e; }
	| b=boolean_expression { $e = $b.e; }
	| c=comparative_expression { $e = $c.e; }
	;

math_expression returns [IExpression e]
	: 
	  l=math_expression MULTIPLY r=math_expression { $e = new Multiply($l.e, $r.e); } // multiply and divide have higher precedence
	| l=math_expression DIVIDE r=math_expression { $e = new Divide($l.e, $r.e); } 
	| l=math_expression PLUS r=math_expression { $e = new Add($l.e, $r.e); }
	| l=math_expression MINUS r=math_expression { $e = new Subtract($l.e, $r.e); } // than plus and minus 
	| num_val 
	;
	
condition returns [IExpression e]
	:
	  a=boolean_expression { $e = $a.e; }
	| b=comparative_expression { $e = $b.e; }
	;

boolean_expression returns [IExpression e]
	: 
	  NOT a=boolean_expression					 { $e = new Not($a.e); } // not has highest precedence but
	| c=boolean_expression AND b=boolean_expression  { $e = new And($c.e, $b.e); } // and has higher precedence
	| c=boolean_expression OR b=boolean_expression   { $e = new Or($c.e, $b.e); } // than or
	| comparative_expression
	| bool_val									
	;

comparative_expression returns [IExpression e]
	:
	   l=num_val SMALLER r=num_val { $e = new SmallerThan($l.e, $r.e); }
	 | l=num_val SMALLEREQUALS r=num_val { $e = new SmallerThan_Equals($l.e, $r.e); }
	 | l=num_val EQUALS r=num_val { $e = new Equals($l.e, $r.e); }
	 | l=num_val NOTEQUALS r=num_val { $e = new NotEquals($l.e, $r.e); }
	 | l=num_val LARGEREQUALS r=num_val { $e = new LargerThan_Equals($l.e, $r.e); }
	 | l=num_val LARGER r=num_val { $e = new LargerThan($l.e, $r.e); }
	;

num_val returns [IExpression e]
	:
	  v=NUMBER { $e = new QSNumber(Int32.Parse($v.text)); }
	;

bool_val returns [IExpression e]
	:
	  v=BOOL_VAL { $e = new QSBoolean(Boolean.Parse($v.text)); }
	;




/*	 
conditional_statement 
	:
	  if_statement else_statement?
	;

if_statement 
	:
	  IF L_HOOK condition R_HOOK code_block
	;

else_statement 
	:
	  ELSE code_block
	| ELSE if_statement
	;
*/
