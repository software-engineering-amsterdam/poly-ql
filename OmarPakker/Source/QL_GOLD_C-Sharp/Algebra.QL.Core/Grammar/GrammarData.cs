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
 * Symbol Count : 62
 * Rule Count   : 48
 */
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Grammar.Generated.v1
{
    public static class GrammarData
    {
        public const int SymbolCount = 62;
        public const int RuleCount = 48;

        public static readonly ReadOnlyDictionary<ushort, string> Rules = new ReadOnlyDictionary<ushort, string>(
            new Dictionary<ushort, string>()
            {
                { 0, "Type_String" },                                       // <Type> ::= string
                { 1, "Type_Int" },                                          // <Type> ::= int
                { 2, "Type_Real" },                                         // <Type> ::= real
                { 3, "Type_Bool" },                                         // <Type> ::= bool
                { 4, "Form_Form_Identifier" },                              // <Form> ::= form Identifier <Block>
                { 5, "Block_Lbrace_Rbrace" },                               // <Block> ::= '{' <Statements> '}'
                { 6, "Statements" },                                        // <Statements> ::= <Statement> <Statements>
                { 7, "Statements2" },                                       // <Statements> ::= <Statement>
                { 8, "Statement_If_Lparen_Rparen" },                        // <Statement> ::= if '(' <Expression> ')' <Statement> <OptElse>
                { 9, "Statement" },                                         // <Statement> ::= <Block>
                { 10, "Statement2" },                                       // <Statement> ::= <Question>
                { 11, "Optelse_Else" },                                     // <OptElse> ::= else <Statement>
                { 12, "Optelse" },                                          // <OptElse> ::= 
                { 13, "Vardecl_Identifier_Colon" },                         // <VarDecl> ::= Identifier ':' <Type>
                { 14, "Varassign_Identifier_Colon_Eq" },                    // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
                { 15, "Question_Stringlit_Gtgt_Semi" },                     // <Question> ::= StringLit '>>' <VarDecl> ';'
                { 16, "Question_Stringlit_Ltlt_Semi" },                     // <Question> ::= StringLit '<<' <VarAssign> ';'
                { 17, "Question_Stringlit_Ltlt_Semi2" },                    // <Question> ::= StringLit '<<' <Expression> ';'
                { 18, "Expression_Question_Colon" },                        // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
                { 19, "Expression" },                                       // <Expression> ::= <OrExpr>
                { 20, "Orexpr_Pipepipe" },                                  // <OrExpr> ::= <OrExpr> '||' <AndExpr>
                { 21, "Orexpr" },                                           // <OrExpr> ::= <AndExpr>
                { 22, "Andexpr_Ampamp" },                                   // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
                { 23, "Andexpr" },                                          // <AndExpr> ::= <EqExpr>
                { 24, "Eqexpr_Eqeq" },                                      // <EqExpr> ::= <EqExpr> '==' <CompExpr>
                { 25, "Eqexpr_Exclameq" },                                  // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
                { 26, "Eqexpr" },                                           // <EqExpr> ::= <CompExpr>
                { 27, "Compexpr_Lt" },                                      // <CompExpr> ::= <CompExpr> '<' <AddExpr>
                { 28, "Compexpr_Gt" },                                      // <CompExpr> ::= <CompExpr> '>' <AddExpr>
                { 29, "Compexpr_Lteq" },                                    // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
                { 30, "Compexpr_Gteq" },                                    // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
                { 31, "Compexpr" },                                         // <CompExpr> ::= <AddExpr>
                { 32, "Addexpr_Plus" },                                     // <AddExpr> ::= <AddExpr> '+' <MultExpr>
                { 33, "Addexpr_Minus" },                                    // <AddExpr> ::= <AddExpr> '-' <MultExpr>
                { 34, "Addexpr" },                                          // <AddExpr> ::= <MultExpr>
                { 35, "Multexpr_Times" },                                   // <MultExpr> ::= <MultExpr> '*' <NegateExpr>
                { 36, "Multexpr_Div" },                                     // <MultExpr> ::= <MultExpr> '/' <NegateExpr>
                { 37, "Multexpr" },                                         // <MultExpr> ::= <NegateExpr>
                { 38, "Negateexpr_Minus" },                                 // <NegateExpr> ::= '-' <Value>
                { 39, "Negateexpr_Exclam" },                                // <NegateExpr> ::= '!' <Value>
                { 40, "Negateexpr" },                                       // <NegateExpr> ::= <Value>
                { 41, "Value_Identifier" },                                 // <Value> ::= Identifier
                { 42, "Value" },                                            // <Value> ::= <Literal>
                { 43, "Value_Lparen_Rparen" },                              // <Value> ::= '(' <Expression> ')'
                { 44, "Literal_Stringlit" },                                // <Literal> ::= StringLit
                { 45, "Literal_Intlit" },                                   // <Literal> ::= IntLit
                { 46, "Literal_Reallit" },                                  // <Literal> ::= RealLit
                { 47, "Literal_Boollit" }                                   // <Literal> ::= BoolLit
            }
        );
    };
}


/*
 * Pre-build switch covering all the rules
 */
