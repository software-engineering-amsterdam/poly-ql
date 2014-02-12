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
	using QL.Components;
}

/*
 * Parser Rules
 */
 
questionnaire returns [Questionnaire newQuest]
: 'form' STRING '{' question+ '}' ';' {$newQuest = new Questionnaire(){Title = $STRING.text};};

question: ID '=' STRING TYPE';';

/*
 * Lexer Rules
 */

ID : ([a-z][A-Z0-9]*);	
TYPE: ('bool' | 'string' | 'int');

BOOL: 'true' | 'false';
STRING: '"'.*?'"';
INT : [0-9]+;

WS  : (' ' | '\r' | '\n' | '\t' | ('\\\\'.*( '\r' | '\n' )))-> channel(HIDDEN);

//expr : expr op=('*'|'/') expr   # MulDiv	// * | / are on higher precedence
//     | expr op=('+'|'-') expr   # AddSub
//     | INT                  # int
//     | '(' expr ')'         # parens
//     ;

//MUL : '*';
//DIV : '/';
//ADD : '+';
//SUB : '-';