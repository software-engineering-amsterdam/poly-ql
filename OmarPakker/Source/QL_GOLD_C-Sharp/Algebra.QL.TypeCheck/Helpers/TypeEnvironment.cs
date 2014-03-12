using System.Linq;
using System.Collections.Generic;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class TypeEnvironment
    {
        private readonly HashSet<string> forms;
        private readonly Dictionary<string, ITypeCheck> gotos;
        private readonly Dictionary<string, VarInitExpr> variables;

        public TypeEnvironment()
        {
            forms = new HashSet<string>();
            gotos = new Dictionary<string, ITypeCheck>();
            variables = new Dictionary<string, VarInitExpr>();
        }

        public void ResetVariables()
        {
            variables.Clear();
        }

        public void DeclareForm(string name)
        {
            forms.Add(name);
        }

        public void DeclareGoto(string name, ITypeCheck item)
        {
            gotos.Add(name, item);
        }

        public bool IsGotoDeclared(string name)
        {
            return gotos.ContainsKey(name);
        }

        public IEnumerable<KeyValuePair<string, ITypeCheck>> GetGotosWithoutForm()
        {
            return gotos.Where(g => !forms.Contains(g.Key));
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
