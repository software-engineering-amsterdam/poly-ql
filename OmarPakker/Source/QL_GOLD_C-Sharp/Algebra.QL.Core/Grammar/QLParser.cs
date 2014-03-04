using System;
using System.Collections.ObjectModel;
using System.Globalization;
using Algebra.Core.GrammarParser;
using Algebra.QL.Core.Factory;
using Grammar.Generated.v1;

namespace Algebra.QL.Core.Grammar
{
	public class QLParser<E, S, T, F> : Parser
		where F : IQLFactory<E, S, T>
	{
		protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }
        protected readonly F factory;

		public QLParser(F f)
			: base(true)
		{
            factory = f;
		}

        protected override object CreateObjectFor(GOLD.Engine.Reduction r)
		{
            ushort tableIndex = r.Production.TableIndex;

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
			else if (tableIndex == Rules["Forms"])
			{
				return factory.Forms((S)r[0].Tag, (S)r[1].Tag);
			}
            //<Statements> ::= <Statement> <Statements>
            else if (tableIndex == Rules["Statements"])
            {
                return factory.Statements((S)r[0].Tag, (S)r[1].Tag);
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
				return r[0].Tag;
			}
			//<Form> ::= form Identifier <Block>
			else if (tableIndex == Rules["Form_Form_Identifier"])
			{
				return factory.Form((string)r[1].Tag, (S)r[2].Tag);
			}
			//<Block> ::= '{' <Statements> '}'
			//<OptElse> ::= else <Statement>
			//<Value> ::= '(' <Expression> ')'
			else if (tableIndex == Rules["Block_Lbrace_Rbrace"]
				|| tableIndex == Rules["Optelse_Else"]
				|| tableIndex == Rules["Value_Lparen_Rparen"])
			{
				return r[1].Tag;
			}
			//<Statement> ::= if '(' <Expression> ')' <Statement> <OptElse>
			else if (tableIndex == Rules["Statement_If_Lparen_Rparen"])
			{
				if (r[5].Tag != null)
				{
					return factory.IfElse((E)r[2].Tag, (S)r[4].Tag, (S)r[5].Tag);
				}
				return factory.If((E)r[2].Tag, (S)r[4].Tag);
			}
			//<Statement> ::= goto Identifier ';'
			else if (tableIndex == Rules["Statement_Goto_Identifier_Semi"])
			{
				return factory.Goto((string)r[1].Tag);
			}
			//<OptElse> ::= 
			else if (tableIndex == Rules["Optelse"])
			{
				return null;
			}
			//<VarDecl> ::= Identifier ':' <Type>
			else if (tableIndex == Rules["Vardecl_Identifier_Colon"])
			{
				return factory.VarDecl((string)r[0].Tag, (T)r[2].Tag);
			}
			//<VarAssign> ::= Identifier ':' <Type> '=' <Expression>
			else if (tableIndex == Rules["Varassign_Identifier_Colon_Eq"])
			{
				return factory.VarAssign((string)r[0].Tag, (T)r[2].Tag, (E)r[4].Tag);
			}
			//<Question> ::= StringLit '>>' <VarDecl> ';'
			else if (tableIndex == Rules["Question_Stringlit_Gtgt_Semi"])
			{
				return factory.Question((string)r[0].Tag, (E)r[2].Tag);
			}
			//<Question> ::= StringLit '<<' <VarAssign> ';'
			//<Question> ::= StringLit '<<' <Expression> ';'
			else if (tableIndex == Rules["Question_Stringlit_Ltlt_Semi"]
				|| tableIndex == Rules["Question_Stringlit_Ltlt_Semi2"])
			{
				return factory.Label((string)r[0].Tag, (E)r[2].Tag);
			}
			//<Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
			else if (tableIndex == Rules["Expression_Question_Colon"])
			{
				return factory.IfElse((E)r[0].Tag, (E)r[2].Tag, (E)r[4].Tag);
			}
			//<OrExpr> ::= <OrExpr> '||' <AndExpr>
			else if (tableIndex == Rules["Orexpr_Pipepipe"])
			{
				return factory.Or((E)r[0].Tag, (E)r[2].Tag);
			}
			//<AndExpr> ::= <AndExpr> '&&' <EqExpr>
			else if (tableIndex == Rules["Andexpr_Ampamp"])
			{
				return factory.And((E)r[0].Tag, (E)r[2].Tag);
			}
			//<EqExpr> ::= <EqExpr> '==' <CompExpr>
			else if (tableIndex == Rules["Eqexpr_Eqeq"])
			{
				return factory.Eq((E)r[0].Tag, (E)r[2].Tag);
			}
			//<EqExpr> ::= <EqExpr> '!=' <CompExpr>
			else if (tableIndex == Rules["Eqexpr_Exclameq"])
			{
				return factory.NotEq((E)r[0].Tag, (E)r[2].Tag);
			}
			//<CompExpr> ::= <CompExpr> '<' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Lt"])
			{
				return factory.LessThen((E)r[0].Tag, (E)r[2].Tag);
			}
			//<CompExpr> ::= <CompExpr> '>' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Gt"])
			{
				return factory.GreaterThen((E)r[0].Tag, (E)r[2].Tag);
			}
			//<CompExpr> ::= <CompExpr> '<=' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Lteq"])
			{
				return factory.LessOrEqualTo((E)r[0].Tag, (E)r[2].Tag);
			}
			//<CompExpr> ::= <CompExpr> '>=' <AddExpr>
			else if (tableIndex == Rules["Compexpr_Gteq"])
			{
				return factory.GreaterOrEqualTo((E)r[0].Tag, (E)r[2].Tag);
			}
			//<AddExpr> ::= <AddExpr> '+' <MultExpr>
			else if (tableIndex == Rules["Addexpr_Plus"])
			{
				return factory.Add((E)r[0].Tag, (E)r[2].Tag);
			}
			//<AddExpr> ::= <AddExpr> '-' <MultExpr>
			else if (tableIndex == Rules["Addexpr_Minus"])
			{
				return factory.Subtract((E)r[0].Tag, (E)r[2].Tag);
			}
			//<MultExpr> ::= <MultExpr> '*' <NegateExpr>
			else if (tableIndex == Rules["Multexpr_Times"])
			{
				return factory.Multiply((E)r[0].Tag, (E)r[2].Tag);
			}
			//<MultExpr> ::= <MultExpr> '/' <NegateExpr>
			else if (tableIndex == Rules["Multexpr_Div"])
			{
				return factory.Divide((E)r[0].Tag, (E)r[2].Tag);
			}
			//<NegateExpr> ::= '-' <Value>
			else if (tableIndex == Rules["Negateexpr_Minus"])
			{
                return factory.NegateNumeric((E)r[1].Tag);
			}
            //<NegateExpr> ::= '!' <Value>
            else if (tableIndex == Rules["Negateexpr_Exclam"])
            {
                return factory.NegateBool((E)r[1].Tag);
            }
            //<Value> ::= Identifier
            else if (tableIndex == Rules["Value_Identifier"])
            {
                return factory.Variable((string)r[0].Tag);
            }
            //<Literal> ::= StringLit
            else if (tableIndex == Rules["Literal_Stringlit"])
            {
                return factory.String((string)r[0].Tag);
            }
            //<Literal> ::= IntLit
            else if (tableIndex == Rules["Literal_Intlit"])
            {
                return factory.Int(Int32.Parse((string)r[0].Tag));
            }
            //<Literal> ::= RealLit
            else if (tableIndex == Rules["Literal_Reallit"])
            {
                return factory.Real(Double.Parse((string)r[0].Tag, CultureInfo.InvariantCulture));
            }
            //<Literal> ::= BoolLit
            else if (tableIndex == Rules["Literal_Boollit"])
            {
                return factory.Bool(Boolean.Parse((string)r[0].Tag));
            }

            throw new InvalidOperationException("Parser object construction is missing value checks!");
		}
	}
}
