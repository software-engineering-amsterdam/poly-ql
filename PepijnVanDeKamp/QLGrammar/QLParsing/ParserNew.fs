namespace QL
module ParserNew =

    let parse parsemethod source =
        let lexbuf = Lexing.LexBuffer<_>.FromString source
        parsemethod QlLexer.tokenize lexbuf  

