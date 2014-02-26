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
	using QL.QLClasses.Expressions.Literals;
	using QL.QLClasses.Expressions.Identifier;
	using QL.QLClasses.Expressions.Unary;
	using QL.QLClasses.Expressions.Math;
	using QL.QLClasses.Expressions.Conditions;
	using QL.QLClasses.Expressions.Conditions.BinaryExpressions;
	using QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators;
	using QL.QLClasses.Types;
}

/*
 * Parser Rules
 */
 
questionnaire
	@init	
	{	
		List<StatementBase> statements = new List<StatementBase>(); 
	}
	: FORM ASSIGN title=STRING 
		LBRACKET 
			(sts=statement{statements.Add($sts.result);})* 
		RBRACKET														{theQuestionnaire = new Questionnaire{Title = $title.text, Body = statements};}
	;

statement returns [StatementBase result]
	: qsSt=questionStmt SEMICOLON										{$result = $qsSt.result;}
	| ifSt=ifStmt														{$result = $ifSt.result;}
	;

questionStmt returns [Question result]
@init
{
	ExpressionBase qExpression = null;
}
	: id=identifier ASSIGN lbl=STRING t=type
			(LPARENS 
				( 
					 expr=expression		{qExpression = $expr.result;}
				)
			 RPARENS)?	
	{$result = new Question($id.result, $lbl.text, $t.result, qExpression){ Token = $ASSIGN };}
	;

ifStmt returns [StatementIf result]
@init	
{ 
	List<StatementBase> statements = new List<StatementBase>();
	StatementIf elseIfStatement = null;
}
	: IF LPARENS cond=expression RPARENS 
	  LBRACKET 
		(sts=statement{statements.Add($sts.result);})* 
	  RBRACKET														
	  (elifSt=elseStmt {elseIfStatement = $elifSt.result;})?			{$result = new StatementIf(){Condition = $cond.result, Body = statements, ElseIfStatement = elseIfStatement };}																		
	;													


elseStmt returns [StatementIf result]
@init	
{	
	List<StatementBase> statements = new List<StatementBase>(); 
}
	: ELSE ifSt=ifStmt													{$result = $ifSt.result;}							//else if
	| ELSE												
		LBRACKET 
			(sts=statement{statements.Add($sts.result);})* 									
		RBRACKET														{$result = new StatementIf(){Body = statements};}	//else
	;													

//expression returns [ExpressionBase result]
//	: l=expression MUL r=expression										{ $result = new Mul(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
//	| l=expression DIV r=expression										{ $result = new Div(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
//	| l=expression PLUS r=expression									{ $result = new Add(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
//	| l=expression MIN r=expression										{ $result = new Sub(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
//	| l=expression AND r=expression										{ $result = new And(){LeftValue = $l.result, RightValue = $r.result, Token = $AND}; }
//	| l=expression OR r=expression										{ $result = new Or(){LeftValue = $l.result, RightValue = $r.result, Token = $OR}; }
//	//| l=expression c=compareOperator r=expression						{ $result = new CompareExpression(){LeftValue = $l.result, RightValue = $r.result, CompareOperator = $c.result, TokenInfo=$l.result.TokenInfo};}
//	| l=expression EQ r=expression										{ $result = new CompareExpression(){LeftValue = $l.result, RightValue = $r.result, CompareOperator = new Equals(), TokenInfo=$l.result.TokenInfo};}
//	| l=expression GT r=expression										{ $result = new CompareExpression(){LeftValue = $l.result, RightValue = $r.result, CompareOperator = new GrTh(), TokenInfo=$l.result.TokenInfo};}
//	| l=expression GTE r=expression										{ $result = new CompareExpression(){LeftValue = $l.result, RightValue = $r.result, CompareOperator = new GrThEq(), TokenInfo=$l.result.TokenInfo};}
//	| l=expression ST r=expression										{ $result = new CompareExpression(){LeftValue = $l.result, RightValue = $r.result, CompareOperator = new SmTh(), TokenInfo=$l.result.TokenInfo};}
//	| l=expression STE r=expression										{ $result = new CompareExpression(){LeftValue = $l.result, RightValue = $r.result, CompareOperator = new SmThEq(), TokenInfo=$l.result.TokenInfo};}
//	| PLUS x=expression													{ $result = new Pos{InnerValue = $x.result.InnerValue, TokenInfo=$x.result.TokenInfo};} 
//    | MIN x=expression													{ $result = new Neg{InnerValue = $x.result.InnerValue, TokenInfo=$x.result.TokenInfo};}
//    | NOT x=expression													{ $result = new Not{InnerValue = $x.result.InnerValue, TokenInfo=$x.result.TokenInfo};}
//	| lit = literal														{ $result = $lit.result; }
//	;

