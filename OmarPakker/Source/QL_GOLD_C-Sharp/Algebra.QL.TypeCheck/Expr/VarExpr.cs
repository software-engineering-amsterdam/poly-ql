using System;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class VarExpr : Algebra.Core.Expr.VarExpr, ITypeCheckExpr
	{
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

		public VarExpr(string name)
			: base(name)
		{

		}

        public ITypeCheckType TypeCheck(TypeEnvironment env)
        {
            if (!env.IsDeclared(Name))
            {
                env.ReportError(String.Format("Undefined variable '{0}' used. Make sure the variable is defined.",
                    Name), SourceStartPosition, SourceEndPosition);

                return new UnknownType();
            }

            return env.GetDeclared(Name);
        }
    }
}
