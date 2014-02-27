using System.Collections.Generic;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class TypeEnvironment
    {
        private readonly HashSet<string> forms;
        private readonly HashSet<string> gotos;
        private readonly Dictionary<string, VarInitExpr> variables;

        public TypeEnvironment()
        {
            forms = new HashSet<string>();
            gotos = new HashSet<string>();
            variables = new Dictionary<string, VarInitExpr>();
        }

        public void DeclareForm(string formName)
        {
            forms.Add(formName);
        }

        public bool IsFormDeclared(string formName)
        {
            return forms.Contains(formName);
        }

        public void ResetGotos()
        {
            gotos.Clear();
        }

        public void DeclareGoto(string gotoName)
        {
            gotos.Add(gotoName);
        }

        public bool IsGotoDeclared(string gotoName)
        {
            return gotos.Contains(gotoName);
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
