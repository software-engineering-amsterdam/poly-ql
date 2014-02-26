from pyparsing import *

# Takes multiple words and accepts them as a single string
def toSentence(tokens):
    return " ".join(tokens)

# Single words
word       = Word(alphanums + "`~_-+=!@#$%^&*[]:;.,'/") # all but {} () " and ?
variable   = Word(alphanums)
keyword    = oneOf("required example success error value validation")

# Multiple words
sentence   = OneOrMore(word).setParseAction(toSentence)
string     = Suppress('"') + sentence + Suppress('"')   #quotedString

type       = oneOf("boolean string integer date decimal money")('type')
key_value  = Group(keyword('key') + Optional(string)('value'))

# Settings
# To define custom messages, information labels or validations (email, password etc)
setting  = key_value('setting')
settings = Optional( Group(OneOrMore(setting))('settings') )

# For dropdown select options
# So instead of showing a checkbox Yes/No it could be Yes/No/Maybe/Not at all
indent  = Suppress(oneOf("\t * + -"))
option  = indent + string('option')
options = Optional( Group( OneOrMore(option) )('options') )

# Question
ask           = sentence('ask') + Suppress("?")
question_type = Optional(type + variable('id'))
question      = Group(ask + question_type + settings + options)('question')


# Condition block
condition = Forward()

_not     = oneOf("not !")('not') # "Not" (special precedence)
operator = oneOf("and && or || == != > >= < <= + - * /")('operator')

# Terms
left_term  = Optional(variable | condition)
right_term = Optional(condition | variable('term'))
term       = Optional(_not) + (left_term | right_term)

# Condition allows recursive/nested (terms) 
condition << Group(Suppress("(") + Group(term)('left') + Optional(operator + Group(term)('right')) + Suppress(")"))



# Put (i.e computed fields/answers)
# Match: put "Label text" (value * 3)
# Skips spacing, so also allows (value*3)
put = Group(Suppress("put") + Optional(string)('answer') + condition('computation'))('put')


# Expression
expression = Forward()

block           = Suppress("{") + ZeroOrMore(question | put | expression) + Suppress("}")
condition_block = Group(condition + block)

_if   = Suppress("if")      + condition_block('if')
_elif = Suppress("else if") + condition_block
_else = Suppress("else")    + Group(block)

expression <<  Group( _if + ZeroOrMore( _elif)('elif') + Optional(_else)('else') )('expression')


# Form
form = (Suppress("form") + word + block )('form')