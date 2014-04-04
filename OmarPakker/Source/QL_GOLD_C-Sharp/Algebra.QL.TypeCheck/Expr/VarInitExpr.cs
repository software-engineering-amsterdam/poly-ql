using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public class VarInitExpr : VarInitExpr<ITypeCheckExpr, ITypeCheckType>, ITypeCheckExpr
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public VarInitExpr(string name, ITypeCheckType type)
            : this(name, type, type.DefaultValue)
        {

        }

        public VarInitExpr(string name, ITypeCheckType type, ITypeCheckExpr value)
            : base(name, type, value)
        {

        }

        public ITypeCheckType TypeCheck(ITypeEnvironment env)
        {
            if (env.IsDeclared(Name))
            {
                ITypeCheckType varType = env.GetDeclared(Name);
                if (!varType.Equals(Type))
                {
                    env.ReportError(String.Format("Variable '{0}' is already defined as '{1}'. Redefining as '{2}'. You cannot redefine variables.",
                        Name, varType, Type), SourceStartPosition, SourceEndPosition);
                }
                else
                {
                    env.ReportWarning(String.Format("Re-using variable '{0}'. Are you sure you want to re-use this variable?",
                        Name), SourceStartPosition, SourceEndPosition);
                }
            }
            else
            {
                env.Declare(Name, Type);
            }

            ITypeCheckType a = Value.TypeCheck(env);
            if (!Type.CompatibleWith(a))
            {
                env.ReportError(String.Format("Can't assign value of {0} to variable of type {1}.",
                    a, Type), SourceStartPosition, SourceEndPosition);
            }
            else if (!Type.GetLeastUpperBound(a).Equals(Type))
            {
                env.ReportWarning(String.Format("Assigning value of type {0} to a variable of type {1}. You may lose some information.",
                    a, Type), SourceStartPosition, SourceEndPosition);
            }

            return Type;
        }
    }
}
