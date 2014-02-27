using System;
using System.Windows.Documents;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Type
{
	public abstract class BaseType : IPrintType
	{
        public Tuple<int, int> SourcePosition { get; set; }
        public abstract IPrintExpr DefaultValue { get; }

		public BaseType()
		{

		}

        public Inline BuildDocument()
        {
            return new Run(ToString()) { Foreground = StyleSettings.KeyWordColor };
        }

		public sealed override bool Equals(object obj)
		{
            return obj is BaseType;
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
