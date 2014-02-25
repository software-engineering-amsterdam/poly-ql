using Algebra.Core.Type;
using Algebra.QL.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class VarInitExpr : VarInitExpr<IPrintExpr>, IPrintExpr
    {
        public VarInitExpr(string name, IType type, IPrintExpr value)
            : base(name, type, value)
		{

		}

        public string BuildDocument()
        {
            return Name + ":" + Type + " = " + Value.BuildDocument();
        }
    }
}
