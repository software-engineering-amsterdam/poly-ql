
using System.IO;
using GOLD;

namespace com.OPCreations.GoldParser
{
	public enum SymbolIndex
	{
		@Eof = 0,                                  // (EOF)
		@Error = 1,                                // (Error)
		@Comment = 2,                              // Comment
		@Newline = 3,                              // NewLine
		@Whitespace = 4,                           // Whitespace
		@Timesdiv = 5,                             // '*/'
		@Divtimes = 6,                             // '/*'
		@Divdiv = 7,                               // '//'
		@Minus = 8,                                // '-'
		@Exclam = 9,                               // '!'
		@Exclameq = 10,                            // '!='
		@Ampamp = 11,                              // '&&'
		@Lparen = 12,                              // '('
		@Rparen = 13,                              // ')'
		@Times = 14,                               // '*'
		@Div = 15,                                 // '/'
		@Colon = 16,                               // ':'
		@Semi = 17,                                // ';'
		@Question = 18,                            // '?'
		@Lbrace = 19,                              // '{'
		@Pipepipe = 20,                            // '||'
		@Rbrace = 21,                              // '}'
		@Plus = 22,                                // '+'
		@Lt = 23,                                  // '<'
		@Ltlt = 24,                                // '<<'
		@Lteq = 25,                                // '<='
		@Eq = 26,                                  // '='
		@Eqeq = 27,                                // '=='
		@Gt = 28,                                  // '>'
		@Gteq = 29,                                // '>='
		@Gtgt = 30,                                // '>>'
		@Boolean = 31,                             // boolean
		@Else = 32,                                // else
		@False = 33,                               // false
		@Form = 34,                                // form
		@Goto = 35,                                // goto
		@Identifier = 36,                          // Identifier
		@If = 37,                                  // if
		@Int = 38,                                 // int
		@Intliteral = 39,                          // IntLiteral
		@Money = 40,                               // money
		@Moneyliteral = 41,                        // MoneyLiteral
		@Real = 42,                                // real
		@Realliteral = 43,                         // RealLiteral
		@String = 44,                              // string
		@Stringliteral = 45,                       // StringLiteral
		@True = 46,                                // true
		@Addexpr = 47,                             // <AddExpr>
		@Andexpr = 48,                             // <AndExpr>
		@Block = 49,                               // <Block>
		@Compexpr = 50,                            // <CompExpr>
		@Eqexpr = 51,                              // <EqExpr>
		@Expression = 52,                          // <Expression>
		@Exprstmnt = 53,                           // <ExprStmnt>
		@Form2 = 54,                               // <Form>
		@Forms = 55,                               // <Forms>
		@Literal = 56,                             // <Literal>
		@Multexpr = 57,                            // <MultExpr>
		@Negateexpr = 58,                          // <NegateExpr>
		@Orexpr = 59,                              // <OrExpr>
		@Statement = 60,                           // <Statement>
		@Statements = 61,                          // <Statements>
		@Substmnt = 62,                            // <SubStmnt>
		@Type = 63,                                // <Type>
		@Value = 64,                               // <Value>
		@Varassign = 65,                           // <VarAssign>
		@Vardecl = 66                              // <VarDecl>
	};

