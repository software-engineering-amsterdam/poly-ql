using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class VarInitExpr : VarInitExpr<ITypeCheckExpr, ITypeCheckType>, ITypeCheckExpr
    {
		public VarInitExpr(string name, ITypeCheckType type, ITypeCheckExpr value)
            : base(name, type, value)
		{

		}

        public ITypeCheckType TypeCheck(TypeCheckData data)
        {
            if (data.Variables.ContainsKey(Name))
			{
				if (!data.Variables[Name].Type.Equals(Type))
				{
                    data.ReportError(String.Format("Variable '{0}' is already defined as '{1}'. Redefining as '{2}'. You cannot redefine variables.",
						Name, data.Variables[Name].Type, Type), SourcePosition);
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

			ITypeCheckType a = Value.TypeCheck(data);
			if (!Type.CompatibleWith(a))
			{
                data.ReportError(String.Format("Can't assign value of {0} to variable of type {1}.",
					a, Type), SourcePosition);
			}
			else if (!Type.GetLeastUpperBound(a).Equals(Type))
			{
                data.ReportWarning(String.Format("Assigning value of type {0} to a variable of type {1}. You may lose some information.",
					a, Type), SourcePosition);
			}

			return Type;
        }
    }
}
