from pyparsing import *

# Caching
ParserElement.enablePackrat()

def Question(tokens):

    return { 
        "element"  : "question",
        "id"       : tokens[0].id,
        "type"     : tokens[0].type,
        "question" : tokens[0].ask,
        "settings" : tokens[0].settings,
        "options"  : tokens[0].options
    }


def ExpressionBlock(tokens):
    
    return { 
        "condition" : tokens[0].computation,
        "elements"  : tokens[0][1:]           # rest of the elements
    }
    
def Expression(tokens):

    return { 
        "element" : "expression",
        
        "if"   : tokens[0]._if,
        "elif" : tokens[0]._elif,
        "else" : tokens[0]._else[0]
        
    }

# Computation / condition
def Computation(tokens):

    return tokens

def Put(tokens):

    return { 
        "element"   : "put",
        "label"     : tokens[0].label,
        "condition" : tokens[0].computation
    }


# Takes multiple words and accepts them as a single string
def toSentence(tokens):
    return " ".join(tokens)


  
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
word       = Word(alphanums + "`~_-+=!@#$%^&[]:;.,'/") # all but {} () " and ?
variable   = Word(alphanums)
keyword    = oneOf("required example success error value validation")

# Condition block

# Allow float, money
integer  = Word(nums).setParseAction(lambda t:int(t[0]))('int')
operand  = integer | variable('var')

# Left precedence
eq    = Literal("==")('eq')
gt    = Literal(">")('gt')
gtEq  = Literal(">=")('gtEq')
lt    = Literal("<")('lt')
ltEq  = Literal("<=")('ltEq')
notEq = Literal("!=")('notEq')
mult  = oneOf('* /')('mult')
plus  = oneOf('+ -')('plus')

_and  = oneOf('&& and')('and')
_or   = oneOf('|| or')('or')

# Right precedence
sign     = oneOf('+ -')('sign')
negation = Literal('!')('negation')

# Operator groups per presedence
right_op = negation | sign 

# Highest precedence
left_op_1 = mult 
left_op_2 = plus 
left_op_3 = gtEq | ltEq | lt | gt
left_op_4 = eq   | notEq
left_op_5 = _and
left_op_6 = _or
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
).setParseAction(Computation)('computation')


# Multiple words
sentence   = OneOrMore(word).setParseAction(toSentence)
string     = quotedString.setParseAction( removeQuotes )

type       = oneOf("boolean string integer date decimal money")('type')
key_value  = Group(keyword('key') + Optional(string)('value'))

# Settings
# To define custom messages, information labels or validations (email, password etc)
setting  = key_value('setting')
settings = Optional( Group(OneOrMore(setting)).setParseAction(toDict)('settings') )

# For dropdown select options
# So instead of showing a checkbox Yes/No it could be Yes/No/Maybe/Not at all
indent  = Suppress(oneOf("\t * + -"))
option  = indent + string('option')
options = Optional( Group( OneOrMore(option) )('options') )

# Question
ask           = sentence('ask') + Suppress("?")
question_type = Optional(type + variable('id'))
question      = Group(ask + question_type + settings + options).setParseAction(Question)('question')


# Put (i.e computed fields/answers)
# Match: put "Label text" (value * 3)
# Skips spacing, so also allows (value*3)
put = Group(Suppress("put") + Optional(string)('label') + condition).setParseAction(Put)('put')


# Expression
expression = Forward()

block           = Suppress("{") + ZeroOrMore(question | put | expression) + Suppress("}")
condition_block = Group(condition + block).setParseAction(ExpressionBlock)

_if   = Suppress("if")      + condition_block
_elif = Suppress("else if") + condition_block
_else = Suppress("else")    + Group(block)

expression << Group(
                  _if ('_if')   +
    ZeroOrMore( _elif)('_elif') + 
       Optional(_else)('_else') 
).setParseAction(Expression)('expression')


# Form
form = (Suppress("form") + word + block )('form')

# Ignore comments
form.ignore(cStyleComment | cppStyleComment) 