using System.Collections.ObjectModel;
using GOLD;
using Grammar.Generated.v2;
using QL_ExtensionTest.Mathematics.Factory;
using QL_Grammar.TypeCheck.Expr;
using QL_Grammar.TypeCheck.Stmnt;

namespace Grammar.Parser
{
    public class MathParser : QLParser<ITypeCheckExpr, ITypeCheckStmnt>
    {
        protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }
        private readonly MathFactory mFactory;

        public MathParser()
            : base()
        {
            Factory = mFactory = new MathFactory();
        }

        protected override object CreateObjectFor(Reduction r)
        {
            //<MultExpr> ::= <MultExpr> '%' <NegateExpr>
            if (r.Parent.TableIndex() == Rules["Multexpr_Percent"])
            {
                return mFactory.Modulo((ITypeCheckExpr)r.get_Data(0), (ITypeCheckExpr)r.get_Data(2));
            }
            // <PowerExpr> ::= <PowerExpr> '^' <NegateExpr>
            if (r.Parent.TableIndex() == Rules["Powerexpr_Caret"])
            {
                return mFactory.Power((ITypeCheckExpr)r.get_Data(0), (ITypeCheckExpr)r.get_Data(2));
            }
            // <PowerExpr> ::= <NegateExpr>
            if (r.Parent.TableIndex() == Rules["Powerexpr"])
            {
                return (ITypeCheckExpr)r.get_Data(0);
            }

            return base.CreateObjectFor(r);
        }
    }
}
