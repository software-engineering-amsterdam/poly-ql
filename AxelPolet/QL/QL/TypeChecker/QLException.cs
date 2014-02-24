using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.TypeChecker
{
    public class QLException
    {
        public int TokenLine { get; set; }
        public int TokenColumn { get; set; }
        public string TokenText { get; set; }

        public string Message { get; set; }
    }
}
