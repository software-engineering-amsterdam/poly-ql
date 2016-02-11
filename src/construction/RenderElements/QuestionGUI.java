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
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import javax.swing.SwingUtilities;

/**
 *
 * @author svene_000
 */
public class QuestionGUI implements QuestionChangedListener {

    List<GeneralQuestion> generalQuestionList = new ArrayList();
    JPanel questionPanel = new JPanel();
    Map<String, Value> memory = new HashMap();

    public QuestionGUI(String formTitle, List<GeneralQuestion> generalQuestionList) {
        this.generalQuestionList = generalQuestionList;
        questionPanel.setBorder(BorderFactory.createTitledBorder("Questions"));
        JScrollPane jsp = new JScrollPane(questionPanel, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JFrame frame = new JFrame(formTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(jsp);
        frame.pack();
        frame.setVisible(true);
    }

    public void render() {
        QuestionRenderVisitor v = new QuestionRenderVisitor(memory);
        questionPanel.removeAll();
        for (GeneralQuestion gq : generalQuestionList) {
            gq.accept(v);
        }
        List<GUIQuestion> questions = v.getRender();
        questionPanel.setLayout(new GridLayout(questions.size(), 1));
        for (GUIQuestion guiQuestion : questions) {
            guiQuestion.addQuestionChangedListener(this);
            JComponent jcp = guiQuestion.render();
            questionPanel.add(jcp);
        }
        questionPanel.revalidate();
        questionPanel.repaint();
        JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, questionPanel);
        parent.pack();
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
