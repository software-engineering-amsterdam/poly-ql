
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
        @Exclam = 8,                               // '!'
        @Exclameq = 9,                             // '!='
        @Ampamp = 10,                              // '&&'
        @Lparen = 11,                              // '('
        @Rparen = 12,                              // ')'
        @Times = 13,                               // '*'
        @Plus = 14,                                // '+'
        @Minus = 15,                               // '-'
        @Div = 16,                                 // '/'
        @Colon = 17,                               // ':'
        @Semi = 18,                                // ';'
        @Lt = 19,                                  // '<'
        @Ltlt = 20,                                // '<<'
        @Lteq = 21,                                // '<='
        @Eq = 22,                                  // '='
        @Eqeq = 23,                                // '=='
        @Gt = 24,                                  // '>'
        @Gteq = 25,                                // '>='
        @Gtgt = 26,                                // '>>'
        @Question = 27,                            // '?'
        @Boolean = 28,                             // boolean
        @Else = 29,                                // else
        @False = 30,                               // false
        @Form = 31,                                // form
        @Goto = 32,                                // goto
        @Identifier = 33,                          // Identifier
        @If = 34,                                  // if
        @Int = 35,                                 // int
        @Intliteral = 36,                          // IntLiteral
        @Money = 37,                               // money
        @Moneyliteral = 38,                        // MoneyLiteral
        @Real = 39,                                // real
        @Realliteral = 40,                         // RealLiteral
        @String = 41,                              // string
        @Stringliteral = 42,                       // StringLiteral
        @True = 43,                                // true
        @Lbrace = 44,                              // '{'
        @Pipepipe = 45,                            // '||'
        @Rbrace = 46,                              // '}'
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
        @Varassign = 10,                           // <VarAssign> ::= <Expression>
        @Block_Lbrace_Rbrace = 11,                 // <Block> ::= '{' '}'
        @Block_Lbrace_Rbrace2 = 12,                // <Block> ::= '{' <Statements> '}'
        @Statements = 13,                          // <Statements> ::= <Statement> <Statements>
        @Statements2 = 14,                         // <Statements> ::= <Statement>
        @Statement_If_Lparen_Rparen = 15,          // <Statement> ::= if '(' <Expression> ')' <Statement>
        @Statement_If_Lparen_Rparen_Else = 16,     // <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
        @Statement = 17,                           // <Statement> ::= <ExprStmnt>
        @Statement2 = 18,                          // <Statement> ::= <Block>
        @Substmnt_If_Lparen_Rparen_Else = 19,      // <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
        @Substmnt = 20,                            // <SubStmnt> ::= <ExprStmnt>
        @Substmnt2 = 21,                           // <SubStmnt> ::= <Block>
        @Exprstmnt_Stringliteral_Gtgt_Semi = 22,   // <ExprStmnt> ::= StringLiteral '>>' <VarDecl> ';'
        @Exprstmnt_Stringliteral_Ltlt_Semi = 23,   // <ExprStmnt> ::= StringLiteral '<<' <VarAssign> ';'
        @Exprstmnt_Goto_Identifier_Semi = 24,      // <ExprStmnt> ::= goto Identifier ';'
        @Expression_Question_Colon = 25,           // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
        @Expression = 26,                          // <Expression> ::= <OrExpr>
        @Orexpr_Pipepipe = 27,                     // <OrExpr> ::= <OrExpr> '||' <AndExpr>
        @Orexpr = 28,                              // <OrExpr> ::= <AndExpr>
        @Andexpr_Ampamp = 29,                      // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
        @Andexpr = 30,                             // <AndExpr> ::= <EqExpr>
        @Eqexpr_Eqeq = 31,                         // <EqExpr> ::= <EqExpr> '==' <CompExpr>
        @Eqexpr_Exclameq = 32,                     // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
        @Eqexpr = 33,                              // <EqExpr> ::= <CompExpr>
        @Compexpr_Lt = 34,                         // <CompExpr> ::= <CompExpr> '<' <AddExpr>
        @Compexpr_Gt = 35,                         // <CompExpr> ::= <CompExpr> '>' <AddExpr>
        @Compexpr_Lteq = 36,                       // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
        @Compexpr_Gteq = 37,                       // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
        @Compexpr = 38,                            // <CompExpr> ::= <AddExpr>
        @Addexpr_Plus = 39,                        // <AddExpr> ::= <AddExpr> '+' <MultExpr>
        @Addexpr_Minus = 40,                       // <AddExpr> ::= <AddExpr> '-' <MultExpr>
        @Addexpr = 41,                             // <AddExpr> ::= <MultExpr>
        @Multexpr_Times = 42,                      // <MultExpr> ::= <MultExpr> '*' <NegateExpr>
        @Multexpr_Div = 43,                        // <MultExpr> ::= <MultExpr> '/' <NegateExpr>
        @Multexpr = 44,                            // <MultExpr> ::= <NegateExpr>
        @Negateexpr_Minus = 45,                    // <NegateExpr> ::= '-' <Value>
        @Negateexpr_Exclam = 46,                   // <NegateExpr> ::= '!' <Value>
        @Negateexpr = 47,                          // <NegateExpr> ::= <Value>
        @Value_Identifier = 48,                    // <Value> ::= Identifier
        @Value = 49,                               // <Value> ::= <Literal>
        @Value_Lparen_Rparen = 50,                 // <Value> ::= '(' <Expression> ')'
        @Literal_Stringliteral = 51,               // <Literal> ::= StringLiteral
        @Literal_Intliteral = 52,                  // <Literal> ::= IntLiteral
        @Literal_Realliteral = 53,                 // <Literal> ::= RealLiteral
        @Literal_Moneyliteral = 54,                // <Literal> ::= MoneyLiteral
        @Literal_True = 55,                        // <Literal> ::= true
        @Literal_False = 56                        // <Literal> ::= false
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
