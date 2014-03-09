using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Identifier
{
    public class QIdentifier : ExpressionBase
    {
        private readonly QLMemoryManager _memory;
        private readonly string _name;

        public QIdentifier(QLMemoryManager memoryManager, string name)
        {
            _memory = memoryManager;
            _name = name;
        }

        public override QBaseType GetResultType()
        {
            return _memory.GetDeclaredType(_name);
        }

        public override ExpressionBase GetResult()
        {
            return _memory.GetDeclaredValue(_name).GetResult();
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!_memory.IsDeclared(_name))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("Referenced identifier '{0}' is not defined!", _name),
                    TokenInfo = TokenInfo
                });
                return false;
            }

            return true;
        }

        #endregion
    }
}
