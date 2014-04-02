using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Statements
{
    public interface IStatement
    {
         T Accept<T>(IStatementVisitor<T> checker);
    }
}
