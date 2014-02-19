using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Antlr4.Runtime;

namespace QL.Components
{
    public class StatementBase
    {
        public int TokenLine { get; set; }
        public int TokenColumn { get; set; }
        public string TokenText { get; set; }

        public IToken Token 
        {
            set { TokenLine = value.Line; TokenColumn = value.Column; TokenText = value.Text; }
        }
    }
}
