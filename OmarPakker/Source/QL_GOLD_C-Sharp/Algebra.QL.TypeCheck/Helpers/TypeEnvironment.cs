using System.Collections.Generic;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class TypeEnvironment
    {
        private readonly HashSet<string> forms;
        private readonly Dictionary<string, VarInitExpr> variables;
        private bool gotoDeclared;

        public TypeEnvironment()
        {
            forms = new HashSet<string>();
            variables = new Dictionary<string, VarInitExpr>();
        }

        public void ResetVariables()
        {
            variables.Clear();
            gotoDeclared = false;
        }

        public void DeclareForm(string name)
        {
            forms.Add(name);
        }

        public void DeclareGoto()
        {
            gotoDeclared = true;
        }

        public bool IsGotoDeclared()
        {
            return gotoDeclared;
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
