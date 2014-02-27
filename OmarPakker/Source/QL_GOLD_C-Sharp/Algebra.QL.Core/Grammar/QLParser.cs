using System;
using System.Collections.ObjectModel;
using System.Globalization;
using Algebra.Core.GrammarParser;
using Algebra.Core.Tree;
using Algebra.QL.Core.Factory;
using GOLD;
using Grammar.Generated.v1;

namespace Algebra.QL.Core.Grammar
{
	public class QLParser<E, S, T, F> : AbstractParser
        where E : IExprNode
        where S : IStmntNode
        where T : ITypeNode
		where F : IQLFactory<E, S, T>
	{
		protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }
        protected readonly F factory;

		public QLParser(F f)
			: base(true)
		{
            factory = f;
		}

		protected override object CreateObjectFor(Reduction r)
		{
            short tableIndex = r.Parent.TableIndex();

			//<Type> ::= string
			if (tableIndex == Rules["Type_String"])
			{
                return factory.StringType();
			}
			//<Type> ::= int
			else if (tableIndex == Rules["Type_Int"])
			{
                return factory.IntType();
			}
			//<Type> ::= real
			else if (tableIndex == Rules["Type_Real"])
			{
                return factory.RealType();
			}
			//<Type> ::= bool
			else if (tableIndex == Rules["Type_Bool"])
			{
                return factory.BoolType();
			}
			//<Forms> ::= <Form> <Forms>
			//<Statements> ::= <Statement> <Statements>
			else if (tableIndex == Rules["Forms"]
				|| tableIndex == Rules["Statements"])
			{
				return factory.Comp((S)r.get_Data(0), (S)r.get_Data(1));
			}
			//<Forms> ::= <Form>
			//<Statements> ::= <Statement>
			//<Statement> ::= <Block>
			//<Statement> ::= <Question>
			//<Expression> ::= <OrExpr>
			//<OrExpr> ::= <AndExpr>
			//<AndExpr> ::= <EqExpr>
			//<EqExpr> ::= <CompExpr>
			//<CompExpr> ::= <AddExpr>
			//<AddExpr> ::= <MultExpr>
			//<MultExpr> ::= <NegateExpr>
			//<NegateExpr> ::= <Value>
			//<Value> ::= <Literal>
			else if (tableIndex == Rules["Forms2"]
				|| tableIndex == Rules["Statements2"]
				|| tableIndex == Rules["Statement"]
				|| tableIndex == Rules["Statement2"]
				|| tableIndex == Rules["Expression"]
				|| tableIndex == Rules["Orexpr"]
				|| tableIndex == Rules["Andexpr"]
				|| tableIndex == Rules["Eqexpr"]
				|| tableIndex == Rules["Compexpr"]
				|| tableIndex == Rules["Addexpr"]
				|| tableIndex == Rules["Multexpr"]
				|| tableIndex == Rules["Negateexpr"]
				|| tableIndex == Rules["Value"])
			{
				return r.get_Data(0);
			}
			//<Form> ::= form Identifier <Block>
			else if (tableIndex == Rules["Form_Form_Identifier"])
			{
				return factory.Form((string)r.get_Data(1), (S)r.get_Data(2));
			}
			//<Block> ::= '{' <Statements> '}'
			//<OptElse> ::= else <Statement>
			//<Value> ::= '(' <Expression> ')'
			else if (tableIndex == Rules["Block_Lbrace_Rbrace"]
				|| tableIndex == Rules["Optelse_Else"]
				|| tableIndex == Rules["Value_Lparen_Rparen"])
			{
				return r.get_Data(1);
			}
			//<Statement> ::= if '(' <Expression> ')' <Statement> <OptElse>
			else if (tableIndex == Rules["Statement_If_Lparen_Rparen"])
			{
				if (r.get_Data(5) != null)
				{
					return factory.IfElse((E)r.get_Data(2), (S)r.get_Data(4), (S)r.get_Data(5));
				}
				return factory.If((E)r.get_Data(2), (S)r.get_Data(4));
			}
			//<Statement> ::= goto Identifier ';'
			else if (tableIndex == Rules["Statement_Goto_Identifier_Semi"])
			{
				return factory.Goto((string)r.get_Data(1));
			}
			//<OptElse> ::= 
			else if (tableIndex == Rules["Optelse"])
			{
				return null;
			}
			//<VarDecl> ::= Identifier ':' <Type>
			else if (tableIndex == Rules["Vardecl_Identifier_Colon"])
			{
				return factory.VarDecl((string)r.get_Data(0), (T)r.get_Data(2));
			}
			//<VarAssign> ::= Identifier ':' <Type> '=' <Expression>
			else if (tableIndex == Rules["Varassign_Identifier_Colon_Eq"])
			{
				return factory.VarAssign((string)r.get_Data(0), (T)r.get_Data(2), (E)r.get_Data(4));
			}
			//<Question> ::= StringLit '>>' <VarDecl> ';'
			else if (tableIndex == Rules["Question_Stringlit_Gtgt_Semi"])
			{
				return factory.Question((string)r.get_Data(0), (E)r.get_Data(2));
			}
			//<Question> ::= StringLit '<<' <VarAssign> ';'
			//<Question> ::= StringLit '<<' <Expression> ';'
			else if (tableIndex == Rules["Question_Stringlit_Ltlt_Semi"]
				|| tableIndex == Rules["Question_Stringlit_Ltlt_Semi2"])
			{
				return factory.Label((string)r.get_Data(0), (E)r.get_Data(2));
			}
			//<Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
			else if (tableIndex == Rules["Expression_Question_Colon"])
			{
				return factory.IfElse((E)r.get_Data(0), (E)r.get_Data(2), (E)r.get_Data(4));
			}
			//<OrExpr> ::= <OrExpr> '||' <AndExpr>
			else if (tableIndex == Rules["Orexpr_Pipepipe"])
			{
				return factory.Or((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<AndExpr> ::= <AndExpr> '&&' <EqExpr>
			else if (tableIndex == Rules["Andexpr_Ampamp"])
			{
				return factory.And((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<EqExpr> ::= <EqExpr> '==' <CompExpr>
			else if (tableIndex == Rules["Eqexpr_Eqeq"])
			{
				return factory.Eq((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<EqExpr> ::= <EqExpr> '!=' <CompExpr>
			else if (tableIndex == Rules["Eqexpr_Exclameq"])
			{
				return factory.NotEq((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '<' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Lt"])
			{
				return factory.LessThen((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '>' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Gt"])
			{
				return factory.GreaterThen((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '<=' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Lteq"])
			{
				return factory.LessOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '>=' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Gteq"])
			{
				return factory.GreaterOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<AddExpr> ::= <AddExpr> '+' <MultExpr>
			else if (tableIndex == Rules["Addexpr_Plus"])
			{
				return factory.Add((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<AddExpr> ::= <AddExpr> '-' <MultExpr>
			else if (tableIndex == Rules["Addexpr_Minus"])
			{
				return factory.Subtract((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<MultExpr> ::= <MultExpr> '*' <NegateExpr>
			else if (tableIndex == Rules["Multexpr_Times"])
			{
				return factory.Multiply((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<MultExpr> ::= <MultExpr> '/' <NegateExpr>
			else if (tableIndex == Rules["Multexpr_Div"])
			{
				return factory.Divide((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<NegateExpr> ::= '-' <Value>
			else if (tableIndex == Rules["Negateexpr_Minus"])
			{
                return factory.NegateNumeric((E)r.get_Data(1));
			}
            //<NegateExpr> ::= '!' <Value>
            else if (tableIndex == Rules["Negateexpr_Exclam"])
            {
                return factory.NegateBool((E)r.get_Data(1));
            }
            //<Value> ::= Identifier
            else if (tableIndex == Rules["Value_Identifier"])
            {
                return factory.Variable((string)r.get_Data(0));
            }
            //<Literal> ::= StringLit
            else if (tableIndex == Rules["Literal_Stringlit"])
            {
                return factory.String((string)r.get_Data(0));
            }
            //<Literal> ::= IntLit
            else if (tableIndex == Rules["Literal_Intlit"])
            {
                return factory.Int(Int32.Parse((string)r.get_Data(0)));
            }
            //<Literal> ::= RealLit
            else if (tableIndex == Rules["Literal_Reallit"])
            {
                return factory.Real(Double.Parse((string)r.get_Data(0), CultureInfo.InvariantCulture));
            }
            //<Literal> ::= BoolLit
            else if (tableIndex == Rules["Literal_Boollit"])
            {
                return factory.Bool(Boolean.Parse((string)r.get_Data(0)));
            }

            throw new InvalidOperationException("Parser object construction is missing value checks!");
		}
	}
}
