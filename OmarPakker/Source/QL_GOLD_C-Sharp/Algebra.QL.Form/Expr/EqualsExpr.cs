using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Expr
{
    public class EqualsExpr : BinaryExpr, IFormExpr
	{
		public EqualsExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}

        public override object Eval(VarEnvironment env)
        {
            return Expr1.Eval(env).Equals(Expr2.Eval(env));
        }
	}
}
