using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using QL.Components.Types;

namespace QL.Components.Statements
{
    public class Question : StatementBase
    {
        public string ID { get; set; }
        public string Label { get; set; }
        public TypeBase Type { get; set; }
    }
}
