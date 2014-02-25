using System.Windows.Documents;
using QL_ExtensionTest.QLPrint.Expr;
using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_ExtensionTest.QLPrint.Stmnt
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
            p.Inlines.Add(CheckExpression.BuildDocument());
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
