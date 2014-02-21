using System;
using System.Collections.ObjectModel;
using System.Globalization;
using GOLD;
using Grammar.Generated.v2;
using QL_ExtensionTest.QLAlgebraExtensions.Factory;

namespace Grammar.Parser
{
    public class ExtensionsParser<E, S, F> : QLParser<E, S, F>
		where F : IQLExtensionsFactory<E, S>
    {
        protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }

        public ExtensionsParser()
            : base()
        {
			
        }

        protected override object CreateObjectFor(Reduction r)
        {
			//<Type> ::= date
			if (r.Parent.TableIndex() == Rules["Type_Date"])
			{
				return Factory.DateType();
			}
            //<MultExpr> ::= <MultExpr> '%' <NegateExpr>
            else if (r.Parent.TableIndex() == Rules["Multexpr_Percent"])
            {
                return Factory.Modulo((E)r.get_Data(0), (E)r.get_Data(2));
            }
            // <PowerExpr> ::= <PowerExpr> '^' <NegateExpr>
            else if (r.Parent.TableIndex() == Rules["Powerexpr_Caret"])
            {
                return Factory.Power((E)r.get_Data(0), (E)r.get_Data(2));
            }
            // <PowerExpr> ::= <NegateExpr>
            else if (r.Parent.TableIndex() == Rules["Powerexpr"])
            {
                return (E)r.get_Data(0);
            }
			// <Statement> ::= loop '(' <Expression> ')' <Statement>
			else if (r.Parent.TableIndex() == Rules["Statement_Loop_Lparen_Rparen"])
            {
                return Factory.Loop((E)r.get_Data(2), (S)r.get_Data(4));
            }
			//<Literal> ::= DateLit
			if (r.Parent.TableIndex() == Rules["Literal_Datelit"])
			{
				return Factory.Date(DateTime.Parse((string)r.get_Data(0), CultureInfo.InvariantCulture));
			}

            return base.CreateObjectFor(r);
        }
    }
}
