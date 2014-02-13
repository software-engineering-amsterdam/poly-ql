/*
 * Grammar Information:
 *
 * Name            : Questionaire Language
 * Version         : v1
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
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Grammar.Generated.v1
{
	public static class GrammarData
    {
        public const int SymbolCount = 64;
        public const int RuleCount = 53;

        public static readonly ReadOnlyDictionary<string, short> Rules = new ReadOnlyDictionary<string, short>(
	        new Dictionary<string, short>()
            {
                { "Type_String", 0 },                                       // <Type> ::= string
                { "Type_Int", 1 },                                          // <Type> ::= int
                { "Type_Real", 2 },                                         // <Type> ::= real
                { "Type_Bool", 3 },                                         // <Type> ::= bool
                { "Forms", 4 },                                             // <Forms> ::= <Form> <Forms>
                { "Forms2", 5 },                                            // <Forms> ::= <Form>
                { "Form_Form_Identifier", 6 },                              // <Form> ::= form Identifier <Block>
                { "Block_Lbrace_Rbrace", 7 },                               // <Block> ::= '{' <Statements> '}'
                { "Statements", 8 },                                        // <Statements> ::= <Statement> <Statements>
                { "Statements2", 9 },                                       // <Statements> ::= <Statement>
                { "Statement_If_Lparen_Rparen", 10 },                       // <Statement> ::= if '(' <Expression> ')' <Statement>
                { "Statement_If_Lparen_Rparen_Else", 11 },                  // <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
                { "Statement", 12 },                                        // <Statement> ::= <QuestionStmnt>
                { "Statement2", 13 },                                       // <Statement> ::= <Block>
                { "Substmnt_If_Lparen_Rparen_Else", 14 },                   // <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
                { "Substmnt", 15 },                                         // <SubStmnt> ::= <QuestionStmnt>
                { "Substmnt2", 16 },                                        // <SubStmnt> ::= <Block>
                { "Vardecl_Identifier_Colon", 17 },                         // <VarDecl> ::= Identifier ':' <Type>
                { "Varassign_Identifier_Colon_Eq", 18 },                    // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
                { "Questionstmnt_Stringlit_Gtgt_Semi", 19 },                // <QuestionStmnt> ::= StringLit '>>' <VarDecl> ';'
                { "Questionstmnt_Stringlit_Ltlt_Semi", 20 },                // <QuestionStmnt> ::= StringLit '<<' <VarAssign> ';'
                { "Questionstmnt_Stringlit_Ltlt_Semi2", 21 },               // <QuestionStmnt> ::= StringLit '<<' <Expression> ';'
                { "Questionstmnt_Goto_Identifier_Semi", 22 },               // <QuestionStmnt> ::= goto Identifier ';'
                { "Expression_Question_Colon", 23 },                        // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
                { "Expression", 24 },                                       // <Expression> ::= <OrExpr>
                { "Orexpr_Pipepipe", 25 },                                  // <OrExpr> ::= <OrExpr> '||' <AndExpr>
                { "Orexpr", 26 },                                           // <OrExpr> ::= <AndExpr>
                { "Andexpr_Ampamp", 27 },                                   // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
                { "Andexpr", 28 },                                          // <AndExpr> ::= <EqExpr>
                { "Eqexpr_Eqeq", 29 },                                      // <EqExpr> ::= <EqExpr> '==' <CompExpr>
                { "Eqexpr_Exclameq", 30 },                                  // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
                { "Eqexpr", 31 },                                           // <EqExpr> ::= <CompExpr>
                { "Compexpr_Lt", 32 },                                      // <CompExpr> ::= <CompExpr> '<' <AddExpr>
                { "Compexpr_Gt", 33 },                                      // <CompExpr> ::= <CompExpr> '>' <AddExpr>
                { "Compexpr_Lteq", 34 },                                    // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
                { "Compexpr_Gteq", 35 },                                    // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
                { "Compexpr", 36 },                                         // <CompExpr> ::= <AddExpr>
                { "Addexpr_Plus", 37 },                                     // <AddExpr> ::= <AddExpr> '+' <MultExpr>
                { "Addexpr_Minus", 38 },                                    // <AddExpr> ::= <AddExpr> '-' <MultExpr>
                { "Addexpr", 39 },                                          // <AddExpr> ::= <MultExpr>
                { "Multexpr_Times", 40 },                                   // <MultExpr> ::= <MultExpr> '*' <NegateExpr>
                { "Multexpr_Div", 41 },                                     // <MultExpr> ::= <MultExpr> '/' <NegateExpr>
                { "Multexpr", 42 },                                         // <MultExpr> ::= <NegateExpr>
                { "Negateexpr_Minus", 43 },                                 // <NegateExpr> ::= '-' <Value>
                { "Negateexpr_Exclam", 44 },                                // <NegateExpr> ::= '!' <Value>
                { "Negateexpr", 45 },                                       // <NegateExpr> ::= <Value>
                { "Value_Identifier", 46 },                                 // <Value> ::= Identifier
                { "Value", 47 },                                            // <Value> ::= <Literal>
                { "Value_Lparen_Rparen", 48 },                              // <Value> ::= '(' <Expression> ')'
                { "Literal_Stringlit", 49 },                                // <Literal> ::= StringLit
                { "Literal_Intlit", 50 },                                   // <Literal> ::= IntLit
                { "Literal_Reallit", 51 },                                  // <Literal> ::= RealLit
                { "Literal_Boollit", 52 }                                   // <Literal> ::= BoolLit
            }
		);
    };
}



/*
 * Pre-build if's covering all the rules
 */
