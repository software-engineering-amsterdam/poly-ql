/* 
 * Copyright (C) 2014 svene_000
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package construction.RenderElements;

import construction.QuestionElements.ComputedQuestion;
import construction.QuestionElements.ConditionalQuestion;
import construction.QuestionElements.GeneralQuestion;
import construction.QuestionElements.Question;
import construction.QuestionElements.Visitor;
import construction.Types.BoolType;
import construction.Values.BoolValue;

import construction.Values.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionRenderVisitor implements Visitor {

    Map<String, Value> memory;

    //Map<String,List<
    List<RenderedQuestion> questions = new ArrayList();
    List<qst> questions2 = new ArrayList();
    int scope = 0;

    public QuestionRenderVisitor(Map<String, Value> memory) {
        this.memory = memory;
    }

    public QuestionRenderVisitor() {
        this.memory = new HashMap<String, Value>();
    }

    @Override
    public void visit(Question q) {

        //    RenderedQuestion qb = new RenderedQuestion(q.getQuestionType());  
        //  memory.put(q.getQuestionName(), q.getQuestionType());
        //   labels.put(q.getQuestionContent(), q.getLine());
        /*
         if (q.getQuestionType().isCompatible(new BoolType())) {
         RenderedBooleanQuestion rbq = new RenderedBooleanQuestion(q);
         memory.put(q.getQuestionName(), rbq.getValue());
         questions.add(rbq);
         }
        
         */
        //  System.out.println(memory);
        if (!memory.containsKey(q.getQuestionName())) {
            memory.put(q.getQuestionName(), q.getQuestionType().getUndefinedValue());
        }

        questions2.add(new qst(q, memory.get(q.getQuestionName()), false));
    }

    public List<RenderedQuestion> getRender() {
        return questions;
    }

    public List<qst> getRender2() {
        return questions2;
    }

    @Override
    public void visit(ConditionalQuestion cq) {
         System.out.println(memory);
        BoolValue expressionResult = (BoolValue) cq.getCondition().getValue(memory);
        if (expressionResult == null) {
            System.out.println("Expression returned NULL, Exiting node");
            return;
        }
        System.out.println(cq.getLine());
        System.out.println(expressionResult.getBoolValue());
        System.out.println("Expression returned: " + expressionResult.getBoolValue());
        if ((expressionResult.getBoolValue() == true)) {
            for (GeneralQuestion generalQuestion : cq.getQuestions()) {
                generalQuestion.accept(this);
            }
        }

    }

    @Override
    public void visit(ComputedQuestion cq) {
        Value expressionResult = cq.getExpression().getValue(memory);
        if (expressionResult == null) {
            expressionResult = cq.getQuestion().getQuestionType().getUndefinedValue();
        }
        if (!memory.containsKey(cq.getQuestion().getQuestionName())) {
            memory.put(cq.getQuestion().getQuestionName(), expressionResult);
        } else {
            memory.remove(cq.getQuestion().getQuestionName());
            memory.put(cq.getQuestion().getQuestionName(), expressionResult);
        }

        questions2.add(new qst(cq.getQuestion(), expressionResult, true));
    }

    public Map<String, Value> getMemory() {
        return memory;
    }
}
