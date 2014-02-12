using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class GotoStmnt : GotoStmntNode, ITypeCheckStmnt
    {
        public ReadOnlyDictionary<string, ITypeCheckStmnt> Forms { get; private set; }

        public GotoStmnt(string gotoName, ReadOnlyDictionary<string, ITypeCheckStmnt> forms)
            : base(gotoName)
		{
            Forms = forms;
		}

        public Tuple<int, int> StatementSourcePosition { get; set; }

        public IEnumerable<Tuple<string, bool, int, int>> CheckTypesValid()
        {
            if (!Forms.ContainsKey(GotoName))
            {
                yield return new Tuple<string, bool, int, int>(
                    String.Format("'goto' not possible. Form '{0}' does not exist!", GotoName),
                    true, StatementSourcePosition.Item1, StatementSourcePosition.Item2);
            }
        }
    }
}
