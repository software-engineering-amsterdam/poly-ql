using System;
using System.Collections.Generic;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.TypeCheck.Expr
{
	public interface ITypeCheckExpr : IExprNode
	{
        IType ExprType { get; }

        IEnumerable<Tuple<string, bool>> CheckTypesValid();
	}
}
