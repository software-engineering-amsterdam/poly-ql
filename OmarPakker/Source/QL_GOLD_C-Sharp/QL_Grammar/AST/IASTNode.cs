using System;

namespace QL_Grammar.AST
{
	public interface IASTNode
	{
		Tuple<int, int> SourcePosition { get; set; }
	}
}
