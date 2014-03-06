using System.Collections.Generic;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Helpers
{
    public class TypeEnvironment
    {
        public static readonly TypeEnvironment Instance = new TypeEnvironment();

        private readonly Dictionary<string, VarInitExpr> variables;

        public TypeEnvironment()
        {
            variables = new Dictionary<string, VarInitExpr>();
        }

        public void ResetVariables()
        {
            variables.Clear();
        }

        public void DeclareVariable(VarInitExpr variable)
        {
            variables[variable.Name] = variable;
        }

        public VarInitExpr GetVariable(string varName)
        {
            return variables[varName];
        }
    }
}
