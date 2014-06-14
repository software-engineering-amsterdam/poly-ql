namespace QLUI
module Builder =
    open System
    open System.Windows.Forms
    open QL
    open QL.AbstractSyntaxTree
    open QL.Interpreter
    open QLUI.WindowsForms.Abstract
    open QLUI.WindowsForms.Forms

    let buildUI (ast:Form) formControl = 
    
        let joinMaps map1 map2 = Map.fold (fun acc key value -> Map.add key value acc) map1 map2
        let foldLists = List.fold (fun acc elem -> acc @ elem ) []
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

        let processForm (ast:Form) (controlmap:Map<string,QuestionControl>) =

            let getValueFromControl (control:QuestionControl) =
                match box control with
                | :? IPrimitiveValue<bool>   -> Boolean((box control :?> IPrimitiveValue<bool>).GetValue())
                | :? IPrimitiveValue<int>    -> Integer((box control :?> IPrimitiveValue<int>).GetValue())
                | :? IPrimitiveValue<string> -> String((box control :?> IPrimitiveValue<string>).GetValue())
                | _ -> failwith "Unexpected primitive type from GUI"
            
            let setValueToControl (control:QuestionControl) value =
                match (box control, value) with
                | :? IPrimitiveValue<bool>, Boolean(innervalue)  -> (box control :?> IPrimitiveValue<bool>).SetValue(innervalue)
                | :? IPrimitiveValue<int>, Integer(innervalue)   -> (box control :?> IPrimitiveValue<int>).SetValue(innervalue)
                | :? IPrimitiveValue<string>, String(innervalue) -> (box control :?> IPrimitiveValue<string>).SetValue(innervalue)
                | _ -> failwith "Invalid combination of control and value"
            
            let evaluateExpressionFromControls (controlMap:Map<string,QuestionControl>) expression =
                let resolveIdValue id = getValueFromControl controlMap.[id]
                evaluateExpression expression resolveIdValue

            let rec getDependentExpressionControls (controlmap:Map<string,QuestionControl>) expression =
                match expression with
                | Id(id)                                -> [controlmap.[id]]
                | LiteralStatement(_)                   -> []
                | NegationExpression(innerExpression)   -> getDependentExpressionControls controlmap innerExpression 
                | BinaryExpression(left,_,right) 
                | ArithmeticExpression(left,_,right)    -> getDependentExpressionControls controlmap left  @ getDependentExpressionControls controlmap right
            
            let addEventHandler expression eventHandler (controlmap:Map<string,QuestionControl>) =
                let eventcontrols = expression |> getDependentExpressionControls controlmap
                List.iter (fun (x:QuestionControl) -> x.ValueChanged.Add(eventHandler)) eventcontrols
                eventHandler(EventArgs.Empty)

            let doQuestionControlVisibility controlids expression (controlmap:Map<string,QuestionControl>) =
                let expressionOutcome = evaluateExpressionFromControls controlmap expression
                match expressionOutcome with
                | Boolean(value) -> controlids |> List.iter (fun (x:string) -> controlmap.[x].Visible <- value)
                | _ -> failwith "Conditional expression did not return boolean value"

            let computeQuestionValue expression questionId (controlmap:Map<string,QuestionControl>) =
                expression |> evaluateExpressionFromControls controlmap |> setValueToControl controlmap.[questionId]

            let rec processStatement statement =
                let addEventHandlerToStatements statements expression = let childstatements = statements |> List.map processStatement |> foldLists
                                                                        let visibilityEventHandler _ = doQuestionControlVisibility childstatements expression controlmap
                                                                        addEventHandler expression visibilityEventHandler controlmap
                                                                        childstatements
                match statement with
                | Question(id,_,_,_)                                      -> [id]
                | ComputedQuestion(id,label,qltype,expression,_)          -> let computationEventHandler _ = computeQuestionValue expression id controlmap
                                                                             addEventHandler expression computationEventHandler controlmap
                                                                             [id]
                | IfThen(expression,thenstatements, _)                    -> addEventHandlerToStatements thenstatements expression
                | IfThenElse(expression,thenstatements,elsestatements, _) -> addEventHandlerToStatements thenstatements expression @ addEventHandlerToStatements elsestatements (NegationExpression(expression))
            ast.StatementList |> List.map processStatement |> foldLists

        ast.StatementList |> mapControls formControl createQuestionControls |> processForm ast