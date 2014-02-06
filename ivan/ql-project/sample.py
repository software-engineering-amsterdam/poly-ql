__author__ = 'Ivan'
""" Basic example from http://fdik.org/pyPEG """

from pypeg2 import *

# A Symbol can be an arbitrary word or one word of an Enum.
# In this easy example there is an Enum.

class Type(Keyword):
    grammar = Enum( K("int"), K("long") )

# Parsing attributes adds them to the resulting thing.
# blank is a callback function. Callback functions are being executed by
# compose(). parse() ignores callback functions. blank inserts " ".
# name() generates a name attribute.

class Parameter(object):
    grammar = attr("typing", Type), blank, name()

# A Namespace is a container for named things.
# csl() creates the grammar for a comma separated list.

class Parameters(Namespace):
    grammar = optional(csl(Parameter))

# This is an example for a user defined callback function, heading().
# endl is a special callback function. It is never executed. Instead it
# triggers the indention system of compose() and will be replaced by "\n".

class Instruction(str):
    def heading(self, parser):
        return "/* on level " + str(parser.indention_level) + " */", endl

    grammar = heading, word, ";", endl

# indent() is a function which marks things for being indented by compose().
# indent() raises the indention level by 1 for each thing which is inside.

block = "{", endl, maybe_some(indent(Instruction)), "}", endl

# If a thing is a List, then parsed things are being put into.

class Function(List):
    grammar = attr("typing", Type), blank, name(), "(", attr("parms", Parameters), ")", endl, block

if __name__ == '__main__':
    f = parse("int f(int a, long b) { do_this; do_that; }", Function, comment=comment_c)
    print(f.parms)
    print(f.parms["a"])
    print(f.parms["a"].typing)
