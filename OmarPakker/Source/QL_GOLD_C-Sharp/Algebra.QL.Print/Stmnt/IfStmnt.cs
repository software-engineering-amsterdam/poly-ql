using System.Windows;
using System.Windows.Documents;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Stmnt
{
    public class IfStmnt : IfStmnt<IPrintExpr, IPrintStmnt>, IPrintStmnt
    {
        public IfStmnt(IPrintExpr check, IPrintStmnt ifTrue)
            : base(check, ifTrue)
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

            return s;
        }
    }
}
