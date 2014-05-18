module Program
open System
open System.Windows.Forms;
open System.Linq
open QLUI
open QuestionnaireGUI
open QL.Parsing
open QL.Checking
open QL.Checks


Application.EnableVisualStyles()
Application.SetCompatibleTextRenderingDefault(false)
let checkers = [DuplicateLabelsCheck;ReferenceUndefinedQuestionsCheck;DuplicateQuestionDeclarationsMustBeOfSameTypeCheck;ExpressionMustBeOfExpectedTypeCheck;OperandsMustBeOfValidTypeToOperatorsCheck;CyclicDependencyCheck]
let mainForm = new QLUserInterface.QLComposerForm()

let parseButtonClick _ _ =
    let setTreeToControl tree = mainForm.setParseTree(tree.ToString())
    let MessagesToString messages = match messages with 
                                    | [] -> ""
                                    | _  ->  messages |> List.map (fun m -> m.ToString()) |> List.reduce (fun acc elem -> acc + Environment.NewLine + elem)
    let setMessagesToControl messages = messages |> MessagesToString |> mainForm.setMessages
    let checkAst ast = checkers |> List.map (fun check -> check ast) |> List.reduce (fun acc elem -> acc @ elem)
    let hasError messages = List.exists (fun (m:Message) -> not <| m.AllowGUIRendering) messages
    let processResult (result:ParseResult) =
        match result.ParseTree with
        | Some ast -> ast |> setTreeToControl
                      let checkMessages = ast |> checkAst
                      checkMessages |> setMessagesToControl
                      if not <| hasError checkMessages then BuildGUI ast
        | None     -> String.Empty |> setTreeToControl
                      result.Messages |> setMessagesToControl
    mainForm.getInputString() |> ParseToParseResult |> processResult



mainForm.AddParseEventHandler(new System.EventHandler(parseButtonClick))


   

[<STAThread>]
do Application.Run(mainForm)
exit 0

