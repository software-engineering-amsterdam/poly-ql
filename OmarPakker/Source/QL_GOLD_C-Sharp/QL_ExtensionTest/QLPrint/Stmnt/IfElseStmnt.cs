using System.Windows.Documents;
using QL_ExtensionTest.QLPrint.Expr;
using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_ExtensionTest.QLPrint.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<IPrintExpr, IPrintStmnt>, IPrintStmnt
	{
        public IfElseStmnt(IPrintExpr check, IPrintStmnt ifTrue, IPrintStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
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
            Block ifFalseBlock = IfFalseBody.BuildDocument();
            ifTrueBlock.Margin = ifFalseBlock.Margin = StyleSettings.Intendation;

            Section s = new Section();
            s.Blocks.Add(p);
            s.Blocks.Add(new Paragraph(new Run("{")));
            s.Blocks.Add(ifTrueBlock);
            s.Blocks.Add(new Paragraph(new Run("}")));
            s.Blocks.Add(new Paragraph(new Run("else") { Foreground = StyleSettings.KeyWordColor }));
            s.Blocks.Add(new Paragraph(new Run("{")));
            s.Blocks.Add(ifFalseBlock);
            s.Blocks.Add(new Paragraph(new Run("}")));

            return s;
        }
	}
}
