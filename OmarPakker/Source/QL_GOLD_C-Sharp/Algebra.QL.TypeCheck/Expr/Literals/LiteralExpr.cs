using System;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public abstract class LiteralExpr<V> : Algebra.Core.Expr.LiteralExpr<V>, ITypeCheckExpr
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public abstract ITypeCheckType TypeCheck(ITypeEnvironment env);
    }
}
