grammar QL;

@parser::members
{
	protected const int EOF = Eof;
	public Questionnaire theQuestionnaire = new Questionnaire();

	private List<string> definedIDs = new List<string>();
	private bool IDExists(string name){return definedIDs.Contains(name);}
	private void CreateID(string name){definedIDs.Add(name);}
}

@lexer::members
{
	protected const int EOF = Eof;
	protected const int HIDDEN = Hidden;
}

@header {
	using System;
	using System.Collections.Generic;
	using QL.Components;
}


/*
 * Parser Rules
 */
 
questionnaire
	: 'form' ID ASSIGN STRING LBRACKET expression+ RBRACKET SEMICOLON 
	{
		string text = $ID.text;
		if(IDExists(text))
			NotifyErrorListeners(string.Format("identifier '{0}' already defined", text));
		
		CreateID(text);
		theQuestionnaire.ID = text; theQuestionnaire.Title = $STRING.text;
	}
	;

expression 
	: question_stmt
	| if_stmt;

question_stmt
	: ID ASSIGN STRING TYPE SEMICOLON 
	{
		string text = $ID.text;
		if(IDExists(text))
			NotifyErrorListeners(string.Format("identifier '{0}' already defined", text));
		
		CreateID($ID.text);
		theQuestionnaire.Questions.Add(new Question(){ID = $ID.text, Label = $STRING.text, Type = $TYPE.text});
	};

if_stmt
	: IF LPARENS boolean_expr RPARENS LBRACKET expression* RBRACKET SEMICOLON;

boolean_expr
	: boolean_expr AND boolean_expr 
	| boolean_expr OR boolean_expr 
	| (BOOL | compare_expr);

compare_expr
	: compare_expr compare_operator compare_expr
	| INT;

compare_operator
	: EQ
	| GT
	| GTE
	| ST
	| STE;

/*
 * Lexer Rules
 */

ID : ([a-z][A-Z0-9]*);	
TYPE: ('bool' | 'string' | 'int');

BOOL: 'true' | 'false';
STRING: '"'.*?'"';
INT : [0-9]+;

LPARENS: '(';
RPARENS: ')';
LBRACKET: '{';
RBRACKET: '}';

ASSIGN: '=';
SEMICOLON: ';';

IF: 'if';

AND: '&&';
OR: '||';
NOT: '!';

EQ: '==';
GT: '>';
GTE: '>=';
ST: '<';
STE: '=<';

WS  : (' ' | '\r' | '\n' | '\t' | ('\\\\'.*( '\r' | '\n' )))-> channel(HIDDEN);