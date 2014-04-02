using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.AST.Statements;
using QSLib.AST;

namespace QSLib.Visitors
{
    public interface IStatementVisitor<T>
    {
        T Visit(Form form);
        T Visit(IfStatement ifStatement);
        T Visit(Question question);
        T Visit(ComputedQuestion computedQuestion);
        T Visit(CodeBlock codeBlock);
    }
}
