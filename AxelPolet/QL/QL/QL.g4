grammar QL;

@parser::members
{
	protected const int EOF = Eof;
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
	using QL.QLClasses.Expressions.Binary.Conditional;
	using QL.QLClasses.Expressions.Binary.Math;
}

/*
 * Parser Rules
 */
 
questionnaire
	: FORM ASSIGN title=LIT_STRING body=codeblock						{_ASTRoot = new Questionnaire($title.text, $body.result);}
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
	: ID ASSIGN lbl=LIT_STRING t=type 
	  (LPARENS ( expr=expression {qExpression = $expr.result;} ) RPARENS)?	
	{
		if(qExpression == null)
			$result = new Question(_qlMemory, $ID.text, $lbl.text, $t.result){ AntlrToken = $ID };
		else
			$result = new ComputedQuestion(_qlMemory, $ID.text, $lbl.text, $t.result, qExpression){ AntlrToken = $ID };
	}
	;

ifStmt returns [StatementIf result]
	: IF LPARENS cond=expression RPARENS body=codeblock			  		  {$result = new StatementIf($cond.result, $body.result){ AntlrToken = $IF };}																		
	| IF LPARENS cond=expression RPARENS body=codeblock	elseBody=elseStmt {$result = new StatementIf($cond.result, $body.result, $elseBody.result){ AntlrToken = $IF };}
	;													

elseStmt returns [List<StatementBase> result]
	@init { List<StatementBase> codeBlock = null; }
	: ELSE ifSt=ifStmt													{$result = codeBlock = new List<StatementBase>(); codeBlock.Add($ifSt.result); $result = codeBlock;}							//else if
	| ELSE body=codeblock 												{$result = $body.result;}
	;

expression returns [ExpressionBase result]
	: LPARENS x=expression RPARENS										{ $result = $x.result;}
	| PLUS x=expression													{ $result = new Pos($x.result){ AntlrToken = $PLUS}; }
    | MIN x=expression													{ $result = new Neg($x.result){ AntlrToken = $MIN}; }
    | NOT x=expression													{ $result = new Not($x.result){ AntlrToken = $NOT}; }
	| l=expression MUL r=expression										{ $result = new Mul($l.result, $r.result){ AntlrToken = $MUL}; }
	| l=expression DIV r=expression										{ $result = new Div($l.result, $r.result){ AntlrToken = $DIV}; }
	| l=expression PLUS r=expression									{ $result = new Add($l.result, $r.result){ AntlrToken = $PLUS}; }
	| l=expression MIN r=expression										{ $result = new Sub($l.result, $r.result){ AntlrToken = $MIN}; }
	| l=expression EQ r=expression										{ $result = new Equals($l.result, $r.result){ AntlrToken = $EQ}; }
	| l=expression GT r=expression										{ $result = new GrTh($l.result, $r.result){ AntlrToken = $GT}; }
	| l=expression GTE r=expression										{ $result = new GrThEq($l.result, $r.result){ AntlrToken = $GTE}; }
	| l=expression ST r=expression										{ $result = new SmTh($l.result, $r.result){ AntlrToken = $ST}; }
	| l=expression STE r=expression										{ $result = new SmThEq($l.result, $r.result){ AntlrToken = $STE}; }
	| l=expression AND r=expression										{ $result = new And($l.result, $r.result){ AntlrToken = $AND}; }
	| l=expression OR r=expression										{ $result = new Or($l.result, $r.result){ AntlrToken = $OR}; }
	| lit = literal														{ $result = $lit.result; }
	;

literal returns [ExpressionBase result]
	: LIT_BOOL															{$result = new BoolLiteral(bool.Parse($LIT_BOOL.text)){ AntlrToken=$LIT_BOOL };}
	| LIT_INT 															{$result = new IntLiteral(int.Parse($LIT_INT.text)){ AntlrToken=$LIT_INT };}
	| LIT_STRING														{$result = new StringLiteral($LIT_STRING.text){ AntlrToken=$LIT_STRING };}
	| id = identifier													{$result = $id.result;}
	;

identifier returns [QIdentifier result]
	: ID																{$result = new QIdentifier(_qlMemory, $ID.text){ AntlrToken=$ID };} //also pass _qlMemory (from partial class)
	;

type returns [QType result]
	: QBOOL																{$result = new QBool{ AntlrToken=$QBOOL };}											
	| QINT																{$result = new QInt { AntlrToken=$QINT };}
	| QSTRING															{$result = new QString{ AntlrToken=$QSTRING };}
	;

/*
 * Lexer Rules
 */

FORM : 'qform';

QBOOL: 'bool';
QINT: 'int';
QSTRING: 'string';

LIT_BOOL: 'true' | 'false';
LIT_INT : [0-9]+;
LIT_STRING: '"'.*?'"';

IF: 'if';
ELSE : 'else';

ID : ([a-z][A-Za-z0-9]+);	//id has lowest precedence

LPARENS: '(';
RPARENS: ')';
LBRACKET: '{';
RBRACKET: '}';

ASSIGN: '=';
SEMICOLON: ';';

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