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
public class qst implements ValueChangedListener {

    Question q;
    Value v;
    boolean isReadOnly;
    List<QuestionChangedListener> questionChangedListeners = new ArrayList();

    public qst(Question q, Value v, boolean isReadOnly) {
        this.q = q;
        this.v = v;
        this.isReadOnly = isReadOnly;
    }

    public JComponent render() {
        v.addValueChangedListener(this);
        JComponent questionBox = new JPanel();
        JLabel questionLabelBox = new JLabel();
        questionLabelBox.setText(q.getQuestionContent().substring(1, q.getQuestionContent().length() - 1));

        questionBox.add(questionLabelBox);
        questionBox.add(v.getControlComponent(isReadOnly));
        return questionBox;
    }

    public void addQuestionChangedListener(QuestionChangedListener qcl) {
        questionChangedListeners.add(qcl);
    }

    @Override
    public void valueChanged(Value newValue) {
        System.out.println(q.getQuestionName() + " changed to: " + newValue.toString());
        for (QuestionChangedListener qcl : questionChangedListeners) {
            qcl.questionChanged(q, v);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof qst) {
            qst tq = (qst) o;
            if (tq.equals(q)) {
                return true;
            }
        }
        return false;
    }
}
