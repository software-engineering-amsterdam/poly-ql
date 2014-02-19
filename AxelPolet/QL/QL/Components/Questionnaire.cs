using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Components.Statements;

namespace QL.Components
{
    public class Questionnaire
    {
        public string ID { get; set; }
        public string Title { get; set; }
        public List<StatementBase> Body { get; set; }

        public Questionnaire()
        {
        }
    }
}
