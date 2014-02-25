using QL_Grammar.QLAlgebra.Expr;

namespace QL_ExtensionTest.QLPrint.Expr
{
    public class IfElseExpr : TripleExpr<IPrintExpr>, IPrintExpr
    {
        public IfElseExpr(IPrintExpr a, IPrintExpr b, IPrintExpr c)
            : base(a, b, c)
        {

        }

        public string BuildDocument()
        {
            return Expr1.BuildDocument() + " ? " + Expr2.BuildDocument() + " : " + Expr3.BuildDocument();
        }
    }
}
