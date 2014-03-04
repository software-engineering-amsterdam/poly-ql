using System;
using System.IO;

namespace Algebra.Core.GrammarParser
{
    public interface IParser
    {
        event Action<Tuple<int, int>, Tuple<int, int>, object> OnReduction;
        event Action<object> OnCompletion;
        event Action OnGroupError;
        event Action OnInternalError;
        event Action OnNotLoadedError;
        event Action<Tuple<int, int>, object> OnLexicalError;
        event Action<Tuple<int, int>, object, string> OnSyntaxError;

        bool LoadGrammar(BinaryReader reader);

        bool Parse(string text);
        bool Parse(TextReader reader);
    }
}
