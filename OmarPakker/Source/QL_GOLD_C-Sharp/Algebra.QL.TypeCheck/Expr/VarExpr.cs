using System;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class VarExpr : Algebra.Core.Expr.VarExpr, ITypeCheckExpr
	{
        public Tuple<int, int> SourcePosition { get; set; }

		public VarExpr(string name)
			: base(name)
		{

		}

        public ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            if (!env.IsVarDeclared(Name))
            {
                errRep.ReportError(String.Format("Undefined variable '{0}' used. Make sure the variable is defined.",
                    Name), SourcePosition);

                return new UnknownType();
            }

            return env.GetVariable(Name).Type;
        }
    }
}
