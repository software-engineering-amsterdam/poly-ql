using System;
using System.Collections.Generic;
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

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (Value.ExprType is UnknownType)
            {
                yield return new Tuple<string, bool>(String.Format("Undefined variable '{0}' used. Make sure the variable is defined.", Name), true);
            }
        }
    }
}
