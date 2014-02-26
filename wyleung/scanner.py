#!/usr/bin/env python

from spark import GenericScanner
from token import Token
#
#	SCANNING
#

class SimpleScanner(GenericScanner):
	def __init__(self):
		GenericScanner.__init__(self)
	
	def tokenize(self, input):
		self.rv = []
		GenericScanner.tokenize(self, input)
		return self.rv
	
	def t_whitespace(self, s):
		r' \s+ '
		pass

	def t_fieldlabel(self, s):
		r' [\w]+: '
		self.rv.append(Token(type=s))

	def t_bracket_open(self, s):
		r' { '
		self.rv.append(Token(type=s))

	def t_bracket_close(self, s):
		r' [ ]?} '
		self.rv.append(Token(type=s))

	def t_form(self, s):
		r' form '
		self.rv.append(Token(type=s))

	def t_question(self, s):
		r' \'[\w\d\?/ ]+\' '
		self.rv.append(Token(type=s))

	def t_formname(self, s):
		r' [\w\d]+ '
		self.rv.append(Token(type=s))

	def t_boolean(self, s):
		r' boolean '
		self.rv.append(Token(type=s))




class FloatScanner(SimpleScanner):
	def __init__(self):
		SimpleScanner.__init__(self)
		
	def t_float(self, s):
		r' \d+ \. \d+ '
		t = Token(type='float', attr=s)
		self.rv.append(t)

def scan(f):
	input_contents = f.read()
	scanner = FloatScanner()
	return scanner.tokenize(input_contents)

