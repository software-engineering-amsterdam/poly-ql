using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
    public class VarExpr : VarExprNode<ITypeCheckExpr>, ITypeCheckExpr
    {
        public VarExpr(string name, IType type, ITypeCheckExpr value)
            : base(name, type, value)
		{

		}

        public IType ExprType { get { return Value.ExprType; } }

        public bool CheckTypesValid(out string msg)
        {
            if(Value.ExprType is UnknownType)
            {
                msg = String.Format("Undefined variable '{0}' used. Make sure the variable is defined.", Name);
                return true;
            }

            msg = null;
            return ExprType.CompatibleWith(Value.ExprType);
        }
    }
}
