using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
    public class OrExpr : DoubleExprNode<ITypeCheckExpr>, ITypeCheckExpr
	{
		public OrExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public IType ExprType { get { return BoolType.Instance; } }

        public bool CheckTypesValid(out string msg)
        {
            if (!(Left.ExprType is BoolType && Right.ExprType is BoolType))
            {
                msg = String.Format("'||' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
                    Left.ExprType.ToString(), Right.ExprType.ToString());
                return true;
            }

            msg = null;
            return false;
        }
	}
}
