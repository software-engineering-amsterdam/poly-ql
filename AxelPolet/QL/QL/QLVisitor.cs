using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Components;

namespace QL
{
    class QLVisitor : QLBaseVisitor<Questionnaire>
    {
        public Questionnaire Quest { get; private set; }
        
        //public override Questionnaire VisitQuestionnaire(QLParser.QuestionnaireContext context)
        //{
        //    base.VisitQuestionnaire(context);
        //    Quest = context.newQuest;
        //    return Quest;
        //}
        //public override int VisitInt(QLParser.IntContext context)
        //{
        //    return int.Parse(context.INT().GetText());
        //}

        //public override int VisitAddSub(QLParser.AddSubContext context)
        //{
        //    int left = Visit(context.expr(0));
        //    int right = Visit(context.expr(1));
        //    if (context.op.Type == QLParser.ADD)
        //    {
        //        return left + right;
        //    }
        //    else
        //    {
        //        return left - right;
        //    }
        //}

        //public override int VisitMulDiv(QLParser.MulDivContext context)
        //{
        //    int left = Visit(context.expr(0));
        //    int right = Visit(context.expr(1));
        //    if (context.op.Type == QLParser.MUL)
        //    {
        //        return left * right;
        //    }
        //    else
        //    {
        //        return left / right;
        //    }
        //}

        //public override int VisitParens(QLParser.ParensContext context)
        //{
        //    return Visit(context.expr());
        //}
    }
}
