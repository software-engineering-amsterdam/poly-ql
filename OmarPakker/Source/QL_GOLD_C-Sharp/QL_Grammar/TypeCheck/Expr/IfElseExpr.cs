using System;
using System.Collections.Generic;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
    public class IfElseExpr : TripleExprNode<ITypeCheckExpr>, ITypeCheckExpr
    {
        public IfElseExpr(ITypeCheckExpr a, ITypeCheckExpr b, ITypeCheckExpr c)
            : base(a, b, c)
        {

        }

        public IType ExprType { get { return Expr2.ExprType.CompatibleWith(Expr3.ExprType) ? Expr2.ExprType : UnknownType.Instance; } }

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!(Expr1.ExprType is BoolType))
            {
                yield return new Tuple<string, bool>(String.Format("Inline 'if/else' evaluation failed. Incompatible type: '{0}'. Only the bool type is supported.",
                    Expr1.ExprType.ToString()), true);
            }

            if (!Expr2.ExprType.CompatibleWith(Expr3.ExprType))
            {
                yield return new Tuple<string, bool>(String.Format("Inline 'if/else' return value conflict. Incompatible types: '{0}', '{1}'. Only similar types can be used in the true/false bodies.",
                    Expr2.ExprType.ToString(), Expr3.ExprType.ToString()), true);
            }
        }
    }
}
