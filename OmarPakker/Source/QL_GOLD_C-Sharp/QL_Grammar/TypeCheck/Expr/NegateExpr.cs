using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
	public class NegateExpr : SingleExprNode<ITypeCheckExpr>, ITypeCheckExpr
	{
		public NegateExpr(ITypeCheckExpr e)
            : base(e)
		{
            
		}

        public IType ExprType { get { return Expression.ExprType; } }

        public bool CheckTypesValid(out string msg)
        {
            if (!(Expression.ExprType is BoolType || Expression.ExprType is NumericType))
            {
                msg = String.Format("Negation not possible. Incompatible type: '{0}', Only bool and numerical types are supported.",
                    Expression.ExprType.ToString());
                return true;
            }

            msg = null;
            return false;
        }
	}
}
