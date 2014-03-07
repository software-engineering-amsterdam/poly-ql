using System;
using System.Diagnostics;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Type
{
    public class BaseType : ITypeCheckType
	{
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }
        public virtual ITypeCheckExpr DefaultValue { get { return null; } }
        public virtual ITypeCheckType SuperType { get { return null; } }

        public BaseType()
        {

        }

        public bool CompatibleWith(ITypeCheckType other)
        {
            if (Equals(other) || IsChildOf(other) || other.IsChildOf(this))
            {
                return true;
            }

            return false;
        }

        public bool IsChildOf(ITypeCheckType other)
        {
            if (SuperType != null && (SuperType.Equals(other) || SuperType.IsChildOf(other)))
            {
                return true;
            }

            return false;
        }

        public ITypeCheckType GetLeastUpperBound(ITypeCheckType other)
        {
            if (Equals(other) || other.IsChildOf(this))
            {
                return this;
            }
            else if (IsChildOf(other))
            {
                return other;
            }

            Debug.Assert(SuperType != null, "SuperType is null!");

            return SuperType.GetLeastUpperBound(other);
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
