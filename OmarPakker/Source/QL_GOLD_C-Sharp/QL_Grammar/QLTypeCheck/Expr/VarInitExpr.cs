using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class VarInitExpr : VarInitExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		public VarInitExpr(string name, IType type, ITypeCheckExpr value)
            : base(name, type, value)
		{

		}

        public IType TypeCheck(TypeCheckData data)
        {
            if (data.Variables.ContainsKey(Name))
			{
				if (data.Variables[Name].Type != Type)
				{
                    data.ReportError(String.Format("Variable '{0}' is already defined as '{1}'. Redefining as '{2}'. You cannot redefine variables.",
						Name, data.Variables[Name].Type.ToString(), Type.ToString()), SourcePosition);
				}
				else
				{
                    data.ReportWarning(String.Format("Re-using variable '{0}'. Are you sure you want to re-use this variable?",
						Name), SourcePosition);
				}
			}
			else
			{
				data.Variables.Add(Name, this);
			}

			IType a = Value.TypeCheck(data);
			if (!Type.CompatibleWith(a))
			{
                data.ReportError(String.Format("Can't assign value of {0} to variable of type {1}.",
					a.ToString(), Type.ToString()), SourcePosition);
			}
			else if (Type is IntType && a is RealType)
			{
                data.ReportError("Assigning real value to an int variable. You'll lose decimal information.",
					SourcePosition);
			}

			return Type;
        }
    }
}
