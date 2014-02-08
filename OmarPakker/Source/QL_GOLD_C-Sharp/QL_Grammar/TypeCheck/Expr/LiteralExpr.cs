using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;

namespace QL_Grammar.TypeCheck.Expr
{
    public class LiteralExpr : LiteralExprNode, ITypeCheckExpr
    {
        public LiteralExpr(IValue value)
            : base(value)
        {

        }

        public IType ExprType { get { return Value.Type; } }

        public bool CheckTypesValid(out string msg)
        {
            msg = null;
            return false;
        }
    }
}
