using System;
using System.Collections.Generic;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.Check
{
	public class CheckExpressions
	{
		public OnTypeCheckErrorEventHandler ReportError { get; internal set; }

		protected Dictionary<string, VarInitExpr> variables { get; private set; }

		public CheckExpressions()
		{
			variables = new Dictionary<string, VarInitExpr>();
		}

		public void ClearVariables()
		{
			variables.Clear();
		}

		public IType Check(ITypeCheckExpr expr)
		{
			return CheckExpr(expr);
		}

		protected virtual IType CheckExpr(ITypeCheckExpr expr)
		{
			return CheckExpr((dynamic)expr);
		}

		protected IType CheckExpr(LiteralExpr expr)
		{
			return expr.Value.Type;
		}

		protected IType CheckExpr(VarExpr expr)
		{
			if (!variables.ContainsKey(expr.Name))
			{
                ReportError(expr.CreateTypeCheckError(String.Format("Undefined variable '{0}' used. Make sure the variable is defined.",
					expr.Name), true));
				return UnknownType.Instance;
			}

			return variables[expr.Name].Type;
		}

		protected IType CheckExpr(VarInitExpr expr)
		{
			if (variables.ContainsKey(expr.Name))
			{
				if (variables[expr.Name].Type != expr.Type)
				{
                    ReportError(expr.CreateTypeCheckError(String.Format("Variable '{0}' is already defined as '{1}'. Redefining as '{2}'. You cannot redefine variables.",
						expr.Name, variables[expr.Name].Type.ToString(), expr.Type.ToString()), true));
				}
				else
				{
                    ReportError(expr.CreateTypeCheckError(String.Format("Re-using variable '{0}'. Are you sure you want to re-use this variable?",
						expr.Name), false));
				}
			}
			else
			{
				variables.Add(expr.Name, expr);
			}

			IType a = CheckExpr(expr.Value);
			if (!expr.Type.CompatibleWith(a))
			{
                ReportError(expr.CreateTypeCheckError(String.Format("Can't assign value of {0} to variable of type {1}.",
					a.ToString(), expr.Type.ToString()), true));
			}
			else if (expr.Type is IntType && a is RealType)
			{
                ReportError(expr.CreateTypeCheckError("Assigning real value to an int variable. You'll lose decimal information.",
					false));
			}

			return expr.Type;
		}

		protected IType CheckExpr(AddExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Addition not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));

				return NumericType.Instance;
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}

		protected IType CheckExpr(SubtractExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Subtraction not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));

				return NumericType.Instance;
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}

		protected IType CheckExpr(MultiplyExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Multiplication not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));

				return NumericType.Instance;
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}

		protected IType CheckExpr(DivideExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Division not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));

				return NumericType.Instance;
			}

			return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
		}

		protected IType CheckExpr(AndExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is BoolType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("'&&' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(OrExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is BoolType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("'||' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(EqualsExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Comparison using '==' not possible. Incompatible types: '{0}', '{1}'.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(NotEqualExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Comparison using '!=' not possible. Incompatible types: '{0}', '{1}'.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(GreaterOrEqualToExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Comparison using '>=' not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(GreaterThenExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Comparison using '>' not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(LessOrEqualToExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Comparison using '<=' not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(LessThenExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);

			if (!(a is NumericType) || !a.CompatibleWith(b))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Comparison using '<' not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a.ToString(), b.ToString()), true));
			}

			return BoolType.Instance;
		}

		protected IType CheckExpr(NegateExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);

			if (!(a is BoolType || a is NumericType))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Negation not possible. Incompatible type: '{0}', Only bool and numerical types are supported.",
					a.ToString()), true));

				return UnknownType.Instance;
			}

			return a;
		}

		protected IType CheckExpr(IfElseExpr expr)
		{
			IType a = CheckExpr(expr.Expr1);
			IType b = CheckExpr(expr.Expr2);
			IType c = CheckExpr(expr.Expr3);

			if (!(a is BoolType))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Inline 'if/else' evaluation failed. Incompatible type: '{0}'. Only the bool type is supported.",
					a.ToString()), true));
			}

			if (!b.CompatibleWith(c))
			{
				ReportError(expr.CreateTypeCheckError(String.Format("Inline 'if/else' return value conflict. Incompatible types: '{0}', '{1}'. Only similar types can be used in the true/false bodies.",
					b.ToString(), c.ToString()), true));
			}

			return b.CompatibleWith(c) ? ((a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance)
				: UnknownType.Instance;
		}
	}
}
