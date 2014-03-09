using QSLib.Types;

namespace QSLib.Expressions
{
    public interface IExpression 
    {
        bool CheckType(TypeChecker checker);
        QSType Type { get; }
        
    }
}
