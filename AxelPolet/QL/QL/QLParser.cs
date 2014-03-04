using QL.QLClasses;
using QL.TypeChecker;

namespace QL
{
    partial class QLParser
    {
        private Questionnaire _ASTRoot;
        private QLIdManager _qlIdManager;
        private QLQuestionManager _qlQuestionManager;

        public Questionnaire GetAST()
        {
            return _ASTRoot;
        }

        public void SetIdManager(QLIdManager qlIdManager)
        {
            _qlIdManager = qlIdManager;
        }

        public void SetQuestionManager(QLQuestionManager qlQuestionManager)
        {
            _qlQuestionManager = qlQuestionManager;
        }
    }
}
