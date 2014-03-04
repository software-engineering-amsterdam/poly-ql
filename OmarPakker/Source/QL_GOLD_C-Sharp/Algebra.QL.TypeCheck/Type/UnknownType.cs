using System;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Type
{
	//TODO: Get rid of UnknownType?
	public sealed class UnknownType : ITypeCheckType
	{
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }
        public ITypeCheckType SuperType { get { return new UnknownType(); } }
		public ITypeCheckExpr DefaultValue { get { return null; } }

        public UnknownType()
        {

        }

        public ITypeCheckType GetLeastUpperBound(ITypeCheckType other)
		{
			return this;
		}

        public bool CompatibleWith(ITypeCheckType other)
		{
			return false;
		}

        public override bool Equals(object obj)
        {
            return GetType().Equals(obj.GetType());
        }

        public override int GetHashCode()
        {
            return GetType().GetHashCode();
        }

		public override string ToString()
		{
			return "unknown";
		}
	}
}
