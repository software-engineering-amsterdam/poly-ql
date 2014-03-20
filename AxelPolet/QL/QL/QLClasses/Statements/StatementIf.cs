using System.Collections.Generic;
using System.Linq;
using QL.Interpreter;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class StatementIf : StatementBase
    {
        private readonly ExpressionBase _condition;
        private readonly List<StatementBase> _body;
        private readonly List<StatementBase> _elseBody;

        public StatementIf(ExpressionBase condition, List<StatementBase> body)
        {
            _condition = condition;
            _body = body;
            _elseBody = new List<StatementBase>();
        }

        public StatementIf(ExpressionBase condition, List<StatementBase> body, List<StatementBase> elseBody)
        {
            _condition = condition;
            _body = body;
            _elseBody = elseBody;
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!_condition.CheckType(typeErrors))
                return false;

            if (!_condition.GetResultType().IsCompatibleWith(new QBool()))
            {
                typeErrors.ReportError(new QLTypeError(
                    string.Format("Condition is not a boolean. Got QType '{0}'", _condition.GetResultType()),
                    _condition.TokenInfo
                ));

                return false;
            }
            
            if (_body.Any(statement => !statement.CheckType(typeErrors)))
                return false;

            return _elseBody.All(elseStatement => elseStatement.CheckType(typeErrors));
        }

        #endregion

        #region Builder Implementation

        public override void Build(QLGuiBuilder guiBuilder)
        {
            guiBuilder.SetShowCondition(_condition);
            foreach (StatementBase statement in _body)
            {
                statement.Build(guiBuilder);
            }
            guiBuilder.RemoveShowCondition();

            guiBuilder.AppendHideCondition(_condition);
            foreach (StatementBase statement in _elseBody)
            {
                statement.Build(guiBuilder);
            }
            guiBuilder.RemoveHideConditions();
        }

        #endregion
    }
}
