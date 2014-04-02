using System;
using QSLib.AST;
using QSLib.AST.Expressions;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Nullary;
using QSLib.AST.Statements;
using QSLib.AST.Expressions.Binary;
namespace QSLib.Visitors
{
    public interface IExpressionVisitor<T>
    {
        T Visit(Primary primary);
        T Visit(Identifier id);
        T Visit(Divide expression);
        T Visit(Add expression);
        T Visit(Subtract expression);
        T Visit(Multiply expression);
        T Visit(Not expression);
        T Visit(LessThan expression);
        T Visit(LessThan_Equals expression);
        T Visit(GreaterThan expression);
        T Visit(GreaterThan_Equals expression);
        T Visit(Equals expression);
        T Visit(NotEquals expression);
        T Visit(Or expression);
        T Visit(And expression);
    }
}
