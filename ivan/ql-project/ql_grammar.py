__author__ = 'Ivan'

""" The pyPEG2 grammar for the QL language """

from pypeg2 import *
from re import *


# Supported types: boolean, integer and string.
class Type(Keyword):
    grammar = Enum(K("boolean"), K("integer"), K("string"))


# Label text should not contain double quotes
class Label(str):
    grammar = '"', attr("text", re.compile(r"[^\"]+")), '"'


class Question(str):
    grammar = indent(name(), ":", blank, attr("label", Label), blank, attr("type", Type), endl)


class Comment(str):
    grammar = indent(comment_cpp, endl)


class Form(List):
    grammar = "form ", name(), ":", endl, some(Question)


test_form = ('form TestFormName:\n'
             '    firstQuestionName: "First Question Label?" boolean\n'
             '    secondQuestionName: "Second Question Label:" integer\n'
             '    thirdQuestionName: "Third Question Label:" string\n'
)