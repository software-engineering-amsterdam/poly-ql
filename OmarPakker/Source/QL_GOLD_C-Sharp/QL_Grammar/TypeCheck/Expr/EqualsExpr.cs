using System;
using System.Collections.Generic;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
    public class EqualsExpr : DoubleExprNode<ITypeCheckExpr>, ITypeCheckExpr
	{
		public EqualsExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public IType ExprType { get { return BoolType.Instance; } }

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!Expr1.ExprType.CompatibleWith(Expr2.ExprType))
            {
                yield return new Tuple<string, bool>(String.Format("Comparison using '==' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
                    Expr1.ExprType.ToString(), Expr2.ExprType.ToString()), true);
            }
        }
	}
}
