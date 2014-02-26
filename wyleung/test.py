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

from ast import AST

import argparse
import sys
import pprint

from codegenerator import *
from parser import *
from scanner import *
from typechecking import *

#
#	MAIN
#

if __name__ == '__main__':
	p = argparse.ArgumentParser()
	p.add_argument('-g', '--grammar', dest='grammar', type=str, required=True,
		help='Yacc grammar')
	p.add_argument('-c', '--content', dest='content', type=str, required=True,
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
#		semantic_res = semantic(parsed)
#		generated = generate(semantic_res)

#		print generated
