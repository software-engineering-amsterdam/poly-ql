using System;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class PowerExpr : DoubleExpr<IEvalExpr>, IEvalExpr
    {
        public PowerExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
        {

        }

        public IValue Eval()
        {
            IValue lEval = Expr1.Eval();
            IValue rEval = Expr2.Eval();

            if (lEval is RealValue || rEval is RealValue)
            {
                return new RealValue(Math.Pow((double)lEval.Value, (double)rEval.Value));
            }
            else
            {
                return new IntValue((int)Math.Pow((int)lEval.Value, (int)rEval.Value));
            }
        }
    }
}
