grammar Newql;

options {
	// antlr will generate java lexer and parser
	language = Java;
}

hallon: 'hallon';

caller: FORM;
FORM: 'form ' [A-Z]+[a-zA-Z09]* ' { ' QITS ' }';
QITS: QIT | QIT QIT;
QIT: QUESTION ' ' IDENTIFIER ' ' TYPE;
QUESTION: '"'[A-Z]+[a-zA-Z0-9 ]*'?"';
IDENTIFIER: [a-z]+[a-zA-z0-9]*':';
TYPE: 'boolean' | 'money';


WS: [\r\n\t ] -> skip;