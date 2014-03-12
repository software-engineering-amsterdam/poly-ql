package main.nl.uva.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.nl.uva.parser.elements.statements.ParserForm;

public class UI extends JFrame {

    private final ParserForm _form;

    private final List<JPanel> _panels = new ArrayList<>();

    public UI(final ParserForm form) {
        _form = form;
        // this.setSize(640, 480);

        generateUI();
    }

    private void generateUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(_form.getLayout().generateUIElement());

        // Display the window.
        this.pack();

    }

    static JPanel p;

    public static void addComponentsToPane(final Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        addInputField("Button 1", pane);
        addInputField("Button 2", pane);
        addInputField("Button 3", pane, false);
        addInputField("Long-Named Button 4", pane);
        addInputField("5", pane);
        addButton("asd", pane, false);
    }

    private static void addInputField(final String text, final Container container, final boolean b) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        // panel.setSize(400, 80);
        // panel.setPreferredSize(new Dimension(640, ));

        JLabel label = new JLabel(text);
        // label.setPreferredSize(new Dimension(100, 80));
        // label.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);

        JTextField tf = new JTextField(20);
        // tf.setMinimumSize(new Dimension(120, 80));
        // tf.setSize(120, 80);
        // tf.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(tf);
        panel.setVisible(b);
        container.add(panel);

        if (!b) p = panel;
    }

    private static void addButton(final String text, final Container container, final boolean b) {
        JButton bd = new JButton(text);
        bd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                p.setVisible(true);
            }
        });
        bd.setAlignmentX(Component.RIGHT_ALIGNMENT);

        container.add(bd);
    }

    private static void addInputField(final String text, final Container container) {
        addInputField(text, container, true);
    }
}
