form ::= form form_name bracket_open questions bracket_close
form ::= term

form_name ::= factor
bracket_open ::= factor
bracket_close ::= factor

questions ::= question questions
question ::= field

fields ::= field fields
fields ::= field
field ::= fieldlabel field_question checkbox
field ::= fieldlabel field_question radio
field ::= fieldlabel field_question textbox

field_question ::= factor
fieldlabel ::= factor

radio ::= factor
checkbox ::= factor
textbox ::= factor

term ::= factor

factor ::= Form
factor ::= FormName
factor ::= bracket_op
factor ::= bracket_cl
factor ::= string
factor ::= number
factor ::= float
factor ::= bool
