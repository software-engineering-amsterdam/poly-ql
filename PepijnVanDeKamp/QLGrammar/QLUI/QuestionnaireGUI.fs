module QuestionnaireGUI
open System.Windows.Forms
open QL
open QL.AbstractSyntaxTree
open QLUI.WindowsForms.Abstract
open QLUI.WindowsForms.Forms

let BuildGUI (ast:Form) = 
    let questionnaireForm = new QLUI.WindowsForms.Forms.QLQuestionnaireForm();
    
    let createQuestionControl id label qltype isreadonly =
        match qltype with
        | QL_Boolean -> new QLUI.WindowsForms.QuestionTypes.BooleanQuestionControl(id,label,isreadonly) :> QuestionControl
        | QL_Integer -> new QLUI.WindowsForms.QuestionTypes.IntQuestionControl(id,label,isreadonly) :> QuestionControl
        | QL_String  -> new QLUI.WindowsForms.QuestionTypes.StringQuestionControl(id,label,isreadonly) :> QuestionControl

    let rec createQuestionControls statement (parentControl:QLQuestionnaireForm) = 
       match statement with
       | Question(id,label,qltype,_) -> parentControl.AddControl(createQuestionControl id label qltype false)
       | ComputedQuestion(id,label,qltype,_,_) -> parentControl.AddControl(createQuestionControl id label qltype true)
       | IfThen(_,thenstatements, _) -> //let newParentControl = new Panel()
                                        List.iter (fun x -> createQuestionControls x parentControl) thenstatements
                                        //parentControl.Controls.Add(newParentControl)
       | IfThenElse(_,thenstatements,elsestatements, _) -> //let newParentControlThen = new Panel()
                                                           List.iter (fun x -> createQuestionControls x parentControl) thenstatements
                                                           //parentControl.Controls.Add(newParentControlThen)
                                                           //let newParentControlElse = new Panel()
                                                           List.iter (fun x -> createQuestionControls x parentControl) elsestatements
                                                           //parentControl.Controls.Add(newParentControlElse)
    //let mainPanel = new Panel()
    List.iter (fun s -> createQuestionControls s questionnaireForm) ast.StatementList
    //questionnaireForm.Controls.Add(mainPanel)
    questionnaireForm.Show();


