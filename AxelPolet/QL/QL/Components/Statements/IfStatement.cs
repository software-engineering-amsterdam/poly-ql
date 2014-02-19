using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Statements
{
    public class IfStmt : Statement
    {
        public Condition Condition { get; set; }
        public Statement Body { get; set; }
    }
}
