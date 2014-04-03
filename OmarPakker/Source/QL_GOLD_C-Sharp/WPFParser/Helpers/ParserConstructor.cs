using System.IO;
using System.Reflection;
using Algebra.Core.Grammar;

namespace WPFParser.Helpers
{
    public static class ParserConstructor
    {
        public static Parser GetBasicParser<S, E, T, F>(F f)
            where F : Algebra.QL.Core.Factory.IStmntFactory<S, E, T>
        {
            var parser = new Algebra.QL.Core.Grammar.Parser<S, E, T, F>(f);

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Core.Grammar.QL_Grammar.egt")));

            return parser;
        }

        public static Parser GetExtendedParser<S, E, T, F>(F f)
            where F : Algebra.QL.Extensions.Factory.IStmntFactory<S, E, T>
        {
            var parser = new Algebra.QL.Extensions.Grammar.Parser<S, E, T, F>(f);

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Extensions.Grammar.QL_Grammar.egt")));

            return parser;
        }
    }
}
