/*
 * Grammar Information:
 *
 * Name            : Questionaire Language
 * Version         : v0.1
 * Author          : Omar Pakker
 * About           : A grammar for Questionaires.
 * Case Sensitive  : 
 * Start Symbol    : 
 *
 *
 * Grammar Build Information:
 *
 * Output File Path : 
 * Output Path      : 
 * Output File      : 
 * Output File Base : 
 *
 * Symbol Count : 64
 * Rule Count   : 53
 */
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
        @Bool = 28,                                // bool
        @Boollit = 29,                             // BoolLit
        @Else = 30,                                // else
        @Form = 31,                                // form
        @Goto = 32,                                // goto
        @Identifier = 33,                          // Identifier
        @If = 34,                                  // if
        @Int = 35,                                 // int
        @Intlit = 36,                              // IntLit
        @Real = 37,                                // real
        @Reallit = 38,                             // RealLit
        @String = 39,                              // string
        @Stringlit = 40,                           // StringLit
        @Lbrace = 41,                              // '{'
        @Pipepipe = 42,                            // '||'
        @Rbrace = 43,                              // '}'
        @Addexpr = 44,                             // <AddExpr>
        @Andexpr = 45,                             // <AndExpr>
        @Block = 46,                               // <Block>
        @Compexpr = 47,                            // <CompExpr>
        @Eqexpr = 48,                              // <EqExpr>
        @Expression = 49,                          // <Expression>
        @Form2 = 50,                               // <Form>
        @Forms = 51,                               // <Forms>
        @Literal = 52,                             // <Literal>
        @Multexpr = 53,                            // <MultExpr>
        @Negateexpr = 54,                          // <NegateExpr>
        @Orexpr = 55,                              // <OrExpr>
        @Questionstmnt = 56,                       // <QuestionStmnt>
        @Statement = 57,                           // <Statement>
        @Statements = 58,                          // <Statements>
        @Substmnt = 59,                            // <SubStmnt>
        @Type = 60,                                // <Type>
        @Value = 61,                               // <Value>
        @Varassign = 62,                           // <VarAssign>
        @Vardecl = 63                              // <VarDecl>
    };

    public enum RuleIndex
    {
        @Type_String = 0,                          // <Type> ::= string
        @Type_Int = 1,                             // <Type> ::= int
        @Type_Real = 2,                            // <Type> ::= real
        @Type_Bool = 3,                            // <Type> ::= bool
        @Forms = 4,                                // <Forms> ::= <Form> <Forms>
        @Forms2 = 5,                               // <Forms> ::= <Form>
        @Form_Form_Identifier = 6,                 // <Form> ::= form Identifier <Block>
        @Block_Lbrace_Rbrace = 7,                  // <Block> ::= '{' <Statements> '}'
        @Statements = 8,                           // <Statements> ::= <Statement> <Statements>
        @Statements2 = 9,                          // <Statements> ::= <Statement>
        @Statement_If_Lparen_Rparen = 10,          // <Statement> ::= if '(' <Expression> ')' <Statement>
        @Statement_If_Lparen_Rparen_Else = 11,     // <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
        @Statement = 12,                           // <Statement> ::= <QuestionStmnt>
        @Statement2 = 13,                          // <Statement> ::= <Block>
        @Substmnt_If_Lparen_Rparen_Else = 14,      // <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
        @Substmnt = 15,                            // <SubStmnt> ::= <QuestionStmnt>
        @Substmnt2 = 16,                           // <SubStmnt> ::= <Block>
        @Vardecl_Identifier_Colon = 17,            // <VarDecl> ::= Identifier ':' <Type>
        @Varassign_Identifier_Colon_Eq = 18,       // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
        @Questionstmnt_Stringlit_Gtgt_Semi = 19,   // <QuestionStmnt> ::= StringLit '>>' <VarDecl> ';'
        @Questionstmnt_Stringlit_Ltlt_Semi = 20,   // <QuestionStmnt> ::= StringLit '<<' <VarAssign> ';'
        @Questionstmnt_Stringlit_Ltlt_Semi2 = 21,  // <QuestionStmnt> ::= StringLit '<<' <Expression> ';'
        @Questionstmnt_Goto_Identifier_Semi = 22,  // <QuestionStmnt> ::= goto Identifier ';'
        @Expression_Question_Colon = 23,           // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
        @Expression = 24,                          // <Expression> ::= <OrExpr>
        @Orexpr_Pipepipe = 25,                     // <OrExpr> ::= <OrExpr> '||' <AndExpr>
        @Orexpr = 26,                              // <OrExpr> ::= <AndExpr>
        @Andexpr_Ampamp = 27,                      // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
        @Andexpr = 28,                             // <AndExpr> ::= <EqExpr>
        @Eqexpr_Eqeq = 29,                         // <EqExpr> ::= <EqExpr> '==' <CompExpr>
        @Eqexpr_Exclameq = 30,                     // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
        @Eqexpr = 31,                              // <EqExpr> ::= <CompExpr>
        @Compexpr_Lt = 32,                         // <CompExpr> ::= <CompExpr> '<' <AddExpr>
        @Compexpr_Gt = 33,                         // <CompExpr> ::= <CompExpr> '>' <AddExpr>
        @Compexpr_Lteq = 34,                       // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
        @Compexpr_Gteq = 35,                       // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
        @Compexpr = 36,                            // <CompExpr> ::= <AddExpr>
        @Addexpr_Plus = 37,                        // <AddExpr> ::= <AddExpr> '+' <MultExpr>
        @Addexpr_Minus = 38,                       // <AddExpr> ::= <AddExpr> '-' <MultExpr>
        @Addexpr = 39,                             // <AddExpr> ::= <MultExpr>
        @Multexpr_Times = 40,                      // <MultExpr> ::= <MultExpr> '*' <NegateExpr>
        @Multexpr_Div = 41,                        // <MultExpr> ::= <MultExpr> '/' <NegateExpr>
        @Multexpr = 42,                            // <MultExpr> ::= <NegateExpr>
        @Negateexpr_Minus = 43,                    // <NegateExpr> ::= '-' <Value>
        @Negateexpr_Exclam = 44,                   // <NegateExpr> ::= '!' <Value>
        @Negateexpr = 45,                          // <NegateExpr> ::= <Value>
        @Value_Identifier = 46,                    // <Value> ::= Identifier
        @Value = 47,                               // <Value> ::= <Literal>
        @Value_Lparen_Rparen = 48,                 // <Value> ::= '(' <Expression> ')'
        @Literal_Stringlit = 49,                   // <Literal> ::= StringLit
        @Literal_Intlit = 50,                      // <Literal> ::= IntLit
        @Literal_Reallit = 51,                     // <Literal> ::= RealLit
        @Literal_Boollit = 52                      // <Literal> ::= BoolLit
    };

	public abstract class BaseParser
	{
		private Parser parser;

		protected Position ParserPosition { get { return parser.CurrentPosition(); } }

		public BaseParser(bool trimReductions)
		{
			parser = new GOLD.Parser();
			parser.TrimReductions = trimReductions;
		}

		protected bool LoadGrammar(string grammarFilePath)
		{
			return parser.LoadTables(grammarFilePath);
		}

		protected bool LoadGrammar(BinaryReader reader)
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
			while (true)
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
						OnCompletion(parser.CurrentReduction);
                        return true;

					case ParseMessage.GroupError:
						//Unexpected end of file (EOF)
						OnGroupError();
                        return false;

					case ParseMessage.InternalError:
						//Something went wrong internally
						OnInternalError();
                        return false;

					case ParseMessage.LexicalError:
						//Token not recognized
						OnLexicalError(parser.CurrentPosition().Line, parser.CurrentPosition().Column, parser.CurrentToken().Data);
                        return false;

					case ParseMessage.NotLoadedError:
						//CGT wasn't loaded
						OnNotLoadedError();
                        return false;

					case ParseMessage.SyntaxError:
						//Expected a different token
						OnSyntaxError(parser.CurrentPosition().Line, parser.CurrentPosition().Column,
							parser.CurrentToken().Data, parser.ExpectedSymbols().Text());
                        return false;
				}
			}
		}

		protected abstract object OnReduction(Reduction r);
		protected abstract void OnCompletion(object root);

		protected abstract void OnGroupError();
		protected abstract void OnInternalError();
		protected abstract void OnNotLoadedError();
		protected abstract void OnLexicalError(int line, int column, object token);
		protected abstract void OnSyntaxError(int line, int column, object token, string expected);
	}
}



