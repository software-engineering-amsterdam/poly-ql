module QuestionnaireGUI
open System.Windows.Forms
open QL
open QL.Values
open QL.AbstractSyntaxTree
open QLUI.WindowsForms.Abstract
open QLUI.WindowsForms.Forms

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
        | ComputedQuestion(id,label,qltype,_,_)          -> addControl id label qltype true controlmap
        | IfThen(_,thenstatements, _)                    -> thenstatements |> mapControls parentControl createQuestionControls |> joinMaps controlmap
        | IfThenElse(_,thenstatements,elsestatements, _) -> controlmap |> joinMaps (thenstatements |> mapControls parentControl createQuestionControls) |> joinMaps (elsestatements |> mapControls parentControl createQuestionControls)

    ast.StatementList |> mapControls formControl createQuestionControls 



