using System.Windows;
using System.Windows.Documents;
using Algebra.QL.Core.Stmnt;

namespace Algebra.QL.Print.Stmnt
{
    public class FormStmnt : FormStmnt<IPrintStmnt>, IPrintStmnt
    {
        public FormStmnt(string name, IPrintStmnt body)
            : base(name, body)
        {

        }

        public Block BuildDocument(int indentation)
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("form") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(" ");
            p.Inlines.Add(new Run(Name) { Foreground = StyleSettings.ReferenceColor });

            Section s = new Section() { Margin = new Thickness(indentation, 0, 0, 0) };
            s.Blocks.Add(p);
            s.Blocks.Add(Body.BuildDocument(indentation + StyleSettings.IntendationAmount));

            return s;
        }
    }
}
