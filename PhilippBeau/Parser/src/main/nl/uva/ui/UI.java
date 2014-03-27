package main.nl.uva.ui;

import javax.swing.JFrame;

import main.nl.uva.parser.Form;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.Scope;

public class UI extends JFrame {

    private static final long serialVersionUID = -8764430535448584481L;

    private final Form _form;

    public UI(final Form form) {
        _form = form;

        generateUI();
    }

    private void generateUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIElement layout = _form.getLayout(this);
        this.add(layout.getPanel());

        this.pack();
    }

    public void refreshView() {
        _form.validateAndCalculate(new Scope());
        this.pack();
    }
}
