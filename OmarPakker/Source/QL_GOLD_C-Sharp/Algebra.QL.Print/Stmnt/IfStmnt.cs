using System.Windows.Documents;
using Algebra.QL.Print.Expr;
using Algebra.QL.Core.Stmnt;

namespace Algebra.QL.Print.Stmnt
{
    public class IfStmnt : IfStmnt<IPrintExpr, IPrintStmnt>, IPrintStmnt
    {
        public IfStmnt(IPrintExpr check, IPrintStmnt ifTrue)
            : base(check, ifTrue)
        {

        }

        public Block BuildDocument()
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("if") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(" (");
            p.Inlines.AddRange(CheckExpression.BuildDocument());
            p.Inlines.Add(")");

            Block ifTrueBlock = IfTrueBody.BuildDocument();
            ifTrueBlock.Margin = StyleSettings.Intendation;

            Section s = new Section();
            s.Blocks.Add(p);
            s.Blocks.Add(new Paragraph(new Run("{")));
            s.Blocks.Add(ifTrueBlock);
            s.Blocks.Add(new Paragraph(new Run("}")));

            return s;
        }
    }
}
