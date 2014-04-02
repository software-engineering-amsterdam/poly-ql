using System;
using QSLib.AST;
using QSLib.AST.Expressions;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Nullary;
using QSLib.AST.Statements;
namespace QSLib.Visitors
{
    public interface IVisitor<T> : IStatementVisitor<T>, IExpressionVisitor<T>
    {
        T Result { get; }
    }
}
