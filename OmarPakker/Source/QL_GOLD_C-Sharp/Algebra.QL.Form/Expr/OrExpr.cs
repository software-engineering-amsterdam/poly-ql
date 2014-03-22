using System;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Expr
{
    public class OrExpr : BinaryExpr, IFormExpr
	{
		public OrExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}

        public override object Eval(VarEnvironment env)
        {
            return Convert.ToBoolean(Expr1.Eval(env)) || Convert.ToBoolean(Expr2.Eval(env));
        }
	}
}