	public enum ProductionIndex
	{
		@Type_String = 0,                          // <Type> ::= string
		@Type_Int = 1,                             // <Type> ::= int
		@Type_Real = 2,                            // <Type> ::= real
		@Type_Money = 3,                           // <Type> ::= money
		@Type_Boolean = 4,                         // <Type> ::= boolean
		@Forms = 5,                                // <Forms> ::= <Form> <Forms>
		@Forms2 = 6,                               // <Forms> ::= <Form>
		@Form_Form_Identifier = 7,                 // <Form> ::= form Identifier <Block>
		@Vardecl_Identifier_Colon = 8,             // <VarDecl> ::= Identifier ':' <Type>
		@Varassign_Identifier_Colon_Eq = 9,        // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
		@Block_Lbrace_Rbrace = 10,                 // <Block> ::= '{' '}'
		@Block_Lbrace_Rbrace2 = 11,                // <Block> ::= '{' <Statements> '}'
		@Statements = 12,                          // <Statements> ::= <Statement> <Statements>
		@Statements2 = 13,                         // <Statements> ::= <Statement>
		@Statement_If_Lparen_Rparen = 14,          // <Statement> ::= if '(' <Expression> ')' <Statement>
		@Statement_If_Lparen_Rparen_Else = 15,     // <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
		@Statement = 16,                           // <Statement> ::= <ExprStmnt>
		@Statement2 = 17,                          // <Statement> ::= <Block>
		@Substmnt_If_Lparen_Rparen_Else = 18,      // <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
		@Substmnt = 19,                            // <SubStmnt> ::= <ExprStmnt>
		@Substmnt2 = 20,                           // <SubStmnt> ::= <Block>
		@Exprstmnt_Stringliteral_Gtgt_Semi = 21,   // <ExprStmnt> ::= StringLiteral '>>' <VarDecl> ';'
		@Exprstmnt_Stringliteral_Ltlt_Semi = 22,   // <ExprStmnt> ::= StringLiteral '<<' <VarAssign> ';'
		@Exprstmnt_Goto_Identifier_Semi = 23,      // <ExprStmnt> ::= goto Identifier ';'
		@Expression_Question_Colon = 24,           // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
		@Expression = 25,                          // <Expression> ::= <OrExpr>
		@Orexpr_Pipepipe = 26,                     // <OrExpr> ::= <OrExpr> '||' <AndExpr>
		@Orexpr = 27,                              // <OrExpr> ::= <AndExpr>
		@Andexpr_Ampamp = 28,                      // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
		@Andexpr = 29,                             // <AndExpr> ::= <EqExpr>
		@Eqexpr_Eqeq = 30,                         // <EqExpr> ::= <EqExpr> '==' <CompExpr>
		@Eqexpr_Exclameq = 31,                     // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
		@Eqexpr = 32,                              // <EqExpr> ::= <CompExpr>
		@Compexpr_Lt = 33,                         // <CompExpr> ::= <CompExpr> '<' <AddExpr>
		@Compexpr_Gt = 34,                         // <CompExpr> ::= <CompExpr> '>' <AddExpr>
		@Compexpr_Lteq = 35,                       // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
		@Compexpr_Gteq = 36,                       // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
		@Compexpr = 37,                            // <CompExpr> ::= <AddExpr>
		@Addexpr_Plus = 38,                        // <AddExpr> ::= <AddExpr> '+' <MultExpr>
		@Addexpr_Minus = 39,                       // <AddExpr> ::= <AddExpr> '-' <MultExpr>
		@Addexpr = 40,                             // <AddExpr> ::= <MultExpr>
		@Multexpr_Times = 41,                      // <MultExpr> ::= <MultExpr> '*' <NegateExpr>
		@Multexpr_Div = 42,                        // <MultExpr> ::= <MultExpr> '/' <NegateExpr>
		@Multexpr = 43,                            // <MultExpr> ::= <NegateExpr>
		@Negateexpr_Minus = 44,                    // <NegateExpr> ::= '-' <Value>
		@Negateexpr_Exclam = 45,                   // <NegateExpr> ::= '!' <Value>
		@Negateexpr = 46,                          // <NegateExpr> ::= <Value>
		@Value_Identifier = 47,                    // <Value> ::= Identifier
		@Value = 48,                               // <Value> ::= <Literal>
		@Value_Lparen_Rparen = 49,                 // <Value> ::= '(' <Expression> ')'
		@Literal_Stringliteral = 50,               // <Literal> ::= StringLiteral
		@Literal_Intliteral = 51,                  // <Literal> ::= IntLiteral
		@Literal_Realliteral = 52,                 // <Literal> ::= RealLiteral
		@Literal_Moneyliteral = 53,                // <Literal> ::= MoneyLiteral
		@Literal_True = 54,                        // <Literal> ::= true
		@Literal_False = 55                        // <Literal> ::= false
	};

	public abstract class BaseParser
	{
		private Parser parser;

		public Reduction Root { get; private set; }

		public BaseParser()
		{
			parser = new GOLD.Parser();
		}

		public bool LoadGrammar(string grammarFilePath)
		{
			return parser.LoadTables(grammarFilePath);
		}

		public bool Parse(TextReader reader)
		{
			parser.Open(reader);
			parser.TrimReductions = false;

			bool done = false;
			bool accepted = false;

			while (!done)
			{
				switch (parser.Parse())
				{
					case ParseMessage.TokenRead:
						break;

					case ParseMessage.Reduction:
						//Create a custom object and store the reduction
						parser.CurrentReduction = OnReduction(parser.CurrentReduction as Reduction);
						break;

					case ParseMessage.Accept:
						//All good!
						Root = (Reduction)parser.CurrentReduction;
						done = true;
						accepted = true;
						break;

					case ParseMessage.GroupError:
						//Unexpected end of file (EOF)
						OnGroupError();
						done = true;
						break;

					case ParseMessage.InternalError:
						//Something went wrong internally
						OnInternalError();
						done = true;
						break;

					case ParseMessage.LexicalError:
						//Token not recognized
						OnLexicalError(parser.CurrentPosition().Line, parser.CurrentPosition().Column, parser.CurrentToken().Data);
						done = true;
						break;

					case ParseMessage.NotLoadedError:
						//CGT wasn't loaded
						OnNotLoadedError();
						done = true;
						break;

					case ParseMessage.SyntaxError:
						//Expected a different token
						OnSyntaxError(parser.CurrentPosition().Line, parser.CurrentPosition().Column,
							parser.CurrentToken().Data, parser.ExpectedSymbols().Text());
						done = true;
						break;
				}
			}

			return accepted;
		}

		protected abstract object OnReduction(Reduction r);

		protected abstract void OnGroupError();
		protected abstract void OnInternalError();
		protected abstract void OnNotLoadedError();
		protected abstract void OnLexicalError(int line, int column, object token);
		protected abstract void OnSyntaxError(int line, int column, object token, string expected);
	}
}
