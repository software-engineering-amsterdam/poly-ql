using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class IfElseExpr : TernaryExpr<IFormExpr>, IFormExpr
    {
        public event Action ValueChanged
        {
            add { Expr1.ValueChanged += value; Expr2.ValueChanged += value; Expr3.ValueChanged += value; }
            remove { Expr1.ValueChanged -= value; Expr2.ValueChanged -= value; Expr3.ValueChanged -= value; }
        }

        public IfElseExpr(IFormExpr a, IFormExpr b, IFormExpr c)
            : base(a, b, c)
        {
            
        }

        public void SetValue(VarEnvironment env, object value)
        {

        }

        public object Eval(VarEnvironment env)
        {
            return Convert.ToBoolean(Expr1.Eval(env)) ? Expr2.Eval(env) : Expr3.Eval(env);
        }

        public IFormType BuildForm(VarEnvironment env)
        {
            IFormType a = Expr2.BuildForm(env);
            IFormType b = Expr3.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);
            type.SetElementExpression(this);

            return type;
        }
    }
}
