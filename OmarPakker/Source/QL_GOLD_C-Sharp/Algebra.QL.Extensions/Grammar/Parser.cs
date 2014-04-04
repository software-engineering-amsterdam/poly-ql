using System;
using System.Collections.ObjectModel;
using System.Globalization;
using Algebra.QL.Extensions.Factory;
using GOLD.Engine;
using Grammar.Generated.v2;

namespace Algebra.QL.Extensions.Grammar
{
    public class Parser<S, E, T, F> : Core.Grammar.Parser<S, E, T, F>
        where F : IFactory<S, E, T>
    {
        protected override ReadOnlyDictionary<ushort, string> Rules { get { return GrammarData.Rules; } }

        public Parser(F f)
            : base(f)
        {
            
        }

        protected override object CreateObjectFor(Reduction r)
        {
            switch (Rules[r.Production.TableIndex])
            {
                //<Type> ::= date
                case "Type_Date":
                    return factory.DateType();

                //<Forms> ::= <Form> <Forms>
                case "Forms":
                    return factory.Forms((S)r[0].Tag, (S)r[1].Tag);

                //<Forms> ::= <Form>
                case "Forms2":
                    return (E)r[0].Tag;

                //<Statement> ::= gotoNextForm ';'
                case "Statement_Gotonextform_Semi":
                    return factory.Goto();

                //<Statement> ::= repeat '(' <Expression> ')' <Statement>
                case "Statement_Repeat_Lparen_Rparen":
                    return factory.Repeat((E)r[2].Tag, (S)r[4].Tag);

                //<Expression> ::= sum '(' Identifier ')'
                case "Expression_Sum_Lparen_Identifier_Rparen":
                    return factory.Sum((string)r[2].Tag);

                //<Expression> ::= avg '(' Identifier ')'
                case "Expression_Avg_Lparen_Identifier_Rparen":
                    return factory.Average((string)r[2].Tag);

                //<MultExpr> ::= <MultExpr> '%' <PowerExpr>
                case "Multexpr_Percent":
                    return factory.Modulo((E)r[0].Tag, (E)r[2].Tag);

                //<PowerExpr> ::= <PowerExpr> '^' <NegateExpr>
                case "Powerexpr_Caret":
                    return factory.Power((E)r[0].Tag, (E)r[2].Tag);

                //<PowerExpr> ::= <NegateExpr>
                case "Powerexpr":
                    return (E)r[0].Tag;

                //<Literal> ::= DateLit
                case "Literal_Datelit":
                    return factory.Date(DateTime.Parse((string)r[0].Tag, CultureInfo.InvariantCulture));

                default:
                    return base.CreateObjectFor(r);
            }
        }
    }
}
