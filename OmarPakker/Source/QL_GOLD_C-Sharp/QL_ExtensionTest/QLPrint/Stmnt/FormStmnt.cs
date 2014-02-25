using System.Windows.Documents;
using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_ExtensionTest.QLPrint.Stmnt
{
    public class FormStmnt : FormStmnt<IPrintStmnt>, IPrintStmnt
    {
        public FormStmnt(string name, IPrintStmnt body)
            : base(name, body)
        {

        }

        public Block BuildDocument()
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("form") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(" ");
            p.Inlines.Add(new Run(Name) { Foreground = StyleSettings.ReferenceColor });

            Block bodyBlock = Body.BuildDocument();
            bodyBlock.Margin = StyleSettings.Intendation;

            Section s = new Section();
            s.Blocks.Add(p);
            s.Blocks.Add(new Paragraph(new Run("{")));
            s.Blocks.Add(bodyBlock);
            s.Blocks.Add(new Paragraph(new Run("}")));

            return s;
        }
    }
}
