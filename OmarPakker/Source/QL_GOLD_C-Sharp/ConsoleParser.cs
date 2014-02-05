using System;
using com.OPCreations.GoldParser;
using GOLD;

namespace QL_GOLD_C_Sharp
{
	public class ConsoleParser : BaseParser
	{
		protected override void OnGroupError()
		{
			Console.WriteLine("ERROR: Unexpected EOF. (Group Error)");
		}

		protected override void OnInternalError()
		{
			Console.WriteLine("ERROR: INTERNAL ERROR");
		}

		protected override void OnNotLoadedError()
		{
			Console.WriteLine("ERROR: Grammar file was not loaded");
		}

		protected override object OnReduction(Reduction r)
		{
			ProductionIndex pIndex = (ProductionIndex)r.Parent.TableIndex();
			
			int count = r.Count();
			string dataOutput = String.Empty;

			for (int i = 0; i < count; i++)
			{
				dataOutput += r.get_Data(i).ToString();
			}

			Console.WriteLine(String.Format("PI: {1}, C: {0}, D: {2}",
				count, pIndex, dataOutput));

			object returnValue = r;

			#region Object Creation
			switch (pIndex)
			{
				case ProductionIndex.Type_String:
					// <Type> ::= string
					break;

				case ProductionIndex.Type_Int:
					// <Type> ::= int
					break;

				case ProductionIndex.Type_Real:
					// <Type> ::= real
					break;

				case ProductionIndex.Type_Money:
					// <Type> ::= money
					break;

				case ProductionIndex.Type_Boolean:
					// <Type> ::= boolean
					break;

				case ProductionIndex.Forms:
					// <Forms> ::= <Form> <Forms>
					break;

				case ProductionIndex.Forms2:
					// <Forms> ::= <Form>
					break;

				case ProductionIndex.Form_Form_Identifier:
					// <Form> ::= form Identifier <Block>
					break;

				case ProductionIndex.Vardecl_Identifier_Colon:
					// <VarDecl> ::= Identifier ':' <Type>
					break;

				case ProductionIndex.Varassign_Identifier_Colon_Eq:
					// <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
					break;

				case ProductionIndex.Block_Lbrace_Rbrace:
					// <Block> ::= '{' '}'
					break;

				case ProductionIndex.Block_Lbrace_Rbrace2:
					// <Block> ::= '{' <Statements> '}'
					break;

				case ProductionIndex.Statements:
					// <Statements> ::= <Statement> <Statements>
					break;

				case ProductionIndex.Statements2:
					// <Statements> ::= <Statement>
					break;

				case ProductionIndex.Statement_If_Lparen_Rparen:
					// <Statement> ::= if '(' <Expression> ')' <Statement>
					break;

				case ProductionIndex.Statement_If_Lparen_Rparen_Else:
					// <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
					break;

				case ProductionIndex.Statement:
					// <Statement> ::= <ExprStmnt>
					break;

				case ProductionIndex.Statement2:
					// <Statement> ::= <Block>
					break;

				case ProductionIndex.Substmnt_If_Lparen_Rparen_Else:
					// <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
					break;

				case ProductionIndex.Substmnt:
					// <SubStmnt> ::= <ExprStmnt>
					break;

				case ProductionIndex.Substmnt2:
					// <SubStmnt> ::= <Block>
					break;

				case ProductionIndex.Exprstmnt_Stringliteral_Gtgt_Semi:
					// <ExprStmnt> ::= StringLiteral '>>' <VarDecl> ';'
					break;

				case ProductionIndex.Exprstmnt_Stringliteral_Ltlt_Semi:
					// <ExprStmnt> ::= StringLiteral '<<' <VarAssign> ';'
					break;

				case ProductionIndex.Exprstmnt_Goto_Identifier_Semi:
					// <ExprStmnt> ::= goto Identifier ';'
					break;

				case ProductionIndex.Expression_Question_Colon:
					// <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
					break;

				case ProductionIndex.Expression:
					// <Expression> ::= <OrExpr>
					break;

				case ProductionIndex.Orexpr_Pipepipe:
					// <OrExpr> ::= <OrExpr> '||' <AndExpr>
					break;

				case ProductionIndex.Orexpr:
					// <OrExpr> ::= <AndExpr>
					break;

				case ProductionIndex.Andexpr_Ampamp:
					// <AndExpr> ::= <AndExpr> '&&' <EqExpr>
					break;

				case ProductionIndex.Andexpr:
					// <AndExpr> ::= <EqExpr>
					break;

				case ProductionIndex.Eqexpr_Eqeq:
					// <EqExpr> ::= <EqExpr> '==' <CompExpr>
					break;

				case ProductionIndex.Eqexpr_Exclameq:
					// <EqExpr> ::= <EqExpr> '!=' <CompExpr>
					break;

				case ProductionIndex.Eqexpr:
					// <EqExpr> ::= <CompExpr>
					break;

				case ProductionIndex.Compexpr_Lt:
					// <CompExpr> ::= <CompExpr> '<' <AddExpr>
					break;

				case ProductionIndex.Compexpr_Gt:
					// <CompExpr> ::= <CompExpr> '>' <AddExpr>
					break;

				case ProductionIndex.Compexpr_Lteq:
					// <CompExpr> ::= <CompExpr> '<=' <AddExpr>
					break;

				case ProductionIndex.Compexpr_Gteq:
					// <CompExpr> ::= <CompExpr> '>=' <AddExpr>
					break;

				case ProductionIndex.Compexpr:
					// <CompExpr> ::= <AddExpr>
					break;

				case ProductionIndex.Addexpr_Plus:
					// <AddExpr> ::= <AddExpr> '+' <MultExpr>
					break;

				case ProductionIndex.Addexpr_Minus:
					// <AddExpr> ::= <AddExpr> '-' <MultExpr>
					break;

				case ProductionIndex.Addexpr:
					// <AddExpr> ::= <MultExpr>
					break;

				case ProductionIndex.Multexpr_Times:
					// <MultExpr> ::= <MultExpr> '*' <NegateExpr>
					break;

				case ProductionIndex.Multexpr_Div:
					// <MultExpr> ::= <MultExpr> '/' <NegateExpr>
					break;

				case ProductionIndex.Multexpr:
					// <MultExpr> ::= <NegateExpr>
					break;

				case ProductionIndex.Negateexpr_Minus:
					// <NegateExpr> ::= '-' <Value>
					break;

				case ProductionIndex.Negateexpr_Exclam:
					// <NegateExpr> ::= '!' <Value>
					break;

				case ProductionIndex.Negateexpr:
					// <NegateExpr> ::= <Value>
					break;

				case ProductionIndex.Value_Identifier:
					// <Value> ::= Identifier
					break;

				case ProductionIndex.Value:
					// <Value> ::= <Literal>
					break;

				case ProductionIndex.Value_Lparen_Rparen:
					// <Value> ::= '(' <Expression> ')'
					break;

				case ProductionIndex.Literal_Stringliteral:
					// <Literal> ::= StringLiteral
					break;

				case ProductionIndex.Literal_Intliteral:
					// <Literal> ::= IntLiteral
					break;

				case ProductionIndex.Literal_Realliteral:
					// <Literal> ::= RealLiteral
					break;

				case ProductionIndex.Literal_Moneyliteral:
					// <Literal> ::= MoneyLiteral
					break;

				case ProductionIndex.Literal_True:
					// <Literal> ::= true
					break;

				case ProductionIndex.Literal_False:
					// <Literal> ::= false
					break;
			}
			#endregion

			return returnValue;
		}

		protected override void OnLexicalError(int line, int column, object token)
		{
			Console.WriteLine(String.Format("ERROR: Unknown token '{0}' found on line {1} column {2}", token, line, column));
		}

		protected override void OnSyntaxError(int line, int column, object token, string expected)
		{
			Console.WriteLine(String.Format("ERROR: Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
				token, line, column, expected));
		}
	}
}
