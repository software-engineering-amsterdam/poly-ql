using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class Question : StatementBase
    {
        protected string Name;
        protected string Label;
        protected QBaseType Type;
        protected QLMemoryManager Memory;

        public Question(QLMemoryManager memory, string name, string label, QBaseType type)
        {
            Memory = memory;
            Name = name;
            Label = label;
            Type = type;
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (Memory.IsDeclared(Name))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("Identifier '{0}' is already defined!", Name),
                    TokenInfo = TokenInfo
                });
                return false;
            }

            Memory.Declare(Name, Type);

            if (!Memory.LabelIsDeclared(Label))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    IsWarning = true,
                    Message = string.Format("(Question) Declared label already exists: '{0}'", Label),
                    TokenInfo = TokenInfo
                });
            }

            Memory.DeclareLabel(Label);
            
            return true;
        }
    }
}
