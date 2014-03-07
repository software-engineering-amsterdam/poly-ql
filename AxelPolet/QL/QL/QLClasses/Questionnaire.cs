using System.Collections.Generic;
using QL.QLClasses.Statements;
using QL.TypeChecker;

namespace QL.QLClasses
{
    public class Questionnaire
    {
        private string _title;
        private List<StatementBase> _body;

        public Questionnaire(string title, List<StatementBase> body)
        {
            _title = title;
            _body = body;
        }

        public void CheckType(QLTypeErrors typeErrors)
        {
            foreach (StatementBase statement in _body)
            {
                statement.CheckType(typeErrors);
            }
        }
    }
}
