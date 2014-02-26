#!/usr/bin/env python

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

