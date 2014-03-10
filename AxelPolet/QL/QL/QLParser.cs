using QL.QLClasses;
using QL.TypeChecker;

namespace QL
{
    partial class QLParser
    {
        private Questionnaire _ASTRoot;
        private QLMemoryManager _qlMemoryManager;

        public Questionnaire GetAST()
        {
            return _ASTRoot;
        }

        public void SetIdManager(QLMemoryManager qlMemoryManager)
        {
            _qlMemoryManager = qlMemoryManager;
        }
    }
}
