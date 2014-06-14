namespace QLUI
module Program =
    open System
    open System.Windows.Forms;
    open System.Linq
    open QLUI
    open QLUI.Builder
    open QL.Parsing
    open QL.Checking
    open QL.Checks
    
    Application.EnableVisualStyles()
    Application.SetCompatibleTextRenderingDefault(false)
    
    let checks = [
                       duplicateLabelsCheck;
                       referenceUndefinedQuestionsCheck;
                       duplicateQuestionDeclarationsMustBeOfSameTypeCheck;
                       expressionMustBeOfExpectedTypeCheck;
                       operandsMustBeOfValidTypeToOperatorsCheck;
                       cyclicDependencyCheck
                   ]
    
    let mainForm = new QLUserInterface.QLComposerForm()
    
    let loadQuestionForm ast = 
        let questionnaireForm = new QLUI.WindowsForms.Forms.QLQuestionnaireForm()
        let controlMap = buildUI ast questionnaireForm
        questionnaireForm.Show()
    
    let parseButtonClick _ _ =
        let setTreeToControl tree = mainForm.setParseTree(tree.ToString())
        let MessagesToString messages = messages |> List.map (fun m -> m.ToString()) |> List.fold (fun acc elem -> acc + Environment.NewLine + elem) String.Empty 
        let setMessagesToControl messages = messages |> MessagesToString |> mainForm.setMessages
        let checkAst ast = checks |> List.map (fun check -> check ast) |> List.reduce (fun acc elem -> acc @ elem)
        let hasError messages = List.exists (fun (m:Message) -> not <| m.AllowGUIRendering) messages
        let processResult (result:ParseResult) =
            match result.ParseTree with
            | Some ast -> ast |> setTreeToControl
                          let checkMessages = ast |> checkAst
                          checkMessages |> setMessagesToControl
                          if not <| hasError checkMessages then loadQuestionForm ast
            | None     -> String.Empty |> setTreeToControl
                          result.Messages |> setMessagesToControl
        mainForm.getInputString() |> parseToParseResult |> processResult
    
    mainForm.AddParseEventHandler(new System.EventHandler(parseButtonClick))
    
    [<STAThread>]
    do Application.Run(mainForm)
    exit 0