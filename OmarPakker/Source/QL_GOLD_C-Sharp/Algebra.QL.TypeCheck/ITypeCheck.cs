using System;

namespace Algebra.QL.TypeCheck
{
	public interface ITypeCheck
	{
		Tuple<int, int> SourcePosition { get; set; }
	}
}
