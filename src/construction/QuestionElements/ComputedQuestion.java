/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.QuestionElements;

import construction.Operators.Expression;
import construction.Types.IType;

/**
 *
 * @author svene_000
 */
public class ComputedQuestion implements GeneralQuestion, Visitable {

    private Expression exp;
    private Question q;

    public ComputedQuestion(String questionName, String questionContent, IType questionType, Expression e, int line) {
        q = new Question(questionName, questionContent, questionType, line);
        this.exp = e;
    }

    public void setExpression(Expression e) {
        this.exp = e;
    }

    public Expression getExpression() {
        return exp;
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        sb.append(toString());
        return sb.toString();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Question getQuestion() {
        return q;
    }

    @Override
    public int getLine() {
        return q.getLine();
    }

}
