namespace QLUI
module GUIBuilder =
    open System.Windows.Forms
    open QL
    open QL.AbstractSyntaxTree
    open QL.Interpreter
    open QLUI.WindowsForms.Abstract
    open QLUI.WindowsForms.Forms
    open QLUI.InterpretGUI

    
    let BuildGUI (ast:Form) formControl = 
    
        let joinMaps map1 map2 = Map.fold (fun acc key value -> Map.add key value acc) map1 map2
    
        let mapControls parentControl createFunction statements  = statements |> List.map (fun s -> createFunction s parentControl Map.empty) |> List.reduce joinMaps
    
        let rec createQuestionControls statement (parentControl:QLQuestionnaireForm) (controlmap:Map<string,QuestionControl>) = 
            let createQuestionControl id label qltype isreadonly : QuestionControl =
                match qltype with
                | QL_Boolean -> upcast new QLUI.WindowsForms.QuestionTypes.BooleanQuestionControl(id,label,isreadonly)
                | QL_Integer -> upcast new QLUI.WindowsForms.QuestionTypes.IntQuestionControl(id,label,isreadonly)
                | QL_String  -> upcast new QLUI.WindowsForms.QuestionTypes.StringQuestionControl(id,label,isreadonly) 
    
            let addControl  id label qltype readonly (controlmap:Map<string,QuestionControl>) = 
                let control = createQuestionControl id label qltype readonly
                control |> parentControl.AddControl
                controlmap.Add(id, control)
   
            match statement with
            | Question(id,label,qltype,_)                    -> addControl id label qltype false controlmap
            | ComputedQuestion(id,label,qltype,expression,_) -> addControl id label qltype true controlmap
            | IfThen(_,thenstatements, _)                    -> thenstatements |> mapControls parentControl createQuestionControls |> joinMaps controlmap
            | IfThenElse(_,thenstatements,elsestatements, _) -> controlmap |> joinMaps (thenstatements |> mapControls parentControl createQuestionControls) |> joinMaps (elsestatements |> mapControls parentControl createQuestionControls)
    
        let rec getDependentExpressionControls (controlmap:Map<string,QuestionControl>) expression =
            match expression with
            | Id(id) -> [controlmap.[id]]
            | LiteralStatement(literalValue) -> []
            | Neg(innerExpression) -> getDependentExpressionControls controlmap innerExpression 
            | BinaryExpression(leftExpression,_,rightExpression) 
            | ArithmeticExpression(leftExpression,_,rightExpression) -> getDependentExpressionControls controlmap leftExpression  @ getDependentExpressionControls controlmap rightExpression
        
        let doQuestionControlVisibility statementids expression (controlmap:Map<string,QuestionControl>) =
            let expressionOutcome = evaluateExpression controlmap expression
            match expressionOutcome with
            | Boolean(value) -> statementids |> List.iter (fun (x:string) -> controlmap.[x].Visible <- value)
            | _ -> failwith "Conditional expression did not return boolean value"

        let addVisibilityEvent expression statementids (controlmap:Map<string,QuestionControl>) =
            let eventcontrols = expression |> getDependentExpressionControls controlmap
            let visibilityEventHandler _ = doQuestionControlVisibility statementids expression controlmap
            List.iter (fun (x:QuestionControl) -> x.ValueChanged.Add(visibilityEventHandler)) eventcontrols
            visibilityEventHandler()
        
        let computeQuestionValue expression questionId (controlmap:Map<string,QuestionControl>) =
            expression |> evaluateExpression controlmap |> setValueToControl controlmap.[questionId]

        let addComputationEvent expression questionId (controlmap:Map<string,QuestionControl>) = 
            let eventcontrols = expression |> getDependentExpressionControls controlmap
            let computationEventHandler _ = computeQuestionValue expression questionId controlmap
            List.iter (fun (x:QuestionControl) -> x.ValueChanged.Add(computationEventHandler)) eventcontrols
            computationEventHandler()

        let Compute (ast:Form) (controlmap:Map<string,QuestionControl>) =
            let foldLists = List.fold (fun acc elem -> acc @ elem ) [] 
            let rec ComputeQuestionValues statement =
                match statement with
                | Question(id,_,_,_)                                      -> [id]
                | ComputedQuestion(id,label,qltype,expression,_)          -> addComputationEvent expression id controlmap
                                                                             [id]
                | IfThen(expression,thenstatements, _)                    -> let childstatements = thenstatements |> List.map ComputeQuestionValues |> foldLists
                                                                             addVisibilityEvent expression childstatements controlmap
                                                                             childstatements
                | IfThenElse(expression,thenstatements,elsestatements, _) -> let thenchildstatements = thenstatements |> List.map ComputeQuestionValues |> foldLists
                                                                             let elsechildstatements = elsestatements |> List.map ComputeQuestionValues |> foldLists
                                                                             addVisibilityEvent expression thenchildstatements controlmap
                                                                             addVisibilityEvent (Neg(expression)) elsechildstatements controlmap
                                                                             thenchildstatements @ elsechildstatements

            ast.StatementList |> List.map ComputeQuestionValues |> foldLists

            

        ast.StatementList |> mapControls formControl createQuestionControls |> Compute ast


    
    
    
    
    