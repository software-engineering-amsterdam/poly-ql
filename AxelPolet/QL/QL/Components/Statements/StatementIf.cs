using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using QL.Components.Conditions;

namespace QL.Components.Statements
{
    public class StatementIf : StatementBase
    {
        public ConditionalExpression Condition { get; set; }
        public List<StatementBase> Body { get; set; }
        public StatementIf ElseIfStatement { get; set; }

        public StatementIf()
        {
            Body = new List<StatementBase>();
        }

        public bool CheckType()
        {


            return true;
        }
    }
}
