using System;
using Algebra.Core.Type;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Expr
{
	public class VarExpr : Algebra.QL.Core.Expr.VarExpr, ITypeCheckExpr
	{
		public VarExpr(string name)
			: base(name)
		{

		}

        public IType TypeCheck(TypeCheckData data)
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
