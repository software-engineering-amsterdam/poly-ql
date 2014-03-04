using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class VarInitExpr : VarInitExpr<ITypeCheckExpr, ITypeCheckType>, ITypeCheckExpr
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

		public VarInitExpr(string name, ITypeCheckType type, ITypeCheckExpr value)
            : base(name, type, value)
		{

		}

        public ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            if (env.IsVarDeclared(Name))
			{
                ITypeCheckType varType = env.GetVariable(Name).Type;
                if (!varType.Equals(Type))
				{
                    errRep.ReportError(this, String.Format("Variable '{0}' is already defined as '{1}'. Redefining as '{2}'. You cannot redefine variables.",
                        Name, varType, Type));
				}
				else
				{
                    errRep.ReportWarning(this, String.Format("Re-using variable '{0}'. Are you sure you want to re-use this variable?",
						Name));
				}
			}
			else
			{
				env.DeclareVariable(this);
			}

			ITypeCheckType a = Value.TypeCheck(env, errRep);
			if (!Type.CompatibleWith(a))
			{
                errRep.ReportError(this, String.Format("Can't assign value of {0} to variable of type {1}.",
					a, Type));
			}
			else if (!Type.GetLeastUpperBound(a).Equals(Type))
			{
                errRep.ReportWarning(this, String.Format("Assigning value of type {0} to a variable of type {1}. You may lose some information.",
					a, Type));
			}

			return Type;
        }
    }
}
