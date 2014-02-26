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
	using QL.QLClasses.Types;
	using QL.QLClasses.Statements;
	using QL.QLClasses.Expressions;
	using QL.QLClasses.Expressions.Literals;
	using QL.QLClasses.Expressions.Identifier;
	using QL.QLClasses.Expressions.Unary;
	using QL.QLClasses.Expressions.Binary;
	using QL.QLClasses.Expressions.Binary.Compare;
	using QL.QLClasses.Expressions.Binary.Compare.Operators;
	using QL.QLClasses.Expressions.Binary.Conditional;
	using QL.QLClasses.Expressions.Binary.Math;
}

/*
 * Parser Rules
 */
 
questionnaire
	: FORM ASSIGN title=STRING body=codeblock							{theQuestionnaire = new Questionnaire{Title = $title.text, Body = $body.result};}
	;

statement returns [StatementBase result]
	: qsSt=questionStmt SEMICOLON										{$result = $qsSt.result;}
	| ifSt=ifStmt														{$result = $ifSt.result;}
	;

codeblock returns [List<StatementBase> result]
	@init {	List<StatementBase> statements = new List<StatementBase>(); }
	: LBRACKET (sts=statement{statements.Add($sts.result);})* RBRACKET	{$result = statements;}
	;

questionStmt returns [Question result]
	@init { ExpressionBase qExpression = null; }
	: id=identifier ASSIGN lbl=STRING t=type 
	  (LPARENS ( expr=expression {qExpression = $expr.result;} ) RPARENS)?	
	{$result = new Question($id.result, $lbl.text, $t.result, qExpression){ Token = $ASSIGN };}
	;

ifStmt returns [StatementIf result]
	@init { StatementIf elseIfStatement = null; }
	: IF LPARENS cond=expression RPARENS body=codeblock													
	  (elifSt=elseStmt {elseIfStatement = $elifSt.result;})?			{$result = new StatementIf(){Condition = $cond.result, Body = $body.result, ElseIfStatement = elseIfStatement };}																		
	;													

elseStmt returns [StatementIf result]
	: ELSE ifSt=ifStmt													{$result = $ifSt.result;}							//else if
	| ELSE body=codeblock												{$result = new StatementIf(){Body = $body.result};}	//else
	;													

expression returns [ExpressionBase result]
	: l=expression MUL r=expression										{ $result = new Mul(){LeftExpression = $l.result, RightExpression = $r.result, TokenInfo=$l.result.TokenInfo};}
	| l=expression DIV r=expression										{ $result = new Div(){LeftExpression = $l.result, RightExpression = $r.result, TokenInfo=$l.result.TokenInfo};}
	| l=expression PLUS r=expression									{ $result = new Add(){LeftExpression = $l.result, RightExpression = $r.result, TokenInfo=$l.result.TokenInfo};}
	| l=expression MIN r=expression										{ $result = new Sub(){LeftExpression = $l.result, RightExpression = $r.result, TokenInfo=$l.result.TokenInfo};}
	| l=expression EQ r=expression										{ $result = new CompareExpression(){LeftExpression = $l.result, RightExpression = $r.result, CompareOperator = new Equals(), TokenInfo=$l.result.TokenInfo};}
	| l=expression GT r=expression										{ $result = new CompareExpression(){LeftExpression = $l.result, RightExpression = $r.result, CompareOperator = new GrTh(), TokenInfo=$l.result.TokenInfo};}
	| l=expression GTE r=expression										{ $result = new CompareExpression(){LeftExpression = $l.result, RightExpression = $r.result, CompareOperator = new GrThEq(), TokenInfo=$l.result.TokenInfo};}
	| l=expression ST r=expression										{ $result = new CompareExpression(){LeftExpression = $l.result, RightExpression = $r.result, CompareOperator = new SmTh(), TokenInfo=$l.result.TokenInfo};}
	| l=expression STE r=expression										{ $result = new CompareExpression(){LeftExpression = $l.result, RightExpression = $r.result, CompareOperator = new SmThEq(), TokenInfo=$l.result.TokenInfo};}
	| l=expression AND r=expression										{ $result = new And(){LeftExpression = $l.result, RightExpression = $r.result, Token = $AND}; }
	| l=expression OR r=expression										{ $result = new Or(){LeftExpression = $l.result, RightExpression = $r.result, Token = $OR}; }
	| PLUS x=expression													{ $result = new Pos{InnerExpression = $x.result, TokenInfo=$x.result.TokenInfo};} 
    | MIN x=expression													{ $result = new Neg{InnerExpression = $x.result, TokenInfo=$x.result.TokenInfo};}
    | NOT x=expression													{ $result = new Not{InnerExpression = $x.result, TokenInfo=$x.result.TokenInfo};}
	| lit = literal														{ $result = $lit.result; }
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

type returns [QBaseType result]
	: TYPE_BOOL															{$result = new QBool(){Token=$TYPE_BOOL};}											
	| TYPE_INT															{$result = new QInt(){Token=$TYPE_INT};}
	| TYPE_STRING														{$result = new QString(){Token=$TYPE_STRING};}
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