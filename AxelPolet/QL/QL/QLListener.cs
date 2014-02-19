using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4;

using QL.Components;
using QL.Components.Statements;

namespace QL
{
    public class QLListener : QLBaseListener
    {
        private List<string> _identifiers = new List<string>();

        public Questionnaire Questionnaire { get; set; }

        public override void EnterQuestionnaire(QLParser.QuestionnaireContext context)
        {
            base.EnterQuestionnaire(context);
            string id = context.ID().GetText();

            //if(_identifiers.Contains(id))
              //      
                
            Questionnaire = new Questionnaire { ID = id, Title = context.STRING().GetText() };
        }

        public override void EnterQuestion_stmt(QLParser.Question_stmtContext context)
        {
            base.EnterQuestion_stmt(context);

            string type = context.t.GetText();
            Type t = typeof(string);

            switch (type)
            {
                case "int":
                    t = typeof(int);
                    break;
                case "bool":
                    t = typeof(bool);
                    break;
                case "string":
                    t = typeof(string);
                    break;
            }
        
            //Questionnaire.Questions.Add(context.qst);
            Questionnaire.Questions.Add(new Question { ID = context.ID().GetText(), Label = context.STRING().GetText(), Type = t });
        }
    }
}
