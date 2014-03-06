using System;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public interface IFormExpr
    {
        event Action ValueChanged;
        object ExpressionValue { get; set; }

        IFormType BuildForm();
    }
}
