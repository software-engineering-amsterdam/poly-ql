start =
    additive

additive =
    left:multiplicative "+" right:additive
        { return {tag: "+", left:left, right:right}; }
  / multiplicative

multiplicative =
    left:primary "*" right:multiplicative
        { return {tag: "*", left:left, right:right}; }
  / primary

primary =
    integer
  / "(" additive:additive ")"
      { return additive; }

integer =
    digits:[0-9]+
        { return parseInt(digits.join(""), 10); }

ws
 = [ \t\r\n]