using System;
using System.Collections.ObjectModel;
using System.Globalization;
using GOLD;
using Grammar.Generated.v1;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.Factory;
using QL_Grammar.QL.Types;

namespace Grammar
{
    public class QLParser<E, S> : AbstractParser
        where E : IExprNode
        where S : IStmntNode
    {
        protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }

        private IFactory<E, S> factory;
        public IFactory<E, S> Factory
        {
            get { return factory; }
            set { factory = factory == null ? value : factory; }
        }

        public QLParser()
            : base(true)
        {

        }

        protected override object CreateObjectFor(Reduction r)
        {
            //<Type> ::= string
            if (r.Parent.TableIndex() == Rules["Type_String"])
            {
                return StringType.Instance;
            }
            //<Type> ::= int
            if (r.Parent.TableIndex() == Rules["Type_Int"])
            {
                return IntType.Instance;
            }
            //<Type> ::= real
            if (r.Parent.TableIndex() == Rules["Type_Real"])
            {
                return RealType.Instance;
            }
            //<Type> ::= bool
            if (r.Parent.TableIndex() == Rules["Type_Bool"])
            {
                return BoolType.Instance;
            }
            //<Forms> ::= <Form> <Forms>
            //<Statements> ::= <Statement> <Statements>
            if (r.Parent.TableIndex() == Rules["Forms"]
                || r.Parent.TableIndex() == Rules["Statements"])
            {
                return factory.Comp((S)r.get_Data(0), (S)r.get_Data(1));
            }
            //<Forms> ::= <Form>
            //<Statements> ::= <Statement>
            //<Statement> ::= <QuestionStmnt>
            //<Statement> ::= <Block>
            //<SubStmnt> ::= <QuestionStmnt>
            //<SubStmnt> ::= <Block>
            //<Expression> ::= <OrExpr>
            //<OrExpr> ::= <AndExpr>
            //<AndExpr> ::= <EqExpr>
            //<EqExpr> ::= <CompExpr>
            //<CompExpr> ::= <AddExpr>
            //<AddExpr> ::= <MultExpr>
            //<MultExpr> ::= <NegateExpr>
            //<NegateExpr> ::= <Value>
            //<Value> ::= <Literal>
            if (r.Parent.TableIndex() == Rules["Forms2"]
                || r.Parent.TableIndex() == Rules["Statements2"]
                || r.Parent.TableIndex() == Rules["Statement"]
                || r.Parent.TableIndex() == Rules["Statement2"]
                || r.Parent.TableIndex() == Rules["Substmnt"]
                || r.Parent.TableIndex() == Rules["Substmnt2"]
                || r.Parent.TableIndex() == Rules["Expression"]
                || r.Parent.TableIndex() == Rules["Orexpr"]
                || r.Parent.TableIndex() == Rules["Andexpr"]
                || r.Parent.TableIndex() == Rules["Eqexpr"]
                || r.Parent.TableIndex() == Rules["Compexpr"]
                || r.Parent.TableIndex() == Rules["Addexpr"]
                || r.Parent.TableIndex() == Rules["Multexpr"]
                || r.Parent.TableIndex() == Rules["Negateexpr"]
                || r.Parent.TableIndex() == Rules["Value"])
            {
                return r.get_Data(0);
            }
            //<Form> ::= form Identifier <Block>
            if (r.Parent.TableIndex() == Rules["Form_Form_Identifier"])
            {
                return factory.Form((string)r.get_Data(1), (S)r.get_Data(2));
            }
            //<Block> ::= '{' <Statements> '}'
            //<Value> ::= '(' <Expression> ')'
            if (r.Parent.TableIndex() == Rules["Block_Lbrace_Rbrace"]
                || r.Parent.TableIndex() == Rules["Value_Lparen_Rparen"])
            {
                return r.get_Data(1);
            }
            //<Statement> ::= if '(' <Expression> ')' <Statement>
            if (r.Parent.TableIndex() == Rules["Statement_If_Lparen_Rparen"])
            {
                return factory.If((E)r.get_Data(2), (S)r.get_Data(4));
            }
            //<Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
            //<SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
            if (r.Parent.TableIndex() == Rules["Statement_If_Lparen_Rparen_Else"]
                || r.Parent.TableIndex() == Rules["Substmnt_If_Lparen_Rparen_Else"])
            {
                return factory.IfElse((E)r.get_Data(2), (S)r.get_Data(4), (S)r.get_Data(6));
            }
            //<VarDecl> ::= Identifier ':' <Type>
            if (r.Parent.TableIndex() == Rules["Vardecl_Identifier_Colon"])
            {
                return factory.VarDecl((string)r.get_Data(0), (IType)r.get_Data(2));
            }
            //<VarAssign> ::= Identifier ':' <Type> '=' <Expression>
            if (r.Parent.TableIndex() == Rules["Varassign_Identifier_Colon_Eq"])
            {
                return factory.VarAssign((string)r.get_Data(0), (IType)r.get_Data(2), (E)r.get_Data(4));
            }
            //<QuestionStmnt> ::= StringLit '>>' <VarDecl> ';'
            if (r.Parent.TableIndex() == Rules["Questionstmnt_Stringlit_Gtgt_Semi"])
            {
                return factory.Question((string)r.get_Data(0), true, (E)r.get_Data(2));
            }
            //<QuestionStmnt> ::= StringLit '<<' <VarAssign> ';'
            //<QuestionStmnt> ::= StringLit '<<' <Expression> ';'
            if (r.Parent.TableIndex() == Rules["Questionstmnt_Stringlit_Ltlt_Semi"]
                || r.Parent.TableIndex() == Rules["Questionstmnt_Stringlit_Ltlt_Semi2"])
            {
                return factory.Question((string)r.get_Data(0), false, (E)r.get_Data(2));
            }
            //<QuestionStmnt> ::= goto Identifier ';'
            if (r.Parent.TableIndex() == Rules["Questionstmnt_Goto_Identifier_Semi"])
            {
                return factory.Goto((string)r.get_Data(1));
            }
            //<Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
            if (r.Parent.TableIndex() == Rules["Expression_Question_Colon"])
            {
                return factory.IfElse((E)r.get_Data(0), (E)r.get_Data(2), (E)r.get_Data(4));
            }
            //<OrExpr> ::= <OrExpr> '||' <AndExpr>
            //<AndExpr> ::= <AndExpr> '&&' <EqExpr>
            //<EqExpr> ::= <EqExpr> '==' <CompExpr>
            //<EqExpr> ::= <EqExpr> '!=' <CompExpr>
            //<CompExpr> ::= <CompExpr> '<' <AddExpr>
            //<CompExpr> ::= <CompExpr> '>' <AddExpr>
            //<CompExpr> ::= <CompExpr> '<=' <AddExpr>
            //<CompExpr> ::= <CompExpr> '>=' <AddExpr>
            //<AddExpr> ::= <AddExpr> '+' <MultExpr>
            //<AddExpr> ::= <AddExpr> '-' <MultExpr>
            //<MultExpr> ::= <MultExpr> '*' <NegateExpr>
            //<MultExpr> ::= <MultExpr> '/' <NegateExpr>
            if (r.Parent.TableIndex() == Rules["Orexpr_Pipepipe"])
            {
                return factory.Or((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Andexpr_Ampamp"])
            {
                return factory.And((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Eqexpr_Eqeq"])
            {
                return factory.Eq((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Eqexpr_Exclameq"])
            {
                return factory.NotEq((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Compexpr_Lt"])
            {
                return factory.LessThen((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Compexpr_Gt"])
            {
                return factory.GreaterThen((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Compexpr_Lteq"])
            {
                return factory.LessOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Compexpr_Gteq"])
            {
                return factory.GreaterOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Addexpr_Plus"])
            {
                return factory.Add((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Addexpr_Minus"])
            {
                return factory.Subtract((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Multexpr_Times"])
            {
                return factory.Multiply((E)r.get_Data(0), (E)r.get_Data(2));
            }
            if (r.Parent.TableIndex() == Rules["Multexpr_Div"])
            {
                return factory.Divide((E)r.get_Data(0), (E)r.get_Data(2));
            }
            //<NegateExpr> ::= '-' <Value>
            //<NegateExpr> ::= '!' <Value>
            if (r.Parent.TableIndex() == Rules["Negateexpr_Minus"]
                || r.Parent.TableIndex() == Rules["Negateexpr_Exclam"])
            {
                return factory.Negate((E)r.get_Data(1));
            }
            //<Value> ::= Identifier
            if (r.Parent.TableIndex() == Rules["Value_Identifier"])
            {
                return factory.Variable((string)r.get_Data(0));
            }
            //<Literal> ::= StringLit
            if (r.Parent.TableIndex() == Rules["Literal_Stringlit"])
            {
                return factory.String((string)r.get_Data(0));
            }
            //<Literal> ::= IntLit
            if (r.Parent.TableIndex() == Rules["Literal_Intlit"])
            {
                return factory.Int(Int32.Parse((string)r.get_Data(0)));
            }
            //<Literal> ::= RealLit
            if (r.Parent.TableIndex() == Rules["Literal_Reallit"])
            {
                return factory.Real(Double.Parse((string)r.get_Data(0), CultureInfo.InvariantCulture));
            }
            //<Literal> ::= BoolLit
            if (r.Parent.TableIndex() == Rules["Literal_Boollit"])
            {
                return factory.Bool(Boolean.Parse((string)r.get_Data(0)));
            }

            return null;
        }
    }
}
