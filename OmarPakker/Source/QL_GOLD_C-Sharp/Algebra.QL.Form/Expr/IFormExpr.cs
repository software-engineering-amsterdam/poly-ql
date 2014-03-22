using System;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public interface IFormExpr : IForm
    {
        event Action ValueChanged;

        void SetValue(VarEnvironment env, object value);
        object Eval(VarEnvironment env);
        IFormType BuildForm(VarEnvironment env);
    }
}
