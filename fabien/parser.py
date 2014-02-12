import sys
from pyparsing import *

def sentence(tokens):
  return " ".join(tokens)

# keywords

L_Bracket = Suppress("{")
R_Bracket = Suppress("}")


# define grammar
word    = Word(alphanums)

SENTENCE = OneOrMore(word).setParseAction(sentence)

# TODO allow multiple expressions with and, or, negation
EXPR     = Word(alphas)


# The question promted to the user
Q_MAIN = SENTENCE + Suppress("?")

# Set type of the question
Q_TYPE    = Group(oneOf("text string boolean money date email password") + word)

# Allow settings
Q_SETTING = Group(
    oneOf("required success error empty default") +
    Optional(
      Suppress('"') +
        SENTENCE +
      Suppress('"')
    )
  )

QUESTION = Group(Q_MAIN + Optional(Q_TYPE) + ZeroOrMore(Group(Q_SETTING)))


BLOCK      = Forward()
CONDITION = Group("if" + Word(alphas) + Group(BLOCK))
STATEMENT = (CONDITION | BLOCK | QUESTION)


BLOCK << L_Bracket + ZeroOrMore( STATEMENT ) + R_Bracket


FORM = "form" + Word(alphas) + Group(BLOCK)


if __name__ == "__main__":
  parsed = FORM.parseFile('if.txt')

  print parsed
