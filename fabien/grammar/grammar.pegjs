start = question

letter = [a-zA-Z]
number = [0-9]
word   = l:letter* { return l.join("") } 

question = word ":" word { return "Hello world!" }
