using System;
using Algebra.Core.Expr;

namespace Algebra.QL.TypeCheck.Expr
{
    public abstract class BinaryExpr : BinaryExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public BinaryExpr(ITypeCheckExpr e1, ITypeCheckExpr e2)
            : base(e1, e2)
        {

        }
    }
}
