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

import construction.QuestionElements.GeneralQuestion;
import construction.QuestionElements.Question;
import construction.Values.Value;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author svene_000
 */
public class QuestionGUI implements QuestionChangedListener {

    List<GeneralQuestion> generalQuestionList = new ArrayList();
    JPanel questionPanel = new JPanel();
    Map<String, Value> memory = new HashMap();

    public QuestionGUI(String formTitle, List<GeneralQuestion> gql) {
        this.generalQuestionList = gql;

        JFrame frame = new JFrame(formTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 1));
        frame.add(questionPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    boolean first = false;

    public void render() {
        QuestionRenderVisitor v = new QuestionRenderVisitor(memory);
        questionPanel.removeAll();
        
        for (GeneralQuestion gq : generalQuestionList) {
            gq.accept(v);
        }

        List<qst> questions = v.getRender2();

        //   questionPanel.revalidate();
        //   questionPanel.repaint();
        questionPanel.setLayout(new GridLayout(questions.size(), 1));
        for (qst trq : questions) {
            trq.addQuestionChangedListener(this);
            JComponent jcp = trq.render();
            questionPanel.add(jcp);

        }
        questionPanel.revalidate();
        questionPanel.repaint();
        first = true;
    }

    @Override
    public void questionChanged(Question q, Value v) {
        if (memory.containsKey(q.getQuestionName())) {
            memory.remove(q.getQuestionName());
            memory.put(q.getQuestionName(), v);
            render();
        }

    }
}
