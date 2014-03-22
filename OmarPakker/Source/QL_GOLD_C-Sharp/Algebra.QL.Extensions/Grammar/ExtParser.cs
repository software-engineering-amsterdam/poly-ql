using System;
using System.Collections.ObjectModel;
using System.Globalization;
using Algebra.QL.Core.Grammar;
using Algebra.QL.Extensions.Factory;
using GOLD.Engine;
using Grammar.Generated.v2;

namespace Algebra.QL.Extensions.Grammar
{
    public class ExtParser<S, E, T, F> : Parser<S, E, T, F>
        where F : IStmntFactory<S, E, T>
    {
        protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }

        public ExtParser(F f)
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
            //<Forms> ::= <Form>
            // <PowerExpr> ::= <NegateExpr>
            else if (tableIndex == Rules["Forms2"]
                || tableIndex == Rules["Powerexpr"])
            {
                return (E)r[0].Tag; //If TrimReductions is true, this is never executed
            }
            //<Forms> ::= <Form> <Forms>
            else if (tableIndex == Rules["Forms"])
            {
                return factory.Forms((S)r[0].Tag, (S)r[1].Tag);
            }
            //<Statement> ::= goto Identifier ';'
            else if (tableIndex == Rules["Statement_Gotonextform_Semi"])
            {
                return factory.Goto();
            }
			// <Statement> ::= repeat '(' <Expression> ')' <Statement>
			else if (tableIndex == Rules["Statement_Repeat_Lparen_Rparen"])
            {
                return factory.Repeat((E)r[2].Tag, (S)r[4].Tag);
            }
			//<Literal> ::= DateLit
			else if (tableIndex == Rules["Literal_Datelit"])
			{
				return factory.Date(DateTime.Parse((string)r[0].Tag, CultureInfo.InvariantCulture));
			}
            //<Expression> ::= sum '(' Identifier ')'
            if (tableIndex == Rules["Expression_Sum_Lparen_Identifier_Rparen"])
            {
                return factory.Sum((string)r[2].Tag);
            }
            //<Expression> ::= avg '(' Identifier ')'
            if (tableIndex == Rules["Expression_Avg_Lparen_Identifier_Rparen"])
            {
                return factory.Average((string)r[2].Tag);
            }

            return base.CreateObjectFor(r);
        }
    }
}
