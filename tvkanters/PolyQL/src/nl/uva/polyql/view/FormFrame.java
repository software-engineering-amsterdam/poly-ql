package nl.uva.polyql.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import nl.uva.polyql.ast.Form;
import nl.uva.polyql.ast.Rule;

public class FormFrame extends JFrame {

    private static final long serialVersionUID = -4168793431805315522L;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;

    public FormFrame(final Form form) {
        super("Poly-QL");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Construct the form container
        final JPanel formPanel = new JPanel();
        final JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        formPanel.add(container);
        getContentPane().add(new JScrollPane(formPanel), BorderLayout.CENTER);

        // Add content to the form container
        final List<Rule> rules = form.getRules();
        for (final Rule rule : rules) {
            container.add(rule.getView());
        }

        setVisible(true);
    }
}