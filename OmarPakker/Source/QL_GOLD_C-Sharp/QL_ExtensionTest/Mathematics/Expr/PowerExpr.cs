using System;
using System.Collections.Generic;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;
using QL_Grammar.TypeCheck.Expr;

namespace QL_ExtensionTest.Mathematics.Expr
{
    public class PowerExpr : DoubleExprNode<ITypeCheckExpr>, ITypeCheckExpr
    {
        public PowerExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public IType ExprType { get { return NumericType.Instance; } }

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!(Expr1.ExprType is NumericType && Expr2.ExprType is NumericType))
            {
                yield return new Tuple<string, bool>(String.Format("Power not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    Expr1.ExprType.ToString(), Expr2.ExprType.ToString()), true);
            }
        }
    }
}
