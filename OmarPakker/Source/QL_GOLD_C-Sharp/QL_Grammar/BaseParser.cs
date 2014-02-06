
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
        @Bool = 28,                                // Bool
        @Boolean = 29,                             // boolean
        @Else = 30,                                // else
        @Form = 31,                                // form
        @Goto = 32,                                // goto
        @Identifier = 33,                          // Identifier
        @If = 34,                                  // if
        @Int = 35,                                 // Int
        @Real = 36,                                // Real
        @String = 37,                              // String
        @Lbrace = 38,                              // '{'
        @Pipepipe = 39,                            // '||'
        @Rbrace = 40,                              // '}'
        @Addexpr = 41,                             // <AddExpr>
        @Andexpr = 42,                             // <AndExpr>
        @Block = 43,                               // <Block>
        @Compexpr = 44,                            // <CompExpr>
        @Eqexpr = 45,                              // <EqExpr>
        @Expression = 46,                          // <Expression>
        @Exprstmnt = 47,                           // <ExprStmnt>
        @Form2 = 48,                               // <Form>
        @Forms = 49,                               // <Forms>
        @Literal = 50,                             // <Literal>
        @Multexpr = 51,                            // <MultExpr>
        @Negateexpr = 52,                          // <NegateExpr>
        @Orexpr = 53,                              // <OrExpr>
        @Statement = 54,                           // <Statement>
        @Statements = 55,                          // <Statements>
        @Substmnt = 56,                            // <SubStmnt>
        @Type = 57,                                // <Type>
        @Value = 58,                               // <Value>
        @Varassign = 59,                           // <VarAssign>
        @Vardecl = 60                              // <VarDecl>
    };

    public enum ProductionIndex
    {
        @Type_String = 0,                          // <Type> ::= String
        @Type_Int = 1,                             // <Type> ::= Int
        @Type_Real = 2,                            // <Type> ::= Real
        @Type_Boolean = 3,                         // <Type> ::= boolean
        @Forms = 4,                                // <Forms> ::= <Form> <Forms>
        @Forms2 = 5,                               // <Forms> ::= <Form>
        @Form_Form_Identifier = 6,                 // <Form> ::= form Identifier <Block>
        @Vardecl_Identifier_Colon = 7,             // <VarDecl> ::= Identifier ':' <Type>
        @Varassign_Identifier_Colon_Eq = 8,        // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
        @Varassign = 9,                            // <VarAssign> ::= <Expression>
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
        @Exprstmnt_String_Gtgt_Semi = 21,          // <ExprStmnt> ::= String '>>' <VarDecl> ';'
        @Exprstmnt_String_Ltlt_Semi = 22,          // <ExprStmnt> ::= String '<<' <VarAssign> ';'
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
        @Literal_String = 50,                      // <Literal> ::= String
        @Literal_Int = 51,                         // <Literal> ::= Int
        @Literal_Real = 52,                        // <Literal> ::= Real
        @Literal_Bool = 53                         // <Literal> ::= Bool
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

		public bool LoadGrammar(BinaryReader reader)
		{
			return parser.LoadTables(reader);
		}

		public bool Parse(string text)
		{
			parser.Open(ref text);
			
			return DoParse();
		}

		public bool Parse(TextReader reader)
		{
			parser.Open(reader);

			return DoParse();
		}

		private bool DoParse()
		{
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
