using System.Collections.Generic;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class TypeEnvironment
    {
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
            variables.Add(variable.Name, variable);
        }

        public VarInitExpr GetVariable(string varName)
        {
            return variables[varName];
        }

        public bool IsVarDeclared(string varName)
        {
            return variables.ContainsKey(varName);
        }
    }
}
