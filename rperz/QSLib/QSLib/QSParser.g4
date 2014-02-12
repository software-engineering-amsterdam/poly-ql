parser grammar QSParser;

@members
{
	protected const int EOF = Eof;
}

question :
	| SQ (WORD+ INTERPUNCT?)+ SQ 
	;

type_declaration :
	| WORD COLON TYPE
	;

conditional_statement :
	| if_statement else_statement?
	;

if_statement :
	| IF L_HOOK condition R_HOOK code_block
	;

else_statement :
	| ELSE  code_block
	| ELSE if_statement
	;

code_block :
	| L_BRACKET statement R_BRACKET
	;

statement :
	| conditional_statement
	| declarative_statement
	;

declarative_statement : 
	| question 
	;
