form ::= form_name bracket_open form_body bracket_close
form ::= term
form_body ::= question
form_body ::= questions

form_name ::= factor

bracket_open ::= factor
bracket_close ::= term

fields ::= field fields
fields ::= field
field ::= fieldlabel question checkbox
field ::= fieldlabel question radio
field ::= fieldlabel question textbox

label ::= factor
field_label ::= factor
radio ::= factor
checkbox ::= factor
textbox ::= factor

question ::= factor

expr ::= expr expr 
expr ::= term

term ::= term factor
term ::= factor

factor ::= str
factor ::= number
factor ::= boolean
