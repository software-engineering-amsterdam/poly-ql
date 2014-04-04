/*
 * Grammar Information:
 *
 * Name            : Questionaire Language
 * Version         : v2
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
 * Symbol Count : 72
 * Rule Count   : 59
 */
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Grammar.Generated.v2
{
    public static class GrammarData
    {
        public const int SymbolCount = 72;
        public const int RuleCount = 59;

        public static readonly ReadOnlyDictionary<ushort, string> Rules = new ReadOnlyDictionary<ushort, string>(
            new Dictionary<ushort, string>()
            {
                { 0, "Type_String" },                                       // <Type> ::= string
                { 1, "Type_Int" },                                          // <Type> ::= int
                { 2, "Type_Real" },                                         // <Type> ::= real
                { 3, "Type_Bool" },                                         // <Type> ::= bool
                { 4, "Type_Date" },                                         // <Type> ::= date
                { 5, "Forms" },                                             // <Forms> ::= <Form> <Forms>
                { 6, "Forms2" },                                            // <Forms> ::= <Form>
                { 7, "Form_Form_Identifier" },                              // <Form> ::= form Identifier <Block>
                { 8, "Block_Lbrace_Rbrace" },                               // <Block> ::= '{' <Statements> '}'
                { 9, "Statements" },                                        // <Statements> ::= <Statement> <Statements>
                { 10, "Statements2" },                                      // <Statements> ::= <Statement>
                { 11, "Statement_If_Lparen_Rparen" },                       // <Statement> ::= if '(' <Expression> ')' <Statement> <OptElse>
                { 12, "Statement" },                                        // <Statement> ::= <Block>
                { 13, "Statement2" },                                       // <Statement> ::= <Question>
                { 14, "Statement_Gotonextform_Semi" },                      // <Statement> ::= gotoNextForm ';'
                { 15, "Statement_Repeat_Lparen_Rparen" },                   // <Statement> ::= repeat '(' <Expression> ')' <Statement>
                { 16, "Optelse_Else" },                                     // <OptElse> ::= else <Statement>
                { 17, "Optelse" },                                          // <OptElse> ::= 
                { 18, "Vardecl_Identifier_Colon" },                         // <VarDecl> ::= Identifier ':' <Type>
                { 19, "Varassign_Identifier_Colon_Eq" },                    // <VarAssign> ::= Identifier ':' <Type> '=' <Expression>
                { 20, "Question_Stringlit_Gtgt_Semi" },                     // <Question> ::= StringLit '>>' <VarDecl> ';'
                { 21, "Question_Stringlit_Ltlt_Semi" },                     // <Question> ::= StringLit '<<' <VarAssign> ';'
                { 22, "Question_Stringlit_Ltlt_Semi2" },                    // <Question> ::= StringLit '<<' <Expression> ';'
                { 23, "Expression_Question_Colon" },                        // <Expression> ::= <OrExpr> '?' <OrExpr> ':' <Expression>
                { 24, "Expression_Sum_Lparen_Identifier_Rparen" },          // <Expression> ::= sum '(' Identifier ')'
                { 25, "Expression_Avg_Lparen_Identifier_Rparen" },          // <Expression> ::= avg '(' Identifier ')'
                { 26, "Expression" },                                       // <Expression> ::= <OrExpr>
                { 27, "Orexpr_Pipepipe" },                                  // <OrExpr> ::= <OrExpr> '||' <AndExpr>
                { 28, "Orexpr" },                                           // <OrExpr> ::= <AndExpr>
                { 29, "Andexpr_Ampamp" },                                   // <AndExpr> ::= <AndExpr> '&&' <EqExpr>
                { 30, "Andexpr" },                                          // <AndExpr> ::= <EqExpr>
                { 31, "Eqexpr_Eqeq" },                                      // <EqExpr> ::= <EqExpr> '==' <CompExpr>
                { 32, "Eqexpr_Exclameq" },                                  // <EqExpr> ::= <EqExpr> '!=' <CompExpr>
                { 33, "Eqexpr" },                                           // <EqExpr> ::= <CompExpr>
                { 34, "Compexpr_Lt" },                                      // <CompExpr> ::= <CompExpr> '<' <AddExpr>
                { 35, "Compexpr_Gt" },                                      // <CompExpr> ::= <CompExpr> '>' <AddExpr>
                { 36, "Compexpr_Lteq" },                                    // <CompExpr> ::= <CompExpr> '<=' <AddExpr>
                { 37, "Compexpr_Gteq" },                                    // <CompExpr> ::= <CompExpr> '>=' <AddExpr>
                { 38, "Compexpr" },                                         // <CompExpr> ::= <AddExpr>
                { 39, "Addexpr_Plus" },                                     // <AddExpr> ::= <AddExpr> '+' <MultExpr>
                { 40, "Addexpr_Minus" },                                    // <AddExpr> ::= <AddExpr> '-' <MultExpr>
                { 41, "Addexpr" },                                          // <AddExpr> ::= <MultExpr>
                { 42, "Multexpr_Times" },                                   // <MultExpr> ::= <MultExpr> '*' <PowerExpr>
                { 43, "Multexpr_Div" },                                     // <MultExpr> ::= <MultExpr> '/' <PowerExpr>
                { 44, "Multexpr_Percent" },                                 // <MultExpr> ::= <MultExpr> '%' <PowerExpr>
                { 45, "Multexpr" },                                         // <MultExpr> ::= <PowerExpr>
                { 46, "Powerexpr_Caret" },                                  // <PowerExpr> ::= <PowerExpr> '^' <NegateExpr>
                { 47, "Powerexpr" },                                        // <PowerExpr> ::= <NegateExpr>
                { 48, "Negateexpr_Minus" },                                 // <NegateExpr> ::= '-' <Value>
                { 49, "Negateexpr_Exclam" },                                // <NegateExpr> ::= '!' <Value>
                { 50, "Negateexpr" },                                       // <NegateExpr> ::= <Value>
                { 51, "Value_Identifier" },                                 // <Value> ::= Identifier
                { 52, "Value" },                                            // <Value> ::= <Literal>
                { 53, "Value_Lparen_Rparen" },                              // <Value> ::= '(' <Expression> ')'
                { 54, "Literal_Stringlit" },                                // <Literal> ::= StringLit
                { 55, "Literal_Intlit" },                                   // <Literal> ::= IntLit
                { 56, "Literal_Reallit" },                                  // <Literal> ::= RealLit
                { 57, "Literal_Boollit" },                                  // <Literal> ::= BoolLit
                { 58, "Literal_Datelit" }                                   // <Literal> ::= DateLit
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

//    //<Type> ::= date
//    case "Type_Date":
//        return;

//    //<Forms> ::= <Form> <Forms>
//    case "Forms":
//        return;

//    //<Forms> ::= <Form>
//    case "Forms2":
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

//    //<Statement> ::= gotoNextForm ';'
//    case "Statement_Gotonextform_Semi":
//        return;

//    //<Statement> ::= repeat '(' <Expression> ')' <Statement>
//    case "Statement_Repeat_Lparen_Rparen":
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

//    //<Expression> ::= sum '(' Identifier ')'
//    case "Expression_Sum_Lparen_Identifier_Rparen":
//        return;

//    //<Expression> ::= avg '(' Identifier ')'
//    case "Expression_Avg_Lparen_Identifier_Rparen":
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

//    //<MultExpr> ::= <MultExpr> '*' <PowerExpr>
//    case "Multexpr_Times":
//        return;

//    //<MultExpr> ::= <MultExpr> '/' <PowerExpr>
//    case "Multexpr_Div":
//        return;

//    //<MultExpr> ::= <MultExpr> '%' <PowerExpr>
//    case "Multexpr_Percent":
//        return;

//    //<MultExpr> ::= <PowerExpr>
//    case "Multexpr":
//        return;

//    //<PowerExpr> ::= <PowerExpr> '^' <NegateExpr>
//    case "Powerexpr_Caret":
//        return;

//    //<PowerExpr> ::= <NegateExpr>
//    case "Powerexpr":
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

//    //<Literal> ::= DateLit
//    case "Literal_Datelit":
//        return;

//    default:
//        return;
//}
#endregion
