from pyparsing import *
from date import nlTimeExpression

# Caching
ParserElement.enablePackrat()

def toDict(tokens): 
  tmp = {}

  for t in tokens[0]:
    if t[0] and t[1]:
      tmp[t[0]] = t[1]
    else:
      # Default to true if no value is given
      tmp[t[0]] = True

  return tmp


# Single words
word     = Word(alphanums + "`~_-+=!@#$%^&[]:;.,'/") # all but {} () " and ?
variable = Word(alphanums)
keyword  = oneOf("required example success error value validation")
boolean  = oneOf('True true False false')

integer  = Word(nums).setParseAction(lambda t:int(t[0]))
float    = Regex(r'\d+(\.\d*)?([eE]\d+)?')

# TODO : Allow euro / dollar / money sign
money    = Regex(r'\d+(\.\d\d)')

# For now dates should be between quotes
date     = Suppress('"') + nlTimeExpression + Suppress('"')

operand  = boolean | integer | float | money | date | variable

# Right precedence
sign     = oneOf('+ -')
negation = Literal('!')

# Operator groups per presedence
right_op = negation | sign 

# Highest precedence
left_op_1 = oneOf('* /')
left_op_2 = oneOf('+ -') 
left_op_3 = oneOf("> >= < <=")
left_op_4 = oneOf("== !=")
left_op_5 = oneOf('&& and')
left_op_6 = oneOf('|| or')
# Lowest precedence

condition = operatorPrecedence( operand, [
     (right_op,   1, opAssoc.RIGHT),
     (left_op_1,  2, opAssoc.LEFT),
     (left_op_2,  2, opAssoc.LEFT),
     (left_op_3,  2, opAssoc.LEFT),
     (left_op_4,  2, opAssoc.LEFT),
     (left_op_5,  2, opAssoc.LEFT),
     (left_op_6,  2, opAssoc.LEFT)
    ]
)('condition')

# Multiple words
sentence   = OneOrMore(word).setParseAction(lambda t:" ".join(t))
string     = quotedString.setParseAction(removeQuotes)

type       = oneOf("boolean string integer date decimal money")
key_value  = Group(keyword + Optional(string))

# Settings
# To define custom messages, information labels or validations (email, password etc)
setting  = key_value
settings = Optional( Group(OneOrMore(setting)) )('settings').setParseAction(toDict)

# Question
ask           = sentence('ask') + Suppress("?")
question_type = Optional(type('type') + variable('id'))
question      = Group(ask + question_type + settings)('question')

# Put (i.e computed fields/answers)
# Match: put "Label text" (value * 3)
# Skips spacing, so also allows (value*3)
put = Group(Suppress("put") + Optional(string)('answer') + condition('condition') )('put')

# Expression
expression = Forward()

block           = Suppress("{") + ZeroOrMore(question | put | expression ) + Suppress("}")
condition_block = Group(condition + block)

_if   = Suppress("if")      + condition_block
_elif = Suppress("else if") + condition_block
_else = Suppress("else")    + Group(block)

expression <<  (_if    + 
    ZeroOrMore( _elif) +
       Optional(_else))

# Form
form = (Suppress("form") + word('name') + block)('form')

# Ignore comments
form.ignore(cStyleComment | cppStyleComment)