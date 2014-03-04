using System;
using System.Collections.ObjectModel;
using System.Globalization;
using Algebra.QL.Core.Grammar;
using Algebra.QL.Extensions.Factory;
using GOLD.Engine;
using Grammar.Generated.v2;

namespace Algebra.QL.Extensions.Grammar
{
    public class ExtensionsParser<E, S, T, F> : QLParser<E, S, T, F>
		where F : IQLExtensionsFactory<E, S, T>
    {
        protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }

        public ExtensionsParser(F f)
            : base(f)
        {
			
        }

        protected override object CreateObjectFor(Reduction r)
        {
            ushort tableIndex = r.Production.TableIndex;

			//<Type> ::= date
			if (tableIndex == Rules["Type_Date"])
			{
				return factory.DateType();
			}
            //<MultExpr> ::= <MultExpr> '%' <NegateExpr>
            else if (tableIndex == Rules["Multexpr_Percent"])
            {
                return factory.Modulo((E)r[0].Tag, (E)r[2].Tag);
            }
            // <PowerExpr> ::= <PowerExpr> '^' <NegateExpr>
            else if (tableIndex == Rules["Powerexpr_Caret"])
            {
                return factory.Power((E)r[0].Tag, (E)r[2].Tag);
            }
            // <PowerExpr> ::= <NegateExpr>
            else if (tableIndex == Rules["Powerexpr"])
            {
                return (E)r[0].Tag;
            }
			// <Statement> ::= loop '(' <Expression> ')' <Statement>
			else if (tableIndex == Rules["Statement_Loop_Lparen_Rparen"])
            {
                return factory.Loop((E)r[2].Tag, (S)r[4].Tag);
            }
			//<Literal> ::= DateLit
			else if (tableIndex == Rules["Literal_Datelit"])
			{
				return factory.Date(DateTime.Parse((string)r[0].Tag, CultureInfo.InvariantCulture));
			}

            return base.CreateObjectFor(r);
        }
    }
}
