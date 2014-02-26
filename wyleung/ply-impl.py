#!/usr/bin/env python
# @author: Wai Yi Leung

import ply.lex as lex

# List of token names.   This is always required
tokens = (
   'FORM',
   'FORMNAME',
   # 'STATEMENTS'
   'FIELDID',
   'BRACKETOPEN',
   'BRACKETCLOSE',
   'FIELDLABEL',
   'FIELD_QUESTION',
   'BOOLEANTYPE'
)
literals = "+-*/"

# Regular expression rules for simple tokens
t_FORM    = r'form '
t_FORMNAME   = r'[a-zA-Z_][a-zA-Z0-9_]*'
# t_STATEMENTS   = r'\{ [.*]* \}'
t_FIELDID   = r'[\w]+: '

# Define a rule so we can track line numbers
def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)

def t_BRACKETOPEN(t):
    r'{'
    return t

def t_BRACKETCLOSE(t):
    r'}'
    return t


def t_FIELDLABEL(t):
    r'[\w]+:'
    return t

def t_FIELD_QUESTION(t):
    r' \'[\w\d\?/ ]+\' '
    return t

def t_BOOLEANTYPE(t):
    r' boolean '
    return t



# A string containing ignored characters (spaces and tabs)
t_ignore  = ' \t'

# Error handling rule
def t_error(t):
    print "Illegal character '%s'" % t.value[0]
    t.lexer.skip(1)

# Build the lexer
lexer = lex.lex()


##########

# data = open('tests/questionaire_skeleton.form').read()
data = open('tests/questionaire_basic.form').read()

# Give the lexer some input
lexer.input(data)

# Tokenize
while True:
    tok = lexer.token()
    if not tok: break      # No more input
    print tok
