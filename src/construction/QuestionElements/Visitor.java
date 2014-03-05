/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package construction.QuestionElements;

/**
 *
 * @author svene_000
 */
public interface Visitor {
    public void visit(Question q);
    public void visit(ConditionalQuestion cq);
    public void visit(ComputedQuestion cq);
}
