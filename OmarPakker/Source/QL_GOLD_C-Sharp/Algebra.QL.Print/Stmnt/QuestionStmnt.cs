using System.Windows.Documents;
using Algebra.QL.Print.Expr;
using Algebra.QL.Core.Stmnt;

namespace Algebra.QL.Print.Stmnt
{
    public class QuestionStmnt : TextExprStmnt<IPrintExpr>, IPrintStmnt
    {
        public QuestionStmnt(string text, IPrintExpr e)
            : base(text, e)
        {

        }

        public Block BuildDocument()
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run(Text) { Foreground = StyleSettings.QuestionStringColor });
            p.Inlines.Add(" >> ");
            p.Inlines.AddRange(Expression.BuildDocument());
            p.Inlines.Add(";");
            return p;
        }
    }
}
