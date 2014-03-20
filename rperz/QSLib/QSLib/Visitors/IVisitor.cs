using System;
using QSLib.AST;
using QSLib.AST.Expressions;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Unary.Identifiers;
using QSLib.AST.Statements;
namespace QSLib.Visitors
{
    public interface IVisitor
    {
        void Visit(CodeBlock codeBlock);
        void Visit(Binary_Expression expression);
        void Visit(Primary primary);
        void Visit(Identifier id);
        void Visit(OutputIdentifier id);
        void Visit(Unary_Expression expression);
        void Visit(Form form);
        void Visit(IfStatement ifStatement);
        void Visit(Question question);
        bool Result { get; }
        object Output { get; }
    }
}
