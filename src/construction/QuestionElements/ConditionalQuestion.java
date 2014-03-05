/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.QuestionElements;

import construction.Operators.Expression;
import java.util.ArrayList;
import java.util.List;

public class ConditionalQuestion implements GeneralQuestion, Visitable {

    List<GeneralQuestion> questions = new ArrayList();
    Expression expression;
    int line;

    public ConditionalQuestion(List<GeneralQuestion> questions, Expression expression, int line) {
        this.questions = questions;
        this.expression = expression;
        this.line = line;
    }

    public ConditionalQuestion(Expression expression, int line) {
        this.expression = expression;
        this.line = line;
    }

    public ConditionalQuestion(int line) {
        this.line = line;
    }

    public void setCondition(Expression ex) {
        this.expression = ex;
    }

    public void add(GeneralQuestion gq) {
        questions.add(gq);
    }

    public void addAll(List<GeneralQuestion> gq) {
        questions.addAll(gq);
    }

    public List<GeneralQuestion> getQuestions() {
        return questions;
    }

    public Expression getCondition() {
        return expression;
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String toString() {
        return "IF " + this.getCondition();
    }

    @Override
    public String toString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        sb.append(toString());
        //    sb.append("\tCheck: "+(condition.c?"Pass":"Fail"));
        for (GeneralQuestion gq : questions) {
            sb.append("\r\n");
            sb.append(gq.toString(depth + 1));
        }
        return sb.toString();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getLine() {
        return line;
    }
}
