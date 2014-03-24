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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author svene_000
 */
public abstract class AbstractRenderedQuestion implements RenderedQuestion {

    protected Question q;
    protected boolean enabled = true;

    public AbstractRenderedQuestion(Question q) {
        this.q = q;
    }

    public AbstractRenderedQuestion(Question q, boolean enabled) {
        this.q = q;
        this.enabled = enabled;
    }

    public JComponent getRender() {
        JComponent questionBox = new JPanel();
        JLabel questionLabelBox = new JLabel();
        questionLabelBox.setText(q.getQuestionContent().substring(1, q.getQuestionContent().length() - 1));

        questionBox.add(questionLabelBox);
        System.out.println("RENDERING QUESTION: " + q.getQuestionContent() + " of type: " + q.getQuestionType());
        return questionBox;
    }

    public boolean equals(Object o) {
        if (o instanceof AbstractRenderedQuestion) {
            AbstractRenderedQuestion arq = (AbstractRenderedQuestion) o;
            if (arq.q.getQuestionName().equals(q.getQuestionName())) {
                return true;
            }
        }
        return false;
    }

}
