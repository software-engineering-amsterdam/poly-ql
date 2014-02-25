using System.Windows.Documents;
using QL_ExtensionTest.QLPrint.Expr;
using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_ExtensionTest.QLPrint.Stmnt
{
    public class QuestionStmnt : QuestionStmnt<IPrintExpr>, IPrintStmnt
    {
        public QuestionStmnt(string text, bool editable, IPrintExpr e)
            : base(text, editable, e)
        {

        }

        public Block BuildDocument()
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run(QuestionText) { Foreground = StyleSettings.QuestionStringColor });
            p.Inlines.Add(Editable ? " >> " : " << ");
            p.Inlines.Add(Expression.BuildDocument());
            p.Inlines.Add(";");
            return p;
        }
    }
}
