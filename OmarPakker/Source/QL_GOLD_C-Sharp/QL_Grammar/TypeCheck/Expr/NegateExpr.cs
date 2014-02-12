using System;
using System.Collections.Generic;
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

        public IType ExprType { get { return Expr1.ExprType; } }

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!(Expr1.ExprType is BoolType || Expr1.ExprType is NumericType))
            {
                yield return new Tuple<string, bool>(String.Format("Negation not possible. Incompatible type: '{0}', Only bool and numerical types are supported.",
                    Expr1.ExprType.ToString()), true);
            }
        }
	}
}
