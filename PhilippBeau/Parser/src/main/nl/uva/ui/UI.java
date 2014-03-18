package main.nl.uva.ui;

import javax.swing.JFrame;

import main.nl.uva.parser.element.Form;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;
import main.nl.uva.ui.element.UIElement;

public class UI extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -8764430535448584481L;

    private final Form _form;

    public UI(final Form form) {
        _form = form;

        generateUI();
    }

    private void generateUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIElement layout = _form.getLayout(_form, this);
        this.add(layout.generateUIElement());

        // Display the window.
        this.pack();

    }

    public void refreshView() {
        ASTValidation validation = _form.validate(new Scope());
        System.out.println("Has Errors: " + validation.hasErrors());
        this.pack();
    }
}
