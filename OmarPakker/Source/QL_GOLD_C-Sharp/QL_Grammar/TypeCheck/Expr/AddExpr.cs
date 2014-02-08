using System;
using System.Collections.Generic;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
    public class AddExpr : DoubleExprNode<ITypeCheckExpr>, ITypeCheckExpr
    {
        public AddExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public IType ExprType { get { return NumericType.Instance; } }

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!(Left.ExprType is NumericType && Right.ExprType is NumericType))
            {
                yield return new Tuple<string, bool>(String.Format("Addition not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    Left.ExprType.ToString(), Right.ExprType.ToString()), true);
            }
        }
    }
}
