#!/usr/bin/env python

from spark import GenericParser
from ast import AST
import pprint
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
	if grammar:
		AutoExprParser.p_expr.__func__.__doc__ = grammar
	
	parser = AutoExprParser(AST, start='form')
#		parser.p_expr.__func__.__doc__ = grammar
#	parser.collectRules()
#	pprint.pprint( parser.rules )
	return parser.parse(tokens)

