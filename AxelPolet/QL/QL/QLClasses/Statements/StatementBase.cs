using Antlr4.Runtime;
using QL.Interfaces;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public abstract class StatementBase : ITypeChecker
    {
        public int TokenLine { get; set; }
        public int TokenColumn { get; set; }
        public string TokenText { get; set; }

        public IToken Token 
        {
            set { TokenLine = value.Line; TokenColumn = value.Column; TokenText = value.Text; }
        }

        public abstract bool CheckType(ref QLException error);
    }
}
