using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class VarExpr : QL_Grammar.QLAlgebra.Expr.VarExpr, ITypeCheckExpr
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
