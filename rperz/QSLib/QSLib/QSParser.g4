parser grammar QSParser;

@header
{
	using QSLib.Expressions;
}

@members
{
	protected const int EOF = Eof;
}

form 
	:
	  FORM code_block
	;

code_block 
	:
	  L_BRACKET statement+ R_BRACKET
	;

statement 
	:
	  question_statement
	| conditional_statement 
	;

question_statement 
	:
	  question type_declaration
	;

question 
	:
	  SQ (WORD+ INTERPUNCT?)+ SQ 
	;

type_declaration 
	:
	  assignment COLON TYPE_STRING 
	| assignment COLON TYPE_BOOL
	| assignment COLON TYPE_INTEGER
	;

assignment 
	:
	  id=WORD ASSIGN v=expression { $e = new OutputVariable($id, $v); }
	| WORD	{ $e = new InputVariable($id); }
	;

expression 
	:
	  math_expression
	| boolean_expression
	| comparative_expression
	;

math_expression returns [Expression e]
	: 
	  l=math_expression MULTIPLY r=math_expression { $e = new Multiply($l, $r) } // multiply and divide have higher precedence
	| l=math_expression DIVIDE r=math_expression { $e = new Divide($l, $r); } 
	| l=math_expression PLUS r=math_expression { $e = new Add($l, $r); }
	| l=math_expression MINUS r=math_expression { $e = new Subtract($l, $r); } // than plus and minus
	| NUMBER
	| WORD	  
	;
	
condition 
	:
	  boolean_expression
	| comparative_expression
	;

boolean_expression returns [Expression e]
	: 
	  NOT v=boolean_expression					 { $e = new Not($v); } // not has highest precedence but
	| l=boolean_expression AND r=boolean_expression  { $e = new And($l, $r); } // and has higher precedence
	| l=boolean_expression OR r=boolean_expression   { $e = new Or($l, $r); } // than or
	| c=comparative_expression { $e=$c; }
	| v=BOOL_VAL  { $e = new Bool($v); }
	;

comparative_expression returns [Expression e]
	:
	   l=value SMALLER r=value { $e = new SmallerThan($l, $r); }
	 | l=value SMALLEREQUALS r=value { $e = new SmallerThan_Equals($l, $r); }
	 | l=value EQUALS r=value { $e = new Equals($l, $r); }
	 | l=value NOTEQUALS r=value { $e = new NotEquals($l, $r); }
	 | l=value LARGEREQUALS r=value { $e = new LargerThan_Equals($l, $r); }
	 | l=value LARGER r=value { $e = new LargerThan($l, $r); }
	;
	 
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


value  :
	  WORD 
	| NUMBER
	| BOOL_VAL
	;
