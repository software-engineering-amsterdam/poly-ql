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

import construction.Operators.Expression;
import construction.Types.IType;

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
