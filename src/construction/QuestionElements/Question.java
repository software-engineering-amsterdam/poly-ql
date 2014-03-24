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

import construction.Types.IType;

public class Question implements GeneralQuestion, Visitable {

    private final String name;
    private final String label;
    private final IType type;
    private final int line;

    public Question(String questionName, String questionContent, IType questionType, int line) {
        this.name = questionName;
        this.label = questionContent;
        this.type = questionType;
        this.line = line;
    }

    public String getQuestionName() {
        return name;
    }

    public String getQuestionContent() {
        return label;
    }

    public IType getQuestionType() {
        return type;
    }

    public String toString() {
        return "Question, content:\"" + label + "\" name:\"" + name + "\" type:\"" + type + "\"";
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

    @Override
    public int getLine() {
        return line;
    }

    public boolean equals(Object o) {
        if (o instanceof Question) {
            Question tmpQuestion = (Question) o;
            if (tmpQuestion.getQuestionName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
