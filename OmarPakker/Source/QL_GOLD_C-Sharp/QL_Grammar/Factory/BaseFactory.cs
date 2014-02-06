using System;
using System.Collections.Generic;
using QL_Grammar.Expr;
using QL_Grammar.Value;

namespace QL_Grammar.Factory
{
	public class BaseFactory<T> : IFactory<IExpr, IExpr>
	{
		private readonly Dictionary<String, IValue> variables;

		public BaseFactory()
		{
			variables = new Dictionary<string, IValue>();
		}

		public IExpr String(string s)
		{
			return new LiteralExpr(new StringValue(s));
		}

		public IExpr Int(int i)
		{
			return new LiteralExpr(new IntValue(i));
		}

		public IExpr Real(double d)
		{
			return new LiteralExpr(new RealValue(d));
		}

		public IExpr Bool(bool b)
		{
			return new LiteralExpr(new BoolValue(b));
		}

		public IExpr IfElse(IExpr toEval, IExpr ifTrue, IExpr ifFalse)
		{
			return new IfElseExpr<T>(toEval, ifTrue, ifFalse);
		}

		public IExpr Or(IExpr a, IExpr b)
		{
			return new OrExpr(a, b);
		}

		public IExpr And(IExpr a, IExpr b)
		{
			return new AndExpr(a, b);
		}

		public IExpr Eq(IExpr a, IExpr b)
		{
			return new EqualsExpr(a, b);
		}

		public IExpr NotEq(IExpr a, IExpr b)
		{
			return new NotEqualExpr(a, b);
		}

		public IExpr LessThen(IExpr a, IExpr b)
		{
			return new LessThenExpr(a, b);
		}

		public IExpr GreaterThen(IExpr a, IExpr b)
		{
			return new GreaterThenExpr(a, b);
		}

		public IExpr LessOrEqualTo(IExpr a, IExpr b)
		{
			return new LessOrEqualToExpr(a, b);
		}

		public IExpr GreaterOrEqualTo(IExpr a, IExpr b)
		{
			return new GreaterOrEqualToExpr(a, b);
		}

		public IExpr Add(IExpr a, IExpr b)
		{
			return new AddExpr(a, b);
		}

		public IExpr Subtract(IExpr a, IExpr b)
		{
			return new SubtractExpr(a, b);
		}

		public IExpr Multiply(IExpr a, IExpr b)
		{
			return new MultiplyExpr(a, b);
		}

		public IExpr Divide(IExpr a, IExpr b)
		{
			return new DivideExpr(a, b);
		}

		public IExpr Negate(IExpr a)
		{
			return new NegateExpr(a);
		}

		public IExpr Variable(string var)
		{
			return new LiteralExpr(variables[var]);
		}

		public IExpr Assign(string var, IExpr a)
		{
			IValue value = a.Eval();
			variables.Add(var, value);
			return new LiteralExpr(value);
		}

		//public IExpr ExprToStmnt(IExpr expr);
		//public IExpr Composition(IExpr a, IExpr b);
	}
}
