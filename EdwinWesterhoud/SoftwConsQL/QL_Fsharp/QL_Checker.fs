module QL_Checker
#nowarn "40"

open System.Collections.Generic
open System
open QL_Grammar

let contains x = Seq.exists ((=) x)

type expressionType = TBool | TString | TInt | TDate | TDecimal | TMoney | TIdentifier | TError | TForm

let mapQLType qlType = match qlType with
                       | QLBool -> TBool
                       | QLString -> TString
                       | QLInt -> TInt
                       | QLDate -> TDate
                       | QLDecimal -> TDecimal
                       | QLMoney -> TMoney

let identifiers = new Dictionary<string, expressionType>()

let getPrimitiveType exprType = 
    match exprType with
    | Bool(_) -> TBool, exprType
    | String(_) -> TString, exprType
    | Int(_) -> TInt, exprType
    | Date(_) -> TDate, exprType
    | Decimal(_) -> TDecimal, exprType
    | Money(_) -> TMoney, exprType

let rec checkExpression expression =
    match expression with
    | ID(_) -> TIdentifier, expression
    | Expr(e) -> (fst <| getPrimitiveType e), expression
    | Neg(Expr(Bool(_))) -> TBool, expression
    | Neg(BooleanOp(_,_,_)) -> TBool, expression
    | Neg(_) -> TError, TypeError(expression, "err1")

    | BooleanOp(b1, booleanOp.Eq, b2)
    | BooleanOp(b1, booleanOp.Ne, b2) -> let t1,_ = checkExpression b1
                                         let t2,_ = checkExpression b2
                                         let accepted = seq [TIdentifier ; TError]
                                         if t1.Equals(t2) || contains t1 accepted || contains t2 accepted then
                                            TBool, expression
                                         else
                                            TError, TypeError(expression, "err2")
    | BooleanOp(b1, booleanOp.And, b2)
    | BooleanOp(b1, booleanOp.Or, b2) -> let t1,_ = checkExpression b1
                                         let t2,_ = checkExpression b2
                                         let accepted = seq [TBool ; TIdentifier ; TError]
                                         if contains t1 accepted && contains t2 accepted then
                                            TBool, expression
                                         else
                                            TError, TypeError(expression, "err3")
    | BooleanOp(b1, booleanOp.Lt, b2)
    | BooleanOp(b1, booleanOp.Le, b2)
    | BooleanOp(b1, booleanOp.Gt, b2)
    | BooleanOp(b1, booleanOp.Ge, b2) -> let t1,_ = checkExpression b1
                                         let t2,_ = checkExpression b2
                                         let valid = seq [TInt ; TDate ; TDecimal ; TMoney ]
                                         let accepted = seq [TIdentifier ; TError]
                                         match t1 with
                                            | TInt | TDate | TDecimal | TMoney when t1.Equals(t2) || contains t2 accepted -> TBool, expression
                                            | TIdentifier | TError when contains t2 valid || contains t2 accepted -> TBool, expression
                                            | _ -> TError, TypeError(expression, "err4")

    | ArithmeticOp(a1, op, a2) -> let t1,_ = checkExpression a1
                                  let t2,_ = checkExpression a1
                                  let accepted = seq [TInt ; TDate ; TDecimal ; TMoney ; TIdentifier ; TError]
                                  if t1.Equals(t2) && contains t1 accepted then
                                    t1, expression
                                  else if contains t1 accepted && contains t2 accepted then
                                    match t1 with
                                    | TError  -> t2, expression
                                    | TIdentifier -> t2, expression
                                    | _ -> t1, expression
                                  else TError, TypeError(expression, "err5")
                                  

let rec checkStmts = 
    let checkAssignment ass = let exprType, expr = checkExpression ass.Expression
                              identifiers.Add(ass.ID, exprType)
                              Assignment(ass)

    let checkQuestion (ques:question) = identifiers.Add(ques.ID, mapQLType ques.Type)
                                        Question(ques)

    let checkConditional cond stmts = let exprType, expr = checkExpression cond
                                      Conditional(cond, checkStmts stmts)

    let checkStmt stmt = 
        match stmt with
        | Assignment(ass) -> checkAssignment ass
        | Question(ques) -> checkQuestion ques
        | Conditional(cond, stmts) -> checkConditional cond stmts
        
    List.map checkStmt

let typeCheck ast = identifiers.Clear()
                    identifiers.Add(ast.ID, TForm)
                    {   ID = ast.ID;
                        Statements = checkStmts ast.Statements 
                    }

