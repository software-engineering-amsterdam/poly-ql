module Program
open System
open QL_Grammar

let parse lexbuf = 
    let res = QL_Parser.start QL_Lexer.tokenize lexbuf
    res
let parse_str str = let lexbuf = Lexing.LexBuffer<_>.FromString str
                    parse lexbuf


let x = Console.ReadLine()

let y = let lexbuf = Lexing.LexBuffer<_>.FromString x
        try 
            parse lexbuf
        with err ->
                let pos = lexbuf.EndPos
                let line = pos.Line
                let column = pos.Column
                let message = err.Message
                let lastToken = new System.String(lexbuf.Lexeme)
                printf "Parse failed at line %d, column %d:\n" line column
                printf "Last loken: %s" lastToken
                printf "\n"
                Console.WriteLine("(press any key)")
                Console.ReadKey(true) |> ignore
                exit 1;

printfn "%A" y

Console.WriteLine("(press any key)")
Console.ReadKey(true) |> ignore