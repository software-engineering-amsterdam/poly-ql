using System;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Type
{
	public class BaseType : ITypeCheckType
	{
        public Tuple<int, int> SourcePosition { get; set; }
        public virtual ITypeCheckType SuperType { get { return new BaseType(); } }
        public virtual ITypeCheckExpr DefaultValue { get { return null; } }

		public BaseType()
		{

		}

        public ITypeCheckType GetLeastUpperBound(ITypeCheckType other)
		{
            if (Equals(other))
            {
                return this;
            }

            ITypeCheckType abortType = new BaseType();

            for (ITypeCheckType a = SuperType; !a.Equals(abortType); a = a.SuperType)
            {
                for (ITypeCheckType b = other.SuperType; !b.Equals(abortType); b = b.SuperType)
                {
                    if(a == b)
                    {
                        return a;
                    }
                }
            }

            return new UnknownType();
		}

        public bool CompatibleWith(ITypeCheckType other)
		{
			return Equals(other) || SuperType.Equals(other) || other.SuperType.Equals(this);
		}

		public sealed override bool Equals(object obj)
		{
			return GetType().Equals(obj.GetType());
		}

		public sealed override int GetHashCode()
		{
			return GetType().GetHashCode();
		}

		public override string ToString()
		{
			return "undefined";
		}
	}
}
