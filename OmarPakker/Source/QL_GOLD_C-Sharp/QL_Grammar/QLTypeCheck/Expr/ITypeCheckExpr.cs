using System;
using QL_Grammar.Algebra.Type;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public interface ITypeCheckExpr : ITypeCheck
	{
        //Type of expression, Any errors?
		//Tuple<IType, bool> TypeCheck();
	}
}
