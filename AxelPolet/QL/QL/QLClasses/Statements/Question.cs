using QL.Interfaces;
using QL.QLClasses.Expressions.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class Question : StatementBase
    {
        public QIdentifier ID { get; set; }
        public string Label { get; set; }

        public Question(string id, string label, QBaseType type)
        {
            ID = new QIdentifier(id, type);
            //ID = identifier;
            Label = label;
        }

        public override bool CheckType(ref QLException error)
        {
            if (!ID.CheckType(ref error))
                return false;
            
            Identifiers.AddIdentifier(ID.Identifier, this);
            return true;
        }
    }
}
