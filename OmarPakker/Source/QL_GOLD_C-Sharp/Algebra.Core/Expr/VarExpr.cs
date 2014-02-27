using System;
using Algebra.Core.Tree;

namespace Algebra.Core.Expr
{
	public class VarExpr : IExprNode
	{
        public Tuple<int, int> SourcePosition { get; set; }
		public string Name { get; private set; }

		public VarExpr(string name)
		{
			Name = name;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is VarExpr))
			{
				return false;
			}

			return Name.Equals(((VarExpr)obj).Name);
		}

		public override int GetHashCode()
		{
			return Name.GetHashCode();
		}
	}
}
