using System.Windows.Documents;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Type
{
    public interface IPrintType : IPrint
    {
        IPrintExpr DefaultValue { get; }

        Inline BuildDocument();
    }
}
