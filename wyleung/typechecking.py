#!/usr/bin/env python

from spark import GenericASTTraversal
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
