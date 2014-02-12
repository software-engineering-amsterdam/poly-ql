#  Copyright (c) 1998-2000 John Aycock
#  
#  Permission is hereby granted, free of charge, to any person obtaining
#  a copy of this software and associated documentation files (the
#  "Software"), to deal in the Software without restriction, including
#  without limitation the rights to use, copy, modify, merge, publish,
#  distribute, sublicense, and/or sell copies of the Software, and to
#  permit persons to whom the Software is furnished to do so, subject to
#  the following conditions:
#  
#  The above copyright notice and this permission notice shall be
#  included in all copies or substantial portions of the Software.
#  
#  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
#  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
#  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
#  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
#  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
#  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
#  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

from spark import GenericScanner, GenericParser, GenericASTTraversal
from token import Token
from ast import AST

import argparse
import sys
import pprint

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
		
	def t_op(self, s):
		r' \+ | \* '
		self.rv.append(Token(type=s))
		
	def t_number(self, s):
		r' \d+ '
		t = Token(type='number', attr=s)
		self.rv.append(t)

	# Implementation of "add" and "mod" tokens.
	def t_add(self, s):
		r' add '
		self.rv.append(Token(type=s))

	def t_mod(self, s):
		r' mod '
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

#
#	PARSING
#

from spark import GenericASTBuilder

class AutoExprParser(GenericASTBuilder):
	def __init__(self, AST, start='expr'):
		GenericASTBuilder.__init__(self, AST, start)

	def p_expr(self, args):
		"""
		"""
		# empty docstring, here is were the rules are defined
		pass
	def terminal(self, token):
		#
		#  Homogeneous AST.
		#
		rv = AST(token.type)
		rv.attr = token.attr
		return rv

	def nonterminal(self, type, args):
		#
		#  Flatten AST a bit by not making nodes if there's only
		#  one child.
		#
		if len(args) == 1:
			return args[0]
		return GenericASTBuilder.nonterminal(self, type, args)

def parse(tokens,grammar=None):
	parser = AutoExprParser(AST)
	if grammar:
		parser.p_expr.__func__.__doc__ = grammar
		parser.collectRules()
	pprint.pprint( parser.rules )
	return parser.parse(tokens)

#
#	SEMANTIC CHECKING
#

class TypeCheck(GenericASTTraversal):
	def __init__(self, ast):
		GenericASTTraversal.__init__(self, ast)
		self.postorder()
		
	def n_number(self, node):
		node.exprType = 'number'
	def n_float(self, node):
		node.exprType = 'float'
		
	def n_expr(self, node):
		leftType = node[0].exprType
		rightType = node[2].exprType

		if leftType != rightType:
			"""
			We can sillently convert types if left or right type is one 
			of the following:
			float, int, "float", "int" -> float
			"""
			if leftType == 'number' and rightType == 'float':
				leftType = 'float'
			elif leftType == 'float' and rightType == 'number':
				rightType = 'float'
			else:
				raise BaseException('Type error.')
		node.exprType = leftType

	n_term = n_expr

def semantic(ast):
	TypeCheck(ast)
	#
	#  Any other ASTTraversal classes
	#  for semantic checking would be
	#  instantiated here...
	#
	return ast

#
#	CODE GENERATION
#

from spark import GenericASTMatcher

class AutoInterpret(GenericASTMatcher):
	def __init__(self, ast):
		GenericASTMatcher.__init__(self, 'V', ast)
		self.match()

	def p_n(self, tree):
		'''
			V ::= number
			V ::= float
		'''
		convert = tree.exprType == 'number' and int or float
		tree.value = convert(tree.attr)

	def p_add(self, tree):
		'''
			V ::= expr ( V + V )
		'''
		tree.value = tree[0].value + tree[2].value

	def p_mod(self, tree):
		'''
			V ::= expr ( V mod V )
		'''
		tree.value = tree[0].value % tree[2].value

	def p_addcustom(self, tree):
		'''
			V ::= expr ( V add V )
		'''
		tree.value = tree[0].value + tree[2].value

	def p_multiply(self, tree):
		'''
			V ::= term ( V * V )
		'''
		tree.value = tree[0].value * tree[2].value

	def p_addmul(self, tree):
		'''
			V ::= expr ( V + term ( V * V ) )
		'''
		tree.value = tree[0].value + tree[2][0].value * tree[2][2].value

def generate(ast):
	AutoInterpret(ast)
	return ast.value

#
#	MAIN
#

if __name__ == '__main__':
	p = argparse.ArgumentParser()
	p.add_argument('-g', '--grammar', dest='grammar', type=str,
		help='Yacc grammar')
	p.add_argument('-c', '--content', dest='content', type=str,
		help='Contents to parse')
	args = p.parse_args()

	empty_AST = AST
	# Load grammar in yacc format
	grammar = ''
	with open(args.grammar,'r') as grammar_file:
		grammar = grammar_file.read()

	# Load contents to parse
	
	with open(args.content, 'r') as parseble_content:
		tokenized = scan(parseble_content)
		print tokenized
		parsed = parse(tokenized, grammar)
		semantic_res = semantic(parsed)
		generated = generate(semantic_res)

		print generated
