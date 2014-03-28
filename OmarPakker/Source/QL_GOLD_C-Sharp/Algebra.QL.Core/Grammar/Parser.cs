using System;
using System.Collections.ObjectModel;
using System.Globalization;
using Grammar.Generated.v1;

namespace Algebra.QL.Core.Grammar
{
    public class Parser<S, E, T, F> : Algebra.Core.Grammar.Parser
        where F : Algebra.QL.Core.Factory.IStmntFactory<S, E, T>
    {
        protected override ReadOnlyDictionary<ushort, string> Rules { get { return GrammarData.Rules; } }
        protected readonly F factory;

        public Parser(F f)
            : base(true)
        {
            factory = f;
        }

        protected override object CreateObjectFor(GOLD.Engine.Reduction r)
        {
            switch (Rules[r.Production.TableIndex])
            {
                //<Type> ::= string
                case "Type_String":
                    return factory.StringType();

                //<Type> ::= int
                case "Type_Int":
                    return factory.IntType();

                //<Type> ::= real
                case "Type_Real":
                    return factory.RealType();

                //<Type> ::= bool
                case "Type_Bool":
                    return factory.BoolType();

                //<Form> ::= form Identifier <Block>
                case "Form_Form_Identifier":
                    return factory.Form((string)r[1].Tag, (S)r[2].Tag);

                //<Block> ::= '{' <Statements> '}'
                case "Block_Lbrace_Rbrace":
                    return r[1].Tag; //TODO: create object for brackets?

                //<Statements> ::= <Statement> <Statements>
                case "Statements":
                    return factory.Statements((S)r[0].Tag, (S)r[1].Tag);

                //<Statements> ::= <Statement>
                case "Statements2":
                    return r[0].Tag;

                //<Statement> ::= if '(' <Expression> ')' <Statement> <OptElse>
                case "Statement_If_Lparen_Rparen":
                    if (!r[5].Tag.Equals(String.Empty))
                    {
                        return factory.IfElse((E)r[2].Tag, (S)r[4].Tag, (S)r[5].Tag);
                    }
                    return factory.If((E)r[2].Tag, (S)r[4].Tag);

                //<Statement> ::= <Block>
                case "Statement":
                    return r[0].Tag;

                //<Statement> ::= <Question>
                case "Statement2":
                    return r[0].Tag;

                //<OptElse> ::= else <Statement>
                case "Optelse_Else":
                    return r[1].Tag;

                //<OptElse> ::= 
                case "Optelse":
                    return String.Empty;

                //<VarDecl> ::= Identifier ':' <Type>
                case "Vardecl_Identifier_Colon":
                    return factory.VarDecl((string)r[0].Tag, (T)r[2].Tag);

                //<VarAssign> ::= Identifier ':' <Type> '=' <Expression>
                case "Varassign_Identifier_Colon_Eq":
                    return factory.VarAssign((string)r[0].Tag, (T)r[2].Tag, (E)r[4].Tag);

                //<Question> ::= StringLit '>>' <VarDecl> ';'
                case "Question_Stringlit_Gtgt_Semi":
                    return factory.Question((string)r[0].Tag, (E)r[2].Tag);

                //<Question> ::= StringLit '<<' <VarAssign> ';'
                case "Question_Stringlit_Ltlt_Semi":
                    return factory.Label((string)r[0].Tag, (E)r[2].Tag);

                //<Question> ::= StringLit '<<' <Expression> ';'
                case "Question_Stringlit_Ltlt_Semi2":
                    return factory.Label((string)r[0].Tag, (E)r[2].Tag);

                //<Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
                case "Expression_Question_Colon":
                    return factory.IfElse((E)r[0].Tag, (E)r[2].Tag, (E)r[4].Tag);

                //<Expression> ::= <OrExpr>
                case "Expression":
                    return r[0].Tag;

                //<OrExpr> ::= <OrExpr> '||' <AndExpr>
                case "Orexpr_Pipepipe":
                    return factory.Or((E)r[0].Tag, (E)r[2].Tag);

                //<OrExpr> ::= <AndExpr>
                case "Orexpr":
                    return r[0].Tag;

                //<AndExpr> ::= <AndExpr> '&&' <EqExpr>
                case "Andexpr_Ampamp":
                    return factory.And((E)r[0].Tag, (E)r[2].Tag);

                //<AndExpr> ::= <EqExpr>
                case "Andexpr":
                    return r[0].Tag;

                //<EqExpr> ::= <EqExpr> '==' <CompExpr>
                case "Eqexpr_Eqeq":
                    return factory.Eq((E)r[0].Tag, (E)r[2].Tag);

                //<EqExpr> ::= <EqExpr> '!=' <CompExpr>
                case "Eqexpr_Exclameq":
                    return factory.NotEq((E)r[0].Tag, (E)r[2].Tag);

                //<EqExpr> ::= <CompExpr>
                case "Eqexpr":
                    return r[0].Tag;

                //<CompExpr> ::= <CompExpr> '<' <AddExpr>
                case "Compexpr_Lt":
                    return factory.LessThen((E)r[0].Tag, (E)r[2].Tag);

                //<CompExpr> ::= <CompExpr> '>' <AddExpr>
                case "Compexpr_Gt":
                    return factory.GreaterThen((E)r[0].Tag, (E)r[2].Tag);

                //<CompExpr> ::= <CompExpr> '<=' <AddExpr>
                case "Compexpr_Lteq":
                    return factory.LessOrEqualTo((E)r[0].Tag, (E)r[2].Tag);

                //<CompExpr> ::= <CompExpr> '>=' <AddExpr>
                case "Compexpr_Gteq":
                    return factory.GreaterOrEqualTo((E)r[0].Tag, (E)r[2].Tag);

                //<CompExpr> ::= <AddExpr>
                case "Compexpr":
                    return r[0].Tag;

                //<AddExpr> ::= <AddExpr> '+' <MultExpr>
                case "Addexpr_Plus":
                    return factory.Add((E)r[0].Tag, (E)r[2].Tag);

                //<AddExpr> ::= <AddExpr> '-' <MultExpr>
                case "Addexpr_Minus":
                    return factory.Subtract((E)r[0].Tag, (E)r[2].Tag);

                //<AddExpr> ::= <MultExpr>
                case "Addexpr":
                    return r[0].Tag;

                //<MultExpr> ::= <MultExpr> '*' <NegateExpr>
                case "Multexpr_Times":
                    return factory.Multiply((E)r[0].Tag, (E)r[2].Tag);

                //<MultExpr> ::= <MultExpr> '/' <NegateExpr>
                case "Multexpr_Div":
                    return factory.Divide((E)r[0].Tag, (E)r[2].Tag);

                //<MultExpr> ::= <NegateExpr>
                case "Multexpr":
                    return r[0].Tag;

                //<NegateExpr> ::= '-' <Value>
                case "Negateexpr_Minus":
                    return factory.NegateNumeric((E)r[1].Tag);

                //<NegateExpr> ::= '!' <Value>
                case "Negateexpr_Exclam":
                    return factory.NegateBool((E)r[1].Tag);

                //<NegateExpr> ::= <Value>
                case "Negateexpr":
                    return r[0].Tag;

                //<Value> ::= Identifier
                case "Value_Identifier":
                    return factory.Variable((string)r[0].Tag);

                //<Value> ::= <Literal>
                case "Value":
                    return r[0].Tag;

                //<Value> ::= '(' <Expression> ')'
                case "Value_Lparen_Rparen":
                    return r[1].Tag; //TODO: create object for brackets?

                //<Literal> ::= StringLit
                case "Literal_Stringlit":
                    return factory.String((string)r[0].Tag);

                //<Literal> ::= IntLit
                case "Literal_Intlit":
                    return factory.Int(Int32.Parse((string)r[0].Tag));

                //<Literal> ::= RealLit
                case "Literal_Reallit":
                    return factory.Real(Double.Parse((string)r[0].Tag, CultureInfo.InvariantCulture));

                //<Literal> ::= BoolLit
                case "Literal_Boollit":
                    return factory.Bool(Boolean.Parse((string)r[0].Tag));

                default:
                    return null;
            }
        }
    }
}
