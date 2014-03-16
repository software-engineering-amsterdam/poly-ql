package edu.uva.softwarecons.util;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.ui.question.QuestionHBox;

import java.util.HashMap;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/16/14
 */
public class StringUtil {

    public static String formToJson(Form form, HashMap<String, QuestionHBox> questions) {
        StringBuffer formData = new StringBuffer();
        formData.append("{\"").append(form.getId()).append("\": {");
        for (String questionId : questions.keySet()) {
            formData.append("\"").append(questionId).append("\": ");
            formData.append(questions.get(questionId).getValue().getValue());
            formData.append(",");
        }
        formData.replace(formData.length() - 1, formData.length(), "} }");
        return formData.toString();
    }
}
