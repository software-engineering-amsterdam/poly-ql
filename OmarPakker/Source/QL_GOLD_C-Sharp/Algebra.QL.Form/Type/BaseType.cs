using System.Windows;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Type
{
	public abstract class BaseType : IFormType
	{
        public abstract IFormExpr DefaultValue { get; }

		public BaseType()
		{

		}

        public abstract FrameworkElement BuildElement(IFormExpr value, object initialValue, bool editable);

		public override string ToString()
		{
			return "undefined";
		}
	}
}
