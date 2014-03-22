using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public abstract class BinaryExpr : BinaryExpr<IFormExpr>, IFormExpr
    {
        public event Action ValueChanged
        {
            add { Expr1.ValueChanged += value; Expr2.ValueChanged += value; }
            remove { Expr1.ValueChanged -= value; Expr2.ValueChanged -= value; }
        }

        public BinaryExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {
            
        }

        public void SetValue(VarEnvironment env, object value)
        {

        }

        public abstract object Eval(VarEnvironment env);

        public IFormType BuildForm(VarEnvironment env)
        {
            IFormType a = Expr1.BuildForm(env);
            IFormType b = Expr2.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);
            type.SetElementExpression(this);

            return type;
        }
    }
}
