using System.Windows;
using System.Windows.Documents;
using Algebra.QL.Print;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;

namespace Algebra.QL.Extensions.Print.Stmnt
{
    public class RepeatStmnt : IPrintStmnt
    {
        public IPrintExpr Expression { get; private set; }
        public IPrintStmnt Body { get; private set; }

        public RepeatStmnt(IPrintExpr expr, IPrintStmnt body)
        {
            Expression = expr;
            Body = body;
        }

        public Block BuildDocument(int indentation)
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("repeat") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(" (");
            p.Inlines.AddRange(Expression.BuildDocument());
            p.Inlines.Add(")");

            Section s = new Section() { Margin = new Thickness(indentation, 0, 0, 0) };
            s.Blocks.Add(p);
            s.Blocks.Add(Body.BuildDocument(indentation));

            return s;
        }
    }
}