/*
 * Pre-build switch covering all the rules
 */
#region Rules Switch
//switch((RuleIndex)r.Parent.TableIndex())
//{
//	case RuleIndex.Type_String:
//		// <Type> ::= string
//		break;
//
//	case RuleIndex.Type_Int:
//		// <Type> ::= int
//		break;
//
//	case RuleIndex.Type_Real:
//		// <Type> ::= real
//		break;
//
//	case RuleIndex.Type_Bool:
//		// <Type> ::= bool
//		break;
//
//	case RuleIndex.Forms:
//		// <Forms> ::= <Form> <Forms>
//		break;
//
//	case RuleIndex.Forms2:
//		// <Forms> ::= <Form>
//		break;
//
//	case RuleIndex.Form_Form_Identifier:
//		// <Form> ::= form Identifier <Block>
//		break;
//
//	case RuleIndex.Block_Lbrace_Rbrace:
//		// <Block> ::= '{' <Statements> '}'
//		break;
//
//	case RuleIndex.Statements:
//		// <Statements> ::= <Statement> <Statements>
//		break;
//
//	case RuleIndex.Statements2:
//		// <Statements> ::= <Statement>
//		break;
//
//	case RuleIndex.Statement_If_Lparen_Rparen:
//		// <Statement> ::= if '(' <Expression> ')' <Statement>
//		break;
//
//	case RuleIndex.Statement_If_Lparen_Rparen_Else:
//		// <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
//		break;
//
//	case RuleIndex.Statement:
//		// <Statement> ::= <QuestionStmnt>
//		break;
//
//	case RuleIndex.Statement2:
//		// <Statement> ::= <Block>
//		break;
//
//	case RuleIndex.Substmnt_If_Lparen_Rparen_Else:
//		// <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
//		break;
//
//	case RuleIndex.Substmnt:
//		// <SubStmnt> ::= <QuestionStmnt>
//		break;
//
//	case RuleIndex.Substmnt2:
//		// <SubStmnt> ::= <Block>
//		break;
//
//	case RuleIndex.Vardecl_Identifier_Colon:
//		// <VarDecl> ::= Identifier ':' <Type>
//		break;
//
//	case RuleIndex.Varassign_Identifier_Colon_Eq:
//		// <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
//		break;
//
//	case RuleIndex.Questionstmnt_Stringlit_Gtgt_Semi:
//		// <QuestionStmnt> ::= StringLit '>>' <VarDecl> ';'
//		break;
//
//	case RuleIndex.Questionstmnt_Stringlit_Ltlt_Semi:
//		// <QuestionStmnt> ::= StringLit '<<' <VarAssign> ';'
//		break;
//
//	case RuleIndex.Questionstmnt_Stringlit_Ltlt_Semi2:
//		// <QuestionStmnt> ::= StringLit '<<' <Expression> ';'
//		break;
//
//	case RuleIndex.Questionstmnt_Goto_Identifier_Semi:
//		// <QuestionStmnt> ::= goto Identifier ';'
//		break;
//
//	case RuleIndex.Expression_Question_Colon:
//		// <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
//		break;
//
//	case RuleIndex.Expression:
//		// <Expression> ::= <OrExpr>
//		break;
//
//	case RuleIndex.Orexpr_Pipepipe:
//		// <OrExpr> ::= <OrExpr> '||' <AndExpr>
//		break;
//
//	case RuleIndex.Orexpr:
//		// <OrExpr> ::= <AndExpr>
//		break;
//
//	case RuleIndex.Andexpr_Ampamp:
//		// <AndExpr> ::= <AndExpr> '&&' <EqExpr>
//		break;
//
//	case RuleIndex.Andexpr:
//		// <AndExpr> ::= <EqExpr>
//		break;
//
//	case RuleIndex.Eqexpr_Eqeq:
//		// <EqExpr> ::= <EqExpr> '==' <CompExpr>
//		break;
//
//	case RuleIndex.Eqexpr_Exclameq:
//		// <EqExpr> ::= <EqExpr> '!=' <CompExpr>
//		break;
//
//	case RuleIndex.Eqexpr:
//		// <EqExpr> ::= <CompExpr>
//		break;
//
//	case RuleIndex.Compexpr_Lt:
//		// <CompExpr> ::= <CompExpr> '<' <AddExpr>
//		break;
//
//	case RuleIndex.Compexpr_Gt:
//		// <CompExpr> ::= <CompExpr> '>' <AddExpr>
//		break;
//
//	case RuleIndex.Compexpr_Lteq:
//		// <CompExpr> ::= <CompExpr> '<=' <AddExpr>
//		break;
//
//	case RuleIndex.Compexpr_Gteq:
//		// <CompExpr> ::= <CompExpr> '>=' <AddExpr>
//		break;
//
//	case RuleIndex.Compexpr:
//		// <CompExpr> ::= <AddExpr>
//		break;
//
//	case RuleIndex.Addexpr_Plus:
//		// <AddExpr> ::= <AddExpr> '+' <MultExpr>
//		break;
//
//	case RuleIndex.Addexpr_Minus:
//		// <AddExpr> ::= <AddExpr> '-' <MultExpr>
//		break;
//
//	case RuleIndex.Addexpr:
//		// <AddExpr> ::= <MultExpr>
//		break;
//
//	case RuleIndex.Multexpr_Times:
//		// <MultExpr> ::= <MultExpr> '*' <NegateExpr>
//		break;
//
//	case RuleIndex.Multexpr_Div:
//		// <MultExpr> ::= <MultExpr> '/' <NegateExpr>
//		break;
//
//	case RuleIndex.Multexpr:
//		// <MultExpr> ::= <NegateExpr>
//		break;
//
//	case RuleIndex.Negateexpr_Minus:
//		// <NegateExpr> ::= '-' <Value>
//		break;
//
//	case RuleIndex.Negateexpr_Exclam:
//		// <NegateExpr> ::= '!' <Value>
//		break;
//
//	case RuleIndex.Negateexpr:
//		// <NegateExpr> ::= <Value>
//		break;
//
//	case RuleIndex.Value_Identifier:
//		// <Value> ::= Identifier
//		break;
//
//	case RuleIndex.Value:
//		// <Value> ::= <Literal>
//		break;
//
//	case RuleIndex.Value_Lparen_Rparen:
//		// <Value> ::= '(' <Expression> ')'
//		break;
//
//	case RuleIndex.Literal_Stringlit:
//		// <Literal> ::= StringLit
//		break;
//
//	case RuleIndex.Literal_Intlit:
//		// <Literal> ::= IntLit
//		break;
//
//	case RuleIndex.Literal_Reallit:
//		// <Literal> ::= RealLit
//		break;
//
//	case RuleIndex.Literal_Boollit:
//		// <Literal> ::= BoolLit
//		break;
//
//}
#endregion
