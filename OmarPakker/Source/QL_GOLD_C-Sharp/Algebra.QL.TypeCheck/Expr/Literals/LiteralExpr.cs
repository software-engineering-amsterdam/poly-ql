using System;
using Algebra.QL.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
	public abstract class LiteralExpr<V> : LiteralExpr<ITypeCheckType, V>, ITypeCheckExpr
	{
        public Tuple<int, int> SourcePosition { get; set; }

		protected LiteralExpr(V value)
			: base(value)
		{

		}

        public ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            return Type;
        }
    }
}
