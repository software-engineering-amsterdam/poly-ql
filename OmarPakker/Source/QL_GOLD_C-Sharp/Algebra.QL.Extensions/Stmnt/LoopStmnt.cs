using System;
using Algebra.Core.Tree;

namespace Algebra.QL.Extensions.Stmnt
{
    public abstract class LoopStmnt<E, S> : IStmntNode
    {
        public Tuple<int, int> SourcePosition { get; set; }
        public E Expression { get; private set; }
        public S Body { get; private set; }

        public LoopStmnt(E expr, S body)
        {
            Expression = expr;
            Body = body;
        }

        public override bool Equals(object obj)
        {
            if (!(obj is LoopStmnt<E, S>))
            {
                return false;
            }

            LoopStmnt<E, S> other = (LoopStmnt<E, S>)obj;
            return Expression.Equals(other.Expression)
                && Body.Equals(other.Body);
        }

        public override int GetHashCode()
        {
            return Expression.GetHashCode() + Body.GetHashCode();
        }
    }
}
