module Program
open System
open QL_Grammar

let parse str =
    let lexbuf = Lexing.LexBuffer<_>.FromString str
    QL_Parser.start QL_Lexer.tokenize lexbuf

let x = Console.ReadLine()
let y = parse x
printfn "%A" y

Console.WriteLine("(press any key)")
Console.ReadKey(true) |> ignore