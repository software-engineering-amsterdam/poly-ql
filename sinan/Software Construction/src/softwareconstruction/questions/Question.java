/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction.questions;

/**
 *
 * @author Sinan
 */
public class Question {

    public String questionName;
    public String questionContent;
    public String questionType;

    public Question(String questionName, String questionContent, String questionType) {
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
    public String getQuestionType() {
        return questionType;
    }

    /**
     * @param questionType the questionType to set
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
    
    public String toString(){
        return "Question name: "+questionName+" Question content: "+questionContent+" Question type: "+questionType+"";
    }

}
