using System.Windows;
using System.Windows.Documents;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<IPrintExpr, IPrintStmnt>, IPrintStmnt
    {
        public IfElseStmnt(IPrintExpr check, IPrintStmnt ifTrue, IPrintStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
        {

        }

        public Block BuildDocument(int indentation)
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("if") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(" (");
            p.Inlines.AddRange(CheckExpression.BuildDocument());
            p.Inlines.Add(")");

            Section s = new Section() { Margin = new Thickness(indentation, 0, 0, 0) };
            s.Blocks.Add(p);
            s.Blocks.Add(IfTrueBody.BuildDocument(indentation));
            s.Blocks.Add(new Paragraph(new Run("else") { Foreground = StyleSettings.KeyWordColor }));
            s.Blocks.Add(IfFalseBody.BuildDocument(indentation));

            return s;
        }
    }
}
