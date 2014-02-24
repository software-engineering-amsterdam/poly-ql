grammar Welcome;   // Define a grammar called Welcome
r : 'welcome' ID ; // match keyword welcome followed by an identifier
ID : [a-z]+ ;    // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines, \r 