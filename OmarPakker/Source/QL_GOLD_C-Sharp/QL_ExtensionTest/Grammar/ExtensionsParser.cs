using System.Collections.ObjectModel;
using GOLD;
using Grammar.Generated.v2;
using QL_ExtensionTest.Extensions.Factory;

namespace Grammar.Parser
{
    public class ExtensionsParser<E, S, F> : QLParser<E, S, F>
		where F : IExtensionsFactory<E, S>
    {
        protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }

        public ExtensionsParser()
            : base()
        {
			
        }

        protected override object CreateObjectFor(Reduction r)
        {
            //<MultExpr> ::= <MultExpr> '%' <NegateExpr>
            if (r.Parent.TableIndex() == Rules["Multexpr_Percent"])
            {
                return Factory.Modulo((E)r.get_Data(0), (E)r.get_Data(2));
            }
            // <PowerExpr> ::= <PowerExpr> '^' <NegateExpr>
            if (r.Parent.TableIndex() == Rules["Powerexpr_Caret"])
            {
                return Factory.Power((E)r.get_Data(0), (E)r.get_Data(2));
            }
            // <PowerExpr> ::= <NegateExpr>
            if (r.Parent.TableIndex() == Rules["Powerexpr"])
            {
                return (E)r.get_Data(0);
            }
			// <Statement> ::= loop '(' <Expression> ')' <Statement>
			if (r.Parent.TableIndex() == Rules["Statement_Loop_Lparen_Rparen"])
            {
                return Factory.Loop((E)r.get_Data(2), (S)r.get_Data(4));
            }

            return base.CreateObjectFor(r);
        }
    }
}