#region Rules If
////<Type> ::= string
//if (r.Parent.TableIndex() == Rules["Type_String"])
//{
//    return;
//}
////<Type> ::= int
//if (r.Parent.TableIndex() == Rules["Type_Int"])
//{
//    return;
//}
////<Type> ::= real
//if (r.Parent.TableIndex() == Rules["Type_Real"])
//{
//    return;
//}
////<Type> ::= bool
//if (r.Parent.TableIndex() == Rules["Type_Bool"])
//{
//    return;
//}
////<Forms> ::= <Form> <Forms>
//if (r.Parent.TableIndex() == Rules["Forms"])
//{
//    return;
//}
////<Forms> ::= <Form>
//if (r.Parent.TableIndex() == Rules["Forms2"])
//{
//    return;
//}
////<Form> ::= form Identifier <Block>
//if (r.Parent.TableIndex() == Rules["Form_Form_Identifier"])
//{
//    return;
//}
////<Block> ::= '{' <Statements> '}'
//if (r.Parent.TableIndex() == Rules["Block_Lbrace_Rbrace"])
//{
//    return;
//}
////<Statements> ::= <Statement> <Statements>
//if (r.Parent.TableIndex() == Rules["Statements"])
//{
//    return;
//}
////<Statements> ::= <Statement>
//if (r.Parent.TableIndex() == Rules["Statements2"])
//{
//    return;
//}
////<Statement> ::= if '(' <Expression> ')' <Statement>
//if (r.Parent.TableIndex() == Rules["Statement_If_Lparen_Rparen"])
//{
//    return;
//}
////<Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
//if (r.Parent.TableIndex() == Rules["Statement_If_Lparen_Rparen_Else"])
//{
//    return;
//}
////<Statement> ::= <QuestionStmnt>
//if (r.Parent.TableIndex() == Rules["Statement"])
//{
//    return;
//}
////<Statement> ::= <Block>
//if (r.Parent.TableIndex() == Rules["Statement2"])
//{
//    return;
//}
////<SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
//if (r.Parent.TableIndex() == Rules["Substmnt_If_Lparen_Rparen_Else"])
//{
//    return;
//}
////<SubStmnt> ::= <QuestionStmnt>
//if (r.Parent.TableIndex() == Rules["Substmnt"])
//{
//    return;
//}
////<SubStmnt> ::= <Block>
//if (r.Parent.TableIndex() == Rules["Substmnt2"])
//{
//    return;
//}
////<VarDecl> ::= Identifier ':' <Type>
//if (r.Parent.TableIndex() == Rules["Vardecl_Identifier_Colon"])
//{
//    return;
//}
////<VarAssign> ::= Identifier ':' <Type> '=' <Expression>
//if (r.Parent.TableIndex() == Rules["Varassign_Identifier_Colon_Eq"])
//{
//    return;
//}
////<QuestionStmnt> ::= StringLit '>>' <VarDecl> ';'
//if (r.Parent.TableIndex() == Rules["Questionstmnt_Stringlit_Gtgt_Semi"])
//{
//    return;
//}
////<QuestionStmnt> ::= StringLit '<<' <VarAssign> ';'
//if (r.Parent.TableIndex() == Rules["Questionstmnt_Stringlit_Ltlt_Semi"])
//{
//    return;
//}
////<QuestionStmnt> ::= StringLit '<<' <Expression> ';'
//if (r.Parent.TableIndex() == Rules["Questionstmnt_Stringlit_Ltlt_Semi2"])
//{
//    return;
//}
////<QuestionStmnt> ::= goto Identifier ';'
//if (r.Parent.TableIndex() == Rules["Questionstmnt_Goto_Identifier_Semi"])
//{
//    return;
//}
////<Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
//if (r.Parent.TableIndex() == Rules["Expression_Question_Colon"])
//{
//    return;
//}
////<Expression> ::= <OrExpr>
//if (r.Parent.TableIndex() == Rules["Expression"])
//{
//    return;
//}
////<OrExpr> ::= <OrExpr> '||' <AndExpr>
//if (r.Parent.TableIndex() == Rules["Orexpr_Pipepipe"])
//{
//    return;
//}
////<OrExpr> ::= <AndExpr>
//if (r.Parent.TableIndex() == Rules["Orexpr"])
//{
//    return;
//}
////<AndExpr> ::= <AndExpr> '&&' <EqExpr>
//if (r.Parent.TableIndex() == Rules["Andexpr_Ampamp"])
//{
//    return;
//}
////<AndExpr> ::= <EqExpr>
//if (r.Parent.TableIndex() == Rules["Andexpr"])
//{
//    return;
//}
////<EqExpr> ::= <EqExpr> '==' <CompExpr>
//if (r.Parent.TableIndex() == Rules["Eqexpr_Eqeq"])
//{
//    return;
//}
////<EqExpr> ::= <EqExpr> '!=' <CompExpr>
//if (r.Parent.TableIndex() == Rules["Eqexpr_Exclameq"])
//{
//    return;
//}
////<EqExpr> ::= <CompExpr>
//if (r.Parent.TableIndex() == Rules["Eqexpr"])
//{
//    return;
//}
////<CompExpr> ::= <CompExpr> '<' <AddExpr>
//if (r.Parent.TableIndex() == Rules["Compexpr_Lt"])
//{
//    return;
//}
////<CompExpr> ::= <CompExpr> '>' <AddExpr>
//if (r.Parent.TableIndex() == Rules["Compexpr_Gt"])
//{
//    return;
//}
////<CompExpr> ::= <CompExpr> '<=' <AddExpr>
//if (r.Parent.TableIndex() == Rules["Compexpr_Lteq"])
//{
//    return;
//}
////<CompExpr> ::= <CompExpr> '>=' <AddExpr>
//if (r.Parent.TableIndex() == Rules["Compexpr_Gteq"])
//{
//    return;
//}
////<CompExpr> ::= <AddExpr>
//if (r.Parent.TableIndex() == Rules["Compexpr"])
//{
//    return;
//}
////<AddExpr> ::= <AddExpr> '+' <MultExpr>
//if (r.Parent.TableIndex() == Rules["Addexpr_Plus"])
//{
//    return;
//}
////<AddExpr> ::= <AddExpr> '-' <MultExpr>
//if (r.Parent.TableIndex() == Rules["Addexpr_Minus"])
//{
//    return;
//}
////<AddExpr> ::= <MultExpr>
//if (r.Parent.TableIndex() == Rules["Addexpr"])
//{
//    return;
//}
////<MultExpr> ::= <MultExpr> '*' <NegateExpr>
//if (r.Parent.TableIndex() == Rules["Multexpr_Times"])
//{
//    return;
//}
////<MultExpr> ::= <MultExpr> '/' <NegateExpr>
//if (r.Parent.TableIndex() == Rules["Multexpr_Div"])
//{
//    return;
//}
////<MultExpr> ::= <NegateExpr>
//if (r.Parent.TableIndex() == Rules["Multexpr"])
//{
//    return;
//}
////<NegateExpr> ::= '-' <Value>
//if (r.Parent.TableIndex() == Rules["Negateexpr_Minus"])
//{
//    return;
//}
////<NegateExpr> ::= '!' <Value>
//if (r.Parent.TableIndex() == Rules["Negateexpr_Exclam"])
//{
//    return;
//}
////<NegateExpr> ::= <Value>
//if (r.Parent.TableIndex() == Rules["Negateexpr"])
//{
//    return;
//}
////<Value> ::= Identifier
//if (r.Parent.TableIndex() == Rules["Value_Identifier"])
//{
//    return;
//}
////<Value> ::= <Literal>
//if (r.Parent.TableIndex() == Rules["Value"])
//{
//    return;
//}
////<Value> ::= '(' <Expression> ')'
//if (r.Parent.TableIndex() == Rules["Value_Lparen_Rparen"])
//{
//    return;
//}
////<Literal> ::= StringLit
//if (r.Parent.TableIndex() == Rules["Literal_Stringlit"])
//{
//    return;
//}
////<Literal> ::= IntLit
//if (r.Parent.TableIndex() == Rules["Literal_Intlit"])
//{
//    return;
//}
////<Literal> ::= RealLit
//if (r.Parent.TableIndex() == Rules["Literal_Reallit"])
//{
//    return;
//}
////<Literal> ::= BoolLit
//if (r.Parent.TableIndex() == Rules["Literal_Boollit"])
//{
//    return;
//}
#endregion


