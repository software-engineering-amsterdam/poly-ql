module QL_Main
open System
open System.Windows.Forms;
open QL_Grammar
open QL_Checker
open QL_Csharp

Application.EnableVisualStyles()
Application.SetCompatibleTextRenderingDefault(false)
let mainForm = new Form1()

let parse_string inputString = let lexbuf = Lexing.LexBuffer<_>.FromString inputString
                               QL_Parser.start QL_Lexer.tokenize lexbuf

let buttonGenerate_Click _ _ = let lexbuf = Lexing.LexBuffer<_>.FromString mainForm.InputText
                               try
                                   let ast = QL_Parser.start QL_Lexer.tokenize lexbuf
                                   let checkInfo = typeCheck ast
                                   if mainForm.CheckTypes && checkInfo.HasErrors then
                                        // Type error(s):
                                        mainForm.SetOutputText(String.concat Environment.NewLine checkInfo.ErrorList)
                                   else // No parse/type errors:
                                        mainForm.SetOutputText(sprintf "%+A" ast)
                               with err -> // Parse error:
                                       let message = err.Message
                                       let s_pos = lexbuf.StartPos
                                       let e_pos = lexbuf.EndPos
                                       mainForm.SetOutputText(sprintf "%s between line %i, column %i and line %i column %i" 
                                        message
                                        (s_pos.Line+1) s_pos.Column
                                        (e_pos.Line+1) e_pos.Column)

mainForm.AddClickEventHandler(new System.EventHandler(buttonGenerate_Click))


[<STAThread>]
do Application.Run(mainForm)
exit 0