#region Rules Switch
//switch (Rules[r.Production.TableIndex])
//{
//    //<Type> ::= string
//    case "Type_String":
//        return;

//    //<Type> ::= int
//    case "Type_Int":
//        return;

//    //<Type> ::= real
//    case "Type_Real":
//        return;

//    //<Type> ::= bool
//    case "Type_Bool":
//        return;

//    //<Form> ::= form Identifier <Block>
//    case "Form_Form_Identifier":
//        return;

//    //<Block> ::= '{' <Statements> '}'
//    case "Block_Lbrace_Rbrace":
//        return;

//    //<Statements> ::= <Statement> <Statements>
//    case "Statements":
//        return;

//    //<Statements> ::= <Statement>
//    case "Statements2":
//        return;

//    //<Statement> ::= if '(' <Expression> ')' <Statement> <OptElse>
//    case "Statement_If_Lparen_Rparen":
//        return;

//    //<Statement> ::= <Block>
//    case "Statement":
//        return;

//    //<Statement> ::= <Question>
//    case "Statement2":
//        return;

//    //<OptElse> ::= else <Statement>
//    case "Optelse_Else":
//        return;

//    //<OptElse> ::= 
//    case "Optelse":
//        return;

//    //<VarDecl> ::= Identifier ':' <Type>
//    case "Vardecl_Identifier_Colon":
//        return;

//    //<VarAssign> ::= Identifier ':' <Type> '=' <Expression>
//    case "Varassign_Identifier_Colon_Eq":
//        return;

//    //<Question> ::= StringLit '>>' <VarDecl> ';'
//    case "Question_Stringlit_Gtgt_Semi":
//        return;

//    //<Question> ::= StringLit '<<' <VarAssign> ';'
//    case "Question_Stringlit_Ltlt_Semi":
//        return;

//    //<Question> ::= StringLit '<<' <Expression> ';'
//    case "Question_Stringlit_Ltlt_Semi2":
//        return;

//    //<Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
//    case "Expression_Question_Colon":
//        return;

//    //<Expression> ::= <OrExpr>
//    case "Expression":
//        return;

//    //<OrExpr> ::= <OrExpr> '||' <AndExpr>
//    case "Orexpr_Pipepipe":
//        return;

//    //<OrExpr> ::= <AndExpr>
//    case "Orexpr":
//        return;

//    //<AndExpr> ::= <AndExpr> '&&' <EqExpr>
//    case "Andexpr_Ampamp":
//        return;

//    //<AndExpr> ::= <EqExpr>
//    case "Andexpr":
//        return;

//    //<EqExpr> ::= <EqExpr> '==' <CompExpr>
//    case "Eqexpr_Eqeq":
//        return;

//    //<EqExpr> ::= <EqExpr> '!=' <CompExpr>
//    case "Eqexpr_Exclameq":
//        return;

//    //<EqExpr> ::= <CompExpr>
//    case "Eqexpr":
//        return;

//    //<CompExpr> ::= <CompExpr> '<' <AddExpr>
//    case "Compexpr_Lt":
//        return;

//    //<CompExpr> ::= <CompExpr> '>' <AddExpr>
//    case "Compexpr_Gt":
//        return;

//    //<CompExpr> ::= <CompExpr> '<=' <AddExpr>
//    case "Compexpr_Lteq":
//        return;

//    //<CompExpr> ::= <CompExpr> '>=' <AddExpr>
//    case "Compexpr_Gteq":
//        return;

//    //<CompExpr> ::= <AddExpr>
//    case "Compexpr":
//        return;

//    //<AddExpr> ::= <AddExpr> '+' <MultExpr>
//    case "Addexpr_Plus":
//        return;

//    //<AddExpr> ::= <AddExpr> '-' <MultExpr>
//    case "Addexpr_Minus":
//        return;

//    //<AddExpr> ::= <MultExpr>
//    case "Addexpr":
//        return;

//    //<MultExpr> ::= <MultExpr> '*' <NegateExpr>
//    case "Multexpr_Times":
//        return;

//    //<MultExpr> ::= <MultExpr> '/' <NegateExpr>
//    case "Multexpr_Div":
//        return;

//    //<MultExpr> ::= <NegateExpr>
//    case "Multexpr":
//        return;

//    //<NegateExpr> ::= '-' <Value>
//    case "Negateexpr_Minus":
//        return;

//    //<NegateExpr> ::= '!' <Value>
//    case "Negateexpr_Exclam":
//        return;

//    //<NegateExpr> ::= <Value>
//    case "Negateexpr":
//        return;

//    //<Value> ::= Identifier
//    case "Value_Identifier":
//        return;

//    //<Value> ::= <Literal>
//    case "Value":
//        return;

//    //<Value> ::= '(' <Expression> ')'
//    case "Value_Lparen_Rparen":
//        return;

//    //<Literal> ::= StringLit
//    case "Literal_Stringlit":
//        return;

//    //<Literal> ::= IntLit
//    case "Literal_Intlit":
//        return;

//    //<Literal> ::= RealLit
//    case "Literal_Reallit":
//        return;

//    //<Literal> ::= BoolLit
//    case "Literal_Boollit":
//        return;

//    default:
//        return;
//}
#endregion
