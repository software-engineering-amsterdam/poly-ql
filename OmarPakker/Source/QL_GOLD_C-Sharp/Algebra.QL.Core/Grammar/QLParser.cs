using System;
using System.Collections.ObjectModel;
using System.Globalization;
using Algebra.Core.GrammarParser;
using Algebra.Core.Type;
using Algebra.QL.Core.Factory;
using GOLD;
using Grammar.Generated.v1;

namespace Algebra.QL.Core.Grammar
{
	public class QLParser<E, S, TF, F> : AbstractParser
        where TF : IQLTypeFactory
		where F : IQLFactory<E, S>
	{
		protected override ReadOnlyDictionary<string, short> Rules { get { return GrammarData.Rules; } }
        protected readonly TF typeFactory;
        protected readonly F factory;

		public QLParser(TF tf, F f)
			: base(true)
		{
            typeFactory = tf;
            factory = f;
		}

		protected override object CreateObjectFor(Reduction r)
		{
			//<Type> ::= string
			if (r.Parent.TableIndex() == Rules["Type_String"])
			{
                return typeFactory.StringType();
			}
			//<Type> ::= int
			else if (r.Parent.TableIndex() == Rules["Type_Int"])
			{
                return typeFactory.IntType();
			}
			//<Type> ::= real
			else if (r.Parent.TableIndex() == Rules["Type_Real"])
			{
                return typeFactory.RealType();
			}
			//<Type> ::= bool
			else if (r.Parent.TableIndex() == Rules["Type_Bool"])
			{
                return typeFactory.BoolType();
			}
			//<Forms> ::= <Form> <Forms>
			//<Statements> ::= <Statement> <Statements>
			else if (r.Parent.TableIndex() == Rules["Forms"]
				|| r.Parent.TableIndex() == Rules["Statements"])
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
			else if (r.Parent.TableIndex() == Rules["Forms2"]
				|| r.Parent.TableIndex() == Rules["Statements2"]
				|| r.Parent.TableIndex() == Rules["Statement"]
				|| r.Parent.TableIndex() == Rules["Statement2"]
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
			else if (r.Parent.TableIndex() == Rules["Form_Form_Identifier"])
			{
				return factory.Form((string)r.get_Data(1), (S)r.get_Data(2));
			}
			//<Block> ::= '{' <Statements> '}'
			//<OptElse> ::= else <Statement>
			//<Value> ::= '(' <Expression> ')'
			else if (r.Parent.TableIndex() == Rules["Block_Lbrace_Rbrace"]
				|| r.Parent.TableIndex() == Rules["Optelse_Else"]
				|| r.Parent.TableIndex() == Rules["Value_Lparen_Rparen"])
			{
				return r.get_Data(1);
			}
			//<Statement> ::= if '(' <Expression> ')' <Statement> <OptElse>
			else if (r.Parent.TableIndex() == Rules["Statement_If_Lparen_Rparen"])
			{
				if (r.get_Data(5) != null)
				{
					return factory.IfElse((E)r.get_Data(2), (S)r.get_Data(4), (S)r.get_Data(5));
				}
				return factory.If((E)r.get_Data(2), (S)r.get_Data(4));
			}
			//<Statement> ::= goto Identifier ';'
			else if (r.Parent.TableIndex() == Rules["Statement_Goto_Identifier_Semi"])
			{
				return factory.Goto((string)r.get_Data(1));
			}
			//<OptElse> ::= 
			else if (r.Parent.TableIndex() == Rules["Optelse"])
			{
				return null;
			}
			//<VarDecl> ::= Identifier ':' <Type>
			else if (r.Parent.TableIndex() == Rules["Vardecl_Identifier_Colon"])
			{
				return factory.VarDecl((string)r.get_Data(0), (IType)r.get_Data(2));
			}
			//<VarAssign> ::= Identifier ':' <Type> '=' <Expression>
			else if (r.Parent.TableIndex() == Rules["Varassign_Identifier_Colon_Eq"])
			{
				return factory.VarAssign((string)r.get_Data(0), (IType)r.get_Data(2), (E)r.get_Data(4));
			}
			//<Question> ::= StringLit '>>' <VarDecl> ';'
			else if (r.Parent.TableIndex() == Rules["Question_Stringlit_Gtgt_Semi"])
			{
				return factory.Question((string)r.get_Data(0), true, (E)r.get_Data(2));
			}
			//<Question> ::= StringLit '<<' <VarAssign> ';'
			//<Question> ::= StringLit '<<' <Expression> ';'
			else if (r.Parent.TableIndex() == Rules["Question_Stringlit_Ltlt_Semi"]
				|| r.Parent.TableIndex() == Rules["Question_Stringlit_Ltlt_Semi2"])
			{
				return factory.Question((string)r.get_Data(0), false, (E)r.get_Data(2));
			}
			//<Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
			else if (r.Parent.TableIndex() == Rules["Expression_Question_Colon"])
			{
				return factory.IfElse((E)r.get_Data(0), (E)r.get_Data(2), (E)r.get_Data(4));
			}
			//<OrExpr> ::= <OrExpr> '||' <AndExpr>
			else if (r.Parent.TableIndex() == Rules["Orexpr_Pipepipe"])
			{
				return factory.Or((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<AndExpr> ::= <AndExpr> '&&' <EqExpr>
			else if (r.Parent.TableIndex() == Rules["Andexpr_Ampamp"])
			{
				return factory.And((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<EqExpr> ::= <EqExpr> '==' <CompExpr>
			else if (r.Parent.TableIndex() == Rules["Eqexpr_Eqeq"])
			{
				return factory.Eq((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<EqExpr> ::= <EqExpr> '!=' <CompExpr>
			else if (r.Parent.TableIndex() == Rules["Eqexpr_Exclameq"])
			{
				return factory.NotEq((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '<' <AddExpr>
			else if (r.Parent.TableIndex() == Rules["Compexpr_Lt"])
			{
				return factory.LessThen((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '>' <AddExpr>
			else if (r.Parent.TableIndex() == Rules["Compexpr_Gt"])
			{
				return factory.GreaterThen((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '<=' <AddExpr>
			else if (r.Parent.TableIndex() == Rules["Compexpr_Lteq"])
			{
				return factory.LessOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<CompExpr> ::= <CompExpr> '>=' <AddExpr>
			else if (r.Parent.TableIndex() == Rules["Compexpr_Gteq"])
			{
				return factory.GreaterOrEqualTo((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<AddExpr> ::= <AddExpr> '+' <MultExpr>
			else if (r.Parent.TableIndex() == Rules["Addexpr_Plus"])
			{
				return factory.Add((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<AddExpr> ::= <AddExpr> '-' <MultExpr>
			else if (r.Parent.TableIndex() == Rules["Addexpr_Minus"])
			{
				return factory.Subtract((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<MultExpr> ::= <MultExpr> '*' <NegateExpr>
			else if (r.Parent.TableIndex() == Rules["Multexpr_Times"])
			{
				return factory.Multiply((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<MultExpr> ::= <MultExpr> '/' <NegateExpr>
			else if (r.Parent.TableIndex() == Rules["Multexpr_Div"])
			{
				return factory.Divide((E)r.get_Data(0), (E)r.get_Data(2));
			}
			//<NegateExpr> ::= '-' <Value>
			else if (r.Parent.TableIndex() == Rules["Negateexpr_Minus"])
			{
                return factory.Negate(typeFactory.RealType(), (E)r.get_Data(1));
			}
            //<NegateExpr> ::= '!' <Value>
            else if (r.Parent.TableIndex() == Rules["Negateexpr_Exclam"])
            {
                return factory.Negate(typeFactory.BoolType(), (E)r.get_Data(1));
            }
            //<Value> ::= Identifier
            else if (r.Parent.TableIndex() == Rules["Value_Identifier"])
            {
                return factory.Variable((string)r.get_Data(0));
            }
            //<Literal> ::= StringLit
            else if (r.Parent.TableIndex() == Rules["Literal_Stringlit"])
            {
                return factory.String((string)r.get_Data(0));
            }
            //<Literal> ::= IntLit
            else if (r.Parent.TableIndex() == Rules["Literal_Intlit"])
            {
                return factory.Int(Int32.Parse((string)r.get_Data(0)));
            }
            //<Literal> ::= RealLit
            else if (r.Parent.TableIndex() == Rules["Literal_Reallit"])
            {
                return factory.Real(Double.Parse((string)r.get_Data(0), CultureInfo.InvariantCulture));
            }
            //<Literal> ::= BoolLit
            else if (r.Parent.TableIndex() == Rules["Literal_Boollit"])
            {
                return factory.Bool(Boolean.Parse((string)r.get_Data(0)));
            }

			return null;
		}
	}
}
