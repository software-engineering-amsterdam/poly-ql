using System.Windows.Documents;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Type
{
	public abstract class BaseType : IPrintType
	{
        public abstract IPrintExpr DefaultValue { get; }

		public BaseType()
		{

		}

        public Inline BuildDocument()
        {
            return new Run(ToString()) { Foreground = StyleSettings.KeyWordColor };
        }

		public override string ToString()
		{
			return "undefined";
		}
	}
}
