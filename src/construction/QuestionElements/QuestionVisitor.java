/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.QuestionElements;

import construction.ErrorTypes.DuplicateLabelWarning;
import construction.ErrorTypes.DuplicateQuestionError;
import construction.ErrorTypes.InvalidOperandError;
import construction.ErrorTypes.TypeError;
import construction.Types.BoolType;
import construction.Types.IType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author svene_000
 */
public class QuestionVisitor implements Visitor {

    HashMap<String, IType> memory = new HashMap<String, IType>();
    List<TypeError> typeErrors = new ArrayList();
    HashMap<String, Integer> labels = new HashMap<String, Integer>();
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
        for (GeneralQuestion generalQuestion : cq.getQuestions()) {
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

    public HashMap<String, IType> getMemory() {
        return memory;
    }

    public List<TypeError> getTypeErrors() {
        return typeErrors;
    }

}
