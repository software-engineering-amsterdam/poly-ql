using System;

namespace QL_Grammar.AST.Expr
{
	public class VarExprNode : IExprNode
	{
		public Tuple<int, int> SourcePosition { get; set; }
		public string Name { get; private set; }

		public VarExprNode(string name)
		{
			Name = name;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is VarExprNode))
			{
				return false;
			}

			return Name.Equals(((VarExprNode)obj).Name);
		}
	}
}
