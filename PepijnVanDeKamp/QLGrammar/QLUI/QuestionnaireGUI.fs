module QuestionnaireGUI
open System.Windows.Forms
open QL
open QL.Values
open QL.AbstractSyntaxTree
open QLUI.WindowsForms.Abstract
open QLUI.WindowsForms.Forms

let BuildGUI (ast:Form) = 
    let questionnaireForm = new QLUI.WindowsForms.Forms.QLQuestionnaireForm();
    
    let createQuestionControl id label qltype isreadonly : QuestionControl =
        match qltype with
        | QL_Boolean -> upcast new QLUI.WindowsForms.QuestionTypes.BooleanQuestionControl(id,label,isreadonly)
        | QL_Integer -> upcast new QLUI.WindowsForms.QuestionTypes.IntQuestionControl(id,label,isreadonly)
        | QL_String  -> upcast new QLUI.WindowsForms.QuestionTypes.StringQuestionControl(id,label,isreadonly)

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


