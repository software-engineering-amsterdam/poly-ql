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
