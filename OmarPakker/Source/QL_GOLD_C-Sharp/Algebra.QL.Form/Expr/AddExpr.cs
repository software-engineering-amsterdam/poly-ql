using System;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Expr
{
    public class AddExpr : BinaryExpr, IFormExpr
    {
        public AddExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        public override object Eval(VarEnvironment env)
        {
            return Convert.ToDouble(Expr1.Eval(env)) + Convert.ToDouble(Expr2.Eval(env));
        }
    }
}
