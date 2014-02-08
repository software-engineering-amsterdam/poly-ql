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

        public IType ExprType { get { return ExprB.ExprType.CompatibleWith(ExprC.ExprType) ? ExprB.ExprType : UnknownType.Instance; } }

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!(ExprA.ExprType is BoolType))
            {
                yield return new Tuple<string, bool>(String.Format("Inline 'if/else' evaluation failed. Incompatible type: '{0}'. Only the bool type is supported.",
                    ExprA.ExprType.ToString()), true);
            }

            if (!ExprB.ExprType.CompatibleWith(ExprC.ExprType))
            {
                yield return new Tuple<string, bool>(String.Format("Inline 'if/else' return value conflict. Incompatible types: '{0}', '{1}'. Only similar types can be used in the true/false bodies.",
                    ExprB.ExprType.ToString(), ExprC.ExprType.ToString()), true);
            }
        }
    }
}
