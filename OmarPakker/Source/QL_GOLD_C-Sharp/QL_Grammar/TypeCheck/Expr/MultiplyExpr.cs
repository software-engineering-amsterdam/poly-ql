using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
    public class MultiplyExpr : DoubleExprNode<ITypeCheckExpr>, ITypeCheckExpr
	{
		public MultiplyExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public IType ExprType { get { return NumericType.Instance; } }

        public bool CheckTypesValid(out string msg)
        {
            if (!(Left.ExprType is NumericType && Right.ExprType is NumericType))
            {
                msg = String.Format("Multiplication not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    Left.ExprType.ToString(), Right.ExprType.ToString());
                return true;
            }

            msg = null;
            return false;
        }
	}
}
