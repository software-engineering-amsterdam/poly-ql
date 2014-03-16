module QL_Interpreter

open System.Collections.Generic
open System
open System.Windows.Forms;
open QL_Grammar
open QL_Csharp

let indentBlock (stmtListControl : StatementList) = let mutable margin = stmtListControl.Margin
                                                    margin.Left <- 25
                                                    stmtListControl.Margin <- margin

let assignmentGUI label expression =    let control = new StatementControl(label)
                                        let textbox = new TextBox()
                                        textbox.ReadOnly <- true
                                        control.AddControl(textbox)
                                        control

let questionGUI label qlType =  let control = new StatementControl(label)
                                match qlType with
                                | QLBool    -> let radioYes = new RadioButton()
                                               let radioNo  = new RadioButton()
                                               radioYes.Text <- "Yes"
                                               radioNo.Text <- "No"
                                               control.AddControls([| radioYes ; radioNo |])
                                | QLString
                                | QLInt
                                | QLDecimal -> control.AddControl(new TextBox())
                                control

let rec checkStmts stmts : Control list = 
    let checkStmt stmt : Control list = 
        match stmt with
        | Assignment(id, label, expression, pos)             -> [assignmentGUI label expression]
        | Question(id, label, qlType, pos)                   -> [questionGUI label qlType]
        | IfElseConditional(cond, ifStmts, elseStmts, pos)   -> let statementListIf = new StatementList()
                                                                let statementListElse = new StatementList()
                                                                statementListIf.AddControls(List.toArray <| checkStmts ifStmts)
                                                                statementListElse.AddControls(List.toArray <| checkStmts elseStmts)
                                                                indentBlock statementListIf
                                                                indentBlock statementListElse
                                                                [statementListIf ; statementListElse]
        | IfConditional(cond, stmts, pos)                   ->  let statementList = new StatementList()
                                                                statementList.AddControls(List.toArray <| checkStmts stmts)
                                                                indentBlock statementList
                                                                [statementList]
        
    List.concat <| List.map checkStmt stmts

let buildGUI ast : Control list = checkStmts ast.Statements