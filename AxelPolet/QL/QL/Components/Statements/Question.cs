using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Statements
{
    public class Question : Statement
    {
        public string ID { get; set; }
        public string Label { get; set; }
        public Type Type { get; set; }
        public object Val { get; set; }
    }
}
