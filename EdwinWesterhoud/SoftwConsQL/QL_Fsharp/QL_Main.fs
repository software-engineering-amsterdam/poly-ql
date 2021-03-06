﻿module QL_Main
open System
open System.Windows.Forms;
open QL_Grammar
open QL_Checker
open TypeCheckInfo
open QL_GUI
open QL_Csharp

Application.EnableVisualStyles()
Application.SetCompatibleTextRenderingDefault(false)
let mainForm = new SourceForm()

let parse_string inputString = let lexbuf = Lexing.LexBuffer<_>.FromString inputString
                               QL_Parser.start QL_Lexer.tokenize lexbuf

let buttonGenerate_Click _ _ = let lexbuf = Lexing.LexBuffer<_>.FromString mainForm.InputText
                               let mutable isParsing = true
                               try
                                   let ast = QL_Parser.start QL_Lexer.tokenize lexbuf
                                   isParsing <- false
                                   let checkInfo = typeCheck ast
                                   if checkInfo.HasErrors then
                                        // Type error(s):
                                        mainForm.SetOutputText(String.concat Environment.NewLine <| List.map fst checkInfo.ErrorList)
                                        List.iter (fun (_, position:Position) -> mainForm.UnderlineParseError(position.StartCharacter, position.EndCharacter - position.StartCharacter)) checkInfo.ErrorList
                                   else // No parse/type errors:
                                        mainForm.SetOutputText(String.concat Environment.NewLine <| List.map fst checkInfo.WarningList)
                                        let qForm = new QuestionnaireForm(ast.ID)
                                        qForm.AddControls(List.toArray <| QL_GUI.buildGUI ast)
                                        qForm.Show()
                               with err when isParsing ->   let message = err.Message
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