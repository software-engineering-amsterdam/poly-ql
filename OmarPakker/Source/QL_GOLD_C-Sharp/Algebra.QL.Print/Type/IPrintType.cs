using System.Windows.Documents;
using Algebra.Core.Tree;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Print.Type
{
    public interface IPrintType : IPrint, ITypeNode
    {
        IPrintExpr DefaultValue { get; }

        Inline BuildDocument();
    }
}
