package edu.uva.softwarecons.test;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.IntegerType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class FormTest {

    @Test
    public void isFormIdProperlySetTest(){
        String formId = "testId";
        Form form = new Form(formId, null);
        assertTrue(form.getId().equals(formId));
    }

    @Test
    public void isFormQuestionSetProperlyTest(){
        List<Question> questionList = new ArrayList<Question>();
        Question question = new BasicQuestion("", "", new IntegerType(0));
        questionList.add(question);
        Form form = new Form(null, questionList);
        assertTrue(form.getQuestions().size() == questionList.size());
        assertTrue(form.getQuestions().get(0).equals(question));
    }
}
