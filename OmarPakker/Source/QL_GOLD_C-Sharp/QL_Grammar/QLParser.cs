using System;
using System.Globalization;
using System.IO;
using System.Reflection;
using com.OPCreations.GoldParser;
using GOLD;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.Factory;

namespace QL_Grammar
{
    public abstract class QLParser<E, S> : BaseParser
        where E : IExprNode
        where S : IStmntNode
    {
        protected abstract IFactory<E, S> Factory { get; }

        public QLParser()
            : base(true)
        {
            Assembly a = typeof(QLParser<E, S>).Assembly;
            LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_Grammar.Grammar.QL_Grammar.egt")));
        }

        protected override object OnReduction(Reduction r)
        {
            object newObj = CreateObjectFor(r);

            OnObjectCreated(newObj);

            return newObj;
        }

        protected virtual void OnObjectCreated(object obj)
        {

        }

        private object CreateObjectFor(Reduction r)
        {
            RuleIndex rIndex = (RuleIndex)r.Parent.TableIndex();

            switch (rIndex)
            {
                case RuleIndex.Type_String:
                    // <Type> ::= string
                    return StringType.Instance;

                case RuleIndex.Type_Int:
                    // <Type> ::= int
                    return IntType.Instance;

                case RuleIndex.Type_Real:
                    // <Type> ::= real
                    return RealType.Instance;

                case RuleIndex.Type_Bool:
                    // <Type> ::= bool
                    return BoolType.Instance;

                case RuleIndex.Forms:
                    // <Forms> ::= <Form> <Forms>
                case RuleIndex.Statements:
                    // <Statements> ::= <Statement> <Statements>
                    return Factory.Comp((S)r.get_Data(0), (S)r.get_Data(1));

                case RuleIndex.Forms2:
                    // <Forms> ::= <Form>
                case RuleIndex.Statements2:
                    // <Statements> ::= <Statement>
                case RuleIndex.Statement2:
                    // <Statement> ::= <Block>
                case RuleIndex.Substmnt2:
                    // <SubStmnt> ::= <Block>
                case RuleIndex.Expression:
                    // <Expression> ::= <OrExpr>
                case RuleIndex.Orexpr:
                    // <OrExpr> ::= <AndExpr>
                case RuleIndex.Andexpr:
                    // <AndExpr> ::= <EqExpr>
                case RuleIndex.Eqexpr:
                    // <EqExpr> ::= <CompExpr>
                case RuleIndex.Compexpr:
                    // <CompExpr> ::= <AddExpr>
                case RuleIndex.Addexpr:
                    // <AddExpr> ::= <MultExpr>
                case RuleIndex.Multexpr:
                    // <MultExpr> ::= <NegateExpr>
                case RuleIndex.Negateexpr:
                    // <NegateExpr> ::= <Value>
                case RuleIndex.Value:
                    // <Value> ::= <Literal>
                case RuleIndex.Statement:
                    // <Statement> ::= <QuestionStmnt>
                case RuleIndex.Substmnt:
                    // <SubStmnt> ::= <QuestionStmnt>
                    return r.get_Data(0);

                case RuleIndex.Form_Form_Identifier:
                    // <Form> ::= form Identifier <Block>
                    return Factory.Form((string)r.get_Data(1), (S)r.get_Data(2));

                case RuleIndex.Block_Lbrace_Rbrace:
                    // <Block> ::= '{' <Statements> '}'
                case RuleIndex.Value_Lparen_Rparen:
                    // <Value> ::= '(' <Expression> ')'
                    return r.get_Data(1);

                case RuleIndex.Statement_If_Lparen_Rparen:
                    // <Statement> ::= if '(' <Expression> ')' <Statement>
                    return Factory.If((E)r.get_Data(2), (S)r.get_Data(4));

                case RuleIndex.Statement_If_Lparen_Rparen_Else:
                    // <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
                case RuleIndex.Substmnt_If_Lparen_Rparen_Else:
                    // <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
                    return Factory.IfElse((E)r.get_Data(2), (S)r.get_Data(4), (S)r.get_Data(6));

                case RuleIndex.Vardecl_Identifier_Colon:
                    // <VarDecl> ::= Identifier ':' <Type>
                    return Factory.VarDecl((string)r.get_Data(0), (IType)r.get_Data(2));

                case RuleIndex.Varassign_Identifier_Colon_Eq:
                    // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
                    return Factory.VarAssign((string)r.get_Data(0), (IType)r.get_Data(2), (E)r.get_Data(4));

                case RuleIndex.Questionstmnt_Stringlit_Gtgt_Semi:
                    // <QuestionStmnt> ::= StringLit '>>' <VarDecl> ';'
                    return Factory.Question((string)r.get_Data(0), true, (E)r.get_Data(2));

                case RuleIndex.Questionstmnt_Stringlit_Ltlt_Semi:
                    // <QuestionStmnt> ::= StringLit '<<' <VarAssign> ';'
                case RuleIndex.Questionstmnt_Stringlit_Ltlt_Semi2:
                    // <QuestionStmnt> ::= StringLit '<<' <Expression> ';'
                    return Factory.Question((string)r.get_Data(0), false, (E)r.get_Data(2));

                case RuleIndex.Questionstmnt_Goto_Identifier_Semi:
                    // <QuestionStmnt> ::= goto Identifier ';'
                    return Factory.Goto((string)r.get_Data(1));

                case RuleIndex.Expression_Question_Colon:
                    // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
                    return Factory.IfElse((E)r.get_Data(0), (E)r.get_Data(2), (E)r.get_Data(4));

                case RuleIndex.Orexpr_Pipepipe:
                    // <OrExpr> ::= <OrExpr> '||' <AndExpr>
                    return Factory.Or((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Andexpr_Ampamp:
                    // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
                    return Factory.And((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Eqexpr_Eqeq:
                    // <EqExpr> ::= <EqExpr> '==' <CompExpr>
                    return Factory.Eq((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Eqexpr_Exclameq:
                    // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
                    return Factory.NotEq((E)r.get_Data(0), (E)r.get_Data(2)); ;

                case RuleIndex.Compexpr_Lt:
                    // <CompExpr> ::= <CompExpr> '<' <AddExpr>
                    return Factory.LessThen((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Compexpr_Gt:
                    // <CompExpr> ::= <CompExpr> '>' <AddExpr>
                    return Factory.GreaterThen((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Compexpr_Lteq:
                    // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
                    return Factory.LessOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Compexpr_Gteq:
                    // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
                    return Factory.GreaterOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Addexpr_Plus:
                    // <AddExpr> ::= <AddExpr> '+' <MultExpr>
                    return Factory.Add((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Addexpr_Minus:
                    // <AddExpr> ::= <AddExpr> '-' <MultExpr>
                    return Factory.Subtract((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Multexpr_Times:
                    // <MultExpr> ::= <MultExpr> '*' <NegateExpr>
                    return Factory.Multiply((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Multexpr_Div:
                    // <MultExpr> ::= <MultExpr> '/' <NegateExpr>
                    return Factory.Divide((E)r.get_Data(0), (E)r.get_Data(2));

                case RuleIndex.Negateexpr_Minus:
                    // <NegateExpr> ::= '-' <Value>
                case RuleIndex.Negateexpr_Exclam:
                    // <NegateExpr> ::= '!' <Value>
                    return Factory.Negate((E)r.get_Data(1));

                case RuleIndex.Value_Identifier:
                    // <Value> ::= Identifier
                    return Factory.Variable((string)r.get_Data(0));

                case RuleIndex.Literal_Stringlit:
                    // <Literal> ::= StringLit
                    return Factory.String((string)r.get_Data(0));

                case RuleIndex.Literal_Intlit:
                    // <Literal> ::= IntLit
                    return Factory.Int(Int32.Parse((string)r.get_Data(0)));

                case RuleIndex.Literal_Reallit:
                    // <Literal> ::= RealLit
                    return Factory.Real(Double.Parse((string)r.get_Data(0), CultureInfo.InvariantCulture));

                case RuleIndex.Literal_Boollit:
                    // <Literal> ::= BoolLit
                    return Factory.Bool(Boolean.Parse((string)r.get_Data(0)));

                default:
                    return CreateObjectFor(r, rIndex);
            }
        }

        protected virtual object CreateObjectFor(Reduction r, RuleIndex rIndex)
        {
            return null;
        }
    }
}
