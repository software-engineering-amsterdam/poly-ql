form ::= question
form ::= questions



fields ::= label field
field ::= field_label checkbox
field ::= field_label radio
field ::= field_label textbox

label ::= factor
field_label ::= factor
radio ::= factor
checkbox ::= factor
textbox ::= factor

question ::= fields
questions ::= question devider question

expr ::= expr expr 
expr ::= term

term ::= term factor
term ::= factor

factor ::= str
factor ::= number
factor ::= dev