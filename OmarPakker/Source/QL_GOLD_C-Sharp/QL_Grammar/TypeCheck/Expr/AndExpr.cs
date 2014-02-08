using System;
using System.Collections.Generic;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
    public class AndExpr : DoubleExprNode<ITypeCheckExpr>, ITypeCheckExpr
	{
        public AndExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public IType ExprType { get { return BoolType.Instance; } }

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!(Left.ExprType is BoolType && Right.ExprType is BoolType))
            {
                yield return new Tuple<string, bool>(String.Format("'&&' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
                    Left.ExprType.ToString(), Right.ExprType.ToString()), true);
            }
        }
	}
}
