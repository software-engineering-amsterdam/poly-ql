using System;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class PowerExpr : BinaryExpr, IFormExpr
    {
        public PowerExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        public override object Eval(VarEnvironment env)
        {
            return Math.Pow(Convert.ToDouble(Expr1.Eval(env)), Convert.ToDouble(Expr2.Eval(env)));
        }
    }
}