expression returns [ExpressionBase result]
	: u=unaryExpr														{ $result = $u.result;}
	| m=mathExpr														{ $result = $m.result;}
	| l=literal															{ $result = $l.result;}
	;

unaryExpr returns [UnaryExpression result]
    : PLUS x=unaryExpr													{ $result = new Pos{InnerValue = $x.result.InnerValue, TokenInfo=$x.result.TokenInfo};} 
    | MIN x=unaryExpr													{ $result = new Neg{InnerValue = $x.result.InnerValue, TokenInfo=$x.result.TokenInfo};}
    | NOT x=unaryExpr													{ $result = new Not{InnerValue = $x.result.InnerValue, TokenInfo=$x.result.TokenInfo};}																					
	| l=literal															{ $result = new UnaryExpression{InnerValue =$l.result, TokenInfo=$l.result.TokenInfo};}
	;

mathExpr returns [MathExpression result]
	: l=unaryExpr MUL r=unaryExpr										{ $result = new Mul(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
	| l=unaryExpr DIV r=unaryExpr										{ $result = new Div(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
	| l=unaryExpr PLUS r=unaryExpr										{ $result = new Add(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
	| l=unaryExpr MIN r=unaryExpr										{ $result = new Sub(){LeftValue = $l.result, RightValue = $r.result, TokenInfo=$l.result.TokenInfo};}
	;

boolExpr returns [ExpressionBase result]
	: l=boolExpr AND r=boolExpr											{$result = new And(){LeftValue = $l.result, RightValue = $r.result, Token = $AND};}
	| l=boolExpr OR r=boolExpr											{$result = new Or(){LeftValue = $l.result, RightValue = $r.result, Token = $OR};}
	| cm=compareExpr 													{$result = ($cm.result as ExpressionBase);}
	| expr=expression 													{$result = ($expr.result as ExpressionBase);}
	;			

compareExpr returns [CompareExpression result]
	: lv=expression op=compareOperator rv=expression					{$result = new CompareExpression(){LeftValue = $lv.result, RightValue = $rv.result, CompareOperator = $op.result, TokenInfo=$lv.result.TokenInfo};}
	;

compareOperator returns [OperatorBase result]
	: EQ																{$result = new Equals(){ Token = $EQ };}
	| GT																{$result = new GrTh(){ Token = $GT };}
	| GTE																{$result = new GrThEq(){ Token = $GTE };}
	| ST																{$result = new SmTh(){ Token = $ST };}
	| STE																{$result = new SmThEq(){ Token = $STE };}
	;

type returns [QBaseType result]
	: TYPE_BOOL															{$result = new QBool(){Token=$TYPE_BOOL};}											
	| TYPE_INT															{$result = new QInt(){Token=$TYPE_INT};}
	| TYPE_STRING														{$result = new QString(){Token=$TYPE_STRING};}
	;

literal returns [ExpressionBase result]
	: BOOL																{$result = new BoolLiteral(bool.Parse($BOOL.text)){Token=$BOOL};}
	| INT 																{$result = new IntLiteral(int.Parse($INT.text)){Token=$INT};}
	| STRING															{$result = new StringLiteral($STRING.text){Token=$STRING};}
	| id = identifier													{$result = $id.result;}
	;

identifier returns [QIdentifier result]
	: ID																{$result = new QIdentifier($ID.text){Token=$ID};}
	;

/*
 * Lexer Rules
 */

FORM : 'FORM';
ID : ([a-z][A-Z0-9]+);	

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

SL_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
WS  : (' ' | '\r' | '\n' | '\t' )-> channel(HIDDEN);