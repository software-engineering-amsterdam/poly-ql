grammar QL;

@parser::members
{
	protected const int EOF = Eof;
	public Questionnaire theQuestionnaire;

	private Dictionary<string, Question> definedQuestions = new Dictionary<string, Question>();
	private bool IDExists(string name){return definedQuestions.ContainsKey(name);}
	private void CreateID(string name, Question question){definedQuestions.Add(name, question);}
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
	using QL.Components;
	using QL.Components.Conditions;
	using QL.Components.Conditions.BinaryExpressions;
	using QL.Components.Conditions.BinaryExpressions.Operators;
	using QL.Components.Statements;
	using QL.Components.Types;
}

/*
 * Parser Rules
 */
 
questionnaire returns [Questionnaire qst]
	@init{ List<StatementBase> statements = new List<StatementBase>(); }
	: 'form' ASSIGN title=STRING LBRACKET (sts=statement{statements.Add($sts.result);})* RBRACKET 
	{
		Questionnaire newQuestionnaire = new Questionnaire{Title = $title.text, Body = statements};
		theQuestionnaire = newQuestionnaire;

		$qst = newQuestionnaire;
	}
	;

statement returns [StatementBase result]
	: qs_st=question_stmt SEMICOLON		{$result = $qs_st.result;}
	| if_st=if_stmt						{$result = $if_st.result;}
	;

question_stmt returns [Question result]
	: id=ID ASSIGN lbl=STRING tp=type
	{
		string identifier = $id.text;
		if(IDExists(identifier))
		{
			NotifyErrorListeners(string.Format("identifier '{0}' already defined", identifier));
		}
		else
		{
			Question newQuestion = new Question(){ID = identifier, Label = $lbl.text, Type = $tp.result, Token = $id};
			CreateID(identifier, newQuestion);
			$result = newQuestion;
		}
	}
	;

if_stmt returns [StatementIf result]
@init{ List<StatementBase> statements = new List<StatementBase>(); }
	: IF LPARENS cond=boolean_expr RPARENS 
		LBRACKET 
			(sts=statement{statements.Add($sts.result);})* 
		RBRACKET 
		elif_st=else_stmt?									{$result = new StatementIf(){Condition = $cond.result, Body = statements, ElseIfStatement = $elif_st.result};}																		
	;													

else_stmt returns [StatementIf result]
@init{ List<StatementBase> statements = new List<StatementBase>(); }
	: ELSE elif=if_stmt												{$result = $elif.result;}							//else if
	| ELSE												
		LBRACKET 
			(sts=statement{statements.Add($sts.result);})* 									
		RBRACKET													{$result = new StatementIf(){Body = statements};}	//else
	;													

boolean_expr returns [ConditionalExpression result]
	: lhs=boolean_expr AND rhs=boolean_expr				{$result = new And(){LeftValue = $lhs.result, RightValue = $rhs.result};}
	| lhs=boolean_expr OR rhs=boolean_expr				{$result = new Or(){LeftValue = $lhs.result, RightValue = $rhs.result};}
	| un=unary_expr 									{$result = ($un.result as ConditionalExpression);}
	| cm=compare_expr 									{$result = ($cm.result as ConditionalExpression);}
	;			

unary_expr returns [UnaryExpression result]
	: id=ID												{
															string id = $id.text;
															if(!IDExists(id))
																NotifyErrorListeners(string.Format("identifier '{0}' not defined", id));
															else
															{
																Question q = definedQuestions[id];

																//if(!(q.Type is TypeBool))
																//	NotifyErrorListeners(string.Format("question '{0}' not of type bool", id));

																$result = new UnaryExpression(){Value = q.Type, Token = $id};
															}
														}
	| val=BOOL											{$result = new UnaryExpression(){Value = new TypeBool($val.text)};}
	;

compare_expr returns [CompareExpression result]
	: ic=int_compare									{$result = $ic.result;}		
	| sc=string_compare									{$result = $sc.result;}
	;

int_compare returns [CompareExpression result]
	: lhs=INT op=compare_operator rhs=INT				{$result = new CompareExpression(){LeftValue = new TypeInt($lhs.text), RightValue = new TypeInt($rhs.text), CompareOperator = $op.result};}
	;

string_compare returns [CompareExpression result]
	: lhs=STRING op=EQ rhs=STRING						{$result = new CompareExpression(){LeftValue = new TypeString($lhs.text), RightValue = new TypeString($rhs.text), CompareOperator = new Equals()};}
	;	

compare_operator returns [OperatorBase result]
	: EQ												{$result = new Equals();}
	| GT												{$result = new GrTh();}
	| GTE												{$result = new GrThEq();}
	| ST												{$result = new SmTh();}
	| STE												{$result = new SmThEq();}
	;

type returns [TypeBase result]
	: TYPE_BOOL											{$result = new TypeBool("false");}											
	| TYPE_INT											{$result = new TypeInt("0");}
	| TYPE_STRING										{$result = new TypeString("");}
	;

value
	: BOOL 
	| INT 
	| STRING
	;

questionValue
	:
	ID
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

WS  : (' ' | '\r' | '\n' | '\t' | )-> channel(HIDDEN);
SL_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);