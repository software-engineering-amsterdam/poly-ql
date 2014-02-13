import sys
import pprint

from pyparsing import *

class Question:

  question = "Hello person"
  settings = {}

  def __init__(self):
    self.type = "question"




def sentence(tokens):
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

def toQuestion(tokens):
  question = { 
    "element"  : "question",
    "question" : tokens[0].q_main,
    "settings" : tokens[0].settings
  }

  # Check if question type and ID are set for reference
  if tokens[0].q_type:
    question["id"]   = tokens[0].q_type[1]
    question["type"] = tokens[0].q_type[0]

  else:
    # Set default type
    question["id"]   = "undefined"
    question["type"] = "string"

  return question


# Suppress single characters
L_Bracket = Suppress("{")
R_Bracket = Suppress("}")

D_QUOTE = Suppress('"')


# define grammar
word    = Word(alphanums)

# Sentence groups multiple words in a single string (instead of a list)
SENTENCE = OneOrMore(word).setParseAction(sentence)

# TODO allow multiple expressions with and, or, negation
EXPR     = Word(alphas)


# The question promted to the user
Q_MAIN = SENTENCE('q_main') + Suppress("?")

# Set type of the question
Q_TYPE    = Group(oneOf("text string boolean money date email password") + word)

# Allow settings
Q_SETTING = Group(
    oneOf("required success error empty default") +
    Optional(
      D_QUOTE +
        SENTENCE +
      D_QUOTE
    )
  )

QUESTION = Group(Q_MAIN + Optional(Q_TYPE('q_type')) + Group(ZeroOrMore(Q_SETTING)).setParseAction(toDict)('settings') ).setParseAction(toQuestion)('question')


# Allow recursion
BLOCK      = Forward()

CONDITION = Group("if" + word + BLOCK)
STATEMENT = (CONDITION | BLOCK | QUESTION)

BLOCK << L_Bracket + ZeroOrMore( STATEMENT ) + R_Bracket

FORM = Group(Suppress("form") + Word(alphas) + BLOCK)

FORMS = ZeroOrMore(FORM)

if __name__ == "__main__":
  parsed = FORMS.parseFile('form.txt')

  pprint.pprint(parsed, width=1)
