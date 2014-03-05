/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.QuestionElements;

import java.util.ArrayList;

/**
 *
 * @author svene_000
 */
public class QuestionForm {

    ArrayList<GeneralQuestion> questions = new ArrayList<GeneralQuestion>();
    String questionaireName;

    public void add(GeneralQuestion cq) {
        questions.add(cq);
    }

    public ArrayList<GeneralQuestion> getQuestions() {
        return questions;
    }

    public String getName() {
        return questionaireName;
    }

    public void setName(String name) {
        this.questionaireName = name;
    }

    public void render() {
        System.out.println("Questionaire Name: "+questionaireName);
        for (GeneralQuestion gq : questions) {
            System.out.println(gq.toString(0));
        }
    }

}
