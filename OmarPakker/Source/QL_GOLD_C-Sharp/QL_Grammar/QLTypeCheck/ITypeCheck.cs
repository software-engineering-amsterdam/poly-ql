using System;

namespace QL_Grammar.QLTypeCheck
{
    //public delegate void OnTypeCheckErrorEventHandler(string msg, bool error);

	public interface ITypeCheck
	{
        //event OnTypeCheckErrorEventHandler OnTypeCheckError;

		Tuple<int, int> SourcePosition { get; set; }
	}
}
