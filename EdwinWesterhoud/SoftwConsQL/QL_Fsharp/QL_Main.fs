module QL_Main
open System
open QL_Grammar
open QL_Checker

let parse lexbuf = QL_Parser.start QL_Lexer.tokenize lexbuf

let parse_str str checkTypes = let lexbuf = Lexing.LexBuffer<_>.FromString str
                               try 
                                   let ast = parse lexbuf
                                   if checkTypes then
                                        typeCheck ast
                                   else
                                        ast
                               with err ->
                                       let message = err.Message
                                       let s_pos = lexbuf.StartPos
                                       let e_pos = lexbuf.EndPos
                                       let startPos = Position(s_pos.Line+1, s_pos.Column+1)
                                       let endPos = Position(e_pos.Line+1, e_pos.Column+1)
                                       //let lastToken = new System.String(lexbuf.Lexeme)
                                       raise << ParseErrorException <| ParseErrorExceptionMessage(message, startPos, endPos)

// Used for direct input in console
let x = Console.ReadLine()

let y = let lexbuf = Lexing.LexBuffer<_>.FromString x
        try 
            parse lexbuf
        with err ->
                let pos = lexbuf.EndPos
                let line = pos.Line
                let column = pos.Column
                let message = err.Message
                //let lastToken = new System.String(lexbuf.Lexeme)
                printf "%s at line %d, column %d:\n" message line column
                printf "\n"
                Console.WriteLine("(press any key)")
                Console.ReadKey(true) |> ignore
                exit 1;

printfn "%A" y

Console.WriteLine();
let check = typeCheck y
printfn "%A" check

Console.WriteLine("(press any key)")
Console.ReadKey(true) |> ignore