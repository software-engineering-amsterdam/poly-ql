using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarInitExpr : VarInitExpr<IFormExpr, IFormType>, IFormExpr
    {
        private readonly IEvalExpr evalExpr;

        public VarInitExpr(string name, IFormType type, IEvalExpr eval)
            : this(name, type, type.DefaultValue, eval)
        {
            
        }

        public VarInitExpr(string name, IFormType type, IFormExpr value, IEvalExpr eval)
            : base(name, type, value)
        {
            evalExpr = eval;
        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            if (!env.IsDeclared(Name))
            {
                env.Declare(Name, Type);
            }

            return Type;
        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            return evalExpr.Evaluate(env);
        }
    }
}
