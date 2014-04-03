/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction.questions;

import java.util.ArrayList;
import java.util.List;
import softwareconstruction.literals.Expression;

/**
 *
 * @author Sinan
 */
public class ConditionalQuestion implements QuestionInterface, Visitable {
    
    Expression expression;
    private List<QuestionInterface> questions = new ArrayList();

    public ConditionalQuestion() {
    }

    public void addQuestion(QuestionInterface o) {
        questions.add(o);
    }
    
    public void addExpression(Expression o) {
        expression = o;
        System.out.println("Added expression: "+o.toString());
    }
   
    public List<QuestionInterface> getConditionalQuestions(){
        return questions;
    }
    
    public Expression getExpression(){
        return expression;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
