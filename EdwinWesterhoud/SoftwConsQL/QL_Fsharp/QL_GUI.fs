module QL_GUI

open System.Collections.Generic
open System.Windows.Forms
open QL_Grammar
open ControlInfo
open QL_Interpreter
open QL_Csharp
open QL_Csharp.PrimitiveControls

let indentBlock (stmtListControl : StatementList) = let mutable margin = stmtListControl.Margin
                                                    margin.Left <- 25
                                                    stmtListControl.Margin <- margin

let setBlockVisibility (block : StatementList) newVisibility = block.Visible <- newVisibility

let rec buildStatements statements (controlInfo : ControlInfo) : Control list =

    let assignmentGUI label expression : StatementControl = let expressionEval = evalExpression expression controlInfo
                                                            match expressionEval with
                                                            | Bool(value)    -> let control = new BooleanControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control
                                                            | String(value)  -> let control = new StringControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control
                                                            | Int(value)     -> let control = new IntegerControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control
                                                            | Decimal(value) -> let control = new DecimalControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control

    let questionGUI label qlType : StatementControl =   match qlType with
                                                        | QLBool    -> upcast new BooleanControl(label)
                                                        | QLString  -> upcast new StringControl(label)
                                                        | QLInt     -> upcast new IntegerControl(label)
                                                        | QLDecimal -> upcast new DecimalControl(label)

    let rec getIdentifierControls expression =  match expression with
                                                | ID(name, _)   -> [controlInfo.GetControl(name)]
                                                | Literal(_, _) -> []
                                                | Neg(expr, _)  -> getIdentifierControls expr
                                                | BooleanOp(left, _, right, _)
                                                | ArithmeticOp(left, _, right, _) -> getIdentifierControls left @ getIdentifierControls right

    let addConditionalEvents condition (statementList : StatementList) =
        let identifierControls = getIdentifierControls condition
        List.iter
            (
                fun (identifier : StatementControl) ->
                    identifier.AddValueChangedEventHandler(
                        fun _ _ -> setBlockVisibility statementList <| evalCondition condition controlInfo
                    )
            )
            identifierControls

    let addAssigmentEvents expression (control : StatementControl) =
        let identifierControls = getIdentifierControls expression
        List.iter
            (
                fun (identifier : StatementControl) ->
                    identifier.AddValueChangedEventHandler(
                        fun _ _ -> setControlValue control <| evalExpression expression controlInfo
                    )
            )
            identifierControls
    
    let processConditional condition body = let statementList = new StatementList()
                                            statementList.AddControls(List.toArray <| buildStatements body controlInfo)
                                            indentBlock statementList
                                            setBlockVisibility statementList <| evalCondition condition controlInfo
                                            addConditionalEvents condition statementList
                                            statementList
    
    let buildStatement stmt : Control list =
        match stmt with
        | Assignment(id, label, expression, pos)             -> let control = assignmentGUI label expression
                                                                controlInfo.AddControl(id, control)
                                                                addAssigmentEvents expression control
                                                                [control]
        | Question(id, label, qlType, pos)                   -> let control = questionGUI label qlType
                                                                controlInfo.AddControl(id, control)
                                                                [control]
        | IfElseConditional(cond, ifBody, elseBody, pos)     -> [processConditional cond ifBody ; processConditional <| Neg(cond, pos) <| elseBody]
        | IfConditional(cond, body, pos)                     -> [processConditional cond body]

    List.concat <| List.map buildStatement statements

let buildGUI ast : Control list =   let controlInfo = new ControlInfo()
                                    buildStatements ast.Statements controlInfo