/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.QuestionElements;

import construction.Types.IType;

/**
 *
 * @author svene_000
 */
public class Question implements GeneralQuestion,Visitable {

    private final String questionName;
    private final String questionContent;
    private final IType questionType;
    private final int line;

    public Question(String questionName, String questionContent, IType questionType,int line) {
        this.questionName = questionName;
        this.questionContent = questionContent;
        this.questionType = questionType;
        this.line = line;
    }

    public String getQuestionName() {
        return questionName;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public IType getQuestionType() {
        return questionType;
    }

    public String toString() {
        return "Question, content:\"" + questionContent + "\" name:\"" + questionName + "\" type:\"" + questionType + "\"";
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

}
