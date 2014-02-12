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
	| IF condition L_BRACKET statement R_BRACKET
	;

declarative_statement : 
	| question 


statement :
	| conditional_statement
	| declarative_statement
	;