using System;
using QL_ExtensionTest.QLTypeCheckExtensions.Expr;
using QL_Grammar.Algebra.Type;
using QL_Grammar.Check;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_ExtensionTest.Check
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
				ReportError(expr.CreateTypeCheckError(String.Format("Power not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}

		protected IType CheckExpr(ModuloExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Modulo not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}
	}
}
