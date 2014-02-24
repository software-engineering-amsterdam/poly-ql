using System;

namespace QL_Grammar.QLTypeCheck
{
	public interface ITypeCheck
	{
		Tuple<int, int> SourcePosition { get; set; }
	}
}
