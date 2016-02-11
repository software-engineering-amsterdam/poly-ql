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
package construction.QuestionElements;

import construction.ErrorTypes.DuplicateLabelWarning;
import construction.ErrorTypes.DuplicateQuestionError;
import construction.ErrorTypes.InvalidOperandError;
import construction.ErrorTypes.TypeError;
import construction.Types.BoolType;
import construction.Types.IType;
import construction.Values.IntValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionTypeCheckVisitor implements Visitor {

    Map<String, IType> memory = new HashMap<String, IType>();
    List<TypeError> typeErrors = new ArrayList();
    Map<String, Integer> labels = new HashMap<String, Integer>();
    int scope = 0;

    @Override
    public void visit(Question q) {
        if (q.getQuestionType().isErrorCompatible()) {
            typeErrors.add(new InvalidOperandError(q.getQuestionType(), null, q.getLine()));
        }
        if (memory.containsKey(q.getQuestionName()) && !memory.get(q.getQuestionName()).isCompatible(q.getQuestionType())) {
            typeErrors.add(new DuplicateQuestionError(q.getLine()));
            return;
        }

        if (labels.containsKey(q.getQuestionContent())) {
            typeErrors.add(new DuplicateLabelWarning(q.getLine()));
        }

        memory.put(q.getQuestionName(), q.getQuestionType());
        labels.put(q.getQuestionContent(), q.getLine());
    }

    @Override
    public void visit(ConditionalQuestion cq) {
        if (cq.getCondition().checkType(memory, typeErrors)) {

            if (!cq.getCondition().getType(memory).isCompatible(new BoolType())) {
                typeErrors.add(new InvalidOperandError(cq.getCondition().getType(memory), new BoolType(), cq.getCondition().getLine()));
            }
        }

        scope++;
        for (GeneralQuestion generalQuestion : cq.getTrueConditionQuestions()) {
            //   System.out.println("Scope: " + scope);
            generalQuestion.accept(this);
        }
        for (GeneralQuestion generalQuestion : cq.getFalseConditionQuestions()) {
            //   System.out.println("Scope: " + scope);
            generalQuestion.accept(this);
        }
        scope--;
    }

    @Override
    public void visit(ComputedQuestion cq) {
        if (!cq.getExpression().checkType(memory, typeErrors)) {
            return;
        }
        Question q = cq.getQuestion();
        if (!q.getQuestionType().isCompatible(cq.getExpression().getType(memory))) {
            typeErrors.add(new InvalidOperandError(cq.getExpression().getType(memory), q.getQuestionType(), cq.getLine()));
        }
        q.accept(this);
    }

    public Map<String, IType> getMemory() {
        return memory;
    }

    public List<TypeError> getTypeErrors() {
        return typeErrors;
    }

}
