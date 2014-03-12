package edu.uva.softwarecons.test;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/13/14
 */

public class TypeCheckerTest {

  @Test
    public void conditionInvalidTypeErrorTest(){
      List<Question> questions = new ArrayList<Question>();
      Form form = new Form("", questions);
//      Expression andExpression = new AndExpression(new )
//      IfQuestion ifQuestion = new IfQuestion()

  }

}
