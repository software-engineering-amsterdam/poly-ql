parser grammar QSParser;

@header
{
	using QSLib.Classes.Expression.Conditions.Binary;
	using QSLib.Classes.Expression.Conditions.Comparison;
	using QSLib.Classes.Math;
	using QSLib.Classes.Expression.Conditions;
	using QSLib.Classes.Types;
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
	  assignment COLON TYPE
	;

assignment 
	:
	  WORD ASSIGN expression
	| WORD
	;

expression 
	:
	  math_expression
	| boolean_expression
	| comparative_expression
	;
	
math_expression 
	: 
	  math_expression MULTDIV math_expression // multiply and divide have higher precedence 
	| math_expression PLUSMIN math_expression // than plus and minus
	| NUMBER
	| WORD
	;

condition 
	:
	  boolean_expression
	| comparative_expression
	;

boolean_expression returns [Boolean_Expression e]
	: 
	  NOT boolean_expression					 { $e = new Not(); } // not has highest precedence but
	| boolean_expression AND boolean_expression  { $e = new And(); } // and has higher precedence
	| boolean_expression OR boolean_expression   { $e = new Or(); } // than or
	| v=BOOL_VAL  { $e = new BooleanValue(); }
	;

comparative_expression 
	:
	  comparative_expression COMPARE comparative_expression
	| NUMBER
	| WORD
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



