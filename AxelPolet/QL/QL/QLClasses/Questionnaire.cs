using System.Collections.Generic;
using QL.Interpreter;
using QL.Interpreter.Controls;
using QL.QLClasses.Statements;
using QL.TypeChecker;

namespace QL.QLClasses
{
    public class Questionnaire : IBuilder
    {
        private readonly string _title;
        private readonly List<StatementBase> _body;

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

        public void Build(QLGuiBuilder guiBuilder)
        {
            foreach (StatementBase statement in _body)
            {
                statement.Build(guiBuilder);
            }
        }
    }
}