/*
 * Pre-build switch covering all the rules
 */
#region Rules Switch
//switch(r.Parent.TableIndex())
//{
//    case RuleIndices.Type_String:
//        // <Type> ::= string
//        break;
//
//    case RuleIndices.Type_Int:
//        // <Type> ::= int
//        break;
//
//    case RuleIndices.Type_Real:
//        // <Type> ::= real
//        break;
//
//    case RuleIndices.Type_Bool:
//        // <Type> ::= bool
//        break;
//
//    case RuleIndices.Forms:
//        // <Forms> ::= <Form> <Forms>
//        break;
//
//    case RuleIndices.Forms2:
//        // <Forms> ::= <Form>
//        break;
//
//    case RuleIndices.Form_Form_Identifier:
//        // <Form> ::= form Identifier <Block>
//        break;
//
//    case RuleIndices.Block_Lbrace_Rbrace:
//        // <Block> ::= '{' <Statements> '}'
//        break;
//
//    case RuleIndices.Statements:
//        // <Statements> ::= <Statement> <Statements>
//        break;
//
//    case RuleIndices.Statements2:
//        // <Statements> ::= <Statement>
//        break;
//
//    case RuleIndices.Statement_If_Lparen_Rparen:
//        // <Statement> ::= if '(' <Expression> ')' <Statement>
//        break;
//
//    case RuleIndices.Statement_If_Lparen_Rparen_Else:
//        // <Statement> ::= if '(' <Expression> ')' <SubStmnt> else <Statement>
//        break;
//
//    case RuleIndices.Statement:
//        // <Statement> ::= <QuestionStmnt>
//        break;
//
//    case RuleIndices.Statement2:
//        // <Statement> ::= <Block>
//        break;
//
//    case RuleIndices.Substmnt_If_Lparen_Rparen_Else:
//        // <SubStmnt> ::= if '(' <Expression> ')' <SubStmnt> else <SubStmnt>
//        break;
//
//    case RuleIndices.Substmnt:
//        // <SubStmnt> ::= <QuestionStmnt>
//        break;
//
//    case RuleIndices.Substmnt2:
//        // <SubStmnt> ::= <Block>
//        break;
//
//    case RuleIndices.Vardecl_Identifier_Colon:
//        // <VarDecl> ::= Identifier ':' <Type>
//        break;
//
//    case RuleIndices.Varassign_Identifier_Colon_Eq:
//        // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
//        break;
//
//    case RuleIndices.Questionstmnt_Stringlit_Gtgt_Semi:
//        // <QuestionStmnt> ::= StringLit '>>' <VarDecl> ';'
//        break;
//
//    case RuleIndices.Questionstmnt_Stringlit_Ltlt_Semi:
//        // <QuestionStmnt> ::= StringLit '<<' <VarAssign> ';'
//        break;
//
//    case RuleIndices.Questionstmnt_Stringlit_Ltlt_Semi2:
//        // <QuestionStmnt> ::= StringLit '<<' <Expression> ';'
//        break;
//
//    case RuleIndices.Questionstmnt_Goto_Identifier_Semi:
//        // <QuestionStmnt> ::= goto Identifier ';'
//        break;
//
//    case RuleIndices.Expression_Question_Colon:
//        // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
//        break;
//
//    case RuleIndices.Expression:
//        // <Expression> ::= <OrExpr>
//        break;
//
//    case RuleIndices.Orexpr_Pipepipe:
//        // <OrExpr> ::= <OrExpr> '||' <AndExpr>
//        break;
//
//    case RuleIndices.Orexpr:
//        // <OrExpr> ::= <AndExpr>
//        break;
//
//    case RuleIndices.Andexpr_Ampamp:
//        // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
//        break;
//
//    case RuleIndices.Andexpr:
//        // <AndExpr> ::= <EqExpr>
//        break;
//
//    case RuleIndices.Eqexpr_Eqeq:
//        // <EqExpr> ::= <EqExpr> '==' <CompExpr>
//        break;
//
//    case RuleIndices.Eqexpr_Exclameq:
//        // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
//        break;
//
//    case RuleIndices.Eqexpr:
//        // <EqExpr> ::= <CompExpr>
//        break;
//
//    case RuleIndices.Compexpr_Lt:
//        // <CompExpr> ::= <CompExpr> '<' <AddExpr>
//        break;
//
//    case RuleIndices.Compexpr_Gt:
//        // <CompExpr> ::= <CompExpr> '>' <AddExpr>
//        break;
//
//    case RuleIndices.Compexpr_Lteq:
//        // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
//        break;
//
//    case RuleIndices.Compexpr_Gteq:
//        // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
//        break;
//
//    case RuleIndices.Compexpr:
//        // <CompExpr> ::= <AddExpr>
//        break;
//
//    case RuleIndices.Addexpr_Plus:
//        // <AddExpr> ::= <AddExpr> '+' <MultExpr>
//        break;
//
//    case RuleIndices.Addexpr_Minus:
//        // <AddExpr> ::= <AddExpr> '-' <MultExpr>
//        break;
//
//    case RuleIndices.Addexpr:
//        // <AddExpr> ::= <MultExpr>
//        break;
//
//    case RuleIndices.Multexpr_Times:
//        // <MultExpr> ::= <MultExpr> '*' <NegateExpr>
//        break;
//
//    case RuleIndices.Multexpr_Div:
//        // <MultExpr> ::= <MultExpr> '/' <NegateExpr>
//        break;
//
//    case RuleIndices.Multexpr:
//        // <MultExpr> ::= <NegateExpr>
//        break;
//
//    case RuleIndices.Negateexpr_Minus:
//        // <NegateExpr> ::= '-' <Value>
//        break;
//
//    case RuleIndices.Negateexpr_Exclam:
//        // <NegateExpr> ::= '!' <Value>
//        break;
//
//    case RuleIndices.Negateexpr:
//        // <NegateExpr> ::= <Value>
//        break;
//
//    case RuleIndices.Value_Identifier:
//        // <Value> ::= Identifier
//        break;
//
//    case RuleIndices.Value:
//        // <Value> ::= <Literal>
//        break;
//
//    case RuleIndices.Value_Lparen_Rparen:
//        // <Value> ::= '(' <Expression> ')'
//        break;
//
//    case RuleIndices.Literal_Stringlit:
//        // <Literal> ::= StringLit
//        break;
//
//    case RuleIndices.Literal_Intlit:
//        // <Literal> ::= IntLit
//        break;
//
//    case RuleIndices.Literal_Reallit:
//        // <Literal> ::= RealLit
//        break;
//
//    case RuleIndices.Literal_Boollit:
//        // <Literal> ::= BoolLit
//        break;
//
//}
#endregion
