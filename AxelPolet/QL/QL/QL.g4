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
	using System.Linq;
	using QL.Components;
	using QL.Components.Statements;
}


/*
 * Parser Rules
 */
 
questionnaire returns [Questionnaire qst]
	: 'form' ID ASSIGN STRING LBRACKET statement* RBRACKET 
	{
		string id = $ID.text;
		if(IDExists(id))
			NotifyErrorListeners(string.Format("identifier '{0}' already defined", id));
		
		CreateID(id);

		//theQuestionnaire.ID = id; theQuestionnaire.Title = $STRING.text;
		$qst = new Questionnaire{ID = id, Title = $STRING.text};
	}
	;

statement 
	: (question_stmt| question_ref) SEMICOLON
	| if_stmt;

question_stmt returns [Question qst]
	: ID ASSIGN STRING t=type v=value 
	{
		string id = $ID.text;
		if(IDExists(id))
			NotifyErrorListeners(string.Format("identifier '{0}' already defined", id));
		
		CreateID(id);
		//theQuestionnaire.Questions.Add(new Question(){ID = id, Label = $STRING.text, Type = $t.text});
		//$qst = new Question(){ID = id, Label = $STRING.text, Type = typeof($t.text)};
	};

question_ref returns [Question qst]
	: ID
	{
		string id = $ID.text;
		if(!IDExists(id))
		{
			NotifyErrorListeners(string.Format("question '{0}' does not exist!", id));
			$qst = null;
		}
		else
		{
			$qst = theQuestionnaire.Questions.Single((q) => q.ID == id);
		}
	};

if_stmt
	: IF boolean_expr LBRACKET statement* RBRACKET else_stmt?;

else_stmt
	: ELSE LBRACKET statement* RBRACKET
	| ELSE if_stmt;

boolean_expr
	: boolean_expr AND boolean_expr 
	| boolean_expr OR boolean_expr 
	| LPARENS (BOOL | compare_expr) RPARENS;

compare_expr
	: int_compare
	| string_compare;

int_compare
	: int_compare (EQ | compare_operator) int_compare
	| INT;

string_compare
	: string_compare EQ string_compare
	| STRING;

compare_operator
	: GT
	| GTE
	| ST
	| STE;

type : (BOOLType | INTType | STRINGType);
value: (BOOL | INT | STRING);

/*
 * Lexer Rules
 */

ID : ([a-z][A-Z0-9]*);	

BOOLType: 'bool';
INTType: 'int';
STRINGType: 'string';

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