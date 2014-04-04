using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;
using Algebra.QL.Extensions.Environment;

namespace Algebra.QL.Extensions.Eval.Environment
{
    public class ValueEnvironment : ExtVarEnvironment<ValueContainer>, IValueEnvironment
    {
        public ValueEnvironment()
        {

        }
    }
}
