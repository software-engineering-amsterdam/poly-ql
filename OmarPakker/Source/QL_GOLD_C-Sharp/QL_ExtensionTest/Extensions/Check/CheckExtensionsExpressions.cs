using System;
using QL_ExtensionTest.Extensions.Expr;
using QL_Grammar.Algebra.Type;
using QL_Grammar.Check;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Types;

namespace QL_ExtensionTest.Extensions.Check
{
	public class CheckExtensionsExpressions : CheckExpressions
	{
		protected override IType CheckExpr(ITypeCheckExpr expr)
		{
			return CheckExpr((dynamic)expr);
		}

		protected IType CheckExpr(PowerExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				AddError(String.Format("Power not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true, expr.SourcePosition);
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}

		protected IType CheckExpr(ModuloExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				AddError(String.Format("Modulo not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true, expr.SourcePosition);
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}
	}
}
