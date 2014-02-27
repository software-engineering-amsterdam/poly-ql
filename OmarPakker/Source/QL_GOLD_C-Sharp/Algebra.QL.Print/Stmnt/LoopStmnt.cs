using System.Windows.Documents;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Stmnt
{
	public class LoopStmnt : IPrintStmnt
	{
		public IPrintExpr Expression { get; private set; }
        public IPrintStmnt Body { get; private set; }

        public LoopStmnt(IPrintExpr expr, IPrintStmnt body)
		{
			Expression = expr;
			Body = body;
		}

        public Block BuildDocument()
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("loop") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(" (");
            p.Inlines.AddRange(Expression.BuildDocument());
            p.Inlines.Add(")");

            Block bodyBlock = Body.BuildDocument();
            bodyBlock.Margin = StyleSettings.Intendation;

            Section s = new Section();
            s.Blocks.Add(p);
            s.Blocks.Add(new Paragraph(new Run("{")));
            s.Blocks.Add(bodyBlock);
            s.Blocks.Add(new Paragraph(new Run("}")));

            return s;
        }
    }
}
