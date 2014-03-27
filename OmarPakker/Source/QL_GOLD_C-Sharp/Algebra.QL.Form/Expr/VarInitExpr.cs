using Algebra.QL.Eval.Expr;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarInitExpr : VarInitExpr<IFormExpr, IFormType>, IFormExpr
    {
        public VarInitExpr(string name, IFormType type)
            : base(name, type, type.DefaultValue)
        {
            
        }

        public VarInitExpr(string name, IFormType type, IFormExpr value)
            : base(name, type, value)
        {

        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            if (!env.IsDeclared(Name))
            {
                env.Declare(Name, Type);
            }

            return Type;
        }
    }
}
