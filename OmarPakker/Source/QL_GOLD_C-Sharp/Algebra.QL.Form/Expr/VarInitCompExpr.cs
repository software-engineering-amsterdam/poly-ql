using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarInitCompExpr : VarInitExpr<IFormExpr, IFormType>, IFormExpr
    {
        public event Action ValueChanged
        {
            add { Value.ValueChanged += value; }
            remove { Value.ValueChanged -= value; }
        }

        public VarInitCompExpr(string name, IFormType type, IFormExpr value)
            : base(name, type, value)
		{
            
		}

        public void SetValue(VarEnvironment env, object value)
        {
            Value.SetValue(env, value);
        }

        public object Eval(VarEnvironment env)
        {
            return Value.Eval(env);
        }

        public IFormType BuildForm(VarEnvironment env)
        {
            if (!env.IsDeclared(Name) && !env.IsRepeated(Name))
            {
                env.Declare(Name, this);
            }

            IFormType type = Value.BuildForm(env);
            type.SetValue(this);

            return type;
        }
    }
}
