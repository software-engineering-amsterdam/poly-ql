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
package construction.RenderElements;

import construction.QuestionElements.Question;
import construction.Values.Value;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author svene_000
 */
public class GUIQuestion implements ValueChangedListener {

    Question question;
    Value value;
    boolean isReadOnly;
    List<QuestionChangedListener> questionChangedListeners = new ArrayList();

    public GUIQuestion(Question q, Value v, boolean isReadOnly) {
        this.question = q;
        this.value = v;
        this.isReadOnly = isReadOnly;
    }

    public JComponent render() {
        value.setValueChangedListener(this);
        JComponent questionBox = new JPanel();
        JLabel questionLabelBox = new JLabel();
        questionLabelBox.setText(question.getQuestionContent());
        questionBox.add(questionLabelBox);
        questionBox.add(value.getControlComponent(isReadOnly));
        return questionBox;
    }

    public void addQuestionChangedListener(QuestionChangedListener qcl) {
        questionChangedListeners.add(qcl);
    }

    @Override
    public void valueChanged(Value newValue) {
        System.out.println(question.getQuestionName() + " changed to: " + newValue.toString());
        for (QuestionChangedListener qcl : questionChangedListeners) {
            qcl.questionChanged(question, value);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof GUIQuestion) {
            GUIQuestion tq = (GUIQuestion) o;
            if (tq.equals(question)) {
                return true;
            }
        }
        return false;
    }
}
