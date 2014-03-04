using System;

namespace Algebra.QL.TypeCheck
{
	public interface ITypeCheck
	{
        Tuple<int, int> SourceStartPosition { get; set; }
        Tuple<int, int> SourceEndPosition { get; set; }
	}
}
