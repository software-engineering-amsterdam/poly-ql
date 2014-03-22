using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarInitExpr : VarInitExpr<IFormExpr, IFormType>, IFormExpr
    {
        public event Action ValueChanged
        {
            add { Value.ValueChanged += value; }
            remove { Value.ValueChanged -= value; }
        }

        public VarInitExpr(string name, IFormType type)
            : base(name, type, type.DefaultValue)
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
            IFormType type = null;

            if (!env.IsDeclared(Name))
            {
                if (env.HasSiblings(Name))
                {
                    VarInitExpr repeatedInstance = new VarInitExpr(Name, Type);
                    env.Declare(Name, repeatedInstance);

                    type = repeatedInstance.BuildForm(env);
                    type.SetValue(repeatedInstance);
                }
                else
                {
                    env.Declare(Name, this);

                    type = Value.BuildForm(env);
                    type.SetValue(this);
                }
            }
            else
            {
                IFormExpr declared = env.GetDeclared(Name);
                if (declared != this)
                {
                    type = declared.BuildForm(env);
                    type.SetValue(declared);
                }
                else
                {
                    type = Value.BuildForm(env);
                    type.SetValue(this);
                }
            }

            return type;
        }
    }
}
