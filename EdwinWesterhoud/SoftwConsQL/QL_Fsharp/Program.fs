module Program
open System
open QL_Grammar
 
let x = Console.ReadLine()
 
let lexbuf = Lexing.LexBuffer<_>.FromString x
let y = QL_Parser.start QL_Lexer.tokenize lexbuf
printfn "%A" y   
 
Console.WriteLine("(press any key)")   
Console.ReadKey(true) |> ignore