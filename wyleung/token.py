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

#
#	Minimal token class.
#

class Token:
	def __init__(self, type, attr=None):
		self.type = type
		self.attr = attr

	#
	#  Not all these may be needed:
	#
	#  __cmp__	required for GenericParser, required for
	#			GenericASTMatcher only if your ASTs are
	#			heterogeneous (i.e., AST nodes and tokens)
	#  __repr__	recommended for nice error messages in GenericParser
	#  __getitem__	only if you have heterogeneous ASTs
	#  
	def __cmp__(self, o):
		return cmp(self.type, o)
	def __repr__(self):
		return self.attr or self.type
	#def __getitem__(self, i):
	#	raise IndexError
