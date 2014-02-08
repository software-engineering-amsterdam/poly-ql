using System;
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

        public bool CheckTypesValid(out string msg)
        {
            msg = String.Empty;

            if(!(ExprA.ExprType is BoolType))
            {
                msg = String.Format("Inline 'if/else' evaluation failed. Incompatible type: '{0}'. Only the bool type is supported.",
                    ExprA.ExprType.ToString());
            }

            if (!ExprB.ExprType.CompatibleWith(ExprC.ExprType))
            {
                msg += String.Format(" Return value conflict. Incompatible types: '{0}', '{1}'. Only similar types can be used in the true/false bodies.",
                    ExprB.ExprType.ToString(), ExprC.ExprType.ToString());
            }

            if(String.IsNullOrEmpty(msg))
            {
                return false;
            }

            return true;
        }
    }
}
