using System.Windows;
using System.Windows.Documents;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Stmnt
{
    public class LabelStmnt : TextExprStmnt<IPrintExpr>, IPrintStmnt
    {
        public LabelStmnt(string text, IPrintExpr e)
            : base(text, e)
        {

        }

        public Block BuildDocument(int indentation)
        {
            Paragraph p = new Paragraph() { Margin = new Thickness(indentation, 0, 0, 0) };
            p.Inlines.Add(new Run(Text) { Foreground = StyleSettings.QuestionStringColor });
            p.Inlines.Add(" << ");
            p.Inlines.AddRange(Expression.BuildDocument());
            p.Inlines.Add(";");
            return p;
        }
    }
}
