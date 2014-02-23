grammar QL;

@parser::members
{
	protected const int EOF = Eof;
	public Questionnaire theQuestionnaire;
}

@lexer::members
{
	protected const int EOF = Eof;
	protected const int HIDDEN = Hidden;
}

@header {
	using System;
	using System.Collections.Generic;
	using System.Linq;
	using QL.QLClasses;
	using QL.QLClasses.Statements;
	using QL.QLClasses.Expressions;
	using QL.QLClasses.Expressions.Unary;
	using QL.QLClasses.Expressions.Math;
	using QL.QLClasses.Expressions.Conditions;
	using QL.QLClasses.Expressions.Conditions.BinaryExpressions;
	using QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators;
	using QL.QLClasses.Expressions.Types;
}

/*
 * Parser Rules
 */
 
questionnaire
	@init	
	{	
		List<StatementBase> statements = new List<StatementBase>(); 
	}
	: 'form' ASSIGN title=STRING 
		LBRACKET 
			(sts=statement{statements.Add($sts.result);})* 
		RBRACKET														{theQuestionnaire = new Questionnaire{Title = $title.text, Body = statements};}
	;

statement returns [StatementBase result]
	: qs_st=question_stmt SEMICOLON										{$result = $qs_st.result;}
	| if_st=if_stmt														{$result = $if_st.result;}
	;

question_stmt returns [Question result]
@init
{
	QBaseType qValue;
}
	: id=ID ASSIGN lbl=STRING tp=type{qValue = $tp.result;}	
			(LPARENS val=unary_expr{qValue.SetValue($val.result.GetValue());} RPARENS)?	//option to assign value on declaration
	{$result = new Question($id.text, $lbl.text, qValue){ Token = $id };}
	;


if_stmt returns [StatementIf result]
@init	
{ 
	List<StatementBase> statements = new List<StatementBase>();
	StatementIf elseIfStatement = null;
}
	: IF LPARENS cond=boolean_expr RPARENS 
	  LBRACKET 
		(sts=statement{statements.Add($sts.result);})* 
	  RBRACKET														
	  (elif_st=else_stmt {elseIfStatement = $elif_st.result;})?			{$result = new StatementIf(){Condition = $cond.result, Body = statements, ElseIfStatement = elseIfStatement };}																		
	;													


else_stmt returns [StatementIf result]
@init	
{	
	List<StatementBase> statements = new List<StatementBase>(); 
}
	: ELSE if_st=if_stmt												{$result = $if_st.result;}							//else if
	| ELSE												
		LBRACKET 
			(sts=statement{statements.Add($sts.result);})* 									
		RBRACKET														{$result = new StatementIf(){Body = statements};}	//else
	;													


boolean_expr returns [ExpressionBase result]
	: lhs=boolean_expr AND rhs=boolean_expr								{$result = new And(){LeftValue = $lhs.result, RightValue = $rhs.result, Token = $AND};}
	| lhs=boolean_expr OR rhs=boolean_expr								{$result = new Or(){LeftValue = $lhs.result, RightValue = $rhs.result, Token = $OR};}
	| cm=compare_expr 													{$result = ($cm.result as ExpressionBase);}
	| un=unary_expr 													{$result = ($un.result as ExpressionBase);}
	;			

compare_expr returns [CompareExpression result]
	: lv=unary_expr op=compare_operator rv=unary_expr					{$result = new CompareExpression(){LeftValue = $lv.result, RightValue = $rv.result, CompareOperator = $op.result};}
	;

//TODO: couple math_expression and unary_expression in AST (add GetValue() method to ExpressionBase?)
value_expr  returns [ExpressionBase result]
	: x=unary_expr														{ $result = $x.result;}
	| m=math_expr														{ $result = $m.result;}
	;

unary_expr returns [UnaryExpression result]
    : PLUS x=unary_expr													{ $result = new Pos{InnerValue = $x.result.InnerValue}; }
    | MIN x=unary_expr													{ $result = new Neg{InnerValue = $x.result.InnerValue}; }
    | NOT x=unary_expr													{ $result = new Not{InnerValue = $x.result.InnerValue}; }
	| id=ID																{ $result = new UnaryExpression(){InnerValue = new QIdentifier($id.text, true){ Token = $id}};}																								
	| val=value															{ $result = new UnaryExpression(){InnerValue = $val.result};}													
	;

math_expr returns [MathExpression result]
	: l=unary_expr MUL r=unary_expr										{ $result = new Mul(){LeftValue = $l.result, RightValue = $r.result};}
	| l=unary_expr DIV r=unary_expr										{ $result = new Div(){LeftValue = $l.result, RightValue = $r.result};}
	| l=unary_expr PLUS r=unary_expr									{ $result = new Add(){LeftValue = $l.result, RightValue = $r.result};}
	| l=unary_expr MIN r=unary_expr										{ $result = new Sub(){LeftValue = $l.result, RightValue = $r.result};}
	;

compare_operator returns [OperatorBase result]
	: EQ																{$result = new Equals(){ Token = $EQ };}
	| GT																{$result = new GrTh(){ Token = $GT };}
	| GTE																{$result = new GrThEq(){ Token = $GTE };}
	| ST																{$result = new SmTh(){ Token = $ST };}
	| STE																{$result = new SmThEq(){ Token = $STE };}
	;


type returns [QBaseType result]
	: TYPE_BOOL															{$result = new QBool(""){Token=$TYPE_BOOL};}											
	| TYPE_INT															{$result = new QInt(""){Token=$TYPE_INT};}
	| TYPE_STRING														{$result = new QString(""){Token=$TYPE_STRING};}
	;


value returns [QBaseType result]
	: BOOL																{$result = new QBool($BOOL.text){Token=$BOOL};}
	| INT 																{$result = new QInt($INT.text){Token=$INT};}
	| STRING															{$result = new QString($STRING.text){Token=$STRING};}
	| id=ID																{$result = new QIdentifier($id.text, true){Token=$id};}
	;


/*
 * Lexer Rules
 */

ID : ([a-z][A-Z0-9]*);	

TYPE_BOOL: 'bool';
TYPE_INT: 'int';
TYPE_STRING: 'string';

BOOL: 'true' | 'false';
INT : [0-9]+;
STRING: '"'.*?'"';

LPARENS: '(';
RPARENS: ')';
LBRACKET: '{';
RBRACKET: '}';

ASSIGN: '=';
SEMICOLON: ';';

IF: 'if';
ELSE : 'else';

AND: '&&';
OR: '||';
NOT: '!';

EQ: '==';
GT: '>';
GTE: '>=';
ST: '<';
STE: '=<';

MUL: '*';
DIV: '/';
PLUS: '+';
MIN: '-';

WS  : (' ' | '\r' | '\n' | '\t' | )-> channel(HIDDEN);
SL_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);