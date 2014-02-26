namespace QL
module Parsing =
 
    open System   

  
    let Parse x = 
        let lexbuf = Lexing.LexBuffer<_>.FromString x
        let y = QlParser.start QlLexer.tokenize lexbuf   
        y