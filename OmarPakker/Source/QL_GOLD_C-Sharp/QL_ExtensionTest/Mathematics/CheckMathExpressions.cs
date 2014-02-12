using System;
using QL_ExtensionTest.Mathematics.Expr;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;
using QL_Grammar.Check;

namespace QL_ExtensionTest.Mathematics
{
	public class CheckMathExpressions : CheckExpressions
	{
		public override IType CheckExpr(IExprNode expr)
		{
			return CheckExpr((dynamic)expr);
		}

		protected IType CheckExpr(PowerExpr expr)
		{
			IType a = CheckExpr((dynamic)expr.Expr1);
			IType b = CheckExpr((dynamic)expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				AddError(String.Format("Power not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true, expr.SourcePosition);
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}

		protected IType CheckExpr(ModuloExpr expr)
		{
			IType a = CheckExpr((dynamic)expr.Expr1);
			IType b = CheckExpr((dynamic)expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				AddError(String.Format("Modulo not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true, expr.SourcePosition);
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}
	}
}
