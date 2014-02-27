using System;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class VarExpr : Algebra.Core.Expr.VarExpr, ITypeCheckExpr
	{
		public VarExpr(string name)
			: base(name)
		{

		}

        public ITypeCheckType TypeCheck(TypeCheckData data)
        {
            if (!data.Variables.ContainsKey(Name))
            {
                data.ReportError(String.Format("Undefined variable '{0}' used. Make sure the variable is defined.",
                    Name), SourcePosition);

                return new UnknownType();
            }

            return data.Variables[Name].Type;
        }
    }
}
