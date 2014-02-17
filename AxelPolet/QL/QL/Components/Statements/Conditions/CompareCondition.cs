using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Components.Statements.Conditions.Operators;

namespace QL.Components.Statements.Conditions
{
    class CompareCondition : Condition
    {
        object Lhv { get; set; }
        object Rhv { get; set; }
        Operator CompareOperator { get; set; }
    }
}
