package nl.uva.polyql.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import nl.uva.polyql.ast.Form;
import nl.uva.polyql.ast.Question;

public class FormFrame extends JFrame {

    private static final long serialVersionUID = -4168793431805315522L;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;

    public FormFrame(final Form form) {
        super("Poly-QL");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JPanel p = new JPanel();

        final List<Question> questions = form.getQuestions();
        for (final Question question : questions) {
            p.add(new JLabel(question.getLabel()));
            p.add(question.getView().getComponent());
        }

        p.setLayout(new GridLayout(questions.size(), 2, 5, 5));

        getContentPane().add(new JScrollPane(p), BorderLayout.CENTER);
        setVisible(true);
    }
}