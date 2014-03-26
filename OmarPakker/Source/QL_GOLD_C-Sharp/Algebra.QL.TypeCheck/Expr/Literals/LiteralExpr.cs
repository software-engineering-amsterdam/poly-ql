using System;
using Algebra.QL.Core.Expr;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public abstract class LiteralExpr<V> : LiteralExpr<ITypeCheckType, V>, ITypeCheckExpr
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public ITypeCheckType TypeCheck(TypeEnvironment env)
        {
            return Type;
        }
    }
}
