package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.statement.Statement;
import main.nl.uva.ui.UI;

public abstract class UIElement {

    protected final UI _parentUI;

    public UIElement(final UI parentUI) {
        _parentUI = parentUI;
    }

    protected void recalculateForm() {
        _parentUI.refreshView();
    }

    /**
     * Generate a user interface representation of the whole block
     * 
     * @param statements
     *            All statements to include in the block
     * @param parent
     *            The user interface parent
     * @return The generated panel
     */
    protected JPanel generateBlockPanel(final List<Statement> statements, final UI parent) {
        JPanel panel = generateYAxisPanel();

        for (Statement child : statements) {
            panel.add(child.getLayout(parent).getPanel());
        }

        return panel;
    }

    /**
     * Generate a JPanel with a Y-Axis BoxLayout
     * 
     * @return The JPanel
     */
    protected JPanel generateYAxisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        return panel;
    }

    /**
     * Generate a JPanel with a X-Axis BoxLayout
     * 
     * @return The JPanel
     */
    protected JPanel generateXAxisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        return panel;
    }

    public abstract JPanel getPanel();
}
