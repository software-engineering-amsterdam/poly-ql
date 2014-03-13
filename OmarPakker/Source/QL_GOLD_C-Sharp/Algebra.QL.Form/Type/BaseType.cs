using System.Diagnostics;
using System.Windows;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Type
{
	public class BaseType : IFormType
	{
        public virtual IFormExpr DefaultValue { get { return null; } }
        public virtual IFormType SuperType { get { return null; } }

		public BaseType()
		{

		}

        public virtual FrameworkElement BuildElement(IFormExpr value, bool editable)
        {
            return null;
        }

        public bool IsChildOf(IFormType other)
        {
            if (SuperType != null && (SuperType.Equals(other) || SuperType.IsChildOf(other)))
            {
                return true;
            }

            return false;
        }

        public IFormType GetLeastUpperBound(IFormType other)
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
	}
}
