using System;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public interface IFormExpr : IForm, IDisposable
    {
        event Action ValueChanged;
        object ExpressionValue { get; set; }
        IFormType ExpressionType { get; }

        IFormExpr Clone();
    }
}
