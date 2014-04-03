/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction.questions;

import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public class Question implements QuestionInterface, Visitable{

    public String questionName;
    public String questionContent;
    public SuperType questionType;

    public Question(String questionName, String questionContent, SuperType questionType) {
        this.questionName = questionName;
        this.questionContent = questionContent;
        this.questionType = questionType;
    }

    public Question() {
    }

    /**
     * @return the questionName
     */
    public String getQuestionName() {
        return questionName;
    }

    /**
     * @param questionName the questionName to set
     */
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    /**
     * @return the questionContent
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * @param questionContent the questionContent to set
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    /**
     * @return the questionType
     */
    public SuperType getQuestionType() {
        return questionType;
    }

    /**
     * @param questionType the questionType to set
     */
    public void setQuestionType(SuperType questionType) {
        this.questionType = questionType;
    }
    
    public String toString(){
        return "Question name: "+questionName+" Question content: "+questionContent+" Question type: "+questionType+"";
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
