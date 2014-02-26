package edu.uva.softwarecons.model;

import edu.uva.softwarecons.grammar.QuestionnaireParser;
import edu.uva.softwarecons.model.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class Question {

    private String id;

    private String text;

    private Type type;

    private List<Question> subQuestions;


    public Question(String id, String text) {
        this.id = id;
        this.text = text;
        subQuestions = new ArrayList<Question>();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addSubQuestion(Question question){
        subQuestions.add(question);
    }

    public void addAllSubQuestion(List<QuestionnaireParser.QuestionContext> questions){
        for(QuestionnaireParser.QuestionContext question: questions){
//            subQuestions.add(new Question(question.getToken(QuestionnaireLexer.ID, 0).getText(),
//                    question.getToken(QuestionnaireLexer.STRING,0).getText(),
//                    question.getToken(QuestionnaireLexer.STRING,0).getText()));
        }

    }
}
