module Program
open System
open System.Windows.Forms;

Application.EnableVisualStyles()
Application.SetCompatibleTextRenderingDefault(false)
let mainForm = new QLUserInterface.QLComposerForm()

[<STAThread>]
do Application.Run(mainForm)
exit 0

