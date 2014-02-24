using System.Collections.Generic;
using QL.QLClasses.Statements;

namespace QL.QLClasses
{
    public class Questionnaire
    {
        public string ID { get; set; }
        public string Title { get; set; }
        public List<StatementBase> Body { get; set; }
    }
}
