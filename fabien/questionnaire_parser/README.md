Software Construction
=====================

This project contains domain specific language parser for a custom questionnaire language (QL).
The QL allows creation of (simple) forms with questions. In addition, the questions may
set conditions to alter the questionnaire flow (based on user input some questions remain hidden, some are shown). 
Finally, it is possible to include computed values. For instance, a date of birth field that automatically gets the
person's age. 

# Dependencies

* Python 2.7
* PyParsing (pip install pyparsing or http://pyparsing.wikispaces.com/)


# Usage

Running the parser:

`python parser.py -f forms/if-else.txt`


# Notes / TODO

* (semi) The parser of the DSL is implemented using a grammar-based parser generator.
* (XML tree > AST) The internal structure of a DSL program is represented using abstract syntax trees.
* QL programs are executed as GUI programs, not command-line dialogues.
* QL programs are executed by interpretation, not code generation.
* Questions are enabled and disabled when different values are entered.
* The type checker detects:

    - Reference to undefined questions
    - Duplicate question declarations with different types
    - Conditions that are not of the type boolean
    - Operands of invalid type to operators
    - references to questions with an undefined value
    - Cyclic dependencies between questions
    - Duplicate labels (warning)

* The language supports booleans, integers and string values.
* Different data types in QL map to different GUI widgets.